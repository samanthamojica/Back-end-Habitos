package com.samantha.habitos.rest;

import com.samantha.habitos.dto.HabitoPayload;
import com.samantha.habitos.dto.HabitoResponse;
import com.samantha.habitos.service.HabitoService;
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
@RequestMapping("/habito")
@RequiredArgsConstructor
public class HabitosController {

    private final HabitoService habitoService;

    @GetMapping
    public List<HabitoResponse> findAll() {
        return habitoService.findAll();
    }

    @GetMapping("/{id}")
    public HabitoResponse findById(@PathVariable Long id) {
        return habitoService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HabitoResponse create(@Valid @RequestBody HabitoPayload payload) {
        return habitoService.create(payload);
    }

    @PutMapping("/{id}")
    public HabitoResponse update(@PathVariable Long id, @Valid @RequestBody HabitoPayload payload) {
        return habitoService.update(id, payload);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        habitoService.delete(id);
    }
}
