import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val meetings = arrayListOf<Meeting>()

    repeat(n) {
        val meetingData = br.readLine().split(" ").map { it.toInt() }
        meetings.add(Meeting(
            startTime = meetingData[0],
            endTime = meetingData[1],
            users = meetingData[2]
        ))
    }

    meetings.sortWith( compareBy { it.startTime } )
    val maxUserPerMeeting = meetings.map { it.users }.toMutableList()
    for (i in 0 until n) {
        var maxUserCount = 0
        for (j in 0 until i) {
            if (meetings[i].startTime >= meetings[j].endTime) {
                if (maxUserCount < maxUserPerMeeting[j]) maxUserCount = maxUserPerMeeting[j]
            }
        }
        maxUserPerMeeting[i] += maxUserCount
    }
    println(maxUserPerMeeting.max())

}

data class Meeting(
    val startTime: Int,
    val endTime: Int,
    val users: Int,
)