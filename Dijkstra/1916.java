import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    static int N, M, src, dest, ans = Integer.MAX_VALUE;
    static ArrayList<ArrayList<int[]>> adj;
    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        adj = new ArrayList<>();
        for(int i=0;i<N;i++)
            adj.add(new ArrayList<>());
        int[] tmp;
        for(int i=0;i<M;i++){
            tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            adj.get(tmp[0]-1).add(new int[] {tmp[1]-1, tmp[2]});
        }
        tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        src = tmp[0]-1; dest = tmp[1]-1;
        dijkstra();
        System.out.println(ans);
    }
    public static void dijkstra(){
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a, int[] b)->Integer.compare(a[0],b[0]));
        pq.add(new int[] {0,src});
        int[] costs = new int[N];
        Arrays.fill(costs, Integer.MAX_VALUE);
        int[] tmp;
        // adj.get(src) = {dest,cost}
        while (!pq.isEmpty()) {
            tmp = pq.poll(); // cost, src
            if(tmp[1] == dest)
                break;
            if(costs[tmp[1]]<tmp[0])
                continue;
            for(int[] arr: adj.get(tmp[1])){
                if(costs[arr[0]]>tmp[0]+arr[1]){
                    costs[arr[0]] = tmp[0]+arr[1];
                    pq.offer(new int[]{tmp[0]+arr[1], arr[0]});
                }
            }
        }
        ans = costs[dest];
    }
}