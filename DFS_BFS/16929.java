import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[][] board;
    static boolean[][] visited;
    static int N, M;
    static int[] Y = {0,0,1,-1}, X = {1,-1,0,0};
    public static void main(String[] args) throws IOException{
        int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = tmp[0]; M = tmp[1];
        board = new char[N][M];
        visited = new boolean[N][M];
        for(int i=0;i<N;i++){
            board[i] = br.readLine().toCharArray();
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                visited = new boolean[N][M];
                if(recur(i,j,-1)){
                    System.out.println("Yes");
                    return;
                }
            }
        }
        System.out.println("No");
    }
    static boolean recur(int y, int x, int dir){
        if(visited[y][x])
            return true;
        visited[y][x] = true;
        int dy=0, dx=0;
        for(int i=0;i<4;i++){
            dy = y+Y[i]; dx = x+X[i];
            if(dy<0 || dx<0 || dy>=N || dx>=M)
                continue;
            if(board[dy][dx] == board[y][x]){
                if((dir%2!=1 && dir+1!=i) || (dir%2!=0 && dir-1!=i)) {
                    if(recur(dy, dx, i)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}