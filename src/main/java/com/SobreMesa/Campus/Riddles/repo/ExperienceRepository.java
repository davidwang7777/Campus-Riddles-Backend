package com.SobreMesa.Campus.Riddles.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.SobreMesa.Campus.Riddles.entity.Experience;
import com.SobreMesa.Campus.Riddles.entity.Riddle;

public interface ExperienceRepository extends CrudRepository<Experience, Integer> {

	public List<Experience> findByRiddleid(int riddleid);
}
