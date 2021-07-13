import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Point[] arr = new Point[N];
        String[] str;
        for(int i=0;i<N;i++){
            str = br.readLine().split(" ");
            arr[i] = new Point(Integer.parseInt(str[0]),Integer.parseInt(str[1]));
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++)
            sb.append(arr[i].x).append(" ").append(arr[i].y).append('\n');
        bw.write(sb.toString());
        bw.flush();bw.close();br.close();
    }
}
class Point implements Comparable<Point>{
    public final int x;
    public final int y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point p){
        if(this.x != p.x)
            return this.x-p.x;
        else
            return this.y-p.y;
    }
}