package com.hiringtest.minesweeper.api;

import com.hiringtest.minesweeper.domain.game.Action;
import com.hiringtest.minesweeper.domain.game.FlagType;
import com.hiringtest.minesweeper.domain.game.Game;
import com.hiringtest.minesweeper.domain.game.Settings;
import com.hiringtest.minesweeper.service.games.GamesServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RestController
public class GamesResource {

    private Integer userId = 1;

    @Autowired
    private GamesServiceImpl gamesService;

    @ApiOperation(value = "Creates a new game.", response = Game.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Game successfully created."),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
    })
    @PostMapping(value = "/games", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public Response createNewGame(@RequestBody Settings gameSettings) {
        return gamesService.newGame(gameSettings, userId);
    }

    @ApiOperation(value = "Retrieves a game that matches the specified ID.", response = Game.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved game."),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping(value = "/games/{id}", produces = MediaType.APPLICATION_JSON)
    public Response getGameById(@PathVariable Integer id) {
        return gamesService.getGame(id,userId);
    }

    @ApiOperation(value = "Retrieves a list of games.", response = Game.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved game."),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource")
    })
    @GetMapping(value = "/games", produces = MediaType.APPLICATION_JSON)
    public Response getGames(@PathVariable Integer id) {
        return gamesService.getGames(userId);
    }


    @ApiOperation(value = "Executes the action specified by the action query parameter.", response = Game.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully executed action"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @PutMapping(value = "/games/{id}", produces = MediaType.APPLICATION_JSON)
    public Response applyGameAction(@PathVariable Integer id, @RequestParam Action action) {
        return gamesService.applyAction(id, action,userId);
    }

    @ApiOperation(value = "Reveals the square specified by the col, row values.", response = Game.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully revealed square"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 400, message = "The col, row vlues are out of the board."),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @PutMapping(value = "/games/{id}/reveal", produces = MediaType.APPLICATION_JSON)
    public Response revealSquare(@PathVariable Integer id, @RequestParam Integer row, @RequestParam Integer column) {
        return gamesService.revealSquare(id, column, row, userId);
    }

    @ApiOperation(value = "Add a flag to the square specified by the col, row values.", response = Game.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully revealed square"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 400, message = "The col, row values are out of the board."),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @PutMapping(value = "/games/{id}/flag", produces = MediaType.APPLICATION_JSON)
    public Response addFlag(@PathVariable Integer id, @RequestParam Integer row, @RequestParam Integer column, @RequestParam FlagType type) {
        return gamesService.addFlag(id, column, row, type,userId);
    }
}
