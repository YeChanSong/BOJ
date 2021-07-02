import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] in = br.readLine().split(" ");
        int a,b;
        StringBuilder sb = new StringBuilder(in[0]);
        a = Integer.parseInt(sb.reverse().toString());
        sb = new StringBuilder(in[1]);
        b = Integer.parseInt(sb.reverse().toString());
        if(a>b)
            bw.write(String.valueOf(a));
        else
            bw.write(String.valueOf(b));
        bw.flush();bw.close();br.close();
    }
}