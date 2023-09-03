package com.springbackend.gamelist.services;

import com.springbackend.gamelist.dtos.GameAllInfoDTO;
import com.springbackend.gamelist.dtos.GameDTO;
import com.springbackend.gamelist.entities.Game;
import com.springbackend.gamelist.projections.GameProjection;
import com.springbackend.gamelist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired// cria uma instância GameRepository por debaixo dos panos
    GameRepository repository;

    @Transactional(readOnly = true) // é uma boa prática declarar o seu médoto como Transactional(ACID)
    public List<GameDTO> findAll() {
        //uso o stream e map para converter para GameDTO
        List<GameDTO> result = repository.findAll().stream().map(g -> new GameDTO(g)).toList();

        return result;
    }

    @Transactional(readOnly = true) // é uma boa prática declarar o seu método como Transactional(ACID)
    public GameAllInfoDTO findById(Long id) {
        Game result = repository.findById(id).get();

        return new GameAllInfoDTO(result);
    }

    @Transactional(readOnly = true) // é uma boa prática declarar o seu método como Transactional(ACID)
    public List<GameDTO> findByList(Long listID) {
        List<GameProjection> result = repository.searchByList(listID);

        //uso o stream e map para converter para GameDTO
        return result.stream().map(g -> new GameDTO(g)).toList();
    }


}
