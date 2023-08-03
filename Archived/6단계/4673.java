import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        boolean[] checker = new boolean[10001];
        String tmp; int temp;
        for(int i=1;i<10001;i++){
            tmp = String.valueOf(i);
            temp = i;
            for(char k: tmp.toCharArray()){
                temp+=(k-'0');
            }
            if(temp<10001){
                checker[temp] = true;
            }

        }
        for(int b=1;b<10001;b++){
            if(checker[b]==false)
                System.out.println(b);
        }
    }
}