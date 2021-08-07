import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int K;
    static int[] S;
    static StringBuilder sb = new StringBuilder(100000);
    public static void main(String[] args) throws IOException{
        int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        while(tmp[0]!=0){
            K = tmp[0];
            S = Arrays.copyOfRange(tmp,1,tmp.length);
            recur(-1,0, new ArrayList<Integer>(100000));
            sb.append('\n');
            tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        bw.write(sb.toString());
        bw.flush();bw.close();br.close();
    }
    public static void recur(int idx, int cnt, ArrayList<Integer> arr){
        if(cnt==6){
            for(int i: arr)
                sb.append(i).append(' ');
            sb.append('\n');
            return;
        }
        for(int i=idx+1;i<S.length;i++){
            arr.add(S[i]);
            recur(i,cnt+1,arr);
            arr.remove(arr.size()-1);
        }
    }
}