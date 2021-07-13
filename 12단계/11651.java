import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        String[] tmp;
        for(int i=0;i<N;i++){
            tmp = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(tmp[0]);
            arr[i][1] = Integer.parseInt(tmp[1]);
        }
        Arrays.sort(arr, new Comparator<int[]>(){
           @Override
           public int compare(int[] a, int[] b){
                if(a[1] == b[1])
                    return Integer.compare(a[0],b[0]);
                else
                    return Integer.compare(a[1],b[1]);
           }
        });
        StringBuilder sb = new StringBuilder();
        for(int[] i:arr){
            sb.append(i[0]).append(' ').append(i[1]).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();bw.close();br.close();
    }
}