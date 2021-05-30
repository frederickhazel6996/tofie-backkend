package com.hazex.tofiebackend.controllers;

import com.hazex.tofiebackend.entities.Agent;
import com.hazex.tofiebackend.services.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/agent")
public class AgentController {

    @Autowired
    AgentService service;

    @GetMapping(path = "/get-agents")
    ResponseEntity<Object> getAgents()
    {
        List<Agent> agentData=service.findAll();
        return new ResponseEntity<>(agentData, HttpStatus.OK);

    }

    @DeleteMapping(path = "/delete-agent/{id}")
    ResponseEntity<String> deleteAgent(@PathVariable String id)
    {
        service.deleteById(id);
        return  new ResponseEntity<>("Agent Deleted",HttpStatus.CREATED);
    }

}
