import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br;
    static BufferedWriter bw;
    static int N,M,K,top=0,right=2,up=1;
    static int[][] board;
    static int[] orders, dice, spare; // 1 2 3 4 5 6
    static StringBuilder sb = new StringBuilder(10000);

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = tmp[0]; M = tmp[1]; K = tmp[4];
        int y = tmp[2], x = tmp[3];
        tmp = new int[] {y,x};
        board = new int[N][M];
        for(int i=0;i<N;i++)
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        orders = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        dice = new int[6]; spare = new int[6];
        for(int i:orders){
            if(i == 1)
                tmp = east(tmp[0],tmp[1]);
            else if(i == 2)
                tmp = west(tmp[0],tmp[1]);
            else if(i == 3)
                tmp = north(tmp[0],tmp[1]);
            else
                tmp = south(tmp[0],tmp[1]);
        }
        bw.write(sb.toString());
        bw.flush();bw.close();br.close();
    }
    public static int[] east(int y, int x){
        if(!(x<M-1))
            return new int[] {y,x};
        int tmp = top;
        top = 5-right; right = tmp;
        if(board[y][x+1] == 0)
            board[y][x+1] = dice[5-top];
        else{
            dice[5-top] = board[y][x+1];
            board[y][x+1] = 0;
        }
        sb.append(dice[top]).append('\n');
        return new int[] {y,x+1};
    }
    public static int[] west(int y, int x){
        if(!(x>0))
            return new int[] {y,x};
        int tmp = right;
        right = 5-top; top = tmp;
        if(board[y][x-1] == 0)
            board[y][x-1] = dice[5-top];
        else{
            dice[5-top] = board[y][x-1];
            board[y][x-1] = 0;
        }
        sb.append(dice[top]).append('\n');
        return new int[] {y,x-1};
    }
    public static int[] north(int y, int x){
        if(!(y>0))
            return new int[] {y,x};
        int tmp = top;
        top = 5-up; up = tmp;
        if(board[y-1][x] == 0)
            board[y-1][x] = dice[5-top];
        else{
            dice[5-top] = board[y-1][x];
            board[y-1][x] = 0;
        }
        sb.append(dice[top]).append('\n');
        return new int[] {y-1,x};
    }
    public static int[] south(int y, int x){
        if(!(y<N-1))
            return new int[] {y,x};
        int tmp = up;
        up = 5-top; top = tmp;
        if(board[y+1][x] == 0)
            board[y+1][x] = dice[5-top];
        else{
            dice[5-top] = board[y+1][x];
            board[y+1][x] = 0;
        }
        sb.append(dice[top]).append('\n');
        return new int[] {y+1,x};
    }
}