package com.victordev.dslist.dto;

import com.victordev.dslist.entities.GameList;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GameListDTO {

    private Long id;
    private String name;

    public GameListDTO(GameList gameList){
        this.id = gameList.getId();
        this.name = gameList.getName();
    }

}
