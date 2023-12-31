package com.springbackend.gamelist.dtos;

import com.springbackend.gamelist.entities.Game;
import com.springbackend.gamelist.projections.GameProjection;

public class GameDTO {

    private Long id;
    private String title;
    private Integer year;
    private String imgUrl;
    private String shortDescription;

    public GameDTO() {

    }

    public GameDTO(Game entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.year = entity.getYear();
        this.imgUrl = entity.getImgUrl();
        this.shortDescription = entity.getShortDescription();
    }

    // Construtor para converter de GameProjection para GameDTO
    public GameDTO(GameProjection entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.year = entity.getGameYear();
        this.imgUrl = entity.getImgUrl();
        this.shortDescription = entity.getShortDescription();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }
}
