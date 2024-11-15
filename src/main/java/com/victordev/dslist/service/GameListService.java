package com.victordev.dslist.service;

import com.victordev.dslist.dto.GameListDTO;
import com.victordev.dslist.entities.GameList;
import com.victordev.dslist.projection.GameMinProjection;
import com.victordev.dslist.repository.GameListRepository;
import com.victordev.dslist.repository.GameRepository;
import com.victordev.dslist.service.exception.GameListNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    private final GameListRepository gameListRepository;
    private final GameRepository gameRepository;

    public GameListService(GameListRepository gameListRepository, GameRepository gameRepository){
        this.gameListRepository = gameListRepository;
        this.gameRepository = gameRepository;
    }

    public List<GameListDTO> findAll(){
        List<GameListDTO> list = gameListRepository.findAll().stream()
                .map(GameListDTO::new)
                .toList();

        return list;
    }

    public GameListDTO findById(Long listId) {
        GameList gameList = gameListRepository.findById(listId).orElseThrow(() -> new GameListNotFoundException("Game list not found."));
        return new GameListDTO(gameList);
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex){

        this.findById(listId);

        List<GameMinProjection> list = gameRepository.searchByList(listId);
        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = Math.min(sourceIndex, destinationIndex);
        int max = Math.max(sourceIndex, destinationIndex);

        for (int i = min; i <= max; i++){
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }

}
