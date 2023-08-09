import java.io.*;
import java.util.*;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] costMap;

    private static int[][] accCostMap;

    private static int houseCount = 0;

    public static void main(String[] args) throws IOException {

        houseCount = Integer.parseInt(br.readLine());
        costMap = new int[houseCount][3];
        accCostMap = new int[houseCount][3];

        for (int n = 0; n < houseCount; n++) {
            costMap[n] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int minCost = calculateCost();

        System.out.println(minCost);
        br.close();
    }

    private static int calculateCost() {
        int[] calculatedCosts = new int[3];
        for (int i=0;i<3;i++) calculatedCosts[i] = calculator(0,i);
        return Arrays.stream(calculatedCosts).min().getAsInt();
    }

    private static int calculator(int y, int x) {

        if (y == houseCount) return 0;

        if (accCostMap[y][x] != 0) return accCostMap[y][x];

        int minCost = 987654321;
        for(int idx = 0; idx < 3; idx++) {
            if(idx==x) continue;
            minCost = Math.min(minCost, calculator(y+1, idx));
        }
        accCostMap[y][x] =  minCost + costMap[y][x];
        return accCostMap[y][x];
    }


}