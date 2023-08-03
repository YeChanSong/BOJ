import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static long[] arr;
	static boolean[] isUsed;
	static boolean flag = false;
	static ArrayList<Long> li = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
		isUsed = new boolean[N];
		for(int i=0;i<N;i++){
			isUsed[i] = true;
			li.add(arr[i]);
			recur(1);
			if(flag)
				return;
			li.remove(li.size()-1);
			isUsed[i] = false;
		}
		
	}
	static void recur(int idx){
		if(flag)
			return;
		if(idx == N){
			StringBuilder sb = new StringBuilder();
			for(long i: li)
				sb.append(i).append(' ');
			System.out.println(sb);
			flag = true;
			return;
		}
		long last = li.get(li.size()-1);
		for(int i=0;i<N;i++){
			if(isUsed[i])
				continue;
			if(!(last *2 == arr[i] || (last/3 == arr[i] && last%3 == 0)))
				continue;
			isUsed[i] = true;
			li.add(arr[i]);
			recur(idx+1);
			if(flag)
				return;
			li.remove(li.size()-1);
			isUsed[i] = false;
		}
		
	}
}