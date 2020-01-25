package base;

public class Display {
    public static void showBoard(Board board, int x, int y, Knight knight) {
        System.out.print("  ");
        for (int i = 0; i < board.chessBoard[0].length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < board.chessBoard.length; i++) {
            System.out.print(i);
            System.out.print("|");
            for (int j = 0; j < board.chessBoard[0].length; j++) {
                if (knight.isAvailableMove(board, x, y, j, i)) {
                    System.out.print("P|");
                } else {
                    System.out.print(board.chessBoard[i][j] + "|");
                }
            }
            System.out.println();
        }
    }
}