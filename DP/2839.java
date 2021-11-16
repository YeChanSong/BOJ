import java.util.*;
import java.io.*;

public class Main{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] cache;
	static int N;
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		cache = new int[N+1];
		Arrays.fill(cache,987654321);
		cache[0] = 0;
		recur(N);
		if(cache[N]>=987654321)
			System.out.println(-1);
		else
			System.out.println(cache[N]);
	}
	static int recur(int idx){
		if(idx<0)
			return 987654321;
		
		if(cache[idx] < 987654321)
			return cache[idx];
		
		int tmp = Math.min(recur(idx-3), recur(idx-5))+1;
		cache[idx] = tmp;
		return tmp;
	}
	
}