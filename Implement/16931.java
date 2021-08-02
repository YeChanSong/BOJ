import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br;
    static int N,M,ans=0;
    static int[] Y = {0,0,1,-1}, X = {1,-1,0,0};
    static int[][] board;
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        N = Integer.parseInt(tmp[0]);
        M = Integer.parseInt(tmp[1]);
        board = new int[N][M];
        for(int i=0;i<N;i++)
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        checkAll();
        System.out.println(ans);
    }
    public static void checkAll(){
        int dy,dx;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                ans+=6*board[i][j];
                ans-=2*(board[i][j]-1); // up, down
                for(int k=0;k<4;k++){
                    dy = i+Y[k];dx = j+X[k];
                    if(!(0<=dy && dy<N && 0<=dx && dx<M))
                        continue;
                    if(board[i][j]<=board[dy][dx])
                        ans-=board[i][j];
                    else
                        ans-=board[dy][dx];
                }
            }
        }
    }
}