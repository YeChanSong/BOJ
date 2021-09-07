import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, K=1;
    static int[] start, end, Y ={1,-1,0,0}, X = {0,0,1,-1};
    static int[][] board;
    static int[][][] dist;

    public static void main(String[] args) throws IOException{
        int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = tmp[0]; M = tmp[1];
        start = new int[2]; end = new int[2];
        tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        start[0] = tmp[0]-1; start[1] = tmp[1]-1; end[0] = tmp[2]-1; end[1] = tmp[3]-1;
        board = new int[N][M];
        for(int i=0;i<N;i++)
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        dist = new int[N][M][3];
        for(int i=0;i<N;i++)
            for(int j=0;j<M;j++)
                Arrays.fill(dist[i][j],Integer.MAX_VALUE);

        dijkstra();
        if(dist[end[0]][end[1]][0] == Integer.MAX_VALUE && dist[end[0]][end[1]][1] == Integer.MAX_VALUE && dist[end[0]][end[1]][2] == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(Math.min(dist[end[0]][end[1]][0],Math.min(dist[end[0]][end[1]][1],dist[end[0]][end[1]][2])));
    }
    static void dijkstra(){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        pq.offer(new int[]{0, 1, start[0], start[1]}); // 충격량 이동횟수 y좌표 x좌표
        dist[start[0]][start[1]][1] = 0;
        int[] itm;
        int dy,dx, nxt=0;
        while(!pq.isEmpty()){
            itm = pq.poll();

            if(itm[2] == end[0] && itm[3] == end[1])
                break;
            if(dist[itm[2]][itm[3]][itm[1]%3] < itm[0])
                continue;
            nxt = itm[1]+1;
            if(itm[1]%3==0){
                for(int i=0;i<4;i++){
                    dy = itm[2]+Y[i]; dx = itm[3]+X[i];
                    if(dy<0 || dx<0 || dy>=N || dx>=M)
                        continue;
                    if(board[dy][dx]!=-1 && dist[dy][dx][nxt%3]>board[dy][dx]+itm[0]){
                        dist[dy][dx][nxt%3] = board[dy][dx]+itm[0];
                        pq.offer(new int[]{dist[dy][dx][nxt%3], nxt,dy,dx});
                    }
                }
            } else if(itm[1]%3==1){
                for(int i=0;i<2;i++){
                    dy = itm[2]+Y[i]; dx = itm[3]+X[i];
                    if(dy<0 || dx<0 || dy>=N || dx>=M)
                        continue;
                    if(board[dy][dx]!=-1 && dist[dy][dx][nxt%3]>board[dy][dx]+itm[0]){
                        dist[dy][dx][nxt%3] = board[dy][dx]+itm[0];
                        pq.offer(new int[]{dist[dy][dx][nxt%3], nxt,dy,dx});
                    }
                }
            } else{
                for(int i=2;i<4;i++){
                    dy = itm[2]+Y[i]; dx = itm[3]+X[i];
                    if(dy<0 || dx<0 || dy>=N || dx>=M)
                        continue;
                    if(board[dy][dx]!=-1 && dist[dy][dx][nxt%3]>board[dy][dx]+itm[0]){
                        dist[dy][dx][nxt%3] = board[dy][dx]+itm[0];
                        pq.offer(new int[]{dist[dy][dx][nxt%3], nxt,dy,dx});
                    }
                }
            }
        }

    }
}