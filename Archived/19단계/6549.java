import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] tmp;
	public static void main(String[] args) throws IOException{
		tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		long ans=0;
		while(tmp[0] != 0){
			ans = recur(1,tmp.length-1);
			System.out.println(ans);
			tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
	}
	static long recur(int left, int right){
		if(left == right)
			return tmp[left];
		int mid = (left+right)/2;
		long ret = Math.max(recur(left, mid), recur(mid+1, right));
		int l=mid, r=mid, minh=tmp[mid];
		while(l>left || r<right){
			if(r<right && (l==left || tmp[l-1]<tmp[r+1])){
				r++;
			}else{
				l--;
			}
			minh = Math.min(minh, Math.min(tmp[l],tmp[r]));
			ret = Math.max(ret, (long) (r - l + 1) *minh);
		}
		return ret;
	}
}