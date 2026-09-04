package com.samantha.habitos.service;

import com.samantha.habitos.dto.GrupoPayload;
import com.samantha.habitos.dto.GrupoResponse;
import com.samantha.habitos.mapper.GrupoMapper;
import com.samantha.habitos.model.Grupo;
import com.samantha.habitos.repository.GrupoRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GrupoService {

    private final GrupoRepository grupoRepository;

    public List<GrupoResponse> findAll() {
        return grupoRepository.findAll().stream()
                .map(GrupoMapper::toResponse)
                .toList();
    }

    public GrupoResponse findById(Long id) {
        return GrupoMapper.toResponse(getOrThrow(id));
    }

    @Transactional
    public GrupoResponse create(GrupoPayload payload) {
        Grupo grupo = GrupoMapper.toEntity(payload);
        return GrupoMapper.toResponse(grupoRepository.save(grupo));
    }

    @Transactional
    public GrupoResponse update(Long id, GrupoPayload payload) {
        Grupo existing = getOrThrow(id);
        Grupo updated = GrupoMapper.toEntity(existing, payload);
        return GrupoMapper.toResponse(grupoRepository.save(updated));
    }

    @Transactional
    public void delete(Long id) {
        if (!grupoRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Grupo not found: " + id);
        }
        grupoRepository.deleteById(id);
    }

    private Grupo getOrThrow(Long id) {
        return grupoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Grupo not found: " + id));
    }
}
