package com.samantha.habitos.repository;

import com.samantha.habitos.model.Habito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HabitoRepository extends JpaRepository<Habito, Long> {
}
