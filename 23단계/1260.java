import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br;
    static BufferedWriter bw;
    static StringBuilder sb;
    static ArrayList<ArrayList<Integer>> adj;
    static int[] hist;
    static int N,M,V;
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder(8192);
        String[] tmp = br.readLine().split(" ");
        int s,d;

        N = Integer.parseInt(tmp[0]);
        M = Integer.parseInt(tmp[1]);
        V = Integer.parseInt(tmp[2])-1;
        adj = new ArrayList<>();
        for(int i=0;i<N;i++)
            adj.add(new ArrayList<>());
        for(int i=0;i<M;i++){
            tmp = br.readLine().split(" ");
            s = Integer.parseInt(tmp[0])-1;
            d = Integer.parseInt(tmp[1])-1;
            adj.get(s).add(d);
            adj.get(d).add(s);
        }
        for(ArrayList<Integer> li: adj){
            Collections.sort(li);
        }
        hist = new int[N];
        DFS(V);
        sb.append('\n');
        hist = new int[N];
        BFS(V);
        sb.append('\n');
        bw.write(sb.toString());
        bw.flush();bw.close();br.close();
    }
    public static void DFS(int idx){
        hist[idx] = 1;
        sb.append(idx+1).append(' ');
        for(int i: adj.get(idx)){
            if(hist[i] == 0){
                DFS(i);
            }
        }
    }
    public static void BFS(int idx){
        Queue<Integer> q = new LinkedList<>();
        q.offer(idx);
        hist[idx] = 1;
        sb.append(idx+1).append(' ');
        int itm;
        while(!q.isEmpty()){
            itm = q.poll();
            for(int i: adj.get(itm)){
                if(hist[i]==0){
                    hist[i] = 1;
                    sb.append(i+1).append(' ');
                    q.offer(i);
                }
            }
        }
    }
}