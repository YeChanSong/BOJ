import java.util.*;
import java.io.*;

/*
1. String.format은 StringBuilder보다 시간을 훨씬 많이 잡아먹는다.
2. BufferedWriter는 기본 버퍼 크기가 8k이므로 크기 할당없이 재귀마다 bw.write()을
    사용할 경우, 속도가 심각하게 느려진다.
*/

public class Main{
    static BufferedReader br;
    static BufferedWriter bw;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        sb.append((int)Math.pow(2,N)-1).append('\n');
        recur(1,3,N);
        bw.write(sb.toString());
        bw.flush();bw.close();br.close();
    }
    static void recur(int start, int end, int num) throws IOException {
        if(num == 1){
            sb.append(start).append(" ").append(end).append('\n');
            return;
        }
        recur(start,6-start-end,num-1);
        sb.append(start).append(" ").append(end).append('\n');
        recur(6-start-end,end,num-1);
    }
}