package com.hiringtest.minesweeper.service.games;

import com.hiringtest.minesweeper.domain.game.Square;
import com.hiringtest.minesweeper.repository.games.SquaresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SquaresServiceImpl implements SquaresService {

    @Autowired
    SquaresRepository squaresRepository;

    @Override
    public void reveal(Integer gameId, Integer column, Integer row) {
        List<Square> squares = squaresRepository.findAllByGameId(gameId);
        reveal(row, column, squares);
    }

    private void reveal(int row, int column, List<Square> squares) {
        Square square = squares.stream()
                .filter(sqr ->  sqr.getColumn() == column && sqr.getRow() == row).findAny().get();
        if (square != null && square.getAdjacentMines() == 0 && !square.getRevealed()) {
            square.setRevealed(true);
            square.setDisplayValue(square.getAdjacentMines().toString());
            squaresRepository.update(square);
            reveal(  square.getRow() - 1, square.getColumn() - 1, squares);
            reveal(  square.getRow() - 1, square.getColumn(), squares);
            reveal(  square.getRow() - 1, square.getColumn() + 1, squares);
            reveal( square.getRow(), square.getColumn() + 1,  squares);
            reveal(  square.getRow(),square.getColumn() - 1, squares);
            reveal( square.getRow() + 1, square.getColumn() -1 , squares);
            reveal( square.getRow() + 1, square.getColumn(), squares);
            reveal( square.getRow() + 1, square.getColumn() + 1, squares);
        } else {
            return;
        }
    }


}
