import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine()), cnt=0;
        char[] word; char before; boolean flag;
        HashMap<Character,Boolean> map;
        for(int i=0;i<N;i++){
            word = br.readLine().toCharArray();
            map = new HashMap<>(); before = word[0];
            flag = true;
            for(char c: word){
                if(c != before){
                    map.put(before,true);
                    before = c;
                }
                if(map.get(c) != null){
                    flag = false;
                    break;
                }
            }
            if(flag)
                cnt++;
        }
        bw.write(Integer.toString(cnt));
        bw.flush();bw.close();br.close();
    }
}