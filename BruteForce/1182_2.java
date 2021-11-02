import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[][] board = new int[20][20];
	static int N, M;
	static boolean[] isUsed;
	static ArrayList<Integer> hist = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		N = tmp[0]; M = tmp[1];
		isUsed = new boolean[N+1];
		for(int i=1;i<=N;i++){
			isUsed[i]=true;
			hist.add(i);
			recur(1);
			hist.remove(hist.size()-1);
			isUsed[i]=false;
		}
		bw.flush();
	}
	static void recur(int cntr) throws IOException {
		if(cntr == M){
			StringBuilder sb = new StringBuilder();
			for(int i: hist)
				sb.append(i).append(' ');
			sb.append('\n');
			bw.write(sb.toString());
			
			return;
		}
		for(int i=1;i<=N;i++){
			if (isUsed[i])
				continue;
			isUsed[i] = true;
			hist.add(i);
			recur(cntr+1);
			hist.remove(hist.size()-1);
			isUsed[i] = false;
		}
		
	}
}