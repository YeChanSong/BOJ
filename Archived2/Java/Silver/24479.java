import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static ArrayList<ArrayList<Integer>> adj;
    private static int order = 1;

    private static int startVertex;

    private static int[] visited;

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        settingInput();
        dfs(startVertex);
        for (int i=1;i<visited.length;i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static void settingInput() throws IOException {

        int[] initData = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        adj = new ArrayList<>(initData[0]+1);
        visited = new int[initData[0]+1];
        startVertex = initData[2];
        for (int i=0;i<initData[0]+1;i++) adj.add(new ArrayList<>());
        ArrayList<int[]> edges = new ArrayList<>();
        for (int i=0;i<initData[1];i++) {
            int[] edge = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            edges.add(edge);
            edges.add(new int[] {edge[1], edge[0]});
        }

        edges.sort( (a,b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            else return a[0]-b[0];
        });

        edges.forEach((edge) -> {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        });

    }

    private static void dfs(int vertex) {
        visited[vertex] = order++;
        adj.get(vertex).forEach((next) -> {
            if(visited[next] == 0) dfs(next);
        });
    }



}