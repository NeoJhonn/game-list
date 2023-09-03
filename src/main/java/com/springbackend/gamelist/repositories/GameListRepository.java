package com.springbackend.gamelist.repositories;

import com.springbackend.gamelist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {// <TIpo de Entidade, Tipo do id>
}
