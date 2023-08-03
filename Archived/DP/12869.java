import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, ans=0;
    static int[] arr;
    static int[][][] cache;
    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        arr = new int[3];
        int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for(int i=0;i<N;i++)
            arr[i] = tmp[i];
        cache = new int[61][61][61];
        cache[0][0][0] = 1;
        System.out.println(recur(arr)-1);
    }
    static int recur(int[] arr){
        Arrays.sort(arr);
        if(cache[arr[0]][arr[1]][arr[2]]!=0)
            return cache[arr[0]][arr[1]][arr[2]];

        int min=Integer.MAX_VALUE;
        min = Math.min(min,
                recur(new int[]{Math.max(arr[0]-9,0),Math.max(arr[1]-3,0),Math.max(arr[2]-1,0)})+1);
        min = Math.min(min,
                recur(new int[]{Math.max(arr[0]-9,0),Math.max(arr[1]-1,0),Math.max(arr[2]-3,0)})+1);
        min = Math.min(min,
                recur(new int[]{Math.max(arr[0]-3,0),Math.max(arr[1]-9,0),Math.max(arr[2]-1,0)})+1);
        min = Math.min(min,
                recur(new int[]{Math.max(arr[0]-3,0),Math.max(arr[1]-1,0),Math.max(arr[2]-9,0)})+1);
        min = Math.min(min,
                recur(new int[]{Math.max(arr[0]-1,0),Math.max(arr[1]-9,0),Math.max(arr[2]-3,0)})+1);
        min = Math.min(min,
                recur(new int[]{Math.max(arr[0]-1,0),Math.max(arr[1]-3,0),Math.max(arr[2]-9,0)})+1);
        cache[arr[0]][arr[1]][arr[2]] = min;
        return min;
    }
}