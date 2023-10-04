import java.util.*;
import java.io.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static String[] board;
    private static int[][][] visited;
    private static int[] moveY = {-1, 0, 1, 0};
    private static int[] moveX = {0, 1, 0, -1};
    private static int N,M;

    public static void main(String[] args) throws IOException {
        settingInput();
        bfs();
        int answer = Math.min(visited[N-1][M-1][0] > 0 ? visited[N-1][M-1][0] : Integer.MAX_VALUE, visited[N-1][M-1][1] > 0 ? visited[N-1][M-1][1] : Integer.MAX_VALUE);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
        br.close();
    }

    private static void settingInput() throws IOException {
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        board = new String[N];
        visited = new int[N][M][2]; // visited[N][M][1] = 벽 부수기 사용 후 방문
        for(int i=0;i<N;i++) board[i] = br.readLine();
    }

    private static void bfs() {
        Queue<Pos> queue = new ArrayDeque<>();
        visited[0][0][0] = 1;
        queue.offer(new Pos(0,0,0));
        while(!queue.isEmpty()) {
            Pos current = queue.poll();
            for(int i=0;i<4;i++) {
                int nextY = current.y + moveY[i];
                int nextX = current.x + moveX[i];
                if (nextY < 0 || nextX < 0 || nextY >= N || nextX >= M) continue;
                if (board[nextY].charAt(nextX) == '0' && visited[nextY][nextX][current.useChance] == 0) {
                    queue.offer(new Pos(nextY, nextX, current.useChance));
                    visited[nextY][nextX][current.useChance] = visited[current.y][current.x][current.useChance] + 1;
                }
                if (board[nextY].charAt(nextX) == '1' && current.useChance == 0 && visited[nextY][nextX][1] == 0) {
                    queue.offer(new Pos(nextY, nextX, 1));
                    visited[nextY][nextX][1] = visited[current.y][current.x][0] + 1;
                }

            }
        }

    }

}

class Pos {
    int y;
    int x;
    int useChance; // true = 1, false = 0

    Pos(int y, int x, int chance) {
        this.y = y;
        this.x = x;
        this.useChance = chance;
    }
}