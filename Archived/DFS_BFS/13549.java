import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static int[] dist;
    static int N,K;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        N = Integer.parseInt(tmp[0]);
        K = Integer.parseInt(tmp[1]);
        dist = new int[100001];
        Arrays.fill(dist,Integer.MAX_VALUE);
        System.out.println(dijkstra(N));
        br.close();
    }
    public static int dijkstra(int start){
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if(a[0] == b[0])
                    return Integer.compare(a[1],b[1]);
                else
                    return Integer.compare(a[0],b[0]);
            }
        });
        pq.offer(new int[]{0,start});
        dist[start] = 0;
        int[] itm;
        while(!pq.isEmpty()){
            itm = pq.poll();
            if(itm[1] == K)
                break;
            if(itm[1]*2<100001 && dist[itm[1]*2]>itm[0]){
                dist[itm[1]*2] = itm[0];
                pq.offer(new int[] { dist[itm[1]*2],itm[1]*2 });
            }
            if(itm[1]+1<100001 && dist[itm[1]+1]>itm[0]+1){
                dist[itm[1]+1] = itm[0]+1;
                pq.offer(new int[] {dist[itm[1]+1],itm[1]+1});
            }
            if(itm[1]>0 && dist[itm[1]-1]>itm[0]+1){
                dist[itm[1]-1] = itm[0]+1;
                pq.offer(new int[] {dist[itm[1]-1],itm[1]-1});
            }
        }
        return dist[K];
    }
}