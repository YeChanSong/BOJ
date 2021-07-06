import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        ArrayList<int[]> arr = new ArrayList<>();
        for(int i=0;i<N;i++){
            arr.add(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());
        }
        int[] rank = new int[N];
        int[] tmp,comp;
        for(int i=0;i<N;i++){
            tmp = arr.get(i);
            for(int j=i+1;j<N;j++){
                comp = arr.get(j);
                if(comp[0]<tmp[0] && comp[1]<tmp[1]){
                    rank[j]++;
                }
                if(comp[0]>tmp[0] && comp[1]>tmp[1]){
                    rank[i]++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i:rank){
            sb.append(i+1).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();bw.close();br.close();
    }

}