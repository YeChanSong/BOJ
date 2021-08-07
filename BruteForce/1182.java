import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N,S, ans=0;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = tmp[0]; S = tmp[1];
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for(int i=0;i<N;i++)
            recur(i,arr[i]);
        System.out.println(ans);
    }
    public static void recur(int idx, int sum){
        if(sum == S)
            ans++;
        for(int i=idx+1;i<N;i++){
            recur(i,sum+arr[i]);
        }
    }
}