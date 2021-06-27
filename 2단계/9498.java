import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    public static String calc(int data){
        if (90<= data)
            return "A";
        else if (80<=data)
            return "B";
        else if (70<=data)
            return "C";
        else if (60<=data)
            return "D";
        else
            return "F";
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String data = br.readLine();
        int num = Integer.parseInt(data);
        bw.write(calc(num));
        bw.flush();
        bw.close();
        br.close();
    }

}
