package com.yega.mlc.service;

import java.util.List;

import com.yega.mlc.dto.CuestionarioDTO;
import com.yega.mlc.dto.RespuestaDTO;
import com.yega.mlc.exception.ServiceException;

public interface QuestionSheetService extends ServiceBase, ServiceCRUD<RespuestaDTO, RespuestaDTO> {

    CuestionarioDTO getQuestionSheetById(Integer cuestionarioId) throws ServiceException;

    List<RespuestaDTO> saveAnswers(List<RespuestaDTO> respuestas) throws ServiceException;

    void deleteById(Integer respuestaId) throws ServiceException;

    void deleteByIds(List<Integer> respuestaIds) throws ServiceException;
}
