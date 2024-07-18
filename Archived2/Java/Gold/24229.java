import java.util.*;
import java.io.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static ArrayList<int[]> boards = new ArrayList<>();
    private static int N = 0;

    public static void main(String[] args) throws IOException{
        setting();
        System.out.println(calculatePosition());
        br.close();
    }

    private static void setting() throws IOException {
        N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++) {
            int[] board = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            boards.add(board);
        }
        boards.sort( (a, b) -> {
            if (a[0] == b[0]) return a[1]-b[1];
            else return a[0]-b[0];
        });
        ArrayList<int[]> mergedBoards = new ArrayList<>();
        int start = boards.get(0)[0];
        int end = boards.get(0)[1];
        for(int i=1;i<boards.size();i++) {
            int[] chunk = boards.get(i);
            if (chunk[1] >= end && end >= chunk[0]) {
                end = chunk[1];
            }
            if (chunk[0] > end){
                mergedBoards.add(new int[] {start, end});
                start= chunk[0];
                end = chunk[1];
            }
        }
        mergedBoards.add(new int[] {start, end});
        boards = mergedBoards;
    }
    private static int calculatePosition() {
        int currentPos = 0, idx = 0, maxJumpLen = 0;
        for(int i=0;i<boards.size();i++) {
            int[] board = boards.get(i);
            if (maxJumpLen >= board[0]) {
                idx = i;
                maxJumpLen = Math.max(maxJumpLen, board[1] + board[1] - board[0]);
            }
        }
        currentPos = boards.get(idx)[1];
        return currentPos;
    }

}