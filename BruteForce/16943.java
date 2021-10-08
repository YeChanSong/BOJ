import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int A, B, lim;
	static long answer;
	static boolean[] isUsed;
	static ArrayList<Integer> arr = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		A = tmp[0]; B = tmp[1];
		answer = -1;
		String str = String.valueOf(A);
		lim = str.length();
		isUsed = new boolean[lim];
		for(char c: str.toCharArray())
			arr.add(c-'0');
		recur(0);
		
		System.out.println(answer);
		
	}
	static void recur(int idx){
		if(idx == lim){
			if(sb.charAt(0) == '0')
				return;
			int ans = Integer.parseInt(sb.toString());
			if(ans<B && ans>answer){
				answer = ans;
			}
			return;
		}
		
		for(int i=0;i<lim;i++){
			if(isUsed[i])
				continue;
			isUsed[i] = true;
			sb.append(arr.get(i));
			recur(idx+1);
			sb.deleteCharAt(sb.length()-1);
			isUsed[i] = false;
		}
	}
}
