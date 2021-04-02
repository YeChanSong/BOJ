import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br;
    static BufferedWriter bw;
    static int N,E,v1,v2;
    static ArrayList<Node>[] adj;
    static int[] dist;
    
    static class Node implements Comparable<Node>{
        int cost,pos;
        public Node(int p,int c){
            this.pos =p;
            this.cost =c;
        }
        @Override
        public int compareTo(Node tgt){
            return cost-tgt.cost;
        }
    }

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N];
        int s,d,c;
        for(int i=0;i<N;i++)
            adj[i]=new ArrayList<Node>();
        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            s=Integer.parseInt(st.nextToken())-1;
            d=Integer.parseInt(st.nextToken())-1;
            c=Integer.parseInt(st.nextToken());
            adj[s].add(new Node(d,c));
            adj[d].add(new Node(s,c));
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken())-1;
        v2 = Integer.parseInt(st.nextToken())-1;
        dijkstra(v1);
        int AtoEnd,Ato1,vtov,res;
        AtoEnd=dist[N-1];Ato1=dist[0];vtov=dist[v2];
        dijkstra(v2);
        int BtoEnd,Bto1;
        BtoEnd=dist[N-1];Bto1=dist[0];
        res = Math.min(AtoEnd+vtov+Bto1,BtoEnd+vtov+Ato1);
        if(res>=1000000)
            bw.write(Integer.toString(-1)+"\n");
        else
            bw.write(Integer.toString(res)+"\n");
        bw.flush();bw.close();br.close();
    }

    static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        dist = new int[N];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start] = 0;
        pq.offer(new Node(start,0));
        Node tmp;
        while(!pq.isEmpty()){
            tmp = pq.poll();
            if(dist[tmp.pos]<tmp.cost)
                continue;
            for(Node nxt: adj[tmp.pos]){
                if(dist[nxt.pos]>nxt.cost+tmp.cost){
                    dist[nxt.pos]=nxt.cost+tmp.cost;
                    pq.offer(new Node(nxt.pos,dist[nxt.pos]));
                }
            }
        }
    }
}