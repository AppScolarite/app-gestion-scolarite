package com.javafx.ourproject.Services;

import com.javafx.ourproject.Entities.BrancheEntity;
import com.javafx.ourproject.Repositories.BrancheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BranchServiceImpl{

    @Autowired
    private BrancheRepository brancheRepository;

    public List<BrancheEntity> listAll() {
        return brancheRepository.findAll();
    }

}
