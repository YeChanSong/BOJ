import java.io.*;
import java.util.*;


public class Main{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String[] board;
	static boolean[][] visited;
	static int N=0;
	static int[] Y={1,-1,0,0}, X={0,0,1,-1};
	
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		board = new String[N];
		for(int i=0;i<N;i++){
			board[i] = br.readLine();
		}
		visited = new boolean[N][N];
		StringBuilder sb = new StringBuilder();
		int cnt=0;
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(!visited[i][j]) {
					RGB(i, j);
					cnt++;
				}
			}
		}
		sb.append(cnt).append(' ');
		visited = new boolean[N][N];
		cnt =0;
		boolean flag = false;
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(!visited[i][j]) {
					if(board[i].charAt(j) == 'B')
						flag = false;
					else
						flag = true;
					RG_B(i, j, flag);
					cnt++;
				}
			}
		}
		sb.append(cnt);
		System.out.println(sb);
	}
	static void RGB(int y, int x){
		visited[y][x] = true;
		int dy=0,dx=0;
		for(int i=0;i<4;i++){
			dy = y+Y[i]; dx = x+X[i];
			if(0>dy || 0>dx || dy>=N || dx>=N || visited[dy][dx])
				continue;
			if(board[dy].charAt(dx) == board[y].charAt(x))
				RGB(dy,dx);
		}
		
	}
	static void RG_B(int y, int x, boolean flag){
		visited[y][x] = true;
		
		int dy=0,dx=0;
		for(int i=0;i<4;i++){
			dy = y+Y[i]; dx = x+X[i];
			if(0>dy || 0>dx || dy>=N || dx>=N || visited[dy][dx])
				continue;
			if (!flag && board[dy].charAt(dx) == 'B')
				RG_B(dy, dx, flag);
			else if (flag && board[dy].charAt(dx) != 'B')
				RG_B(dy, dx, flag);
		}
	}
}