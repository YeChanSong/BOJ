import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    public static String calc(int h, int m){
        if(m>=45)
            return String.format("%d %d",h,m-45);
        else{
            if (h==0)
                return String.format("%d %d",23,m+15);
            else
                return String.format("%d %d",h-1,m+15);
        }
    }
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String data[] = br.readLine().split(" ");
        int h = Integer.parseInt(data[0]);
        int m = Integer.parseInt(data[1]);
        bw.write(calc(h,m));bw.flush();bw.close();br.close();
    }
}