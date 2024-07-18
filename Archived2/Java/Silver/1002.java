import java.io.*;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int testCaseCount = Integer.parseInt(br.readLine());
        while (testCaseCount > 0) {
            System.out.println(calculatePossiblePositionCount());
            testCaseCount--;
        }


    }

    private static int calculatePossiblePositionCount() throws IOException {
        // x1, y1, r1, x2, y2, r2
        int[] positionsAndDistances = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        double distanceBetween = Math.sqrt(Math.pow(positionsAndDistances[0] - positionsAndDistances[3], 2) + Math.pow(positionsAndDistances[1] - positionsAndDistances[4], 2));

        // 동심원의 경우
        if(distanceBetween == 0 && positionsAndDistances[2] == positionsAndDistances[5]) return -1;
        if(distanceBetween == 0) return 0;

        boolean isTriangle = (distanceBetween < positionsAndDistances[2] + positionsAndDistances[5])
                && (positionsAndDistances[2] < distanceBetween + positionsAndDistances[5])
                && (positionsAndDistances[5] < distanceBetween + positionsAndDistances[2]);

        if (isTriangle) return 2;

        // 일직선인 경우
        boolean isLine = (distanceBetween == positionsAndDistances[2] + positionsAndDistances[5])
                || (positionsAndDistances[2] == distanceBetween + positionsAndDistances[5])
                || (positionsAndDistances[5] == distanceBetween + positionsAndDistances[2]);

        if (isLine) return 1;

        // 접점이 없거나 포함관계의 원인 경우
        return 0;
    }
}