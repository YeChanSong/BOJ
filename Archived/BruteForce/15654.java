import java.io.*;
import java.util.*;

public class Main{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M;
	static int[] arr;
	static ArrayList<Integer> hist = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		N = tmp[0]; M = tmp[1];
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(arr);
		for(int i=0;i<arr.length;i++){
			hist.add(arr[i]);
			recur(i,1);
			hist.remove(hist.size()-1);
		}
		
	}
	static void recur(int idx, int cnt){
		if(cnt == M){
			StringBuilder sb = new StringBuilder();
			for(int i: hist){
				sb.append(i).append(' ');
			}
			System.out.println(sb);
			return;
		}
		for(int i=0;i<N;i++){
			if(hist.contains(arr[i]))
				continue;
			hist.add(arr[i]);
			recur(i+1,cnt+1);
			hist.remove(hist.size()-1);
		}
		
		
	}
}
