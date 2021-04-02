import java.util.*;
import java.io.*;

public class Main{
    static int[] dist;
    static BufferedReader br;
    static BufferedWriter bw;
    static int N,K;
    public static void bfs(){
        dist[N] = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(N);
        int itm;
        while(!q.isEmpty()){
            itm = q.poll();
            if(itm==K)
                break;
            if(itm*2<200000 && dist[itm*2]==-1){
                q.offer(itm*2);
                dist[itm*2] = dist[itm]+1;
            }
            if(itm+1<200000&& dist[itm+1]==-1){
                q.offer(itm+1);
                dist[itm+1] = dist[itm]+1;
            }
            if(itm-1>=0 && dist[itm-1]==-1){
                q.offer(itm-1);
                dist[itm-1] = dist[itm]+1;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dist = new int[200000];
        Arrays.fill(dist,-1);
        bfs();
        bw.write(Integer.toString(dist[K])+"\n");
        bw.flush();bw.close();br.close();
    }
}