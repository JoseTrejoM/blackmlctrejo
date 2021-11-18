package com.yega.mlc.service;

import java.util.List;

public interface CatalogoService {

    List getCatPaises();
    List getCatEstados(short idPais);
}
