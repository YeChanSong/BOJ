import java.util.*;
import java.io.*;

public class Main{
    static int V,E,K;
    static BufferedReader br;
    static BufferedWriter bw;
    static ArrayList<Node>[] adj;
    static int[] dist;

    static class Node implements Comparable<Node>{
        int pos,cost;
        public Node(int p, int c){
            this.pos = p;
            this.cost = c;
        }
        @Override
        public int compareTo(Node tgt){
            return cost-tgt.cost;
        }
    }

    static void dijkstra(){
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        dist[K-1] = 0;
        pq.offer(new Node(K-1,0));
        Node itm;
        while(!pq.isEmpty()){
            itm = pq.poll();
            if(dist[itm.pos]<itm.cost)
                continue;
            for(Node nxt: adj[itm.pos]){
                if(dist[nxt.pos]>itm.cost+nxt.cost){
                    dist[nxt.pos] = itm.cost+nxt.cost;
                    pq.offer(new Node(nxt.pos,dist[nxt.pos]));
                }
            }
        }

    }

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        adj = new ArrayList[V];
        
        for(int i=0;i<V;i++){
            adj[i] = new ArrayList<>();
        }
        dist = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            adj[Integer.parseInt(st.nextToken())-1].add(new Node(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())));
        }
        dijkstra();
        for(int i=0;i<V;i++){
            if(dist[i]==Integer.MAX_VALUE)
                bw.write("INF\n");
            else
                bw.write(Integer.toString(dist[i])+"\n");
            bw.flush();
        }
        bw.close();
        br.close();
    }
}