import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    public static int calc(int x, int y){
        if (x>0 && y>0)
            return 1;
        else if (x<0 && y>0)
            return 2;
        else if (x<0 && y<0)
            return 3;
        else
            return 4;
    }
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String data = br.readLine();
        int num1 = Integer.parseInt(data);
        data = br.readLine();
        int num2 = Integer.parseInt(data);
        bw.write(String.valueOf(calc(num1,num2)));bw.flush();bw.close();br.close();
    }
}