package com.example.nevena.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.nevena.domain.Labela;

@Repository
public interface LabelaRepository extends JpaRepository<Labela, Long> {

	Labela findOneById (Long Id);
	
}
