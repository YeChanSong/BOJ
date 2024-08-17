
import java.util.*;
import java.io.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static List<List<Node>> adj = new ArrayList<>();

    private static int[] costs;
    private static StringBuilder sb = new StringBuilder();

    private static int V,E,start;

    public static void main(String[] args) throws IOException {

        int[] ve = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        start = Integer.parseInt(br.readLine().trim())-1;
        V = ve[0];
        E = ve[1];
        costs = new int[V];
        Arrays.fill(costs, Integer.MAX_VALUE);
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());

        for(int i=0;i<E;i++) {
            int[] edge = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            adj.get(edge[0]-1).add(new Node(edge[1]-1, edge[2]));
        }

        dijkstra();
        costs[start] = 0;
        for(int cost : costs) {
            if (cost == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(cost);
            }
        }
        br.close();
    }

    private static void dijkstra() {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node curr = pq.poll();
            if (costs[curr.getTarget()] < curr.getWeight()) continue;
            adj.get(curr.getTarget()).forEach(next -> {
                if (costs[next.getTarget()] > curr.getWeight() + next.getWeight()) {
                    costs[next.getTarget()] = curr.getWeight() + next.getWeight();
                    pq.offer(new Node(next.getTarget(), costs[next.getTarget()]));
                }
            });
        }

    }


}


class Node implements Comparable<Node>{
    private final Integer target;

    private final Integer weight;

    public Node(int target, int weight) {
        this.target = target;
        this.weight = weight;
    }

    public Integer getTarget() {
        return this.target;
    }

    public Integer getWeight() {
        return this.weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.getWeight();
    }
}