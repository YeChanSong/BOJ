import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        HashSet<Integer> set = new HashSet<>();
        for(int i: tmp)
            set.add(i);
        int[] arr = set.stream().mapToInt(Number::intValue).toArray();
        Arrays.sort(arr);
        HashMap<Integer,Integer> map = new HashMap<>();
        int cnt=0;
        for(int i: arr){
            map.put(i,cnt);
            cnt++;
        }
        for(int i=0;i<N;i++){
            tmp[i] = map.get(tmp[i]);
        }
        StringBuilder sb = new StringBuilder();
        for(int i: tmp)
            sb.append(i).append(" ");
        bw.write(sb.toString());
        bw.flush();bw.close();br.close();
    }
}