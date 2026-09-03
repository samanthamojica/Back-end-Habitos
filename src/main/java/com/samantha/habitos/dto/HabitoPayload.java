package com.samantha.habitos.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.time.LocalTime;

public record HabitoPayload(
        @NotBlank String nombre,
        String descripcion,
        Integer duracion,
        LocalTime recordatorioHora,
        String recordatorioDias,
        String tipoAlarma,
        Long grupoId,
        Long usuarioId,
        LocalDate fechaInicio,
        LocalDate fechaFin,
        Boolean activo
) {
}
