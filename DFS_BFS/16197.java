import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[][] board;
    static boolean[][][][] dist;
    static int N,M;
    static int[] Y = {0,0,1,-1}, X = {1,-1,0,0};
    public static void main(String[] args) throws IOException{
        int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = tmp[0]; M = tmp[1];
        board = new char[N][M];
        dist = new boolean[N][M][N][M];
        int cnt=0;
        int[] c1 = new int[2], c2 = new int[2];
        for(int i=0;i<N;i++) {
            board[i] = br.readLine().toCharArray();
            for(int j=0;j<M;j++) {
                if (cnt > 1)
                    break;
                if (board[i][j] == 'o')
                    if (cnt == 0) {
                        c1[0] = i;c1[1] = j;cnt++;
                    } else if (cnt == 1) {
                        c2[0] = i;c2[1] = j;cnt++;
                    } else
                        break;
            }
        }
        System.out.println(bfs(c1,c2));
    }
    static int bfs(int[] coin1, int[] coin2){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {coin1[0],coin1[1],coin2[0],coin2[1],0});
        // coin1 pos y,x , coin2 pos y,x , moving cnt
        dist[coin1[0]][coin1[1]][coin2[0]][coin2[1]] = true;
        int[] itm;
        int dy1, dy2, dx1, dx2;
        while(!q.isEmpty()){
            itm = q.poll();
            if(itm[4]>=10)
                break;
            for(int i=0;i<4;i++){
                dy1 = itm[0]+Y[i]; dx1 = itm[1]+X[i];
                dy2 = itm[2]+Y[i]; dx2 = itm[3]+X[i];
                switch(isFallOrStuck(dy1,dx1,dy2,dx2)){
                    case 0:
                    case 3:
                        continue;
                    case 1:
                    case 2:
                        return itm[4]+1;
                    case 4:
                        if(!dist[itm[0]][itm[1]][dy2][dx2]) {
                            dist[itm[0]][itm[1]][dy2][dx2] = true;
                            q.offer(new int[]{itm[0], itm[1], dy2, dx2, itm[4] + 1});
                        }
                        continue;
                    case 5:
                        if(!dist[dy1][dx1][itm[2]][itm[3]]) {
                            dist[dy1][dx1][itm[2]][itm[3]] = true;
                            q.offer(new int[]{dy1, dx1, itm[2], itm[3], itm[4] + 1});
                        }
                        continue;
                    case 6:
                        if(!dist[dy1][dx1][dy2][dx2]) {
                            dist[dy1][dx1][dy2][dx2] = true;
                            q.offer(new int[]{dy1, dx1, dy2, dx2, itm[4] + 1});
                        }
                }
            }
        }
        return -1;
    }
    static int isFallOrStuck(int dy1, int dx1, int dy2, int dx2){
        if((N<=dy2 || dy2<0 || M<=dx2 || dx2<0) &&
                (N<=dy1 || dy1<0 || M<=dx1 || dx1<0)){
            // 둘다 떨어진 상황
            return 0;
        }
        if(0<=dy1 && dy1<N && 0<=dx1 && dx1<M &&
                (N<=dy2 || dy2<0 || M<=dx2 || dx2<0)){
            // coin1 안쪽, coin2가 밖으로 떨어진 상황
            return 1;
        }
        if (0<=dy2 && dy2<N && 0<=dx2 && dx2<M &&
                (N<=dy1 || dy1<0 || M<=dx1 || dx1<0)){
            // coin2 안쪽, coin1이 밖으로 떨어진 상황
            return 2;
        }
        // 두 동전 모두 벽을 만남
        if((board[dy1][dx1]=='#' && board[dy2][dx2]=='#') ||
                (board[dy1][dx1]=='#' && board[dy2][dx2]=='o') ||
                (board[dy1][dx1]=='o' && board[dy2][dx2]=='#'))
            return 3;
        // coin1만 벽을 만남
        if(board[dy1][dx1]=='#' && board[dy2][dx2] == '.')
            return 4;
        // coin2만 벽을 만남
        if(board[dy2][dx2]=='#' && board[dy1][dx1] == '.')
            return 5;
        // 둘다 벽을 만나지 않음
        return 6;
    }
}