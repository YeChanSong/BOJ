import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        double N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();
        double sum = Arrays.stream(arr).sum();
        double M = Arrays.stream(arr).max().getAsInt();
        bw.write(Double.toString(((sum/M)*100)/N));
        bw.flush();bw.close();br.close();
    }

}