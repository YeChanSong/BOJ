import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] board, spare;
    static int N,R,size;
    public static void main(String[] args) throws IOException{
        int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = tmp[0]; R = tmp[1];
        board = new int[(int)Math.pow(2,N)][(int)Math.pow(2,N)];
        spare = new int[(int)Math.pow(2,N)][(int)Math.pow(2,N)];
        size =(int)Math.pow(2,N);
        for(int i=0;i<(int)Math.pow(2,N);i++)
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for(int i=0;i<R;i++){
            tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if(tmp[0]==1){
                func1(tmp[1]);
            }else if(tmp[0]==2){
                func2(tmp[1]);
            }else if(tmp[0]==3){
                func3(tmp[1]);
            }else if(tmp[0]==4){
                func4(tmp[1]);
            }else if(tmp[0]==5){
                func5(tmp[1]);
            }else if(tmp[0]==6){
                func6(tmp[1]);
            }else if(tmp[0]==7){
                func7(tmp[1]);
            }else{
                func8(tmp[1]);
            }
        }
        printing(board);
    }
    public static void func1(int l){
        if(l==0)
            return;
        int lim = (int)Math.pow(2,l),start =0;
        int times = (int)Math.pow(2,N-l);
        for(int i=0;i<times;i++){
            for(int j=0;j<lim;j++){
                spare[lim+start-j-1] = board[j+start];
            }
            start += lim;
        }
        swap();
    }
    public static void func2(int l){
        if(l==0)
            return;
        int lim = (int)Math.pow(2,l),start =0;
        int times = (int)Math.pow(2,N-l);

        for(int i=0;i<times;i++){
            for(int j=0;j<lim;j++){
                for(int k=0;k<size;k++){
                    spare[k][lim+start-j-1] = board[k][j+start];
                }
            }
            start += lim;
        }
        swap();
    }
    public static void func3(int l){
        if(l==0)
            return;
        int lim = (int)Math.pow(2,l),start =0;
        int times = (int)Math.pow(2,N-l);
        int[][] tmp = new int[lim][size];
        for(int i=0;i<times;i++){
            for(int j=0;j<lim;j++)
                tmp[j] = board[i*lim+j];
            for(int j=0;j<times;j++){
                for(int k=0;k<lim;k++){
                    for(int p=0;p<lim;p++) {
                        spare[i*lim+p][(j+1)*lim-k-1] = tmp[k][j*lim+p];
                    }
                }
            }
        }
        swap();
    }
    public static void func4(int l){
        if(l==0)
            return;
        int lim = (int)Math.pow(2,l);
        int times = (int)Math.pow(2,N-l);
        int[][] tmp = new int[lim][size];
        for(int i=0;i<times;i++){
            for(int j=0;j<lim;j++)
                tmp[j] = board[i*lim+j];
            for(int j=0;j<times;j++){
                for(int k=0;k<lim;k++){
                    for(int p=0;p<lim;p++){
                        spare[(i+1)*lim-1-p][j*lim+k] = tmp[k][j*lim+p];
                    }
                }
            }
        }
        swap();
    }
    public static void func5(int l){
        int lim = (int)Math.pow(2,l);
        int times = (int)Math.pow(2,N-l);
        for(int i=0;i<times;i++){
            for(int j=0;j<lim;j++){
                spare[size-lim*(i+1)+j] = board[i*lim+j];
            }
        }
        swap();
    }
    public static void func6(int l){
        int lim = (int)Math.pow(2,l);
        int times = (int)Math.pow(2,N-l);
        for(int i=0;i<times;i++){
            for(int j=0;j<lim;j++){
                for(int k=0;k<size;k++){
                    spare[k][size-lim*(i+1)+j] = board[k][i*lim+j];
                }
            }
        }
        swap();
    }
    public static void func7(int l){
        int lim = (int)Math.pow(2,l);
        int times = (int)Math.pow(2,N-l);
        int[][] tmp = new int[lim][size];
        for(int i=0;i<times;i++){
            for(int j=0;j<lim;j++)
                tmp[j] = board[i*lim+j];
            for(int j=0;j<times;j++){
                for(int k=0;k<lim;k++) {
                    for(int p=0;p<lim;p++) {
                        spare[j*lim+k][size-(i+1)*lim+p] = tmp[k][j*lim+p];
                    }
                }
            }
        }
        swap();
    }
    public static void func8(int l){
        int lim = (int)Math.pow(2,l);
        int times = (int)Math.pow(2,N-l);
        int[][] tmp = new int[lim][size];
        for(int i=0;i<times;i++){
            for(int j=0;j<lim;j++)
                tmp[j] = board[i*lim+j];
            for(int j=0;j<times;j++){
                for(int k=0;k<lim;k++) {
                    for(int p=0;p<lim;p++) {
                        spare[size-(j+1)*lim+k][i*lim+p] = tmp[k][j*lim+p];
                    }
                }
            }
        }
        swap();
    }
    public static void printing(int[][] target) throws IOException{
        StringBuilder sb = new StringBuilder();
        for(int[] arr:target){
            for(int i:arr)
                sb.append(i).append(' ');
            sb.append('\n');
        }
        bw.write(sb.toString());
        bw.flush();bw.close();br.close();
    }
    public static void swap(){
        board=spare;
        spare=new int[size][size];
    }
}