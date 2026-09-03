package com.samantha.habitos.mapper;

import com.samantha.habitos.dto.HabitoPayload;
import com.samantha.habitos.dto.HabitoResponse;
import com.samantha.habitos.model.Habito;

public final class HabitoMapper {

    private HabitoMapper() {
    }

    public static Habito toEntity(HabitoPayload payload) {
        return Habito.builder()
                .nombre(payload.nombre())
                .descripcion(payload.descripcion())
                .duracion(payload.duracion())
                .recordatorioHora(payload.recordatorioHora())
                .recordatorioDias(payload.recordatorioDias())
                .tipoAlarma(payload.tipoAlarma())
                .grupoId(payload.grupoId())
                .usuarioId(payload.usuarioId())
                .fechaInicio(payload.fechaInicio())
                .fechaFin(payload.fechaFin())
                .activo(payload.activo())
                .build();
    }

    public static Habito toEntity(Habito existing, HabitoPayload payload) {
        return Habito.builder()
                .id(existing.getId())
                .nombre(payload.nombre())
                .descripcion(payload.descripcion())
                .duracion(payload.duracion())
                .recordatorioHora(payload.recordatorioHora())
                .recordatorioDias(payload.recordatorioDias())
                .tipoAlarma(payload.tipoAlarma())
                .grupoId(payload.grupoId())
                .usuarioId(payload.usuarioId())
                .fechaInicio(payload.fechaInicio())
                .fechaFin(payload.fechaFin())
                .activo(payload.activo())
                .fechaCreacion(existing.getFechaCreacion())
                .build();
    }
    

	public static HabitoResponse toResponse(Habito habito) {
        return new HabitoResponse(
                habito.getId(),
                habito.getNombre(),
                habito.getDescripcion(),
                habito.getDuracion(),
                habito.getRecordatorioHora(),
                habito.getRecordatorioDias(),
                habito.getTipoAlarma(),
                habito.getGrupoId(),
                habito.getUsuarioId(),
                habito.getFechaInicio(),
                habito.getFechaFin(),
                habito.getActivo(),
                habito.getFechaCreacion(),
                habito.getFechaActualizacion()
        );
	}
}
