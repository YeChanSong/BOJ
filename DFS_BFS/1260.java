import java.util.*;
import java.io.*;

public class Main{
    static ArrayList<ArrayList<Integer>> adj;
    static BufferedReader br;
    static BufferedWriter bw;
    static boolean[] visited;
    static int n,m,v;
    static ArrayList<Integer> dfshist;
    static ArrayList<Integer> bfshist;

    public static void dfs(int idx){
        visited[idx]=true;
        dfshist.add(idx+1);
        for(int i=0;i<adj.get(idx).size();i++){
            if(visited[adj.get(idx).get(i)])
                continue;
            dfs(adj.get(idx).get(i));
        }
    }
    public static void bfs(){
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(v-1);
        boolean[] watched = new boolean[n];
        for(int i=0;i<n;i++)
            watched[i] = false;
        watched[v-1]=true;
        int itm;
        while(!q.isEmpty()){
            itm = q.poll();
            bfshist.add(itm+1);
            for(int i=0;i<adj.get(itm).size();i++){
                if(watched[adj.get(itm).get(i)])
                    continue;
                watched[adj.get(itm).get(i)] = true;
                q.offer(adj.get(itm).get(i));
            }
        }
    }

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s= br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        v = Integer.parseInt(s[2]);
        visited = new boolean[n];
        dfshist = new ArrayList<Integer>();
        bfshist = new ArrayList<Integer>();
        adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<n;i++){
            visited[i] = false;
            adj.add(new ArrayList<Integer>());
        }
        int src,dest;
        for(int i=0;i<m;i++){
            s=br.readLine().split(" ");
            src=Integer.parseInt(s[0]); dest=Integer.parseInt(s[1]);
            adj.get(src-1).add(dest-1);
            adj.get(dest-1).add(src-1);
        }
        for(int i=0;i<n;i++){
            Collections.sort(adj.get(i));
        }
        dfs(v-1);
        bfs();
        for(int i=0;i<dfshist.size();i++){
            bw.write(Integer.toString(dfshist.get(i))+" ");
        }
        bw.write("\n");
        bw.flush();
        for(int i=0;i<bfshist.size();i++){
            bw.write(Integer.toString(bfshist.get(i))+" ");
        }
        bw.write("\n");
        bw.flush();
        bw.close();
        br.close();
    }
}