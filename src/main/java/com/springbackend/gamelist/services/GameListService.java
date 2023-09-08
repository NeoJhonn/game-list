package com.springbackend.gamelist.services;


import com.springbackend.gamelist.dtos.GameDTO;
import com.springbackend.gamelist.dtos.GameListDTO;
import com.springbackend.gamelist.projections.GameProjection;
import com.springbackend.gamelist.repositories.GameListRepository;
import com.springbackend.gamelist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired// cria uma instância GameListRepository por debaixo dos panos
    GameListRepository gameListRepository;
    @Autowired
    GameRepository gameRepository;

    @Transactional(readOnly = true) // é uma boa prática declarar o seu médoto como Transactional(ACID)
    public List<GameListDTO> findAll() {
        //uso o stream e map para converter para GameListDTO
        List<GameListDTO> result = gameListRepository.findAll().stream().map(g -> new GameListDTO(g)).toList();

        return result;
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {

        List<GameProjection> list = gameRepository.searchByList(listId);

        GameProjection obj = list.remove(sourceIndex);// remove da lista o game e guarda em obj
        list.add(destinationIndex, obj); // adicion o game(obj) da posisção de destino e empurra os outros itens da
        // lista pra baixo atualizando os index da lista

        // encontrando o menor e o maior index para salvar no banco
        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        // fazer um for para atualizar a posição no banco
        for (int i = min; i <= max; i++) {

            // usando os ids atualizados dos games em memória
            // da lista de games(plataforma ou RPG) -> listId
            // com o novo id que no caso é o próprio i
            // listId(plataforma ou RPG)
            // list.get(i).getId() -> id do game que quero atualizar no banco
            // com a nova posição que é próprio i
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }

    }


}
