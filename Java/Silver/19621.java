import java.io.*;
import java.util.*;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        ArrayList<Meeting> meetings = new ArrayList<>(N);

        for (int i=0;i<N;i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            meetings.add( new Meeting( input[0], input[1], input[2] ));
        }

        meetings.sort(Comparator.comparingInt(meeting -> meeting.startTime));
        int[] maxUserPerMeeting = meetings.stream().mapToInt((meeting) -> meeting.users).toArray();

        for (int i=0;i<N;i++) {
            int maxUserBefore = 0;
            for (int j=0;j<i;j++) {
                if (meetings.get(i).startTime >= meetings.get(j).endTime) {
                    if (maxUserBefore < maxUserPerMeeting[j]) maxUserBefore = maxUserPerMeeting[j];
                }

            }
            maxUserPerMeeting[i] += maxUserBefore;
        }
        System.out.println(Arrays.stream(maxUserPerMeeting).max().getAsInt());
    }

}

class Meeting {
    int startTime;
    int endTime;
    int users;

    Meeting(int start, int end, int users) {
        this.startTime = start;
        this.endTime = end;
        this.users = users;
    }

}