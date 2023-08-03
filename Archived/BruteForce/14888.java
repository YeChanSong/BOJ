import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N,mn = 1000000000, mx = -1000000000;
    static int[] arr; // pls,mns,pow,div
    static ArrayList<Integer> ops = new ArrayList<>(100);
    static boolean[] isUsed;
    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int op=0;
        isUsed = new boolean[N-1];
        for(int i:tmp){
            for(int j=0;j<i;j++){
                ops.add(op);
            }
            op++;
        }
        recur(0,0,new ArrayList<>());
        System.out.println(mx);
        System.out.println(mn);
    }
    public static void recur(int idx, int cnt, ArrayList<Integer> hist){
        if(cnt == N-1){
            int tmp = 1, sum=arr[0];
            for(int i: hist){
                if(i==0)
                    sum+=arr[tmp];
                else if(i==1)
                    sum-=arr[tmp];
                else if(i==2)
                    sum*=arr[tmp];
                else
                    sum/=arr[tmp];
                tmp++;
            }
            if(sum<mn)
                mn = sum;
            if(sum>mx)
                mx = sum;

            return;
        }
        for(int i=0;i<N-1;i++){
            if(!isUsed[i]){
                isUsed[i] = true;
                hist.add(ops.get(i));
                recur(i,cnt+1,hist);
                hist.remove(hist.size()-1);
                isUsed[i] = false;
            }
        }
    }
}