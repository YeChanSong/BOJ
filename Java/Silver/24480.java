import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] visited;
    private static int order = 1;
    private static int startVertex;
    private static ArrayList<ArrayList<Integer>> adj;

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        settingInput();

        dfs(startVertex);
        for(int i=1; i<visited.length; i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static void settingInput() throws IOException {
        int[] initData = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        startVertex = initData[2];
        visited = new int[initData[0] +1];
        adj = new ArrayList<>();
        for (int i=0;i<initData[0]+1;i++) adj.add(new ArrayList<>());
        ArrayList<int[]> edges = new ArrayList<>();
        for (int i=0;i<initData[1];i++) {
            int[] edge = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            edges.add(edge);
            edges.add(new int[] {edge[1], edge[0]});
        }
        edges.sort((a,b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            else return b[0] - a[0];
        });
        edges.forEach((edge) ->  adj.get(edge[0]).add(edge[1]));
    }

    private static void dfs(int vertex) {
        visited[vertex] = order++;
        adj.get(vertex).forEach((next) -> {
            if (visited[next] == 0) dfs(next);
        });
    }


}