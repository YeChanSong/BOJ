import java.util.*;
import java.io.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static ArrayList<ArrayList<Vertex>> adj = new ArrayList<>();
    private static int[] checkPoint;
    private static int V;
    private static long[] dist;
    public static void main(String[] args) throws IOException {
        settingInput();
        System.out.println(visitVertexWithOrder(checkPoint[0], checkPoint[1]));
        br.close();
    }

    private static void settingInput() throws IOException {
        int[] VE = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        V = VE[0];
        for(int i=0;i<VE[0]+1;i++) adj.add(new ArrayList<>());
        for(int i=0;i<VE[1];i++) {
            int[] edge = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            adj.get(edge[0]).add(new Vertex(edge[1], edge[2]));
            adj.get(edge[1]).add(new Vertex(edge[0], edge[2]));
        }
        dist = new long[VE[0]+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        checkPoint = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    private static void dijkstra(int startVertex) {
        PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a.weight));
        dist[startVertex] = 0;
        pq.offer(new Vertex(startVertex, 0));

        while(!pq.isEmpty()) {
            Vertex currentVertex = pq.poll();

            if (dist[currentVertex.number] < currentVertex.weight) continue;
            adj.get(currentVertex.number).forEach( (next) -> {
                long nextDist = currentVertex.weight + next.weight;
                if (dist[next.number] > nextDist) {
                    dist[next.number] = nextDist;
                    pq.offer(new Vertex(next.number, nextDist));
                }
            });

        }
    }

    private static long visitVertexWithOrder(int firstVertex, int secondVertex) {
        long startToFirstVertex = 0;
        long startToSecondVertex = 0;
        long firstVertexToSecondVertex = 0;
        long firstVertexToEnd = 0;
        long secondVertexToEnd = 0;

        dijkstra(firstVertex);
        startToFirstVertex = dist[1];
        firstVertexToSecondVertex = dist[secondVertex];
        firstVertexToEnd = dist[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dijkstra(secondVertex);
        startToSecondVertex = dist[1];
        secondVertexToEnd = dist[V];

        long routeA = startToFirstVertex + firstVertexToSecondVertex + secondVertexToEnd;
        long routeB = startToSecondVertex + firstVertexToSecondVertex + firstVertexToEnd;

        if (routeA >= Integer.MAX_VALUE && routeB >= Integer.MAX_VALUE) return -1;
        else return Long.min(routeA, routeB);
    }

}

class Vertex {
    int number;
    long weight;

    Vertex(int number, long weight) {
        this.number = number;
        this.weight = weight;
    }
}