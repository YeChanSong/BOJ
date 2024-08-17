import java.util.*;
import java.io.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int n, k;
    private static int[] costs;

    private static int[][] items;

    public static void main(String[] args) throws IOException {

        int[] nk = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();

        n = nk[0]; k = nk[1];
        costs = new int[k+1];
        items = new int[n][2]; // weight / value
        for (int i=0;i<n;i++) {
            int[] wv = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            items[i][0] = wv[0];
            items[i][1] = wv[1];
        }

        findMaximumValue(0);

        System.out.println(Arrays.stream(costs).max().getAsInt());

        br.close();
    }

    private static void findMaximumValue(int itemNum) {
        if (itemNum >= n) return;

        int[] item = items[itemNum];

        for(int i=k;i>=0;i--) {
            if (i - item[0] >= 0)
                costs[i] = Math.max(costs[i], costs[i-item[0]] + item[1]);
        }

        findMaximumValue(itemNum+1);
    }

}
