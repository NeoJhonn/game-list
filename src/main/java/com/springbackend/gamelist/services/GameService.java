package com.springbackend.gamelist.services;

import com.springbackend.gamelist.dtos.GameDTO;
import com.springbackend.gamelist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired// cria uma instância GameRepository por debaixo dos panos
    GameRepository repository;

    public List<GameDTO> findAll() {
        //uso o stream e map para converter para GameDTO
        List<GameDTO> result = repository.findAll().stream().map(g -> new GameDTO(g)).toList();

        return result;
    }
}
