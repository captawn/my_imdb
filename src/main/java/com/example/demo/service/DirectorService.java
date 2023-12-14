package com.example.demo.service;

import com.example.demo.domain.DirectorDomain;

import java.util.List;


public interface DirectorService {
    List<DirectorDomain> getAllDirector();

    Long saveDirector(DirectorDomain DirectorDomain);

    DirectorDomain findDirectorById(Long DirectorId);

    void deleteDirectorById(Long DirectorId);
}
