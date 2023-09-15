import java.util.*;
import java.io.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static ArrayList<ArrayList<Integer>> adj;
    private static ArrayList<ArrayList<Integer>> revAdj;
    private static HashMap<Integer, Boolean> isBuildTree;
    private static HashMap<Integer, Integer> depthMap;

    private static int W;
    private static int N;
    private static int[] costs;
    private static boolean[] visited;
    private static List<Integer> tpSortList;

    public static void main(String[] args) throws IOException{
        int T = Integer.parseInt(br.readLine());
        for (int i=0;i<T;i++) {
            settingInput();
            revDfs(W);
            dfsStartVertex();
            Collections.reverse(tpSortList);
            tpSortList.forEach( (vertex) -> {
                int beforeMaxCost = 0;
                ArrayList<Integer> beforeVertexes = revAdj.get(vertex);
                for (Integer beforeVertex : beforeVertexes) {
                    beforeMaxCost = beforeMaxCost >= depthMap.getOrDefault(beforeVertex, 0)
                            ? beforeMaxCost
                            : depthMap.getOrDefault(beforeVertex, 0);
                }
                depthMap.put(vertex, beforeMaxCost + costs[vertex]);
            });
            System.out.println(depthMap.get(W));
        }
        br.close();
    }

    private static void settingInput() throws IOException {
        adj = new ArrayList<>();
        revAdj = new ArrayList<>();
        isBuildTree = new HashMap<>();
        depthMap = new HashMap<>();
        tpSortList = new LinkedList<>();
        int[] NK = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = NK[0];
        int k = NK[1];
        visited = new boolean[N];
        for (int i = 0; i< N; i++) {
            adj.add(new ArrayList<>());
            revAdj.add(new ArrayList<>());
        }

        costs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i< k; i++) {
            String[] edge = br.readLine().split(" ");
            adj.get(Integer.parseInt(edge[0])-1).add(Integer.parseInt(edge[1])-1);
            revAdj.get(Integer.parseInt(edge[1])-1).add(Integer.parseInt(edge[0])-1);
        }
        W = Integer.parseInt(br.readLine())-1;
    }

    private static void revDfs(int vertex) {
        visited[vertex] = true;
        isBuildTree.putIfAbsent(vertex, true);

        revAdj.get(vertex).forEach( (next) -> {
            if (!visited[next]) {
                revDfs(next);
            }
        });

    }

    private static void dfsStartVertex() {
        visited = new boolean[N];
        for (int i=0;i<N;i++) {
            if (!visited[i] && isBuildTree.get(i) != null && revAdj.get(i).isEmpty()) {
                dfs(i);
            }
        }

    }

    private static void dfs(int vertex) {
        visited[vertex] = true;
        adj.get(vertex).forEach( next -> {
            if ( !visited[next] && isBuildTree.get(next) != null) {
                dfs(next);
            }
        });
        tpSortList.add(vertex);
    }
}