import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][][] type1 = {
            // 2by2
            {{1, 1}, {1, 1}}
    }, type2 = {
            // 2by3
            {{0, 1, 0}, {1, 1, 1}},
            {{1, 1, 1}, {0, 1, 0}},
            {{1, 1, 0}, {0, 1, 1}},
            {{0, 1, 1}, {1, 1, 0}},
            {{1, 0, 0}, {1, 1, 1}},
            {{0, 0, 1}, {1, 1, 1}},
            {{1, 1, 1}, {0, 0, 1}},
            {{1, 1, 1}, {1, 0, 0}},
    }, type3 = {
            // 3by2
            {{0, 1}, {1, 1}, {0, 1}},
            {{1, 0}, {1, 1}, {1, 0}},
            {{1, 0}, {1, 1}, {0, 1}},
            {{0, 1}, {1, 1}, {1, 0}},
            {{1, 0}, {1, 0}, {1, 1}},
            {{1, 1}, {0, 1}, {0, 1}},
            {{0, 1}, {0, 1}, {1, 1}},
            {{1, 1}, {1, 0}, {1, 0}}
    }, type4 = {
            // 1by4
            {{1, 1, 1, 1}}
    }, type5 = {
            // 4by1
            {{1}, {1}, {1}, {1}}
    };

    static int N,M, ans=0;
    static int[][] board;
    public static void main(String[] args) throws IOException{
        int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = tmp[0]; M = tmp[1];
        board = new int[N][M];
        for(int i=0;i<N;i++)
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        matching();
        System.out.println(ans);
    }
    static void matching(){
        int sum=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){

                if(i+1<N && j+1<M){
                    for (int[][] ints : type1) {
                        for (int y = 0; y < 2; y++)
                            for (int x = 0; x < 2; x++)
                                if (ints[y][x] == 1)
                                    sum += board[i + y][j + x];
                        if (sum > ans)
                            ans = sum;
                        sum = 0;
                    }
                }
                if(i+1<N && j+2<M){
                    for (int[][] ints : type2) {
                        for (int y = 0; y < 2; y++)
                            for (int x = 0; x < 3; x++)
                                if (ints[y][x] == 1)
                                    sum += board[i + y][j + x];
                        if (sum > ans)
                            ans = sum;
                        sum = 0;
                    }
                }
                if(i+2<N && j+1<M){
                    for (int[][] ints : type3) {
                        for (int y = 0; y < 3; y++)
                            for (int x = 0; x < 2; x++)
                                if (ints[y][x] == 1)
                                    sum += board[i + y][j + x];
                        if (sum > ans)
                            ans = sum;
                        sum = 0;
                    }
                }
                if(j+3<M){
                    for (int[][] ints : type4) {
                        for (int x = 0; x < 4; x++)
                            if (ints[0][x] == 1)
                                sum += board[i][j + x];
                        if (sum > ans)
                            ans = sum;
                        sum = 0;
                    }
                }
                if(i+3<N){
                    for (int[][] ints : type5) {
                        for (int y = 0; y < 4; y++)
                            if (ints[y][0] == 1)
                                sum += board[i + y][j];
                        if (sum > ans)
                            ans = sum;
                        sum = 0;
                    }
                }
            }
        }
    }
}