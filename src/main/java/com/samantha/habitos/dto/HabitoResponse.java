package com.samantha.habitos.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public record HabitoResponse(
        Long id,
        String nombre,
        String descripcion,
        Integer duracion,
        LocalTime recordatorioHora,
        String recordatorioDias,
        String tipoAlarma,
        Long grupoId,
        Long usuarioId,
        LocalDate fechaInicio,
        LocalDate fechaFin,
        Boolean activo,
        LocalDateTime fechaCreacion,
        LocalDateTime fechaActualizacion
) {
}
