import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M;
	static int[][] adj;
	
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		adj = new int[N][N];
		
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(i!=j)
					adj[i][j] = 987654321;
			}
		}
		
		int[] tmp;
		for(int i=0;i<M;i++){
			tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			if(adj[tmp[0]-1][tmp[1]-1]>tmp[2])
				adj[tmp[0]-1][tmp[1]-1] = tmp[2];
		}
		
		for(int k=0;k<N;k++){
			for(int i=0;i<N;i++){
				if(i==k)
					continue;
				for(int j=0;j<N;j++){
					adj[i][j] = Math.min(adj[i][j], adj[i][k]+adj[k][j]);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(adj[i][j] >= 987654321)
					sb.append(0).append(' ');
				else
					sb.append(adj[i][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}