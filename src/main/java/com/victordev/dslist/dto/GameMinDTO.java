package com.victordev.dslist.dto;

import com.victordev.dslist.entities.Game;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameMinDTO {

    private Long id;
    private String title;
    private Integer year;
    private String imgUrl;
    private String shortDescription;

    public GameMinDTO(Game game){
        id = game.getId();
        title = game.getTitle();
        year = game.getYear();
        imgUrl = game.getImgUrl();
        shortDescription = game.getShortDescription();
    }

}