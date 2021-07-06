import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int ans=666, cnt=0;
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb;
        while(cnt<N){
            if(String.valueOf(ans).contains("666")){
                cnt++;
            }
            ans++;
        }

        bw.write(String.valueOf(ans-1));
        bw.flush();bw.close();br.close();
    }
}