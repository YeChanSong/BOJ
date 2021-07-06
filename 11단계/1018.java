import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] comp1 = {
                {1,0,1,0,1,0,1,0},
                {0,1,0,1,0,1,0,1},
                {1,0,1,0,1,0,1,0},
                {0,1,0,1,0,1,0,1},
                {1,0,1,0,1,0,1,0},
                {0,1,0,1,0,1,0,1},
                {1,0,1,0,1,0,1,0},
                {0,1,0,1,0,1,0,1}

        };
        int[][] comp2 = {
                {0,1,0,1,0,1,0,1},
                {1,0,1,0,1,0,1,0},
                {0,1,0,1,0,1,0,1},
                {1,0,1,0,1,0,1,0},
                {0,1,0,1,0,1,0,1},
                {1,0,1,0,1,0,1,0},
                {0,1,0,1,0,1,0,1},
                {1,0,1,0,1,0,1,0}
        };
        int N,M;
        String[] tmp = br.readLine().split(" ");
        N = Integer.parseInt(tmp[0]);
        M = Integer.parseInt(tmp[1]);
        int[][] board = new int[N][M];
        char[] init;
        for(int i=0;i<N;i++){
            init = br.readLine().toCharArray();
            for(int j=0;j<M;j++){
                if(init[j] == 'W')
                    board[i][j] = 1;
                else
                    board[i][j] = 0;
            }
        }
        int y = N-8, x = M-8, dy,dx;
        int cnt1 =0, cnt2 =0, min = 100000;
        for(int i=0;i<=y;i++){
            for(int j=0;j<=x;j++){
                cnt1 = 0;
                cnt2 = 0;
                for(int cy=0;cy<8;cy++){
                    dy = i+cy;
                    for(int cx=0;cx<8;cx++){
                        dx = j+cx;
                        cnt1 += board[dy][dx]^comp1[cy][cx];
                        cnt2 += board[dy][dx]^comp2[cy][cx];
                    }
                }
                min = Math.min(min,cnt1);
                min = Math.min(min,cnt2);
            }
        }
        bw.write(String.valueOf(min));
        bw.flush();bw.close();br.close();
    }
}