
import java.util.*;
import java.io.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static List<List<Integer>> adj = new ArrayList<>();

    private static List<Integer> tpSortList = new ArrayList<>();
    private static boolean[] visited;
    private static StringBuilder sb = new StringBuilder();

    private static int N,M;

    public static void main(String[] args) throws IOException {

        int[] nm = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();

        N = nm[0];
        M = nm[1];

        visited = new boolean[N];
        for(int i=0;i<N;i++) adj.add(new ArrayList<>());

        for(int i=0;i<M;i++) {
            int[] edge = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            adj.get(edge[0]-1).add(edge[1]-1);
        }

        dfsAll();

        Collections.reverse(tpSortList);
        tpSortList.forEach( item -> sb.append(item+1).append(" "));
        System.out.println(sb);
        br.close();
    }

    private static void dfsAll() {
        for(int i=0;i<N;i++) {
            if (!visited[i]) dfs(i);
        }
    }

    private static void dfs(int v) {
        visited[v] = true;

        adj.get(v).forEach(next -> {
            if (!visited[next]) dfs(next);
        });

        tpSortList.add(v);
    }


}


