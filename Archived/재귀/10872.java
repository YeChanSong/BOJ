import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        bw.write(Integer.toString(recur(N)));
        bw.flush();bw.close();br.close();
    }
    public static int recur(int idx){
        if(idx == 0){
            return 1;
        }
        return idx * recur(idx-1);
    }
}