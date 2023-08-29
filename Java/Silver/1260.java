import java.util.*;
import java.io.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static ArrayList<ArrayList<Integer>> adj;
    private static int startVertex;
    private static int totalVertex;
    private static boolean[] visited;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        settingInput();

        visited = new boolean[totalVertex];
        DFS(startVertex);
        System.out.println(sb);

        sb = new StringBuilder();
        visited = new boolean[totalVertex];
        BFS(startVertex);
        System.out.println(sb);
    }

    static void settingInput() throws IOException {
        int[] conditions = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        totalVertex = conditions[0]+1;
        startVertex = conditions[2];

        adj = new ArrayList<>( totalVertex );
        for (int i=0;i<totalVertex; i++) {
            adj.add(new ArrayList<>());
        }
        ArrayList<int[]> edges = new ArrayList<>();
        for (int i=0;i<conditions[1]; i++) {
            int[] edge = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            edges.add(edge);
            int[] reverseEdge =  {edge[1], edge[0]};
            edges.add(reverseEdge);
        }
        edges.sort( (a, b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            else return a[0] - b[0];
        });

        edges.forEach( (edge) ->
                adj.get(edge[0]).add(edge[1])
        );

    }

    static void DFS(int startVertex) {
        visited[startVertex] = true;
        sb.append(startVertex).append(" ");
        adj.get(startVertex).forEach( (next) -> {
            if (!visited[next]) DFS(next);
        });
    }

    static void BFS(int startVertex) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        visited[startVertex] = true;
        sb.append(startVertex).append(" ");
        queue.offer(startVertex);

        while (!queue.isEmpty()) {
            int vertex = queue.pollFirst();
            adj.get(vertex).forEach((next) -> {
                if(!visited[next]) {
                    visited[next] = true;
                    sb.append(next).append(" ");
                    queue.offerLast(next);
                }
            });
        }
    }

}