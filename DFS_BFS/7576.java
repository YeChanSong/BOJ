import java.util.*;
import java.io.*;

public class Main{
    static int[] X = {1,-1,0,0};
    static int[] Y = {0,0,1,-1};
    static BufferedReader br;
    static BufferedWriter bw;
    static int[][] dist;
    static int[][] board;
    static int M,N;
    static Queue<int[]> q;
    static int cnt=0;

    public static void bfs(){
        int[] itm;
        while(!q.isEmpty()){
            itm = q.poll();
            for(int i=0;i<4;i++){
                if(!(0<=itm[0]+Y[i] && itm[0]+Y[i]<N && 0<= itm[1]+X[i] && itm[1]+X[i]<M))
                    continue;
                if(board[itm[0]+Y[i]][itm[1]+X[i]] == -1 || dist[itm[0]+Y[i]][itm[1]+X[i]] != -1 )
                    continue;
                dist[itm[0]+Y[i]][itm[1]+X[i]] = dist[itm[0]][itm[1]] +1;
                q.offer(new int[] {itm[0]+Y[i],itm[1]+X[i]});
            }
        }
    }

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        dist = new int[N][M];
        q = new LinkedList<int[]>();
        int t=0;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0;j<M;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 1){
                    dist[i][j] = 0;
                    q.offer(new int[] {i,j});
                    t+=1;
                }
                else if(board[i][j] == -1){
                    cnt +=1;
                    dist[i][j] = -1;
                }
                else{
                    dist[i][j] = -1;
                }
            }
        }
        if(t==M*N-cnt){
            bw.write('0'+"\n");
            bw.flush(); bw.close(); br.close();
            return;
        }
        bfs();
        t=0;
        int mx=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(dist[i][j]==-1)
                    t+=1;
                if(mx<dist[i][j])
                    mx = dist[i][j];   
            }
        }
        if(t==cnt){
            bw.write(Integer.toString(mx)+"\n");
            bw.flush(); bw.close(); br.close();
        }else{
            bw.write("-1"+"\n");
            bw.flush(); bw.close(); br.close();
        }
    }
}