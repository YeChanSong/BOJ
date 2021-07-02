import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String in = br.readLine();
        int tmp=0;
        for(char i:in.toCharArray()){
            tmp += i-'0';
        }
        bw.write(String.valueOf(tmp));
        bw.flush();bw.close();br.close();
    }
}