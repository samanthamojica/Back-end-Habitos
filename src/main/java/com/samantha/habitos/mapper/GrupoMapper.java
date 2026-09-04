package com.samantha.habitos.mapper;

import com.samantha.habitos.dto.GrupoPayload;
import com.samantha.habitos.dto.GrupoResponse;
import com.samantha.habitos.model.Grupo;

public final class GrupoMapper {

    private GrupoMapper() {
    }

    public static Grupo toEntity(GrupoPayload payload) {
        return Grupo.builder()
                .nombre(payload.nombre())
                .descripcion(payload.descripcion())
                .color(payload.color())
                .icono(payload.icono())
                .activo(payload.activo())
                .build();
    }

    public static Grupo toEntity(Grupo existing, GrupoPayload payload) {
        return Grupo.builder()
                .id(existing.getId())
                .nombre(payload.nombre())
                .descripcion(payload.descripcion())
                .color(payload.color())
                .icono(payload.icono())
                .activo(payload.activo())
                .fechaCreacion(existing.getFechaCreacion())
                .build();
    }

    public static GrupoResponse toResponse(Grupo grupo) {
        return new GrupoResponse(
                grupo.getId(),
                grupo.getNombre(),
                grupo.getDescripcion(),
                grupo.getColor(),
                grupo.getIcono(),
                grupo.getActivo(),
                grupo.getFechaCreacion(),
                grupo.getFechaActualizacion()
        );
    }
}
