import java.util.*;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class Main{
    static ArrayList<Integer> arr = new ArrayList<>();
    static int N;
    static int M;
    static BufferedReader br;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for(int i=1;i<=N;i++)
            arr.add(i);
        ArrayList<Integer> hist = new ArrayList<Integer>();
        recur(0,hist);
        bw.close();
        br.close();
    }
    public static void recur(int idx, ArrayList<Integer> hist) throws IOException{
        if(idx == M){
            for(int i=0;i<hist.size();i++){
                bw.write(Integer.toString(hist.get(i))+' ');
            }
            bw.write("\n");
            bw.flush();
            return;
        }
        for(int i=1;i<=N;i++){
            boolean flag = false;
            if(hist.size()>0){
                if(i<= hist.get(hist.size()-1))
                    flag = true;
            }
            if(flag)
                continue;
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.addAll(hist);
            tmp.add(i);
            recur(idx+1,tmp);
        }
    }
}