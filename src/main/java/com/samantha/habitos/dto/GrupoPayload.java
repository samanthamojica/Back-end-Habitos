package com.samantha.habitos.dto;

import jakarta.validation.constraints.NotBlank;

public record GrupoPayload(
        @NotBlank String nombre,
        String descripcion,
        String color,
        String icono,
        Boolean activo
) {
}
