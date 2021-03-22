import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a,b;
        String tmp;
        a=sc.nextInt();b=sc.nextInt();
        tmp = Integer.toString(b);
        System.out.println(a*Character.getNumericValue(tmp.charAt(2)));
        System.out.println(a*Character.getNumericValue(tmp.charAt(1)));
        System.out.println(a*Character.getNumericValue(tmp.charAt(0)));
        System.out.println(a*b);
    }
}