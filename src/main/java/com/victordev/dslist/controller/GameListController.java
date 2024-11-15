package com.victordev.dslist.controller;

import com.victordev.dslist.dto.GameListDTO;
import com.victordev.dslist.dto.GameMinDTO;
import com.victordev.dslist.dto.ReplacementDTO;
import com.victordev.dslist.service.GameListService;
import com.victordev.dslist.service.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lists")
public class GameListController {

    private final GameListService gameListService;
    private final GameService gameService;

    public GameListController(GameListService gameListService, GameService gameService) {
        this.gameListService = gameListService;
        this.gameService = gameService;
    }

    @GetMapping
    public ResponseEntity<List<GameListDTO>> findAll(){
        List<GameListDTO> response = gameListService.findAll();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{listId}/games")
    public ResponseEntity<List<GameMinDTO>> findGamesByList(@PathVariable Long listId){
        List<GameMinDTO> response = gameService.findByList(listId);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{listId}/replacement")
    public ResponseEntity<Void> move(@PathVariable Long listId , @RequestBody ReplacementDTO requestBody){
        gameListService.move(listId, requestBody.getSourceIndex(), requestBody.getDestinationIndex());
        return ResponseEntity.ok().build();
    }
}
