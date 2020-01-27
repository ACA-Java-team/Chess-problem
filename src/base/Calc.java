package base;

public class Calc {
    private final static int MMIEP = 8; //MAXIMAL_MOVES_IN_EVERY_POSITION
    private final static int START_DEPTH = 10;

    //All possible moves in every position
    //Example: if your current position is 2:2
    //next available move can be 2+cX[0]:2+cY[0] = 0:1
    private final static int[] cX = new int[]{-2, +2, -2, +2, -1, +1, -1, +1};
    private final static int[] cY = new int[]{-1, -1, +1, +1, -2, -2, +2, +2};

    private boolean isCorrectPosition(int rows, int column, int x, int y) {
        return (x >= 0 && x < rows) && (y >= 0 && y < column);
    }

    int getNumberOfMoves(int rows, int columns,
                         int startX, int startY,
                         int endX, int endY) {
        int score = minMovesCounter(
                rows, columns,
                startX, startY,
                endX, endY,
                START_DEPTH);
        if (score < 999) {
            return score;
        } else {
            return -1;
        }
    }

    private int minMovesCounter(int rows, int columns,
                                int startX, int startY,
                                int endX, int endY,
                                int currentDepth) {
        if (startX == endX && startY == endY) {
            return START_DEPTH - currentDepth;
        }
        if (currentDepth == 0) {
            return 999; // just big integer for Math.min func
        }

        int bestScore = 999; //just big integer for Math.min func

        for (int i = 0; i < MMIEP; i++) {
            int tryX = startX + cX[i];
            int tryY = startY + cY[i];
            if (isCorrectPosition(rows, columns, tryX, tryY)) {
                int score = minMovesCounter(
                        rows, columns,
                        tryX, tryY,
                        endX, endY,
                        currentDepth - 1
                );

                bestScore = Math.min(bestScore, score);
            }
        }
        return bestScore;
    }
}
