import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N,L,R,ans=0,total=0,cnt=0;
    static int[] Y = {1,-1,0,0}, X = {0,0,1,-1};
    static int[][] board, comp;
    static boolean[][] visited, visited2;

    public static void main(String[] args) throws IOException{
        int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = tmp[0]; L = tmp[1]; R = tmp[2];
        board = new int[N][N];
        comp = new int[N][N];
        for(int i=0;i<N;i++)
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for(int i=0;i<N;i++)
            for(int j=0;j<N;j++)
                comp[i][j] = board[i][j];
        while(dfsAll()){
            ans++;
        }
        System.out.println(ans);
    }

    static boolean dfsAll(){
        visited = new boolean[N][N];
        visited2 = new boolean[N][N];
        boolean isMoved = false;
        int[][] swap;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j]) {
                    total =0; cnt=0;
                    if(dfs(i, j)){
                        setDfs(i,j,total/cnt);
                        isMoved = true;
                    }
                }
            }
        }
        swap = board;
        board = comp;
        comp = swap;
        for(int i=0;i<N;i++)
            for(int j=0;j<N;j++)
                comp[i][j] = board[i][j];
        return isMoved;
    }
    static boolean dfs(int y, int x){
        visited[y][x] = true;
        total+=board[y][x];
        cnt++;
        boolean isMoved = false;
        int dy, dx, diff;
        for(int i=0;i<4;i++){
            dy = y+Y[i]; dx = x+X[i];
            if(dy<0||dx<0||dy>=N||dx>=N||visited[dy][dx])
                continue;
            diff = Math.abs(board[y][x]-board[dy][dx]);
            if(L<= diff && diff<=R){
                isMoved = true;
                dfs(dy,dx);
            }
        }
        return isMoved;
    }
    static void setDfs(int y, int x, int value){
        visited2[y][x] = true;
        comp[y][x] = value;
        int dy, dx, diff;
        for(int i=0;i<4;i++){
            dy = y+Y[i]; dx = x+X[i];
            if(dy<0||dx<0||dy>=N||dx>=N||visited2[dy][dx])
                continue;
            diff = Math.abs(board[y][x]-board[dy][dx]);
            if(L<= diff && diff<=R){
                setDfs(dy,dx,value);
            }
        }
    }
}