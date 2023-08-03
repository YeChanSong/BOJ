import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N,max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
    static int[] form, ops;
    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        form = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ops = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        recur(1,0,form[0]);
        System.out.println(max);
        System.out.println(min);
    }
    static void recur(int idx, int cnt, int ttl){
        if(idx==N){
            if(ttl>max)
                max=ttl;
            if(ttl<min)
                min=ttl;
            return;
        }
        for(int i=0;i<4;i++){
            if(ops[i]>0){
                ops[i]--;
                if(i==0)
                    recur(idx+1,cnt+1,ttl+form[idx]);
                else if(i==1)
                    recur(idx+1,cnt+1,ttl-form[idx]);
                else if(i==2)
                    recur(idx+1,cnt+1,ttl*form[idx]);
                else
                    recur(idx+1,cnt+1,ttl/form[idx]);
                ops[i]++;
            }
        }

    }
}