import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br;
    static BufferedWriter bw;
    static char[][] board;
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        board = new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],' ');
        }
        recur(0,0,n);
        for(int i=0;i<n;i++){
            bw.write(String.valueOf(board[i])+'\n');
        }
        bw.flush();bw.close();br.close();

    }
    public static void recur(int uly, int ulx, int size){
        if(size == 1){
            board[uly][ulx] = '*';
            return;
        }
        int l = size/3;
        for(int i=0;i<3;i++)
            recur(uly,ulx+l*i,l);
        recur(uly+l,ulx,l);
        recur(uly+l,ulx+2*l,l);
        for(int i=0;i<3;i++)
            recur(uly+2*l,ulx+i*l,l);

    }
}