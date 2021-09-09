import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int R,C,T,up=-1,down=-1;
    static int[] Y = {1,-1,0,0}, X = {0,0,1,-1};
    static int[][] board, comp;
    public static void main(String[] args) throws IOException{
        int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        R = tmp[0]; C = tmp[1]; T = tmp[2];
        board = new int[R][C];
        comp = new int[R][C];
        for(int i=0;i<R;i++)
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for(int i=0;i<R;i++){
            if(board[i][0]==-1){
                if(up==-1) up=i;
                else {
                    down = i;
                    break;
                }
            }
        }
        for(int i=0;i<T;i++) {
            diffusion();
            circulation();
        }
        int ans=0;
        for(int i=0;i<R;i++){
            ans += Arrays.stream(board[i]).sum();
        }
        System.out.println(ans+2);
    }
    static void diffusion(){ // 미세먼지 확산
        int tmp=0,dy,dx,cnt=0;
        int[][] swap;
        comp = new int[R][C];
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(board[i][j] == -1){
                    comp[i][j] = -1;
                } else if(board[i][j] > 0){
                    tmp = board[i][j]/5;
                    cnt=0;
                    for(int k=0;k<4;k++){
                        dy = i+Y[k]; dx = j+X[k];
                        if(dy<0||dx<0||dy>=R||dx>=C||board[dy][dx]==-1)
                            continue;
                        cnt++;
                        comp[dy][dx]+=tmp;
                    }
                    comp[i][j] += board[i][j] - cnt*tmp;
                }
            }
        }
        swap = board;
        board = comp;
        comp = swap;
    }
    static void circulation(){
        int uitm=0, ditm=0, ubef=0, dbef=0;
        for(int i=1;i<C-1;i++){
            ubef = board[up][i];
            dbef = board[down][i];
            board[up][i] = uitm;
            board[down][i] = ditm;
            uitm = ubef;
            ditm = dbef;
        }

        for(int i=up;i>-1;i--){
            ubef = board[i][C-1];
            board[i][C-1] = uitm;
            uitm = ubef;
        }
        for(int i=down;i<R;i++){
            dbef = board[i][C-1];
            board[i][C-1] = ditm;
            ditm = dbef;
        }

        for(int i=C-2;i>0;i--){
            ubef = board[0][i];
            board[0][i] = uitm;
            uitm = ubef;
            dbef = board[R-1][i];
            board[R-1][i] = ditm;
            ditm = dbef;
        }

        for(int i=0;i<up;i++){
            ubef = board[i][0];
            board[i][0] = uitm;
            uitm = ubef;
        }
        for(int i=R-1;i>down;i--){
            dbef = board[i][0];
            board[i][0] = ditm;
            ditm = dbef;
        }
    }
}