import java.io.*;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static Meeting[] meetings;
    private static int[] timeline;
    private static HashMap<Integer, Integer> startTimeIndex = new HashMap<>();
    private static HashMap<Integer, Integer> sortedStartTimeIndex = new HashMap<>();

    private static HashMap<Integer, Integer> endTimeIndex = new HashMap<>();

    public static void main(String[] args) throws IOException {

        settingInputs();

        System.out.println(getMaxMeetingUser());
    }

    static void settingInputs() throws IOException{
        int n = Integer.parseInt(br.readLine());
        meetings = new Meeting[n];
        timeline = new int[2*n];
        for (int i=0; i<n; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            meetings[i] = new Meeting(input[0], input[1], input[2]);
            timeline[i*2] = input[0];
            timeline[i*2+1] = input[1];
            startTimeIndex.put(input[0], 0);
            endTimeIndex.put(input[1], i);
        }
        Arrays.sort(timeline);
        for(int i=0;i<2*n;i++) {
            Integer value = startTimeIndex.get(timeline[i]);
            if (value != null) sortedStartTimeIndex.put(timeline[i], i);
        }
    }

    static int getMaxMeetingUser() {
        int[] dp = new int[timeline.length];
        for(int t=1; t<timeline.length; t++) {
            dp[t] = Integer.max(dp[t-1],
                    // 종료시각일 경우
                    endTimeIndex.get(timeline[t]) != null ? dp[sortedStartTimeIndex.get(meetings[endTimeIndex.get(timeline[t])].startTime)] + meetings[endTimeIndex.get(timeline[t])].user : 0
            );
        }
        return dp[timeline.length-1];
    }


}

class Meeting {

    int startTime;
    int endTime;
    int user;

    Meeting(int startTime, int endTime, int user) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.user = user;
    }



}