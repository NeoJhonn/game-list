package com.springbackend.gamelist.controllers;

import com.springbackend.gamelist.dtos.GameListDTO;
import com.springbackend.gamelist.services.GameListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")// ---> endpoint
public class GameListControllers {

    @Autowired
    private GameListService service;

    @GetMapping
    public List<GameListDTO> findAll() { // "/games" ---> endpoint
        List<GameListDTO> result = service.findAll();

        return result;
    }
}
