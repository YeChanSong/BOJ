import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, ans=-1;
    static int[] arr;
    static boolean[] isUsed;
    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        isUsed = new boolean[N];
        for(int i=1;i<N-1;i++) {
            isUsed[i]=true;
            recur(i,N,0);
            isUsed[i]=false;
        }
        System.out.println(ans);
    }
    public static void recur(int idx, int cnt, int ttl){
        int sum = ttl;
        int tmp = 1;
        for(int i=idx-1;i>-1;i--)
            if(!isUsed[i]) {
                tmp *= arr[i];
                break;
            }
        for(int i=idx+1;i<N;i++)
            if(!isUsed[i]){
                tmp *= arr[i];
                break;
            }
        sum+=tmp;
        if(cnt == 3){
            ans = Math.max(ans, sum);
            return;
        }
        for(int i=1;i<N-1;i++){
            if(!isUsed[i]){
                isUsed[i] = true;
                recur(i,cnt-1,sum);
                isUsed[i] = false;
            }
        }
    }
}