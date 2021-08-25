import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N,K;
    static ArrayList<int[]> stuff;
    static int[] cache;
    public static void main(String[] args) throws IOException{
        int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = tmp[0]; K = tmp[1];
        cache = new int[K+1];
        Arrays.fill(cache,-1);
        stuff = new ArrayList<>();
        for(int i=0;i<N;i++){
            stuff.add(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());
        }
        cache[0] =0;
        for(int i=0;i<N;i++){
            for(int j=K;j>-1;j--){
                if(j-stuff.get(i)[0]>=0){
                    cache[j] = Math.max(cache[j],cache[j-stuff.get(i)[0]]+stuff.get(i)[1]);
                }
            }
        }
        int max=0;
        for(int i:cache){
            if(max<i)
                max=i;
        }
        System.out.println(max);
    }
}