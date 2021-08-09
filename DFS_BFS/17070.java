import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][] board;
    static int[][][] cache;
    static boolean[][][] visited;
    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        cache = new int[N][N][3];
        visited = new boolean[N][N][3];
        for(int i=0;i<3;i++)
            cache[N-1][N-1][i]=1;
        for(int i=0;i<N;i++)
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        recur(0,1,0); // y,x에서 dir방향으로 들어올 때 경우의 수
        System.out.println(cache[0][1][0]);
    }
    public static int recur(int y, int x, int dir){
        visited[y][x][dir] = true;
        cache[y][x][dir] += cacheCheck(y,x,dir);

        if(x+1<N && dir != 1 && board[y][x+1]==0 && !visited[y][x+1][0])
            cache[y][x][dir] += recur(y,x+1,0);
        if(y+1<N && dir != 0 && board[y+1][x]==0 && !visited[y+1][x][1])
            cache[y][x][dir] += recur(y+1,x,1);
        if(x+1<N && y+1<N && board[y+1][x+1]==0 && board[y][x+1]==0 && board[y+1][x]==0 && !visited[y+1][x+1][2])
            cache[y][x][dir] += recur(y+1,x+1,2);

        return cache[y][x][dir];
    }
    public static int cacheCheck(int y, int x, int dir){
        int ret=0;
        if(x+1<N && dir != 1 && board[y][x+1]==0 && visited[y][x+1][0])
            ret += cache[y][x+1][0];
        if(y+1<N && dir != 0 && board[y+1][x]==0 && visited[y+1][x][1])
            ret += cache[y+1][x][1];
        if(x+1<N && y+1<N && board[y+1][x+1]==0 && board[y][x+1]==0 && board[y+1][x]==0 && visited[y+1][x+1][2])
            ret += cache[y+1][x+1][2];
        return ret;
    }
}