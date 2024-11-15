package com.victordev.dslist.service;

import com.victordev.dslist.dto.GameDTO;
import com.victordev.dslist.dto.GameMinDTO;
import com.victordev.dslist.entities.Game;
import com.victordev.dslist.projection.GameMinProjection;
import com.victordev.dslist.repository.GameRepository;
import com.victordev.dslist.service.exception.GameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    private final GameRepository gameRepository;
    private final GameListService gameListService;

    // constructor to do dependency injections
    public GameService(GameRepository gameRepository, GameListService gameListService){
        this.gameRepository = gameRepository;
        this.gameListService = gameListService;
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
        Game gameResult = gameRepository.findById(id).orElseThrow(() -> new GameNotFoundException("Game not found."));
        return new GameDTO(gameResult);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId){
        gameListService.findById(listId);
        List<GameMinProjection> listGameMinProjection = gameRepository.searchByList(listId);
        return listGameMinProjection.stream()
                .map(GameMinDTO::new)
                .toList();
    }

}
