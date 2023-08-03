import java.util.*;
import java.io.*;

public class Main{
    static int N;
    static int[] li;
    static BufferedReader br;
    static BufferedWriter bw;
    static int[] cache;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        li = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
            li[i] = Integer.parseInt(st.nextToken());
        cache = new int[N];
        Arrays.fill(cache,-1);
        for(int i=0;i<N;i++)
            if(cache[i]==-1)
                recur(i);
        bw.write(Integer.toString(Arrays.stream(cache).max().getAsInt())+"\n");
        bw.flush();bw.close();br.close();
    }

    static int recur(int idx){
        if(idx == N)
            return 0;
        if(cache[idx]!=-1)
            return cache[idx];
        int tmp=0;
        for(int i=idx+1;i<N;i++)
            if(li[i]>li[idx])
                tmp = Math.max(tmp,recur(i));
        tmp++;
        cache[idx] = tmp;
        return tmp;
    }
}