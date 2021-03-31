import java.util.*;
import java.io.*;

public class Main{
    static int[] X = {-2,-2,-1,-1,1,1,2,2};
    static int[] Y = {-1,1,-2,2,-2,2,-1,1};
    static BufferedReader br;
    static BufferedWriter bw;
    static int[][] dist;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T,n,kx,ky,dx,dy;
        T = Integer.parseInt(br.readLine());
        String[] s;
        Queue<int[]> q;
        for(int p=0;p<T;p++){
            n = Integer.parseInt(br.readLine());
            s = br.readLine().split(" ");
            ky = Integer.parseInt(s[0]); kx = Integer.parseInt(s[1]);
            s = br.readLine().split(" ");
            dy = Integer.parseInt(s[0]); dx = Integer.parseInt(s[1]);
            dist = new int[n][n];
            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++)
                    dist[i][j] = -1;

            q = new LinkedList<int[]>();
            q.offer(new int[] {ky,kx});
            dist[ky][kx]=0;
            int[] itm;
            while(!q.isEmpty()){
                itm = q.poll();
                if(itm[0] == dy && itm[1] == dx)
                    break;
                for(int i=0;i<8;i++){
                    if(!(0<=itm[0]+Y[i] && itm[0]+Y[i]<n && 0<=itm[1]+X[i] && itm[1]+X[i]<n))
                        continue;
                    if(dist[itm[0]+Y[i]][itm[1]+X[i]]!=-1)
                        continue;
                    dist[itm[0]+Y[i]][itm[1]+X[i]] = dist[itm[0]][itm[1]]+1;
                    q.offer(new int[] {itm[0]+Y[i],itm[1]+X[i]});
                }
            }
            bw.write(Integer.toString(dist[dy][dx])+"\n");
            bw.flush();
        }
        bw.close();
        br.close();
    }
    
}