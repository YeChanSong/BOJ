import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long a,b,c;
        a = Long.parseLong(br.readLine());
        b = Long.parseLong(br.readLine());
        c = Long.parseLong(br.readLine());
        String ans = String.valueOf(a*b*c);

        int[] arr = new int[10];
        Arrays.fill(arr,0);
        for(char i: ans.toCharArray())
            if(i=='0') ++arr[0];
            else if(i=='1') ++arr[1];
            else if(i=='2') ++arr[2];
            else if(i=='3') ++arr[3];
            else if(i=='4') ++arr[4];
            else if(i=='5') ++arr[5];
            else if(i=='6') ++arr[6];
            else if(i=='7') ++arr[7];
            else if(i=='8') ++arr[8];
            else ++arr[9];
        for(int i:arr){
            bw.write(Integer.toString(i)+'\n');
        }
        bw.flush();bw.close();br.close();
    }
}