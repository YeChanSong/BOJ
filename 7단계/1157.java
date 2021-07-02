import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String in = br.readLine().toUpperCase();
        int[] cntr = new int[26];
        for(char c:in.toCharArray()){
            cntr[c-'A']++;
        }
        int mx = Arrays.stream(cntr).max().getAsInt();
        int cnt=0,idx=0;
        for(int i=0;i<cntr.length;i++){
            if(cntr[i]==mx) {
                cnt++;
                idx = i;
            }
        }
        if(cnt>1)
            bw.write("?");
        else
            bw.write(String.format("%c",idx+'A'));
        bw.flush();bw.close();br.close();
    }
}