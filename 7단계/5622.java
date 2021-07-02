import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<Character,Integer> map = new HashMap<>();
        int key = 1, cntr = 0;
        for(char c: "ABCDEFGHIJKLMNO".toCharArray()){
            if(cntr%3==0)
                key++;
            map.put(c,key);
            cntr++;
        }
        for(char c: "PQRS".toCharArray())
            map.put(c,7);
        for(char c: "TUV".toCharArray())
            map.put(c,8);
        for(char c: "WXYZ".toCharArray())
            map.put(c,9);

        int tmp=0;
        for(char c: br.readLine().toCharArray()){
            tmp+=map.get(c)+1;
        }
        bw.write(Integer.toString(tmp));
        bw.flush();bw.close();br.close();
    }
}