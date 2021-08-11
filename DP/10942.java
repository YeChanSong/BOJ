import java.io.*;
import java.util.*;

// 이미 팰린드롬으로 판명난 구간의 정보를 활용
// 팰린드롬으로 확인된 구간의 시작-1 == 끝+1이면 이 구간도 팰린드롬

public class Main {
    static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] cache;
    static int N,M;
    static int[] li, query;
    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        li = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        M = Integer.parseInt(br.readLine());
        cache = new int[N][N];
        StringBuilder sb = new StringBuilder();
        for(int p=0;p<M;p++){
            query = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if(recur(query[0]-1, query[1]-1)==-1)
                sb.append(0);
            else
                sb.append(1);
            sb.append('\n');
        }
        bw.write(sb.toString());
        bw.flush();bw.close();br.close();
    }
    static int recur(int s, int e){
        if(e-s<0)
            return 1;

        if(cache[s][e]!=0)
            return cache[s][e];
        if(li[s]==li[e]){
            if(recur(s+1,e-1)==1){
                cache[s][e] = 1;
                return 1;
            }
        }
        cache[s][e] = -1;
        return -1;
    }
}