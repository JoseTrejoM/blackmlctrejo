package com.yega.mlc.service.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.yega.mlc.dto.CuestionarioDTO;
import com.yega.mlc.dto.ErrorCodeDTO;
import com.yega.mlc.dto.FieldQueryDTO;
import com.yega.mlc.dto.RespuestaDTO;
import com.yega.mlc.entity.RespuestaEntity;
import com.yega.mlc.exception.ServiceException;
import com.yega.mlc.exception.utils.UtilsEx;
import com.yega.mlc.repository.AnswerRepository;
import com.yega.mlc.repository.QuestionSheetRepository;
import com.yega.mlc.service.QuestionSheetService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class QuestionSheetServiceImpl implements QuestionSheetService {
    private static final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private QuestionSheetRepository questionSheetRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Override
    public CuestionarioDTO getQuestionSheetById(Integer cuestionarioId) throws ServiceException {
        try {
            var opQuestionSheet = questionSheetRepository.findById(cuestionarioId);
            var errorCode = new ErrorCodeDTO(HttpStatus.NOT_FOUND,
                    String.format("QuestionSheet not found with id %d", cuestionarioId));
            var questionSheetEntity = opQuestionSheet
                    .orElseThrow(() -> new ServiceException(errorCode, errorCode.getMessage()));
            return modelMapper.map(questionSheetEntity, CuestionarioDTO.class);
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public List<RespuestaDTO> saveAnswers(List<RespuestaDTO> respuestas) throws ServiceException {
        try {
            var listRepEntity = respuestas.stream().map(element -> modelMapper.map(element, RespuestaEntity.class))
                    .collect(Collectors.toList());
            var listSave = answerRepository.saveAll(listRepEntity);
            return listSave.stream().map(element -> modelMapper.map(element, RespuestaDTO.class))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public void deleteById(Integer respuestaId) throws ServiceException {
        try{
            answerRepository.deleteById(respuestaId);
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
        
    }

    @Override
    public void deleteByIds(List<Integer> respuestaIds) throws ServiceException {
        try{
            answerRepository.deleteAllById(respuestaIds);
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
        
    }

    @Override
    public RespuestaDTO crear(RespuestaDTO t) throws ServiceException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public RespuestaDTO getById(Integer id) throws ServiceException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<RespuestaDTO> getAll() throws ServiceException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public RespuestaDTO actualizar(RespuestaDTO t) throws ServiceException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public RespuestaDTO eliminar(Integer id) throws ServiceException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<RespuestaDTO> getResultSet(Set<FieldQueryDTO> fields) throws ServiceException {
        try {
            var listResulSet = answerRepository.getResultSet(fields, RespuestaEntity.class);
            return listResulSet.stream().map(element -> mapper(element, RespuestaDTO.class))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

}
