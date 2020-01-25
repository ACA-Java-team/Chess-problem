package base;

import java.util.Arrays;

public class Board {
    char[][] chessBoard;
    int xSize;
    int ySize;

    public Board(int xSize, int ySize) {
        this.xSize = xSize;
        this.ySize = ySize;
        chessBoard = new char[ySize][xSize];
        for (char[] part : chessBoard) {
            Arrays.fill(part, ' ');
        }
    }


}
