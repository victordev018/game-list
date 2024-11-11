package com.victordev.dslist.service;

import com.victordev.dslist.dto.GameMinDTO;
import com.victordev.dslist.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private final GameRepository gameRepository;

    // constructor to do dependency injections
    public GameService(GameRepository gameRepository){
        this.gameRepository = gameRepository;
    }

    public List<GameMinDTO> findALl(){
         List<GameMinDTO> listGameResult = gameRepository.findAll().stream()
                .map(game -> new GameMinDTO(game))
                .toList();

         return listGameResult;
    }

}
