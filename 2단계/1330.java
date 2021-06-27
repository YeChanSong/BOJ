import java.io.*;
import java.util.*;

public class Main {

    public static String calc(int a, int b){
        if(a>b)
            return ">";
        else if(a<b)
            return "<";
        else
            return "==";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String data = br.readLine();
        String arr[] = data.split(" ");
        int a,b;
        a = Integer.parseInt(arr[0]);
        b = Integer.parseInt(arr[1]);
        bw.write(calc(a,b));
        bw.flush();
        bw.close();
        br.close();
    }

}
