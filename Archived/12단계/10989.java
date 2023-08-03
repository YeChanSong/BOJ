import java.io.*;
import java.util.Arrays;

public class Main{
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[10001];
        for(int i=0;i<N;i++){
            arr[Integer.parseInt(br.readLine())]++;
        }

        for(int i=1;i<=10000;i++){
            for(int j=0;j<arr[i];j++)
                bw.write(String.valueOf(i)+'\n');
        }
        bw.flush();bw.close();br.close();
    }
}