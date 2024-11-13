package com.victordev.dslist.service;

import com.victordev.dslist.dto.GameDTO;
import com.victordev.dslist.dto.GameMinDTO;
import com.victordev.dslist.entities.Game;
import com.victordev.dslist.projection.GameMinProjection;
import com.victordev.dslist.repository.GameRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    private final GameRepository gameRepository;

    // constructor to do dependency injections
    public GameService(GameRepository gameRepository){
        this.gameRepository = gameRepository;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findALl(){
         List<GameMinDTO> listGameResult = gameRepository.findAll().stream()
                .map(game -> new GameMinDTO(game))
                .toList();

         return listGameResult;
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
        Game gameResult = gameRepository.findById(id).get();
        return new GameDTO(gameResult);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId){
        List<GameMinProjection> listGameMinProjection = gameRepository.searchByList(listId);
        return listGameMinProjection.stream()
                .map(GameMinDTO::new)
                .toList();
    }

}
