import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        double a=0;
        int max=-4000, min = 4000;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
            if(map.get(arr[i]) == null){
                map.put(arr[i],1);
            }
            else
                map.put(arr[i],map.get(arr[i])+1);
            a+=arr[i];
            if(max<arr[i])
                max = arr[i];
            if(min>arr[i])
                min = arr[i];
        }
        Arrays.sort(arr);
        a/=N;
        List<Integer> li = new LinkedList<>(map.values());
        int mx = -4000, freq;
        for(int i: li){
            if(mx<i){
                mx = i;
            }
        }
        li = new LinkedList<>();
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(entry.getValue() == mx){
                li.add(entry.getKey());
            }
        }
        li.sort(Comparator.naturalOrder());
        if(li.size()>1){
            freq = li.get(1);
        }
        else{
            freq = li.get(0);
        }
        bw.write(String.valueOf(Math.round(a))+'\n');
        bw.write(String.valueOf(arr[N/2])+'\n');
        bw.write(String.valueOf(freq)+'\n');
        bw.write(String.valueOf(max-min)+'\n');
        bw.flush();bw.close();br.close();
    }
}