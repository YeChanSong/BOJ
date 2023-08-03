import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        List<String> li = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        String tmp;
        for(int i=0;i<N;i++){
            tmp = br.readLine();
            if(!set.contains(tmp)){
                set.add(tmp);
                li.add(tmp);
            }
        }
        Collections.sort(li, new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                if(a.length() == b.length()){
                    return a.compareTo(b);
                }
                else{
                    return a.length()-b.length();
                }
            }
        });
        StringBuilder sb = new StringBuilder();
        for(String s: li){
            sb.append(s).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();bw.close();br.close();
    }
}