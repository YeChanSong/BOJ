
import java.util.*;
import java.io.*;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static HashMap<String, Double> gradePointMap = new HashMap<>();

    public static void main(String[] args) throws IOException {

        gradePointMap.put("A+", 4.5);
        gradePointMap.put("A0", 4.0);
        gradePointMap.put("B+", 3.5);
        gradePointMap.put("B0", 3.0);
        gradePointMap.put("C+", 2.5);
        gradePointMap.put("C0", 2.0);
        gradePointMap.put("D+", 1.5);
        gradePointMap.put("D0", 1.0);
        gradePointMap.put("F", 0.0);


        double totalPoint  = 0.0;
        double totalGradePoint = 0.0;
        int N = 20;
        while (N-- > 0) {
            String input = br.readLine();
            String[] splited = input.split(" ");
            Double gradePoint = gradePointMap.get(splited[2]);

            if (gradePoint != null) {
                totalGradePoint += Double.parseDouble(splited[1]);
                totalPoint += gradePointMap.get(splited[2]) * Double.parseDouble(splited[1]);
            }
        }
        bw.write(String.valueOf(totalPoint / totalGradePoint));
        bw.flush();
        bw.close();br.close();
    }
}