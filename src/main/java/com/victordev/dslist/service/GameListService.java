package com.victordev.dslist.service;

import com.victordev.dslist.dto.GameListDTO;
import com.victordev.dslist.repository.GameListRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameListService {

    private final GameListRepository gameListRepository;

    public GameListService(GameListRepository gameListRepository){
        this.gameListRepository = gameListRepository;
    }

    public List<GameListDTO> findAll(){
        List<GameListDTO> list = gameListRepository.findAll().stream()
                .map(GameListDTO::new)
                .toList();

        return list;
    }

}
