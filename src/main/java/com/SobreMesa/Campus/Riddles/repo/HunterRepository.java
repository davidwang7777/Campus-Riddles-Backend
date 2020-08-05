package com.SobreMesa.Campus.Riddles.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.SobreMesa.Campus.Riddles.entity.Hunter;

public interface HunterRepository extends CrudRepository<Hunter, Integer>{
	Optional<Hunter> findByUsername(String username);
}
