import java.io.*;
import java.util.Arrays;

public class Main{
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        for(int i=0;i<N;i++){
            bw.write(String.valueOf(arr[i])+'\n');
        }
        bw.flush();bw.close();br.close();

    }

}