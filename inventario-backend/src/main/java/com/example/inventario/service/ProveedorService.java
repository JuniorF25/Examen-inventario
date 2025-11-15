package com.example.inventario.service;

import com.example.inventario.web.dto.ProveedorDto;
import java.util.List;

public interface ProveedorService {
    List<ProveedorDto> findAll();
}
