import java.util.*;
import java.io.*;


public class Main {

    private static char[][] board;
    private static int[][] visited;

    private static int N, M;
    private static int[] moveY = new int[] {-1, 0, 1, 0};
    private static int[] moveX = new int[] {0, -1, 0, 1};

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] agrs) throws IOException {

        settingInput();

        bfs(new int[]{0,0});
        System.out.println(visited[N-1][M-1]);
    }

    private static void settingInput() throws IOException {
        int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = NM[0]; M = NM[1];
        board = new char[N][M];
        visited = new int[N][M];
        for(int i=0;i<N;i++) board[i] = br.readLine().toCharArray();
    }

    private static void bfs(int[] coord) { // coord: {y,x}
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(coord);
        visited[coord[0]][coord[1]] = 1;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for(int i=0;i<4;i++) {
                int nextY = current[0] + moveY[i];
                int nextX = current[1] + moveX[i];
                if (!isOutOfBoundary(nextY, nextX) && isMovable(nextY, nextX) && visited[nextY][nextX] == 0) {
                    queue.offer(new int[] {nextY, nextX});
                    visited[nextY][nextX] = visited[current[0]][current[1]] +1;
                }
            }
        }
    }

    private static boolean isOutOfBoundary(int y, int x) {
        return y<0 || x<0 || y>=N || x>=M;
    }

    private static boolean isMovable(int y, int x) {
        return board[y][x] == '1';
    }

}