package com.example.inventario.service.impl;

import com.example.inventario.repository.BodegaRepository;
import com.example.inventario.service.BodegaService;
import com.example.inventario.web.dto.BodegaDto;
import com.example.inventario.web.mapper.BodegaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BodegaServiceImpl implements BodegaService {

    private final BodegaRepository bodegaRepository;
    private final BodegaMapper bodegaMapper;

    @Autowired // Explicitly inject dependencies via constructor
    public BodegaServiceImpl(BodegaRepository bodegaRepository, BodegaMapper bodegaMapper) {
        this.bodegaRepository = bodegaRepository;
        this.bodegaMapper = bodegaMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<BodegaDto> findAll() {
        return bodegaRepository.findAll().stream()
                .map(bodegaMapper::toDto)
                .collect(Collectors.toList());
    }
}