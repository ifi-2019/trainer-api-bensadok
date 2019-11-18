package com.ifi.trainer_api.repository;

import com.ifi.trainer_api.bo.Trainer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.CrudRepositoryExtensionsKt;

import java.util.List;
import java.util.Optional;

public interface TrainerRepository extends CrudRepository<Trainer,String> {

    List<Trainer> findAll();
    Optional<Trainer> findByName(String id);
    Trainer save(Trainer trainer);
}
