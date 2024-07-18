import java.util.*;
import java.io.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] dp;
    private static int k, n;
    private static ArrayDeque<Integer> moneys;

    public static void main(String[] args) throws IOException {

        settingInput();

        for(int i=1;i<=k;i++) {
            int currentMoney = i;
            moneys.forEach(money -> {
                if (currentMoney >= money) dp[currentMoney] = Math.min(dp[currentMoney-money]+1, dp[currentMoney]);
            });
        }
        System.out.println(dp[k] >= 987654321 ? -1 : dp[k]);
        br.close();
    }

    private static void settingInput() throws IOException {

        int[] nk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = nk[0];
        k = nk[1];
        dp = new int[k+1];
        Arrays.fill(dp, 987654321);
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++) set.add(Integer.parseInt(br.readLine()));
        moneys = new ArrayDeque<>(set);
        moneys.forEach( money -> {
            if (money <= k) dp[money] = 1;
        });
    }
}