import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M, X;
	static ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
	static int[] time;
	static int[] dist;
	public static void main(String[] args) throws IOException{
		int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		N = tmp[0]; M = tmp[1]; X = tmp[2]-1;
		time = new int[N];
		for(int i=0;i<N;i++)
			adj.add(new ArrayList<>());
		for(int i=0;i<M;i++){
			tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			adj.get(tmp[0]-1).add(new int[]{tmp[2],tmp[1]-1}); // cost, dest
		}
		for(int i=0;i<N;i++)
			dijkstra(i);
		System.out.println(Arrays.stream(time).max().getAsInt());
	
	
	}
	public static void dijkstra(int src){
		dist = new int[N];
		Arrays.fill(dist,987654321);
		PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a, int[] b)->Integer.compare(a[0],b[0]));
		pq.offer(new int[]{0,src});
		dist[src]=0;
		int[] itm;
		while(!pq.isEmpty()){
			itm = pq.poll();
			if(dist[itm[1]]<itm[0])
				continue;
			for(int[] nxt: adj.get(itm[1])){
				if(dist[nxt[1]]>nxt[0]+itm[0]){
					dist[nxt[1]]=nxt[0]+itm[0];
					pq.offer(new int[]{dist[nxt[1]],nxt[1]});
				}
			}
		}
		if(src == X){
			for(int i=0;i<N;i++)
				time[i]+=dist[i];
		}else{
			time[src]+=dist[X];
		}
		
		
	}
}