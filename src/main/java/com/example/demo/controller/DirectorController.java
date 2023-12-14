package com.example.demo.controller;




import com.example.demo.domain.DirectorDomain;
import com.example.demo.dto.DirectorDTO;
import com.example.demo.mapper.DirectorMapperHelper;
import com.example.demo.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/director")
public class DirectorController {

    private final DirectorService directorService;
    private final DirectorMapperHelper DirectorMapperHelper;

    @Autowired
    public DirectorController(DirectorService DirectorService, DirectorMapperHelper directorMapperHelper) {
        this.directorService = DirectorService;
        this.DirectorMapperHelper = directorMapperHelper;
    }

    @GetMapping
    public List<DirectorDTO> getAllDirectors() {
        List<DirectorDomain> DirectorDomains = directorService.getAllDirector();
        return DirectorMapperHelper.convertDirectorDomainListToDirectorDTOList(DirectorDomains);
    }

    @PostMapping
    public Long saveDirector(@RequestBody DirectorDTO DirectorDTO) {
        DirectorDomain DirectorDomain = DirectorMapperHelper.convertDirectorDTOToDirectorDomain(DirectorDTO);
        return directorService.saveDirector(DirectorDomain);
    }

    @GetMapping("/{directorId}")
    public DirectorDTO getDirectorById(@PathVariable Long DirectorId) {
        DirectorDomain DirectorDomain = directorService.findDirectorById(DirectorId);
        return DirectorMapperHelper.convertDirectorDomainToDirectorDTO(DirectorDomain);
    }

    @DeleteMapping("/{directorId}")
    public void deleteDirectorById(@PathVariable Long DirectorId) {
        directorService.deleteDirectorById(DirectorId);
    }
}
