import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int C = Integer.parseInt(br.readLine());
        int[] arr; int[] input; double sum=0; int[] subArr; double cnt=0;
        for(int i=0;i<C;i++){
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();
            subArr = new int[input.length];
            subArr = Arrays.copyOfRange(input, 1,input.length);
            sum = Arrays.stream(subArr).sum();
            sum /= input[0];
            cnt =0;
            for(double k: subArr)
                if(k>sum)
                    cnt++;
            cnt/=input[0];
            bw.write(String.format("%.3f%%\n",cnt*100));
        }
        bw.flush();bw.close();br.close();
    }
}