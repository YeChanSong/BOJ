import java.io.*;
import java.util.*;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int currentEndTime = 0;
    private static int meetingCount = 0;

    public static void main(String[] args) throws IOException {

        int N  = Integer.parseInt(br.readLine());
        ArrayList<Meetings> timeLine = new ArrayList<>(N);

        for (int i=0; i<N; i++) {
            int[] meeting = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            timeLine.add(new Meetings(meeting[0], meeting[1]));
        }

        timeLine.sort((meetingA, meetingB) -> {
            if (meetingA.endTime != meetingB.endTime) return meetingA.endTime - meetingB.endTime;
            else return meetingA.startTime - meetingB.startTime;
        });

        timeLine.forEach(Main::checkAndAddTime);

        System.out.println(meetingCount);
    }

    static void checkAndAddTime(Meetings meetings) {
        if (currentEndTime <= meetings.startTime) {
            currentEndTime = meetings.endTime;
            meetingCount++;
        }
    }

}

class Meetings {

    int startTime;
    int endTime;

    Meetings(int start, int end) {
        startTime = start;
        endTime = end;
    }

}