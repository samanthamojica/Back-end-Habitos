package com.samantha.habitos.service;

import com.samantha.habitos.dto.HabitoPayload;
import com.samantha.habitos.dto.HabitoResponse;
import com.samantha.habitos.mapper.HabitoMapper;
import com.samantha.habitos.model.Habito;
import com.samantha.habitos.repository.HabitoRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class HabitoService {

    private final HabitoRepository habitoRepository;

    public List<HabitoResponse> findAll() {
        return habitoRepository.findAll().stream()
                .map(HabitoMapper::toResponse)
                .toList();
    }

    public HabitoResponse findById(Long id) {
        return HabitoMapper.toResponse(getOrThrow(id));
    }

    @Transactional
    public HabitoResponse create(HabitoPayload payload) {
        Habito habito = HabitoMapper.toEntity(payload);
        return HabitoMapper.toResponse(habitoRepository.save(habito));
    }

    @Transactional
    public HabitoResponse update(Long id, HabitoPayload payload) {
        Habito existing = getOrThrow(id);
        Habito updated = HabitoMapper.toEntity(existing, payload);
        return HabitoMapper.toResponse(habitoRepository.save(updated));
    }

    @Transactional
    public void delete(Long id) {
        if (!habitoRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Habito not found: " + id);
        }
        habitoRepository.deleteById(id);
    }

    private Habito getOrThrow(Long id) {
        return habitoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Habito not found: " + id));
    }
}
