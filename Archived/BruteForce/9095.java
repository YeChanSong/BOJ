import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main{
    public static int[] cache = new int[11];
    public static void main(String[] args) throws IOException{
        for(int i = 0;i<11;i++)
            cache[i] = -1;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int ans = 0;
        int T = Integer.parseInt(bf.readLine());
        int idx = -1;
        for(int i =0;i<T;i++){
            idx = Integer.parseInt(bf.readLine());
            ans = recur(idx);
            bw.write(Integer.toString(ans)+'\n');
            bw.flush();
        }
        bf.close();
        bw.close();
    }

    public static int recur(int idx){

        if (idx<0)
            return 0;
        if (idx == 0)
            return 1;

        if (cache[idx]!= -1)
            return cache[idx];
        int one=0,two=0,three=0;
        one = recur(idx-1);
        two = recur(idx-2);
        three = recur(idx-3);
        cache[idx] = one+two+three;
        return cache[idx];

    }

}