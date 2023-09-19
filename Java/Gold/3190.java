import java.util.*;
import java.io.*;


public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static HashMap<Integer, Integer> leftDirection = new HashMap<>();
    private static HashMap<Integer, Integer> rightDirection = new HashMap<>();

    private static int[] moveY = {-1,0,1,0};
    private static int[] moveX = {0,-1,0,1};
    private static int N;
    private static int K; // number of apple

    private static Movement[] movements;
    private static HeadPosition head;
    private static List<Body> snake;
    private static List<Apple> apples;

    public static void main(String[] args) throws IOException {

        settingInput();
        play();
        System.out.println(head.seconds);
        br.close();
    }

    private static void settingInput() throws IOException {
        // 0: y-1, 1: x-1, 2: y+1, 3: x+1
        leftDirection.put(0, 1);
        leftDirection.put(1, 2);
        leftDirection.put(2, 3);
        leftDirection.put(3, 0);

        rightDirection.put(0, 3);
        rightDirection.put(3, 2);
        rightDirection.put(2, 1);
        rightDirection.put(1, 0);
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        snake = new LinkedList<>();
        apples = new LinkedList<>();
        snake.add(new Body(0,0, null));
        head = new HeadPosition(snake.get(0),3);

        for(int i=0;i<K;i++) {
            int[] applePosition = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            apples.add(new Apple(applePosition[0]-1, applePosition[1]-1));
        }

        int L = Integer.parseInt(br.readLine());
        movements = new Movement[L];
        for(int i=0;i<L;i++) {
            String[] move = br.readLine().split(" ");
            movements[i] = new Movement(Integer.parseInt(move[0]), move[1]);
        }

    }

    private static void play() {

        while (true) {
            head.seconds+=1;

            int nextY = head.pos.y + moveY[head.direction];
            int nextX = head.pos.x + moveX[head.direction];
            // next pos is wall
            if (nextY < 0 || nextX < 0 || nextY >= N || nextX >= N) return;
            // next pos is body
            for(Body body: snake) if (nextY == body.y && nextX == body.x) return;
            // next pos is apple

            for(Apple apple: apples) {
                if (nextY == apple.y && nextX == apple.x) {
                    snake.add(0, new Body(nextY, nextX, head.pos));
                    head.pos = snake.get(0);
                    // delete apple
                    apple.y = -1;
                    apple.x = -1;
                }
            }

            if (head.pos.y != nextY || head.pos.x != nextX) {
                Body iter = head.pos;
                while (iter != null) {
                    int beforeY = iter.y;
                    int beforeX = iter.x;
                    iter.y = nextY;
                    iter.x = nextX;
                    nextY = beforeY;
                    nextX = beforeX;
                    iter = iter.before;
                }
            }

            for(Movement move: movements) {
                if (move.time == head.seconds)
                    head.direction = move.direction.equals("L") ? leftDirection.get(head.direction) : rightDirection.get(head.direction);
            }
        }

    }

}

class Movement {
    int time;
    String direction;
    Movement(int time, String direction) {
        this.time = time;
        this.direction = direction;
    }
}

class HeadPosition {
    Body pos;
    int direction;    // 0: up, 2: down, 1: left, 3: right
    int seconds;
    HeadPosition(Body pos, int d) {
        this.pos = pos;
        this.direction = d;
        seconds = 0;
    }
}
class Body {
    int y;
    int x;
    Body before;
    Body(int y, int x, Body before) {
        this.y = y;
        this.x = x;
        this.before = before;
    }
}

class Apple {
    int y;
    int x;
    Apple(int y, int x) {
        this.y = y;
        this.x = x;
    }
}