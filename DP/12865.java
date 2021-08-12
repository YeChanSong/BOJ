import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N,K;
    static int[][] values;
    static int[] cache;
    public static void main(String[] args) throws IOException{
        int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = tmp[0]; K = tmp[1];
        values = new int[N][];
        cache = new int[K+1];
        for(int i=0;i<N;i++) 
            values[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int ans=0;
        for(int i=0;i<N;i++){
            for(int j=K;j>=0;j--){
                if(j-values[i][0]>=0)
                    cache[j] = Math.max(cache[j], cache[j-values[i][0]]+values[i][1]);
            }
        }
        ans = Arrays.stream(cache).max().getAsInt();
        System.out.println(ans);
    }
}