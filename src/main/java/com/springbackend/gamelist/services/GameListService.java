package com.springbackend.gamelist.services;


import com.springbackend.gamelist.dtos.GameDTO;
import com.springbackend.gamelist.dtos.GameListDTO;
import com.springbackend.gamelist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired// cria uma instância GameListRepository por debaixo dos panos
    GameListRepository repository;

    @Transactional(readOnly = true) // é uma boa prática declarar o seu médoto como Transactional(ACID)
    public List<GameListDTO> findAll() {
        //uso o stream e map para converter para GameListDTO
        List<GameListDTO> result = repository.findAll().stream().map(g -> new GameListDTO(g)).toList();

        return result;
    }


}
