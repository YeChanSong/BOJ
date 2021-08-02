import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static String N;
    static int S;
    static char[][] board;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] tmp = br.readLine().split(" ");
        S = Integer.parseInt(tmp[0]);
        N = tmp[1];
        board = new char[S*2+3][(S+3)*N.length()];
        for(int i=0;i<S*2+3;i++){
            Arrays.fill(board[i],' ');
        }
        sb = new StringBuilder((S*2+3)*(((S+3)*N.length()-1)+1));
        for(int i=0;i<N.length();i++)
            printN(N.charAt(i)-'0',i);

        for(char[] arr: board){
            for(char c: arr)
                sb.append(c);
            sb.append('\n');
        }
        bw.write(sb.toString());
        bw.flush();bw.close();br.close();
    }
    public static void printN(int N, int idx){
        int uly = 0,ulx = (S+3)*idx, lry = 2*S+2, lrx = (S+3)*idx+S+1;
        if(N==1){
            for(int i=1;i<=S;i++) {
                board[uly + i][lrx] = '|';
                board[lry - i][lrx] = '|';
            }
        } else if(N==2) {
            for (int i = 1; i <= S; i++) {
                board[uly][ulx + i] = '-';
                board[uly + S + 1][ulx + i] = '-';
                board[lry][ulx + i] = '-';
                board[uly + i][lrx] = '|';
                board[lry - i][ulx] = '|';
            }
        } else if(N == 3){
            for (int i = 1; i <= S; i++) {
                board[uly][ulx + i] = '-';
                board[uly + S + 1][ulx + i] = '-';
                board[lry][ulx + i] = '-';
                board[uly + i][lrx] = '|';
                board[lry - i][lrx] = '|';
            }
        } else if(N==4){
            for (int i = 1; i <= S; i++) {
                board[uly + i][ulx] = '|';
                board[uly + S + 1][ulx + i] = '-';
                board[uly + i][lrx] = '|';
                board[lry - i][lrx] = '|';
            }
        } else if(N==5){
            for (int i = 1; i <= S; i++) {
                board[uly][ulx + i] = '-';
                board[uly + S + 1][ulx + i] = '-';
                board[lry][ulx + i] = '-';
                board[uly + i][ulx] = '|';
                board[lry - i][lrx] = '|';
            }
        } else if(N==6){
            for (int i = 1; i <= S; i++) {
                board[uly][ulx + i] = '-';
                board[uly + S + 1][ulx + i] = '-';
                board[lry][ulx + i] = '-';
                board[uly + i][ulx] = '|';
                board[lry - i][lrx] = '|';
                board[lry - i][ulx] = '|';
            }
        } else if(N==7){
            for (int i = 1; i <= S; i++) {
                board[uly][ulx + i] = '-';
                board[uly + i][lrx] = '|';
                board[lry - i][lrx] = '|';
            }
        } else if(N==8){
            for (int i = 1; i <= S; i++) {
                board[uly][ulx + i] = '-';
                board[uly + S + 1][ulx + i] = '-';
                board[lry][ulx + i] = '-';
                board[uly + i][ulx] = '|';
                board[lry - i][lrx] = '|';
                board[lry - i][ulx] = '|';
                board[uly + i][lrx] = '|';
            }
        } else if(N==9){
            for (int i = 1; i <= S; i++) {
                board[uly][ulx + i] = '-';
                board[uly + S + 1][ulx + i] = '-';
                board[lry][ulx + i] = '-';
                board[uly + i][ulx] = '|';
                board[lry - i][lrx] = '|';
                board[uly + i][lrx] = '|';
            }
        } else if(N==0){
            for (int i = 1; i <= S; i++) {
                board[uly][ulx + i] = '-';
                board[lry][ulx + i] = '-';
                board[uly + i][ulx] = '|';
                board[lry - i][lrx] = '|';
                board[lry - i][ulx] = '|';
                board[uly + i][lrx] = '|';
            }
        }
    }
}