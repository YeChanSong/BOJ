import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int L,T;
	static long[] cache;
	public static void main(String[] args) throws IOException{
		T = Integer.parseInt(br.readLine());
		cache = new long[5001];
		Arrays.fill(cache,-1);
		cache[0]=1;
		for(int p=0;p<T;p++){
			L = Integer.parseInt(br.readLine());
			if(L%2==1)
				System.out.println(0);
			else
				System.out.println(recur(L));
		}
	}
	static long recur(int idx){
		if(idx<0)
			return 0;

		if(cache[idx]!=-1)
			return cache[idx];

		long tmp=0;
		for(int i=2;i<=idx;i+=2){
			tmp+=((recur(i-2)%1000000007)*(recur(idx-i))%1000000007)%1000000007;
		}
		cache[idx] = tmp%1000000007;
		return cache[idx];
	}
}