import java.io.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static boolean[][] board; // true: queen이 위치한다.
    private static int successCount = 0;
    private static int boardSize = 0;

    public static void main(String[] args) throws IOException {

        boardSize = Integer.parseInt(br.readLine());
        board = new boolean[boardSize][boardSize];

        for (int i=0;i<boardSize;i++) {
            board[0][i] = true;
            setQueens(0,i);
            board[0][i] = false;
        }

        System.out.println(successCount);
        br.close();
    }

    private static void setQueens(int y, int x) {

        if (isQueenInHorizontal(y, x)
                || isQueenInVertical(y, x)
                || isQueenInLeftDiagonal(y, x)
                || isQueenInRightDiagonal(y, x)) return;

        if (y == boardSize-1) {
            successCount += 1;
            return;
        }

        for (int i=0; i<boardSize; i++) {
            board[y+1][i] = true;
            setQueens(y+1, i);
            board[y+1][i] = false;
        }
    }

    private static boolean isQueenInHorizontal(int y, int x) {
        for (int i=0; i<boardSize; i++) {
            if (i == x) continue;
            if (board[y][i]) return true;
        }
        return false;
    }
    private static boolean isQueenInVertical(int y, int x) {
        for (int i=0; i<boardSize; i++) {
            if (i == y) continue;
            if (board[i][x]) return true;
        }
        return false;
    }

    private static boolean isQueenInLeftDiagonal(int y, int x) {
        // lower
        for (int i=1;i<boardSize; i++) {
            if (y+i >= boardSize || x-i < 0) break;
            if (board[y+i][x-i]) return true;
        }

        // upper
        for (int i=1; i<boardSize; i++) {
            if (y-i < 0 || x+i >= boardSize) break;
            if (board[y-i][x+i]) return true;
        }

        return false;
    }

    private static boolean isQueenInRightDiagonal(int y, int x) {
        // lower
        for (int i=1; i<boardSize; i++) {
            if (y+i >= boardSize || x+i >= boardSize) break;
            if (board[y+i][x+i]) return true;
        }

        //upper
        for (int i=1; i<boardSize; i++) {
            if (y-i < 0 || x-i < 0) break;
            if (board[y-i][x-i]) return true;
        }
        return false;
    }

}