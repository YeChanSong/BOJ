import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        char[] tmp; int temp, ans = -1, lim = String.valueOf(N).length();
        for(int i=N-9*lim;i<N;i++){
            tmp = String.valueOf(i).toCharArray();
            temp = i;
            for(char c:tmp)
                temp+=c-'0';
            if(temp == N){
                ans = i;
                break;
            }
        }
        if(ans != -1)
            bw.write(String.valueOf(ans));
        else
            bw.write("0");
        bw.flush();bw.close();br.close();
    }

}