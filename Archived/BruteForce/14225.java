import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] S;
    static HashSet<Integer> set = new HashSet<>();
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        S = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for(int i=0;i<S.length;i++)
            recur(i);
        int[] arr = set.parallelStream().mapToInt(Number::intValue).toArray();
        Arrays.sort(arr);
        int cnt=1, idx=0;
        while(idx<arr.length && (cnt == arr[idx])){
            cnt++; idx++;
        }
        System.out.println(cnt);
    }
    public static void recur(int idx){
        stack.add(S[idx]);
        for(int i=idx+1;i<S.length;i++){
            recur(i);
        }
        int sum=0;
        for(int i:stack){
            sum+=i;
        }
        set.add(sum);
        stack.pop();
    }
}