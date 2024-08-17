import java.util.*;
import java.io.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int n;
    private static int[][] costs;
    private static int[] points;

    public static void main(String[] args) throws IOException{

        n = Integer.parseInt(br.readLine().trim());
        costs = new int[n][2];
        points = new int[n];

        for (int i=n-1;i>=0;i--) points[i] = Integer.parseInt(br.readLine().trim());

        jump(0,1);

        int answer = costs[0][0];

        System.out.println(answer);
        br.close();
    }

    public static int jump(int pos, int oneStepCnt) {

        if (pos >= n || oneStepCnt > 2) return 0;

        if (costs[pos][oneStepCnt-1] > 0) return costs[pos][oneStepCnt-1];

        if (oneStepCnt == 2) {
            costs[pos][oneStepCnt-1] = jump(pos+2, 1) + points[pos];
        } else {
            costs[pos][oneStepCnt-1] = Math.max(jump(pos+2, 1), jump(pos+1, oneStepCnt+1)) + points[pos];
        }

        return costs[pos][oneStepCnt-1];
    }



}
