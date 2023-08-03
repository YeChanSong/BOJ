import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<Integer,Boolean> map = new HashMap<>();
        int tmp;
        for(int i=0;i<10;i++){
            tmp = Integer.parseInt(br.readLine())%42;
            if(map.get(tmp)==null){
                map.put(tmp,true);
            }

        }
        tmp = 0;
        for(Map.Entry<Integer,Boolean> entry: map.entrySet()){
            tmp++;
        }
        bw.write(String.valueOf(tmp));
        bw.flush();bw.close();br.close();
    }
}