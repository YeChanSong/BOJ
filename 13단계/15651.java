import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br;
    static BufferedWriter bw;
    static StringBuilder sb = new StringBuilder(8192);
    static int N,M;
    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] tmp = br.readLine().split(" ");
        N = Integer.parseInt(tmp[0]);
        M = Integer.parseInt(tmp[1]);
        recur(0);
        bw.write(sb.toString());
        bw.flush();bw.close();br.close();
    }
    public static void recur(int cnt){
        if(cnt == M){
            for(Object o: stack.toArray()){
                sb.append(o).append(' ');
            }
            sb.append('\n');
            return;
        }
        for(int i=1;i<=N;i++){
            stack.push(i);
            recur(cnt+1);
            stack.pop();
        }
    }
}