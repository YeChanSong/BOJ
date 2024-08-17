
import java.util.*;
import java.io.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static List<List<Integer>> adj = new ArrayList<>();

    private static boolean[] visited;
    private static StringBuilder sb = new StringBuilder();

    private static int N,M,V;

    public static void main(String[] args) throws IOException {

        int[] nmv = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();

        N = nmv[0];
        M = nmv[1];
        V = nmv[2];

        visited = new boolean[N];

        for (int i=0;i<N;i++) adj.add(new ArrayList<>());

        for (int i=0;i<M;i++) {
            int[] edge = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            adj.get(edge[0]-1).add(edge[1]-1);
            adj.get(edge[1]-1).add(edge[0]-1);
        }

        adj.forEach( adjList -> adjList.sort(Integer::compare));

        dfs(V-1);
        visited = new boolean[N];
        sb.append("\n");
        bfs(V-1);
        System.out.println(sb);
        br.close();
    }

    private static void dfs(int v) {

        visited[v] = true;
        sb.append(v+1).append(" ");

        adj.get(v).forEach( next -> {
            if (!visited[next]) dfs(next);
        });

    }

    private static void bfs(int v) {

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offerLast(v);
        visited[v] = true;

        while(!queue.isEmpty()) {
            int current = queue.pollFirst();
            sb.append(current+1).append(" ");
            adj.get(current).forEach( next -> {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offerLast(next);
                }
            });
        }

    }


}


