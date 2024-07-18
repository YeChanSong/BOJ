import java.io.*;
import java.util.*;


public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static ArrayList<ArrayList<Vertex>> adj;
    private static int[] dist;
    private static int startVertex;

    public static void main(String[] args) throws IOException {

        settingInput();
        dijkstra();
        StringBuilder sb = new StringBuilder();
        for (int i=1;i<dist.length;i++) if (dist[i] == Integer.MAX_VALUE) sb.append("INF").append("\n"); else sb.append(dist[i]).append("\n");
        System.out.println(sb);
        br.close();
    }

    private static void settingInput() throws IOException {

        int[] VE = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        startVertex = Integer.parseInt(br.readLine());
        adj = new ArrayList<>();
        dist = new int[VE[0]+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i=0;i<VE[0]+1;i++) adj.add(new ArrayList<>());
        for (int i=0;i<VE[1];i++) {
            // u, v, w
            int[] edge = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            adj.get(edge[0]).add(new Vertex( edge[1], edge[2] ));
        }

    }

    private static void dijkstra() {

        PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
        dist[startVertex] = 0;
        pq.offer(new Vertex(startVertex, 0));

        while(!pq.isEmpty()) {
            Vertex currentVertex = pq.poll();
            if (dist[currentVertex.number] < currentVertex.weight) continue;

            adj.get(currentVertex.number).forEach((nextVertex) -> {
                int nextDist = currentVertex.weight + nextVertex.weight;
                if ( dist[nextVertex.number] > nextDist ) {
                    dist[nextVertex.number] = nextDist;
                    pq.offer(new Vertex(nextVertex.number, nextDist));
                }
            });
        }

    }
}

class Vertex {
    int number;
    int weight;

    Vertex(int number, int weight) {
        this.number = number;
        this.weight = weight;
    }
}