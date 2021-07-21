import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br;
    static BufferedWriter bw;
    static int[] hist, dist;
    static int N,K;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] tmp = br.readLine().split(" ");
        N = Integer.parseInt(tmp[0]);
        K = Integer.parseInt(tmp[1]);
        sb = new StringBuilder();
        dist = new int[100001];
        hist = new int[100001];
        BFS(N);
        bw.write(sb.toString());
        bw.flush();bw.close();br.close();
    }
    public static void BFS(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        hist[start] = start;
        dist[start] = 1;
        int itm;
        while(!q.isEmpty()){
            itm = q.poll();
            if(dist[K] != 0)
                break;
            if(itm*2<=100000 && dist[itm*2] == 0){
                q.offer(itm*2);
                dist[itm*2] = dist[itm]+1;
                hist[itm*2] = itm;
            }
            if(itm+1<=100000 && dist[itm+1] == 0){
                q.offer(itm+1);
                dist[itm+1] = dist[itm]+1;
                hist[itm+1] = itm;
            }
            if(itm>0 && dist[itm-1] == 0){
                q.offer(itm-1);
                dist[itm-1] = dist[itm]+1;
                hist[itm-1] = itm;
            }
        }
        sb.append(dist[K]-1).append('\n');
        Stack<Integer> stack = new Stack<>();
        itm = K;
        stack.add(itm);
        while(itm != N){
            itm = hist[itm];
            stack.add(itm);
        }
        while(!stack.isEmpty())
            sb.append(stack.pop()).append(' ');
        sb.append('\n');
    }

}