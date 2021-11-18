package com.yega.mlc.service;

import org.modelmapper.ModelMapper;

public interface ServiceBase {

    default <D> D mapper(Object source, Class<D> clazz){
        var modelMapper = new ModelMapper();
        return modelMapper.map(source, clazz);
    }
}
