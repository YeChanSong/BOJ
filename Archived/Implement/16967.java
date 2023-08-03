import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int N,M,X,Y;
    static int[][] B;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = tmp[0]; M = tmp[1]; Y = tmp[2]; X = tmp[3];
        B = new int[N+Y][M+X];
        for(int i=0;i<N+Y;i++)
            B[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for(int i=Y;i<N;i++){
            for(int j=X;j<M;j++){
                B[i][j]-=B[i-Y][j-X];
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++)
                sb.append(B[i][j]).append(' ');
            sb.append('\n');
        }
        bw.write(sb.toString());
        bw.flush();bw.close();br.close();
    }
}