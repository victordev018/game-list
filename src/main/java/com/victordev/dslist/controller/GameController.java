package com.victordev.dslist.controller;

import com.victordev.dslist.dto.GameDTO;
import com.victordev.dslist.dto.GameMinDTO;
import com.victordev.dslist.service.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    private final GameService gameService;

    // constructor to do dependencies injections
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public ResponseEntity<List<GameMinDTO>> getAll(){
        List<GameMinDTO> response = gameService.findALl();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameDTO> getById(@PathVariable Long id){
        GameDTO response = gameService.findById(id);
        return ResponseEntity.ok(response);
    }

}
