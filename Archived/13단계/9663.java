import java.io.*;

public class Main{
    static BufferedReader br;
    static BufferedWriter bw;
    static int[] pos;
    static int cnt=0, N;
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        pos = new int[N];
        for(int i=0;i<N;i++){
            nQueen(0,i);
        }

        bw.write(String.valueOf(cnt));
        bw.flush();bw.close();br.close();
    }

    public static void nQueen(int y, int x){
        // check another queens position
        for(int i=0;i<y;i++){
            if((pos[i] == x) || (i+pos[i] == y+x) || (i-pos[i] == y-x)){
                // xpos || ll->ur diagonal || ul->lr diagonal overlap
                return;
            }
        }
        if(y==N-1){
            cnt++;
            return;
        }
        pos[y] = x;
        for(int i=0;i<N;i++){
            nQueen(y+1,i);
        }
    }
}