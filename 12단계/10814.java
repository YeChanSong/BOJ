import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        List<data> li = new LinkedList<>();
        String[] tmp;
        for(int i=0;i<N;i++){
            tmp = br.readLine().split(" ");
            li.add(new data(Integer.parseInt(tmp[0]),tmp[1],i));
        }
        StringBuilder sb = new StringBuilder();
        Collections.sort(li);
        for(data d: li){
            sb.append(d.age).append(" ").append(d.name).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();bw.close();br.close();
    }
}
class data implements Comparable<data>{
    int age;
    String name;
    int rank;
    public data(int age, String name, int rank){
        this.age = age;
        this.name = name;
        this.rank = rank;
    }

    @Override
    public int compareTo(data b) {
        if(this.age==b.age)
            return Integer.compare(this.rank,b.rank);
        else
            return Integer.compare(this.age,b.age);
    }
}