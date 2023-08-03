import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int C = Integer.parseInt(br.readLine()),tmp,ans;
        String input;
        for (int q = 0; q < C; q++) {
            input = br.readLine();
            tmp = 0;ans=0;
            for(char i: input.toCharArray()){
                if(i=='O'){
                    ++tmp;
                    ans += tmp;
                }
                else
                    tmp = 0;
            }
            bw.write(Integer.toString(ans)+'\n');
        }
        bw.flush();bw.close();br.close();
    }
}