import java.util.*;
import java.io.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static String A;
    private static String B;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {

        settingInput();
        for(int i=1;i<=A.length();i++) {
            for(int j=1;j<=B.length();j++) {
                dp[i][j] = A.charAt(i-1) == B.charAt(j-1) ? dp[i-1][j-1] + 1 : Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        System.out.println(dp[A.length()][B.length()]);
        br.close();
    }

    private static void settingInput() throws IOException {

        A = br.readLine();
        B = br.readLine();
        dp = new int[A.length()+1][B.length()+1];

    }

}