import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br;
    static int N,K;
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        N = Integer.parseInt(tmp[0]);
        K = Integer.parseInt(tmp[1]);
        System.out.println(BFS());
    }
    public static int BFS(){
        Queue<Integer> q = new LinkedList<>();
        q.offer(N);
        int[] dist = new int[100001];
        Arrays.fill(dist,-1);
        dist[N] = 0;

        int itm;
        while(!q.isEmpty()){
            itm = q.poll();
            if(dist[K] != -1)
                break;
            if(2*itm<=100000 && dist[itm*2] == -1){
                q.offer(2*itm);
                dist[2*itm] = dist[itm]+1;
            }
            if(itm+1<=100000 && dist[itm+1]==-1){
                q.offer(itm+1);
                dist[itm+1] = dist[itm]+1;
            }
            if(itm>0 && dist[itm-1] == -1){
                q.offer(itm-1);
                dist[itm-1] = dist[itm]+1;
            }
        }

        return dist[K];
    }

}