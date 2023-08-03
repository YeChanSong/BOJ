import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, start=-1;
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    static boolean[] visited, cycles;
    static int[] dist;
    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        cycles = new boolean[N];
        dist = new int[N];
        Arrays.fill(dist,-1);
        int[] tmp;
        for(int i=0;i<N;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<N;i++){
            tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            adj.get(tmp[0]-1).add(tmp[1]-1);
            adj.get(tmp[1]-1).add(tmp[0]-1);
        }
        DFS(0,-1);
        StringBuilder sb = new StringBuilder();
        BFS();
        for(int i: dist){
            sb.append(i).append(' ');
        }
        System.out.println(sb);
    }
    static void DFS(int idx, int before){
        visited[idx] = true;
        for(int i: adj.get(idx)){
            if(visited[i] && i!=before && start != idx){
                start = i;
                cycles[idx] = true;
                break;
            }
            if(!visited[i])
                DFS(i,idx);
        }
        if(idx!=start && cycles[idx])
            cycles[before] = true;
    }
    static void BFS(){
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0;i<cycles.length;i++){
            if(cycles[i]){
                q.offer(i);
                dist[i]=0;
            }
        }
        int itm=0;
        while(!q.isEmpty()){
            itm = q.poll();
            for(int i: adj.get(itm)){
                if(dist[i]==-1){
                    q.offer(i);
                    dist[i] = dist[itm]+1;
                }
            }

        }

    }
}