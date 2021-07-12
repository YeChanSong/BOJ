import java.io.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[10];
        for(int i:str.toCharArray()){
            arr[i-'0']++;
        }
        for(int i=arr.length-1;i>-1;i--){
            while(arr[i]>0){
                sb.append(i);
                arr[i]--;
            }
        }
        bw.write(sb.toString());
        bw.flush();bw.close();br.close();
    }
}