import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] cache;
    static int T, K;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            K = Integer.parseInt(br.readLine());
            arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            cache = new int[K][K];
            dp(0,K-1);
            System.out.println(cache[0][K-1]);
        }

    }
    public static int dp(int start, int end){
        if(start == end)
            return 0;

        if(cache[start][end]!=0)
            return cache[start][end];
        int cost=0;
        for(int i=start;i<=end;i++)
            cost+=arr[i];
        int tmp=Integer.MAX_VALUE;
        for(int k=start;k<end;k++){
            tmp = Math.min(tmp,dp(start,k)+dp(k+1,end)+cost);
        }
        cache[start][end] = tmp;
        return tmp;
    }
}