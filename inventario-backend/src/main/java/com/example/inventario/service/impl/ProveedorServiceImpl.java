package com.example.inventario.service.impl;

import com.example.inventario.repository.ProveedorRepository;
import com.example.inventario.service.ProveedorService;
import com.example.inventario.web.dto.ProveedorDto;
import com.example.inventario.web.mapper.ProveedorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProveedorServiceImpl implements ProveedorService {

    private final ProveedorRepository proveedorRepository;
    private final ProveedorMapper proveedorMapper;

    @Autowired // Explicitly inject dependencies via constructor
    public ProveedorServiceImpl(ProveedorRepository proveedorRepository, ProveedorMapper proveedorMapper) {
        this.proveedorRepository = proveedorRepository;
        this.proveedorMapper = proveedorMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProveedorDto> findAll() {
        return proveedorRepository.findAll().stream()
                .map(proveedorMapper::toDto)
                .collect(Collectors.toList());
    }
}