import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br;
    static BufferedWriter bw;
    static int[][] cache;
    static int N;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        cache = new int[N][10];
        for(int i=0;i<N;i++)
            Arrays.fill(cache[i],-1);
        int ans=0;
        for(int i=1;i<10;i++)
            ans = (ans%1000000000 + recur(0,i)%1000000000)%1000000000;
        bw.write(Integer.toString(ans)+"\n");
        bw.flush();bw.close();br.close();
    }

    static int recur(int idx, int curr){
        if(curr<0 || curr>9)
            return 0;
        if(idx==N-1)
            return 1;
        if(cache[idx][curr]!= -1)
            return cache[idx][curr];
        
        int tmp = (recur(idx+1,curr+1)%1000000000 + recur(idx+1,curr-1)%1000000000)%1000000000;
        cache[idx][curr] = tmp;
        return tmp;
    }
}