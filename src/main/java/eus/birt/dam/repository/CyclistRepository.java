package eus.birt.dam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import eus.birt.dam.domain.Cyclist;

public interface CyclistRepository extends JpaRepository<Cyclist, Long>{
}