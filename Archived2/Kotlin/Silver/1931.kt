import java.io.BufferedReader
import java.io.InputStreamReader

val br = BufferedReader(InputStreamReader(System.`in`))

var currentEndTime = 0
var meetingCount = 0

fun main() {

    val n = br.readLine().toInt()
    val timeLine = arrayListOf<Meetings>()
    repeat(n) {
        val meeting = br.readLine().split(" ").map { it.toInt() }
        timeLine.add( Meetings(
            startTime = meeting[0],
            endTime = meeting[1]
        ) )
    }

    val sortedTimeLine = timeLine.sortedWith(
        compareBy( {it.endTime}, {it.startTime} )
    )

    sortedTimeLine.forEach {checkTimeOverlap(it)}
    println(meetingCount)
}

fun checkTimeOverlap(meetings: Meetings) {
    if (meetings.startTime >= currentEndTime) {
        currentEndTime = meetings.endTime
        meetingCount++
    }
}

data class Meetings(
    val startTime: Int,
    val endTime: Int
)