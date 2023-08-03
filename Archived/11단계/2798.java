import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br;
    static BufferedWriter bw;
    static int N,M,max;
    static int[] cards;
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] tmp = br.readLine().split(" ");
        N = Integer.parseInt(tmp[0]);
        M = Integer.parseInt(tmp[1]);
        cards = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        recur(-1,0,0);
        bw.write(String.valueOf(max)+'\n');
        bw.flush();bw.close();br.close();

    }
    static void recur(int idx,int sum, int cnt){
        if(sum>M)
            return;

        if(cnt ==3) {
            if(sum>max) {
                max = sum;
            }
            return;
        }
        
        for(int i=idx+1;i<N;i++)
            recur(i,sum+cards[i],cnt+1);

    }
}