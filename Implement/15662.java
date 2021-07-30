import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br;
    static int[][] gear;
    static int[] top;
    static boolean[] isDiff;
    static int T,K;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        gear = new int[T][8];
        isDiff = new boolean[T-1];
        char[] tmp;
        for(int i=0;i<T;i++){
            tmp = br.readLine().toCharArray();
            for(int k=0;k<8;k++)
                gear[i][k] = tmp[k]-'0';
        }
        top = new int[T];
        K = Integer.parseInt(br.readLine());
        int[] tmp2;
        for(int i=0;i<K;i++){
            tmp2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            action(tmp2[0]-1 ,tmp2[1]);
        }
        int cnt=0;

        for(int i=0;i<T;i++)
            if(gear[i][top[i]]==1)
                cnt++;
        
        System.out.println(cnt);
    }
    static void action(int target, int direction){
        // left = (index+6)%8, right = (index+2)%8
        // clock = top: (index+7)%8, rev = top: (index+1)%8
        for(int i=0;i<T-1;i++){
            if(gear[i][(top[i]+2)%8] == gear[i+1][(top[i+1]+6)%8])
                // 각 톱니가 오른쪽 톱니와 극이 같은 경우 -> 움직이지 않음.
                isDiff[i] = false;
            else
                // 각 톱니가 오른쪽 톱니와 극이 다른 경우 -> 움직인다.
                isDiff[i] = true;
        }

        int dir = direction;
        if(dir == -1){
            // 반시계 방향의 경우
            top[target] = (top[target]+1)%8;
            dir*=-1;
        }else{
            // 시계 방향의 경우
            top[target] = (top[target]+7)%8;
            dir*=-1;
        }

        // target의 왼쪽 톱니 조정
        for(int i=target-1;i>-1;i--){
            if(!isDiff[i])
                break;
            if(dir == -1){
                // 반시계 방향의 경우
                top[i] = (top[i]+1)%8;
                dir*=-1;
            }else{
                // 시계 방향의 경우
                top[i] = (top[i]+7)%8;
                dir*=-1;
            }
        }
        // target의 오른쪽 톱니 조정
        dir = direction*-1;
        for(int i=target+1;i<T;i++){
            if(!isDiff[i-1])
                break;
            if(dir == -1){
                // 반시계 방향의 경우
                top[i] = (top[i]+1)%8;
                dir*=-1;
            }else{
                // 시계 방향의 경우
                top[i] = (top[i]+7)%8;
                dir*=-1;
            }
        }
    }
}