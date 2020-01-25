package base;

import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        final int boardXSize = 4;
        final int boardYSize = 2;
        final int horseX = 1;
        final int horseY = 1;
        Board board = new Board(boardXSize, boardYSize);
        Knight knight = new Knight();
        Display.showBoard(board, horseX, horseY, knight);
        
    }
}
