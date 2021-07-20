import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br;
    static int V,E,cnt;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> adj;
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp; int s,d;
        adj = new ArrayList<>();
        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());
        visited = new boolean[V];
        for(int i=0;i<V;i++)
            adj.add(new ArrayList<>());
        for(int i=0;i<E;i++){
            tmp = br.readLine().split(" ");
            s = Integer.parseInt(tmp[0])-1;
            d = Integer.parseInt(tmp[1])-1;
            adj.get(s).add(d);
            adj.get(d).add(s);
        }
        dfs(0);
        System.out.println(cnt-1);
    }
    public static void dfs(int idx){
        visited[idx] = true;
        cnt++;
        for(int i:adj.get(idx)){
            if(!visited[i]){
                dfs(i);
            }
        }
    }
}