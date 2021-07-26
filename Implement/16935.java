import java.io.*;
import java.util.*;

public class Main{
    static int N,M,R,OP;
    static BufferedReader br;
    static BufferedWriter bw;
    static int[][] original, cpy;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] tmp = br.readLine().split(" ");
        N = Integer.parseInt(tmp[0]);
        M = Integer.parseInt(tmp[1]);
        R = Integer.parseInt(tmp[2]);
        original = new int[N][M];
        for(int i=0;i<N;i++){
            original[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        tmp = br.readLine().split(" ");
        for(int i=0;i<R;i++){
            OP = Integer.parseInt(tmp[i%tmp.length]);
            if(OP == 1)
                op1();
            else if(OP == 2)
                op2();
            else if(OP == 3)
                op3();
            else if(OP == 4)
                op4();
            else if(OP == 5)
                op5();
            else
                op6();
        }
        for(int[] y: original) {
            for (int x : y)
                sb.append(x).append(' ');
            sb.append('\n');
        }
        bw.write(sb.toString());
        bw.flush();br.close();bw.close();
    }
    public static void op1(){
        int tmp = original.length-1;
        cpy = new int[original.length][original[0].length];
        for(int i=tmp;i>-1;i--)
            for (int j = 0; j < original[0].length; j++)
                cpy[tmp-i][j] = original[i][j];
        original = cpy;
    }
    public static void op2(){
        int tmp = original[0].length-1;
        cpy = new int[original.length][original[0].length];
        for(int i=0;i<original.length;i++)
            for (int j = tmp; j > -1; j--)
                cpy[i][tmp - j] = original[i][j];
        original = cpy;
    }
    public static void op3(){
        int tmp = original.length-1;
        cpy = new int[original[0].length][original.length];
        for(int j=0;j<original[0].length;j++)
            for(int i=tmp;i>-1;i--)
                cpy[j][tmp-i] = original[i][j];
        original = cpy;
    }
    public static void op4(){
        int tmp = original.length-1, tmp2 = original[0].length-1;
        cpy = new int[original[0].length][original.length];
        for(int j=tmp2;j>-1;j--)
            for(int i=0;i<original.length;i++)
                cpy[tmp2-j][i] = original[i][j];
        original = cpy;
    }
    public static void op5(){
        int tmp = original.length/2, tmp2 = original[0].length/2;
        cpy = new int[original.length][original[0].length];
        for(int i=tmp;i< original.length;i++) {
            for (int j = 0; j < original[0].length / 2; j++)
                cpy[i-tmp][j] = original[i][j];
            for (int j = 0; j < original[0].length / 2; j++)
                cpy[i-tmp][j+tmp2] = original[i-tmp][j];
            for (int j = original[0].length / 2; j < original[0].length; j++)
                cpy[i][j-tmp2] = original[i][j];
            for (int j = original[0].length / 2; j < original[0].length; j++)
                cpy[i][j] = original[i-tmp][j];
        }
        original = cpy;
    }
    public static void op6(){
        int tmp = original.length/2, tmp2 = original[0].length/2;
        cpy = new int[original.length][original[0].length];
        for(int i=0;i<tmp;i++){
            for(int j=0;j<tmp2;j++)
                cpy[i+tmp][j] = original[i][j];
            for(int j=tmp2;j<original[0].length;j++)
                cpy[i][j-tmp2] = original[i][j];
        }
        for(int i=tmp;i<original.length;i++){
            for(int j=0;j<tmp2;j++)
                cpy[i][j+tmp2] = original[i][j];
            for(int j=tmp2;j<original[0].length;j++)
                cpy[i-tmp][j] = original[i][j];
        }
        original = cpy;
    }

}