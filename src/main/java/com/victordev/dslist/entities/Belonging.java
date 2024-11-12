package com.victordev.dslist.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_belonging")
@NoArgsConstructor
@Data
@EqualsAndHashCode(of = "id")
public class Belonging {

    @EmbeddedId     // this attribute will represent two components in the table
    private BelongingPK id = new BelongingPK();

    private Integer position;

    public Belonging(Game game, GameList list, int position){
        id.setGame(game);
        id.setList(list);
        this.position = position;
    }

}
