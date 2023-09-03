package com.springbackend.gamelist.projections;

public interface GameProjection {

    // Adicionar métodos get correspondente a sua consulta SQL lá do GameRepository
    long getId();
    String getTitle();
    Integer getYear();// se usar Alias colocar aqui o nome do ALias
    String getImgUrl();// se usar Alias colocar aqui o nome do ALias
    String getShortDescription();// se usar Alias colocar aqui o nome do ALias
    Integer getPosition();
}
