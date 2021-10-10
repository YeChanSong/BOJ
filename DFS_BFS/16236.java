import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M=0, sY, sX, size=2, eating=0, ans=0;
	static int[] Y = {-1,1,0,0}, X = {0,0,-1,1};
	static int[][] board, dist;
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		
		for(int i=0;i<N;i++){
			board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			for(int j=0;j<N;j++) {
				if (board[i][j] == 9){
					sY = i; sX = j;
					board[i][j] = 0;
				}else if(board[i][j] != 0){
					M++;
				}
			}
		}
		while(moving()){}
		System.out.println(ans);
	}
	static boolean moving(){
		
		bfs();
		ArrayList<int[]> fish = new ArrayList<>();
		
		Comparator<int[]> com = ((int[] a, int[] b)->{
			if(a[0] == b[0]){
				if(a[1] == b[1]){
					return Integer.compare(a[2],b[2]);
				}else{
					return Integer.compare(a[1],b[1]);
				}
			}else{
				return Integer.compare(a[0],b[0]);
			}
		});
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(board[i][j] != 0 && board[i][j] != 9 && dist[i][j] != -1){
					fish.add(new int[]{dist[i][j], i, j, board[i][j]});
				}
			}
		}
		fish.sort(com);
		boolean flag = false;
		for(int[] itm: fish){
			if(itm[3]>=size)
				continue;
			else {
				eating += 1;
				if (eating >= size) {
					eating = 0;
					size++;
				}
				sY = itm[1];
				sX = itm[2];
				
				board[sY][sX] = 0;
				flag = true;
				M--;
				ans += itm[0];
				break;
			}
		}
		
		if(M==0 || !flag)
			return false;
		return true;
	}
	
	static void bfs(){
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {sY, sX});
		dist = new int[N][N];
		for(int i=0;i<N;i++)
			Arrays.fill(dist[i], -1);
		dist[sY][sX] = 0;
		int[] itm; int dy=0, dx=0;
		while(!q.isEmpty()){
			itm = q.poll();
			for(int i=0;i<4;i++){
				dy = itm[0]+Y[i]; dx = itm[1]+X[i];
				if(dy<0 || dx<0 || dy>=N || dx>=N)
					continue;
				if(dist[dy][dx] != -1 || board[dy][dx]>size)
					continue;
				dist[dy][dx] = dist[itm[0]][itm[1]]+1;
				q.offer(new int[]{dy, dx});
			}
		}
		
	}
	
}