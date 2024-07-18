import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

val br = BufferedReader(InputStreamReader(System.`in`))
lateinit var meetings: MutableList<Meeting?>
lateinit var timeline: MutableList<Int>
val startTimeIndex = HashMap<Int, Int>()
val endTimeIndex = HashMap<Int, Int>()
val sortedStartTimeIndex = HashMap<Int, Int>()

fun main() {

    settingInput()
    println(getMaxMeetingUser())
}

fun settingInput() {
    val n = br.readLine().toInt()
    meetings = MutableList(n) { null }
    timeline = MutableList(2*n) { 0 }
    repeat(n) {
        val input = br.readLine().split(" ").map { it.toInt() }
        meetings[it] = Meeting(input[0], input[1], input[2])
        timeline[it*2] = input[0]
        timeline[it*2+1] = input[1]
        startTimeIndex[input[0]] = 0
        endTimeIndex[input[1]] = it
    }

    timeline.sortBy { it }
    timeline.forEachIndexed { idx, element ->
        startTimeIndex.get(element)?.let {
            sortedStartTimeIndex[element] = idx
        }
    }

}

fun getMaxMeetingUser(): Int {

    val dp = MutableList(timeline.size) { 0 }

    repeat(timeline.size-1) { time ->
        // 종료시간인 경우
        val compare = endTimeIndex[timeline[time+1]]?.let {
            dp[sortedStartTimeIndex[meetings[it]!!.startTime]!!] + meetings[it]!!.user
        } ?: 0

        dp[time+1] = max(dp[time], compare)
    }

    return dp[timeline.size-1]
}

class Meeting(val startTime: Int, val endTime: Int, val user: Int)