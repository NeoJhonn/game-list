package com.springbackend.gamelist.controllers;


import com.springbackend.gamelist.dtos.GameAllInfoDTO;
import com.springbackend.gamelist.dtos.GameDTO;
import com.springbackend.gamelist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")// ---> endpoint
public class GameControllers {

    @Autowired
    private GameService service;

    @GetMapping
    public List<GameDTO> findAll() { // "/games" ---> endpoint
        List<GameDTO> result = service.findAll();

        return result;
    }

    @GetMapping(value = "/{id}")// "/games/1" ---> endpoint
    public GameAllInfoDTO findById(@PathVariable Long id) {
        GameAllInfoDTO result = service.findById(id);

        return result;
    }
}
