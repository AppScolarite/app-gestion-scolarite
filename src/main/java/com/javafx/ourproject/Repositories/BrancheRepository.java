package com.javafx.ourproject.Repositories;

import com.javafx.ourproject.Entities.BrancheEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrancheRepository extends JpaRepository<BrancheEntity, Integer> {
    public BrancheEntity findByIdBranche(int id);

    @Override
    List<BrancheEntity> findAll();
}

