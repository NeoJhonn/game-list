package com.springbackend.gamelist.controllers;

import com.springbackend.gamelist.dtos.GameDTO;
import com.springbackend.gamelist.dtos.GameListDTO;
import com.springbackend.gamelist.services.GameListService;
import com.springbackend.gamelist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")// ---> endpoint
public class GameListControllers {

    @Autowired
    private GameListService gameListservice;
    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll() { // "/lists" ---> endpoint
        List<GameListDTO> result = gameListservice.findAll();

        return result;
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameDTO> findByList(@PathVariable Long listId) { // "/lists/1/games" ---> endpoint
        List<GameDTO> result = gameService.findByList(listId);

        return result;
    }
}
