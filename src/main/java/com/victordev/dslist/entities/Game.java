package com.victordev.dslist.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_game")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(name = "game_year")
    private Integer year;
    private String genre;
    private String platform;
    private Double score;
    private String imgUrç;
    private String shortDescription;
    private String longDescription;


}