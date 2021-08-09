import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] board;
    static ArrayList<int[]> virus, empty;
    static int[] Y = {1,-1,0,0}, X = {0,0,1,-1};
    static boolean[][] visited;
    static int ans=0, N, M, walls=0;
    public static void main(String[] args) throws IOException{
        int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = tmp[0]; M = tmp[1];
        board = new int[N][M];
        virus = new ArrayList<>();
        empty = new ArrayList<>();
        String[] init;
        for(int i=0;i<N;i++){
            init = br.readLine().split(" ");
            for(int j=0;j<M;j++){
                if(init[j].charAt(0) == '0')
                    empty.add(new int[] {i,j});
                else if(init[j].charAt(0) == '1')
                    walls++;
                else
                    virus.add(new int[] {i,j});
                board[i][j] = Integer.parseInt(init[j]);
            }
        }
        for(int i=-1;i<empty.size();i++) {
            posPicker(i,0);
        }
        System.out.println(ans-3);
    }
    public static int dfsAll(){ // 오염된 영역의 넓이
        int ret = 0;
        visited = new boolean[N][M];
        for(int[] arr: virus){
            ret += dfs(arr[0],arr[1]);
        }
        return ret;
    }
    public static int dfs(int y, int x){
        visited[y][x] = true;
        int dy,dx, ret=1;
        for(int i=0;i<4;i++){
            dy = y+Y[i]; dx = x+X[i];
            if(0>dy || 0>dx || dy>=N || dx>=M)
                continue;
            if(!visited[dy][dx] && board[dy][dx] == 0)
                ret += dfs(dy,dx);
        }
        return ret;
    }
    public static void posPicker(int idx, int cnt){
        if(cnt == 3){
            ans = Math.max(ans, N*M-walls-dfsAll());
            return;
        }
        int[] tmp;
        for(int i=idx+1;i<empty.size();i++){
            tmp = empty.get(i);
            board[tmp[0]][tmp[1]] = 1;
            posPicker(i,cnt+1);
            board[tmp[0]][tmp[1]] = 0;
        }
    }
}