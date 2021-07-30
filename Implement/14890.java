import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br;
    static int[][] board, isSlope;
    static int N,L,ans;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        N = Integer.parseInt(tmp[0]);
        L = Integer.parseInt(tmp[1]);
        board = new int[N][N];
        isSlope = new int[N][N];
        for(int i=0;i<N;i++)
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        horiCheck();
        isSlope = new int[N][N];
        vertCheck();
        System.out.println(ans);
    }
    public static void horiCheck(){
        int curr, cnt, j; boolean flag;
        for(int i=0;i<N;i++){
            curr = board[i][0];
            cnt = 1; j = 1; flag = true;
            while(j<N){
                if(curr==board[i][j]){
                    cnt++;
                } else if(curr+1 == board[i][j]){
                    if(cnt<L || j-L<=-1) {
                        flag = false;
                        break;
                    }
                    curr = board[i][j]; cnt=1;
                    for(int k=j-1;k>=j-L;k--){
                        if(isSlope[i][k]==1){
                            flag = false;
                            break;
                        }
                    }
                    if(flag){
                        isSlope[i][j-1] = 1;
                    } else
                        break;
                } else if(curr-1 == board[i][j]){
                    if(j+L-1 >=N) {
                        flag = false;
                        break;
                    }
                    for(int k=j;k<j+L;k++){
                        if(board[i][j] != board[i][k]){
                            flag = false;
                            break;
                        }
                    }
                    if(flag){
                        isSlope[i][j+L-1] = 1;
                        j+=L-1;
                        curr = board[i][j]; cnt=1;
                    } else
                        break;
                } else{
                    flag = false;
                    break;
                }
                j++;
            }
            if(flag) {
                ans++;
            }
        }
    }
    public static void vertCheck(){
        int curr, cnt, j; boolean flag;
        for(int i=0;i<N;i++){
            curr = board[0][i];
            cnt = 1; j = 1; flag = true;
            while(j<N){
                if(curr==board[j][i]){
                    cnt++;
                } else if(curr+1 == board[j][i]){
                    if(cnt<L || j-L<=-1) {
                        flag = false;
                        break;
                    }
                    curr = board[j][i]; cnt=1;
                    for(int k=j-1;k>=j-L;k--){
                        if(isSlope[k][i]==1){
                            flag = false;
                            break;
                        }
                    }
                    if(flag){
                        isSlope[j-1][i] = 1;
                    } else
                        break;
                } else if(curr-1 == board[j][i]){
                    if(j+L-1 >=N) {
                        flag = false;
                        break;
                    }
                    for(int k=j;k<j+L;k++){
                        if(board[j][i] != board[k][i]){
                            flag = false;
                            break;
                        }
                    }
                    if(flag){
                        isSlope[j+L-1][i] = 1;
                        j+=L-1;
                        curr = board[j][i]; cnt=1;
                    } else
                        break;
                } else{
                    flag = false;
                    break;
                }
                j++;
            }
            if(flag) {
                ans++;
            }
        }
    }

}