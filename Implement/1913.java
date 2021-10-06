import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, target, tY, tX, dir=0;
	static int[] Y = {-1,0,1,0}, X = {0,1,0,-1};
	static int[][] board;
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		target = Integer.parseInt(br.readLine());
		board = new int[N][N];
		recur(N/2,N/2,1,0,1,0);
		StringBuilder sb = new StringBuilder();
		for(int[] arr: board){
			for(int i: arr)
				sb.append(i).append(' ');
			sb.append('\n');
		}
		sb.append(tY+1).append(' ').append(tX+1);
		System.out.println(sb);
	}
	static void recur(int y, int x, int lim, int cntr, int val, int change) {
		if (y >= N || x >= N || y<0 || x<0)
			return;
		if (val == target) {
			tY = y;
			tX = x;
		}
		board[y][x] = val;
		if(lim == cntr){
			cntr=0;
			dir++; dir%=4;
			change++;
		}
		if(change==2)
			recur(y+Y[dir], x+X[dir], lim+1, cntr+1,val+1,0);
		else
			recur(y+Y[dir], x+X[dir], lim, cntr+1, val+1, change);
		
	}
}