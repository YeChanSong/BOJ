import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br;
    static BufferedWriter bw;
    static int[] cache;
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        cache = new int[n+1];
        Arrays.fill(cache,-1);
        bw.write(String.valueOf(recur(n)));
        bw.flush();bw.close();br.close();
    }
    public static int recur(int idx){
        if(idx == 0 || idx == 1){
            return idx;
        }
        if(cache[idx] != -1)
            return cache[idx];
        int tmp = recur(idx-1) + recur(idx-2);
        cache[idx] = tmp;
        return tmp;
    }
}