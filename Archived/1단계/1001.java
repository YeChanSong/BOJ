import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args){
        //Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            String a = br.readLine();
            int c,d;
            StringTokenizer st = new StringTokenizer(a," ");
            c = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            System.out.println(c-d);
        }
        catch(IOException e){
            System.out.println("Error: "+e);
        }
        

    }
}