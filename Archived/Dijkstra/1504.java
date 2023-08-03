import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N,E, V1, V2, AtoV1, AtoV2, BtoV1, BtoV2, VtoV;
    static ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = tmp[0]; E =tmp[1];
        for(int i=0;i<N;i++)
            adj.add(new ArrayList<>());
        for(int i=0;i<E;i++){
            tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            adj.get(tmp[0]-1).add(new int[]{tmp[1]-1,tmp[2]});
            adj.get(tmp[1]-1).add(new int[]{tmp[0]-1,tmp[2]});
        }
        tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        V1= tmp[0]-1; V2= tmp[1]-1;
        dijkstra();
        long sum1 = (long)AtoV1+(long)VtoV+(long)BtoV2;
        long sum2 = (long)AtoV2+(long)VtoV+(long)BtoV1;
        if(sum1>=Integer.MAX_VALUE && sum2>=Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            if(sum1<sum2)
                System.out.println(sum1);
            else
                System.out.println(sum2);
        }
    }
    static void dijkstra(){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->Integer.compare(a[0],b[0]));
        int[] dist = new int[N];
        Arrays.fill(dist,Integer.MAX_VALUE);
        pq.offer(new int[]{0,V1});
        dist[V1] = 0;
        int[] itm;
        while(!pq.isEmpty()){
            itm= pq.poll();
            if(dist[itm[1]]<itm[0])
                continue;
            for(int[] nxt: adj.get(itm[1])){
                if(dist[nxt[0]]>nxt[1]+itm[0]){
                    dist[nxt[0]] = nxt[1]+itm[0];
                    pq.offer(new int[]{dist[nxt[0]],nxt[0]});
                }
            }
        }
        AtoV1 = dist[0]; BtoV1 = dist[N-1]; VtoV = dist[V2];
        Arrays.fill(dist,Integer.MAX_VALUE);
        pq.offer(new int[]{0,V2});
        dist[V2]=0;
        while(!pq.isEmpty()){
            itm= pq.poll();
            if(dist[itm[1]]<itm[0])
                continue;
            for(int[] nxt: adj.get(itm[1])){
                if(dist[nxt[0]]>nxt[1]+itm[0]){
                    dist[nxt[0]] = nxt[1]+itm[0];
                    pq.offer(new int[]{dist[nxt[0]],nxt[0]});
                }
            }
        }
        AtoV2 = dist[0]; BtoV2 = dist[N-1];
    }
}