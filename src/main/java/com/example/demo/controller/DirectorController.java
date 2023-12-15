package com.example.demo.controller;




import com.example.demo.domain.DirectorDomain;
import com.example.demo.dto.DirectorDTO;
import com.example.demo.mapper.DirectorMapperHelper;
import com.example.demo.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/director")
public class DirectorController {

    private static final Logger logger = LoggerFactory.getLogger(DirectorController.class);

    private final DirectorService directorService;
    private final DirectorMapperHelper DirectorMapperHelper;

    @Autowired
    public DirectorController(DirectorService DirectorService, DirectorMapperHelper directorMapperHelper) {
        this.directorService = DirectorService;
        this.DirectorMapperHelper = directorMapperHelper;
    }

    @GetMapping
    public List<DirectorDTO> getAllDirectors() {
        logger.info("Received request to get all directors.");
        List<DirectorDomain> DirectorDomains = directorService.getAllDirector();
        return DirectorMapperHelper.convertDirectorDomainListToDirectorDTOList(DirectorDomains);
    }

    @PostMapping
    public Long saveDirector(@RequestBody DirectorDTO directorDTO) {
        logger.info("Received request to save directorDTO: {}", directorDTO.toString());
        DirectorDomain directorDomain = DirectorMapperHelper.convertDirectorDTOToDirectorDomain(directorDTO);
        logger.info("Received request to save director Domain: {}", directorDomain.toString());
        Long directorId = directorService.saveDirector(directorDomain);
        logger.info("Received director Id: {}", directorId);
        return directorId;

    }

    @GetMapping("/{directorId}")
    public DirectorDTO getDirectorById(@PathVariable Long directorId) {
        logger.info("Received request to get director by ID: {}", directorId);
        DirectorDomain DirectorDomain = directorService.findDirectorById(directorId);
        return DirectorMapperHelper.convertDirectorDomainToDirectorDTO(DirectorDomain);
    }

    @DeleteMapping("/{directorId}")
    public void deleteDirectorById(@PathVariable Long directorId) {
        logger.info("Received request to delete director by ID: {}", directorId);
        directorService.deleteDirectorById(directorId);
    }
}
