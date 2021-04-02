import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br;
    static BufferedWriter bw;
    static int[] cache;
    static int N;


    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        cache = new int[N+1];
        Arrays.fill(cache,Integer.MAX_VALUE);
        cache[N]=0;
        for(int i=N;i>0;i--){
            if(i%3==0)
                cache[i/3] = Math.min(cache[i]+1,cache[i/3]);
            if(i%2==0)
                cache[i/2] = Math.min(cache[i]+1,cache[i/2]);
            if(i>1)
                cache[i-1] = Math.min(cache[i]+1,cache[i-1]);
        }
        bw.write(Integer.toString(cache[1])+"\n");
        bw.flush();bw.close();br.close();
    }
}