import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, ans=0;
	static char[][] board;
	static int[][] colors;
	static int[] Y = {-1,-1,0,1,1,0}, X = {0,1,1,0,-1,-1};
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		board = new char[N][N];
		colors = new int[N][N];
		for(int i=0;i<N;i++) {
			board[i] = br.readLine().toCharArray();
			Arrays.fill(colors[i],-1);
		}
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(board[i][j]=='X' && colors[i][j]==-1) {
					ans = Math.max(ans,1);
					if (dfs(i, j,0)) {
						System.out.println(ans);
						return;
					}
				}
			}
		}
		System.out.println(ans);
	}
	static boolean dfs(int y, int x, int color){
		colors[y][x] = color;
		int dy=0,dx=0;
		for(int i=0;i<6;i++){
			dy = y+Y[i]; dx = x+X[i];
			if(0>dy || 0>dx || dy>=N || dx>=N)
				continue;
			if(board[dy][dx] == '-')
				continue;
			if(colors[dy][dx]==-1){
				ans = Math.max(ans,2);
				if(dfs(dy,dx,1-color))
					return true;
			}
			if(colors[dy][dx] == color){
				ans = 3;
				return true;
			}
		}
		return false;
	}
}