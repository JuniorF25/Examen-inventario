package com.example.inventario.service;

import com.example.inventario.web.dto.BodegaDto;
import java.util.List;

public interface BodegaService {
    List<BodegaDto> findAll();
}
