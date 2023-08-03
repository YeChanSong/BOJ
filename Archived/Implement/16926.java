import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br;
    static BufferedWriter bw;
    static Queue<Integer> q = new LinkedList<>();
    static int[][] board;
    static int N,M,R;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] tmp = br.readLine().split(" ");
        N = Integer.parseInt(tmp[0]);
        M = Integer.parseInt(tmp[1]);
        R = Integer.parseInt(tmp[2]);
        board = new int[N][M];
        for(int i=0;i<N;i++)
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for(int i=0;i<Math.min(N,M)/2;i++) {
            enque(i);
            setBoard(i);
        }
        StringBuilder sb = new StringBuilder(500000);
        for(int[] i: board) {
            for (int v : i) {
                sb.append(v).append(' ');
            }
            sb.append('\n');
        }
        bw.write(sb.toString());
        bw.flush();bw.close();br.close();
    }
    public static void setBoard(int start){
        int y = start, x = start, r = R%(2*(N+M)-4-8*start);
        if(r<N-2*start-1){
            y = start+r;
            for(;y<N-start-1;y++)
                board[y][x] = q.poll();
            for(;x<M-start-1;x++)
                board[y][x] = q.poll();
            for(;y>start;y--)
                board[y][x] = q.poll();
            for(;x>start;x--)
                board[y][x] = q.poll();
            for(;y<start+r;y++)
                board[y][x] = q.poll();
            return;
        }
        r -= (N-2*start-1);
        if(r<M-2*start-1){
            y = N-start-1;
            x = start+r;
            for(;x<M-start-1;x++)
                board[y][x] = q.poll();
            for(;y>start;y--)
                board[y][x] = q.poll();
            for(;x>start;x--)
                board[y][x] = q.poll();
            for(;y<N-start-1;y++)
                board[y][x] = q.poll();
            for(;x<start+r;x++)
                board[y][x] = q.poll();
            return;
        }
        r-= (M-2*start-1);
        if(r<N-2*start-1){
            y = N-start-1-r;
            x = M-start-1;
            for(;y>start;y--)
                board[y][x] = q.poll();
            for(;x>start;x--)
                board[y][x] = q.poll();
            for(;y<N-start-1;y++)
                board[y][x] = q.poll();
            for(;x<M-start-1;x++)
                board[y][x] = q.poll();
            for(;y>N-start-1-r;y--)
                board[y][x] = q.poll();
            return;
        }
        r -= (N-2*start-1);
        x = M-start-1-r;
        for(;x>start;x--)
            board[y][x] = q.poll();
        for(;y<N-start-1;y++)
            board[y][x] = q.poll();
        for(;x<M-start-1;x++)
            board[y][x] = q.poll();
        for(;y>start;y--)
            board[y][x] = q.poll();
        for(;x>M-start-1-r;x--)
            board[y][x] = q.poll();
    }
    public static void enque(int start){
        int y = start, x = start;
        for(;y<N-start-1;y++)
            q.add(board[y][x]);
        for(;x<M-start-1;x++)
            q.add(board[y][x]);
        for(;y>start;y--)
            q.add(board[y][x]);
        for(;x>start;x--)
            q.add(board[y][x]);
    }
}