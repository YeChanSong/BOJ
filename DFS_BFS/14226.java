import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br;
    static int[][] cache;
    static int S;
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        S = Integer.parseInt(br.readLine());
        cache = new int[1001][1001];
        // cache[screen][clipboard]
        System.out.println(bfs(1));
        br.close();
    }
    public static int bfs(int start){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {start,0});
        cache[start][0] = 1;
        int[] itm;
        while(!q.isEmpty()){
            itm = q.poll();
            if(itm[0]>=S)
                break;
            if(itm[0]!=itm[1] && cache[itm[0]][itm[0]] == 0){
                q.offer(new int[] {itm[0],itm[0]});
                cache[itm[0]][itm[0]] = cache[itm[0]][itm[1]]+1;
            }
            if(itm[0]+itm[1]<=S && itm[1]>0 && cache[itm[0]+itm[1]][itm[1]] == 0){
                q.offer(new int[] {itm[0]+itm[1],itm[1]});
                cache[itm[0]+itm[1]][itm[1]] = cache[itm[0]][itm[1]]+1;
            }
            if(itm[0]>1 && cache[itm[0]-1][itm[1]] == 0){
                q.offer(new int[] {itm[0]-1,itm[1]});
                cache[itm[0]-1][itm[1]] = cache[itm[0]][itm[1]]+1;
            }
        }
        int min = 10000;
        for(int i: cache[S])
            if(i != 0 && i<min)
                min = i;
        return min-1;
    }
}