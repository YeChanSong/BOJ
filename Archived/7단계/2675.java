import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int R; String s; String[] in; StringBuilder sb;
        for(int i=0;i<T;i++){
            in = br.readLine().split(" ");
            R = Integer.parseInt(in[0]);
            s = in[1]; sb = new StringBuilder();
            for(char c: s.toCharArray()){
                for(int k=0;k<R;k++){
                    sb.append(c);
                }
            }
            bw.write(sb.toString()+'\n');
        }
        bw.flush();bw.close();br.close();
    }
}
