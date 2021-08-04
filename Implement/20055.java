import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N,K,first,ans=0,brkn=0;
    static int[] conv;
    static boolean[] robots;

    public static void main(String[] args) throws IOException{
        int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = tmp[0]; K = tmp[1];
        conv = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        first = 0;
        robots = new boolean[2*N];
        while(brkn<K){
            ans++;
            oneStep();
        }
        System.out.println(ans);
        br.close();
    }
    public static void oneStep(){
        first = (first+2*N-1)%(2*N);
        if(robots[(first+N-1)%(2*N)])
            robots[(first+N-1)%(2*N)]=false;
        for(int i=N-2;i>0;i--){
            if(robots[(first+i)%(2*N)] && !robots[(first+i+1)%(2*N)]
                    && conv[(first+i+1)%(2*N)]>0){
                robots[(first+i+1)%(2*N)] = true;
                robots[(first+i)%(2*N)] = false;
                conv[(first+i+1)%(2*N)]--;
                if(conv[(first+i+1)%(2*N)]==0)
                    brkn++;
            }
        }
        if(robots[(first+N-1)%(2*N)])
            robots[(first+N-1)%(2*N)]=false;
        if(conv[first]>0){
            robots[first]=true;
            conv[first]--;
            if(conv[first]==0)
                brkn++;
        }
    }
}