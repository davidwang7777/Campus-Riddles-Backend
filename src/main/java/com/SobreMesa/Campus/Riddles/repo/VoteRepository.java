package com.SobreMesa.Campus.Riddles.repo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.SobreMesa.Campus.Riddles.entity.Vote;

public interface VoteRepository extends CrudRepository<Vote, Integer>{

}
