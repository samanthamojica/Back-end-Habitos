package com.samantha.habitos.dto;

import java.time.LocalDateTime;

public record GrupoResponse(
        Long id,
        String nombre,
        String descripcion,
        String color,
        String icono,
        Boolean activo,
        LocalDateTime fechaCreacion,
        LocalDateTime fechaActualizacion
) {
}
