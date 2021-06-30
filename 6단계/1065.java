import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int ans = func(n);
        bw.write(String.valueOf(ans));
        bw.flush();br.close();bw.close();

    }

    public static int func(int N){
        int ans=99;
        if(N<100)
            return N;
        String tmp; int temp,next,diff; boolean flag = true;
        for(int i=100;i<=N;i++){
            tmp = String.valueOf(i);
            temp = tmp.charAt(0)-'0';
            diff = temp-(tmp.charAt(1)-'0');
            flag = true;
            for(int k=1;k<tmp.length();k++){
                next = tmp.charAt(k)-'0';
                if(diff != (temp-next)){
                    flag = false;
                    break;
                }
                temp = next;
            }
            if(flag)
                ans++;
        }
        return ans;
    }

}