import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static int N, ans=0;
    static int[] Y = {0,-1,0,1}, X = {1,0,-1,0};
    static int[][] dc;
    static boolean[][] board;
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dc = new int[N][4];
        board = new boolean[101][101];
        for(int i=0;i<N;i++) {
            dc[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            dcDrawing(i);
        }
        getSquare();
        System.out.println(ans);
    }
    public static void dcDrawing(int idx){
        int y=dc[idx][1],x=dc[idx][0],d=dc[idx][2],g=dc[idx][3];
        ArrayList<Integer> q = new ArrayList<>(8192);
        Stack<Integer> stack = new Stack<>();
        q.add(d);
        int lim;
        for(int i=0;i<g;i++){
            for(int k:q)
                stack.add((k+1)%4);
            lim = stack.size();
            for(int k=0;k<lim;k++){
                q.add(stack.pop());
            }

        }
        board[y][x] = true;
        int dy=y,dx=x;
        for(int i: q){
            dy = dy+Y[i];
            dx = dx+X[i];
            board[dy][dx]=true;
        }
    }
    public static void getSquare(){
        int[] coords = new int[8]; //uly,ulx,ury,urx,lly,llx,lry,lrx;
        coords[3]=1;coords[4]=1;coords[6]=1;coords[7]=1;
        for(int i=0;i<100;i++){
            for(int j=0;j<100;j++){
                if(board[coords[0]][coords[1]] && board[coords[2]][coords[3]]
                && board[coords[4]][coords[5]] && board[coords[6]][coords[7]]){
                    ans++;
                }
                coords[1]++;coords[3]++;coords[5]++;coords[7]++;
            }
            coords[1]=0;coords[3]=1;coords[5]=0;coords[7]=1;
            coords[0]++;coords[2]++;coords[4]++;coords[6]++;
        }
    }
}