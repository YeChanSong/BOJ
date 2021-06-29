import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = new int[9]; int mx = -1, pos = -1;
        for(int i=0;i<9;i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if(arr[i]>mx){
                pos = i;
                mx = arr[i];
            }
        }
        bw.write(Integer.toString(mx)+"\n");
        bw.write(Integer.toString(pos+1));
        bw.flush();bw.close();br.close();
    }
}
