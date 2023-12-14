package com.example.demo.service;

import com.example.demo.domain.DirectorDomain;
import com.example.demo.entity.DirectorEntity;
import com.example.demo.mapper.DirectorMapperHelper;
import com.example.demo.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DirectorServiceImpl implements DirectorService {


    private final DirectorRepository DirectorRepository;
    private final DirectorMapperHelper DirectorMapperHelper;

    @Autowired
    public DirectorServiceImpl(DirectorRepository DirectorRepository, DirectorMapperHelper DirectorMapperHelper) {
        this.DirectorRepository = DirectorRepository;
        this.DirectorMapperHelper = DirectorMapperHelper;
    }

    @Override
    public List<DirectorDomain> getAllDirector() {
        List<DirectorEntity> DirectorEntities = DirectorRepository.findAll();
        return DirectorMapperHelper.convertDirectorEntityListToDirectorDomainList(DirectorEntities);
    }

    @Override
    public Long saveDirector(DirectorDomain DirectorDomain) {
        DirectorEntity DirectorEntity = DirectorMapperHelper.convertDirectorDomainToDirectorEntity(DirectorDomain);
        DirectorEntity savedDirector = DirectorRepository.save(DirectorEntity);
        return savedDirector.getId();
    }

    @Override
    public DirectorDomain findDirectorById(Long DirectorId) {
        Optional<DirectorEntity> byId = DirectorRepository.findById(DirectorId);
        if (byId.isPresent()) {
            DirectorEntity DirectorEntity = byId.get();
            return DirectorMapperHelper.convertDirectorEntityToDirectorDomain(DirectorEntity);
        }
        return null;
    }

    @Override
    public void deleteDirectorById(Long DirectorId) {
        DirectorRepository.deleteById(DirectorId);
    }
}
