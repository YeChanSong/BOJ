import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br;
    static int[] Y = {0,-1,0,1}, X = {-1,0,1,0}; // N E S W 에서의 왼쪽
    static int N,M,R,C,D, ans=0;
    static int[][] board;
    static boolean[][] isClean;
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        N = Integer.parseInt(tmp[0]);
        M = Integer.parseInt(tmp[1]);
        tmp = br.readLine().split(" ");
        R = Integer.parseInt(tmp[0]);
        C = Integer.parseInt(tmp[1]);
        D = Integer.parseInt(tmp[2]);
        board = new int[N][M];
        isClean = new boolean[N][M];
        for(int i=0;i<N;i++)
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        cleaning(R,C,D);
        System.out.println(ans);
    }
    public static void cleaning(int y, int x, int d){

        if(!isClean[y][x]) {
            isClean[y][x] = true;
            ans++;
        }
        int dir = d, dy, dx;
        for(int i=0;i<4;i++){
            dy = y+Y[dir]; dx = x+X[dir];
            dir = (dir+3)%4;
            if(board[dy][dx] == 0 && !isClean[dy][dx]){
                cleaning(dy,dx,dir);
                return;
            }
        }
        dy = y+Y[(d+3)%4]; dx = x+X[(d+3)%4];
        if(board[dy][dx] == 0) {
            cleaning(dy, dx, d);
        }
    }
}