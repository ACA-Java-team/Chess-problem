package base;

import java.util.ArrayList;
import java.util.HashSet;

public class Knight {

    int[] cX = new int[]
            {-2, +2, -2, +2, -1, +1, -1, +1};
    int[] cY = new int[]
            {-1, -1, +1, +1, -2, -2, +2, +2};

    boolean isPossibleMove(Board board, int x, int y) {
        return (x >= 0 && x < board.xSize) && (y >= 0 && y < board.ySize);
    }

    int[][] possibleMovesList(Board board, int startX, int startY) {
        final int maximumPossibleMoves = 8;
        int[][] list = new int[maximumPossibleMoves][];
        int counter = 0;

        for (int i = 0; i < maximumPossibleMoves; i++) {
            int changedX = startX + cX[i];
            int changedY = startY + cY[i];
            if (isPossibleMove(board, changedX, changedY)) {
                list[counter++] = new int[]{changedX, changedY};
            }
        }

        if (counter > 0) {
            int[][] result = new int[counter][];
            System.arraycopy(list, 0, result, 0, counter);
            return result;
        } else {
            return new int[][]{{-1}};
        }
    }

    boolean isAvailableMove(Board board,
                            int x, int y,
                            int endX, int endY) {
        HashSet<ArrayList<Integer>> list = new HashSet<>();
        int result = -1;
        result = Math.max(recursiveSearch(board, x, y, endX, endY, list), result);
        return result > 0;
    }

    private int recursiveSearch(Board board,
                                int x, int y,
                                int endX, int endY,
                                HashSet<ArrayList<Integer>> list) {
        if (x == endX && y == endY) {
            return 1;
        }
        ArrayList<Integer> tempList = new ArrayList<>(2);
        tempList.add(x);
        tempList.add(y);
        boolean isFreeMove = list.add(tempList);
        if (!isFreeMove) {
            return 0;
        }

        int bestScore = -99;
        int[][] possibleMoves = possibleMovesList(board, x, y);
        for (int[] part : possibleMoves) {
            int score = recursiveSearch(board, part[0], part[1], endX, endY, list);
            bestScore = Math.max(score, bestScore);
        }
        return bestScore;
    }
}
