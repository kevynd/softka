package com.softka.demo.repository;

import com.softka.demo.entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository  extends JpaRepository<PersonaEntity, Integer> {
}
