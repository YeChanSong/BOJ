import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String word = br.readLine(); String[] arr = new String[26]; int cnt=0;
        Arrays.fill(arr,"-1");
        for(int i: word.toCharArray()){
            if(arr[i-'a'] == "-1")
                arr[i-'a'] = Integer.toString(cnt);
            cnt++;
        }
        bw.write(String.join(" ",arr));
        bw.flush();bw.close();br.close();
    }
}