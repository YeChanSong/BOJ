
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    public static int calc(int data){
        if(data%4==0 && data%100!=0 || data%400==0)
            return 1;
        else
            return 0;
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String data = br.readLine();
        int num = Integer.parseInt(data);
        bw.write(Integer.toString(calc(num)));bw.flush();bw.close();br.close();
    }

}