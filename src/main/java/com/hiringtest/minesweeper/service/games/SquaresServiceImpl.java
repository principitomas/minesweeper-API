package com.hiringtest.minesweeper.service.games;

import com.hiringtest.minesweeper.domain.game.Square;
import com.hiringtest.minesweeper.repository.games.SquaresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
                .filter(sqr ->  sqr.getColumn() == column && sqr.getRow() == row).findFirst().orElse(null);
        if (square == null || (square.getFlag() && "F".equals(square.getDisplayValue()))) {
            return;
        }
        if (!square.getIsMine() && square.getAdjacentMines() == 0 && !square.getRevealed()) {
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
            square.setRevealed(true);
            square.setDisplayValue(square.getAdjacentMines().toString());
            squaresRepository.update(square);
            return;
        }
    }

    @Override
    public List<Square> setAdjacentMines(List<Square> squares, Integer rows, Integer columns) {
        List<Square> mines = squares.stream().filter(Square::getIsMine).collect(Collectors.toList());
        mines.forEach(mine -> {
            //Mine adjacent squares
            boolean [][] mineAdjacent = new boolean[rows][columns];
            int previousRow = mine.getRow() > 0 ? mine.getRow() - 1 : 0;
            int nextRow = mine.getRow() < rows - 1 ? mine.getRow() + 1 : rows - 1;
            int previousColumn = mine.getColumn() > 0 ? mine.getColumn() - 1 : 0;
            int nextColumn = mine.getColumn() < columns - 1 ? mine.getColumn() + 1 : columns - 1;

            mineAdjacent[previousRow][previousColumn] = previousRow != mine.getRow() && previousColumn != mine.getColumn();
            mineAdjacent[previousRow][mine.getColumn()] = previousRow != mine.getRow();
            mineAdjacent[previousRow][nextColumn] = previousRow != mine.getRow() && nextColumn != mine.getColumn();

            mineAdjacent[mine.getRow()][previousColumn] = previousColumn != mine.getColumn();
            mineAdjacent[mine.getRow()][nextColumn] = nextColumn != mine.getColumn();;

            mineAdjacent[nextRow][previousColumn] = nextRow != mine.getRow() && previousColumn != mine.getColumn();
            mineAdjacent[nextRow][mine.getColumn()] = nextRow != mine.getRow();
            mineAdjacent[nextRow][nextColumn] = nextRow != mine.getRow() && nextColumn != mine.getColumn();

            squares.forEach(square -> {
                square.setAdjacentMines(
                        mineAdjacent[square.getRow()][square.getColumn()] ?
                                square.getAdjacentMines() + 1 : square.getAdjacentMines()
                );
            });
        });
        return squares;
    }


}
