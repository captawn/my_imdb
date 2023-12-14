package com.example.demo.controller;




import com.example.demo.domain.ActorDomain;
import com.example.demo.dto.ActorDTO;
import com.example.demo.mapper.ActorMapperHelper;
import com.example.demo.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actor")
public class ActorController {

    private final ActorService actorService;
    private final ActorMapperHelper actorMapperHelper;

    @Autowired
    public ActorController(ActorService ActorService, ActorMapperHelper actorMapperHelper) {
        this.actorService = ActorService;
        this.actorMapperHelper = actorMapperHelper;
    }

    @GetMapping
    public List<ActorDTO> getAllActors() {
        List<ActorDomain> ActorDomains = actorService.getAllActor();
        return actorMapperHelper.convertActorDomainListToActorDTOList(ActorDomains);
    }

    @PostMapping
    public Long saveActor(@RequestBody ActorDTO ActorDTO) {
        ActorDomain ActorDomain = actorMapperHelper.convertActorDTOToActorDomain(ActorDTO);
        return actorService.saveActor(ActorDomain);
    }

    @GetMapping("/{actorId}")
    public ActorDTO getActorById(@PathVariable Long ActorId) {
        ActorDomain ActorDomain = actorService.findActorById(ActorId);
        return actorMapperHelper.convertActorDomainToActorDTO(ActorDomain);
    }

    @DeleteMapping("/{actorId}")
    public void deleteActorById(@PathVariable Long ActorId) {
        actorService.deleteActorById(ActorId);
    }
}
