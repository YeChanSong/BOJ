import java.util.*;
import java.io.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static ArrayList<Integer> numbers;
    public static void main(String[] args) throws IOException {
        settingInput();
        System.out.println(bindingNumbers());
        br.close();
    }
    private static void settingInput() throws IOException{
        N = Integer.parseInt(br.readLine());
        numbers = new ArrayList<>(N);
        ArrayList<Integer> positiveNums = new ArrayList<>(N);
        ArrayList<Integer> negativeNums = new ArrayList<>(N);

        for(int i=0;i<N;i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 0) positiveNums.add(num);
            else negativeNums.add(num);
        }
        positiveNums.sort(Comparator.comparingInt(a -> -a));
        negativeNums.sort(Comparator.comparingInt(a -> a));
        numbers.addAll(positiveNums);
        numbers.addAll(negativeNums);
    }
    private static int bindingNumbers() {
        int index = 0;
        int sum = 0;
        while (index < N) {
            int base = numbers.get(index);
            if (index+1 == N) {
                sum += base;
                break;
            }
            int next = numbers.get(index+1);
            int multiply = base*next;
            if (multiply > base + next) {
                sum += multiply;
                index+=2;
            } else {
                sum += base;
                index+=1;
            }
        }
        return sum;
    }
}