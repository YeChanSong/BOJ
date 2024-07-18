import java.io.*;
import java.util.*;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        checkStackSequence(n);
        br.close();
    }

    private static void checkStackSequence(int n) throws IOException {

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++){ queue.offer(i); }

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        while (n-- > 0) {
            int num = Integer.parseInt(br.readLine());

            while (stack.isEmpty() || stack.peekFirst() < num) {
                stack.offerFirst(queue.poll());
                sb.append("+\n");
            }

            if (stack.peekFirst() == num) {
                stack.pollFirst();
                sb.append("-\n");
                continue;
            }

            if (stack.peekFirst() > num) {
                System.out.println("NO");
                return;
            }

        }

        System.out.println(sb);
    }
}
