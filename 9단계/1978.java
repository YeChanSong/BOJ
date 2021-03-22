import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc =  new Scanner(System.in);
        int N = sc.nextInt();
        int tmp=0;
        boolean flag;
        int cnt=0;
        for(int i=0;i<N;i++){
            tmp = sc.nextInt();
            flag = true;
            int lim = (int)(Math.floor(Math.sqrt(tmp)));
            for(int j=2;j<lim+1;j++){
                if(tmp%j==0){
                    flag = false;
                    break;
                }
            }
            if(flag == true && tmp != 1){
                cnt += 1;
            }
        }
        System.out.println(cnt);
    }
}