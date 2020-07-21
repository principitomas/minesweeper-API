package com.hiringtest.minesweeper.service.games;

import com.google.common.collect.Lists;
import com.hiringtest.minesweeper.domain.game.*;
import com.hiringtest.minesweeper.repository.games.GamesRepository;
import com.hiringtest.minesweeper.repository.games.GamesRepositoryImpl;
import liquibase.pro.packaged.S;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import javax.ws.rs.core.Response;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

class GamesServiceImplTest {

    private GamesService gamesService;
    private Integer FAKE_USER_ID = 1;
    private GamesRepository gamesRepository;
    private SquaresService squaresService;
    @BeforeEach
    void setUp() {
        gamesRepository = mock(GamesRepository.class);
        squaresService = mock(SquaresService.class);
        gamesService = new GamesServiceImpl(gamesRepository, squaresService);
    }

    @Test
    void testRevealSquare() {

    }

    @Test
    void testNewGame() {
        Settings settings = new Settings(5, 10, 5);

        when(squaresService.setAdjacentMines(any(), eq(10), eq(5))).thenReturn(Lists.newArrayList());
        Response response = gamesService.newGame(settings, FAKE_USER_ID);

        ArgumentCaptor<List> listArgumentCaptor = ArgumentCaptor.forClass(List.class);
        verify(squaresService).setAdjacentMines(listArgumentCaptor.capture(), eq(10), eq(5));
        assertThat( listArgumentCaptor.getValue().size(), is(equalTo(settings.getColumns() * settings.getRows())));

    }

    @Test
    void testGetGames() {

        List<Game> gamesList = Lists.newArrayList(new Game());

        when(gamesRepository.findAll( eq(FAKE_USER_ID))).thenReturn(gamesList);

        Response response = gamesService.getGames(FAKE_USER_ID);

        assertThat((List) response.getEntity(), is(equalTo(gamesList)));
    }


    @Test
    void testAddFlag() {

        Settings settings = new Settings(5, 10, 5);
        List<Square> squares = Lists.newArrayList(new Square(false, false, 5, 4, ""));
        Game game = new Game();
        game.setSquares(squares);
        game.setSettings(settings);
        Game updatedGame = new Game();
        updatedGame.setId(123);

        when(gamesRepository.findById(anyInt(), eq(FAKE_USER_ID))).thenReturn(game);
        when(gamesRepository.update(any())).thenReturn(updatedGame);

       Response response = gamesService.addFlag(1, 4, 5, FlagType.RED_FLAG, FAKE_USER_ID);

        verify(gamesRepository).update(any(Game.class));
        assertThat((Game) response.getEntity(), is(equalTo(updatedGame)));
    }

    @Test
    void testGetGame() {
        Settings settings = new Settings(5, 10, 5);
        List<Square> squares = Lists.newArrayList(new Square(false, false, 5, 4, ""));
        Game game = new Game();
        game.setSquares(squares);
        game.setSettings(settings);

        when(gamesRepository.findById(anyInt(), eq(FAKE_USER_ID))).thenReturn(game);

        Response response = gamesService.getGame(1, FAKE_USER_ID);

        assertThat((Game) response.getEntity(), is(equalTo(game)));
    }

    @Test
    void testApplyAction() {

        Settings settings = new Settings(5, 10, 5);
        List<Square> squares = Lists.newArrayList(new Square(false, false, 5, 4, ""));
        Game game = new Game();
        game.setSquares(squares);
        game.setSettings(settings);
        game.setStatus(Status.PAUSED);
        Game updatedGame = new Game();
        updatedGame.setId(123);

        when(gamesRepository.findById(anyInt(), eq(FAKE_USER_ID))).thenReturn(game);
        when(gamesRepository.update(any())).thenReturn(updatedGame);

        Response response = gamesService.applyAction(1, Action.PAUSE, FAKE_USER_ID);

        ArgumentCaptor<Game> gameArgumentCaptor = ArgumentCaptor.forClass(Game.class);

        verify(gamesRepository).update(gameArgumentCaptor.capture());
        Game gameUpdate = (Game) gameArgumentCaptor.getValue();
        assertThat(gameUpdate.getStatus(), is(equalTo(Status.PAUSED)));

        assertThat((Game) response.getEntity(), is(equalTo(updatedGame)));
    }
}