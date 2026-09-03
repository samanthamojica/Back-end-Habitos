package com.samantha.habitos.rest;

import com.samantha.habitos.dto.GrupoPayload;
import com.samantha.habitos.dto.GrupoResponse;
import com.samantha.habitos.service.GrupoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/grupo")
@RequiredArgsConstructor
public class GruposController {

    private final GrupoService grupoService;

    @GetMapping
    public List<GrupoResponse> findAll() {
        return grupoService.findAll();
    }

    @GetMapping("/{id}")
    public GrupoResponse findById(@PathVariable Long id) {
        return grupoService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GrupoResponse create(@Valid @RequestBody GrupoPayload payload) {
        return grupoService.create(payload);
    }

    @PutMapping("/{id}")
    public GrupoResponse update(@PathVariable Long id, @Valid @RequestBody GrupoPayload payload) {
        return grupoService.update(id, payload);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        grupoService.delete(id);
    }
}
