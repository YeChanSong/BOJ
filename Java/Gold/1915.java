import java.io.*;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static String[] board;
    private static int[][] dp;
    private static int n,m, answer = 0;

    public static void main(String[] args) throws IOException {
        settingInput();
        for (int i=1;i<=n;i++) {
            for (int j=1;j<=m;j++) {
                dp[i][j] = board[i-1].charAt(j-1) == '1'
                        ? (dp[i-1][j-1] > 0) && (dp[i-1][j] > 0) && (dp[i][j-1] > 0)
                        ? Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + (board[i-1].charAt(j-1) - '0')
                        : board[i-1].charAt(j-1) - '0'
                        : 0;
                answer = Math.max(answer, dp[i][j]);
            }
        }

        System.out.println(answer*answer);
        br.close();
    }

    private static void settingInput() throws IOException{
        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = nm[0]; m = nm[1];
        board = new String[n];
        for(int i=0;i<n;i++) board[i] = br.readLine();
        dp = new int[n+1][m+1];
    }

}