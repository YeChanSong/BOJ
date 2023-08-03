import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br;
    static BufferedWriter bw;
    static StringBuilder sb = new StringBuilder(8192);
    static int N,M;
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] tmp = br.readLine().split(" ");
        N = Integer.parseInt(tmp[0]);
        M = Integer.parseInt(tmp[1]);
        Stack<Integer> stack = new Stack<>();
        recur(0,0,stack);
        bw.write(sb.toString());
        bw.flush();bw.close();br.close();
    }
    public static void recur(int idx, int cnt, Stack<Integer> stack){
        if(cnt == M){
            for(Object o: stack.toArray()){
                sb.append(o).append(" ");
            }
            sb.append("\n");
        }
        for(int i=idx+1;i<=N;i++){
            stack.push(i);
            recur(i,cnt+1,stack);
            stack.pop();
        }
    }
}
