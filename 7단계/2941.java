import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] init = br.readLine().toCharArray();
        HashMap<String,Boolean> map = new HashMap<>();
        map.put("c=",true);map.put("c-",true);map.put("dz=",true);map.put("d-",true);
        map.put("lj",true);map.put("nj",true);map.put("s=",true);map.put("z=",true);
        int i = 0, cnt = 0; StringBuilder sb;
        while(i<init.length){
            sb = new StringBuilder();
            if(i+1<init.length){
                sb.append(init[i]);
                sb.append(init[i+1]);
                if(map.get(sb.toString()) != null){
                    cnt++;
                    i+=2;
                    continue;
                }
            }
            if(i+2<init.length){
                sb.append(init[i+2]);
                if(map.get(sb.toString()) != null){
                    cnt++;
                    i+=3;
                    continue;
                }
            }
            cnt++;
            i++;
        }
        bw.write(String.valueOf(cnt));
        bw.flush();bw.close();br.close();

    }
}