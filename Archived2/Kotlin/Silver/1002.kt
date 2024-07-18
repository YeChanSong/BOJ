import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.pow
import kotlin.math.sqrt


fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))

    var testCaseCount = br.readLine().toInt()
    while (testCaseCount-- > 0) {
        println(calculatePossiblePositionCount(br))
    }

}

fun calculatePossiblePositionCount(br: BufferedReader): Int {

    // x1, y1, r1, x2, y2, r2
    val positionsAndDistances = br.readLine().split(" ").map { it.toDouble() }

    val distanceBetween = sqrt(
        positionsAndDistances[0].minus(positionsAndDistances[3]).pow(2)
                + positionsAndDistances[1].minus(positionsAndDistances[4]).pow(2)
    )

    val isTriangle = (distanceBetween < positionsAndDistances[2] + positionsAndDistances[5])
            && (positionsAndDistances[2] < distanceBetween + positionsAndDistances[5])
            && (positionsAndDistances[5] < distanceBetween + positionsAndDistances[2])

    val isLine = (distanceBetween == positionsAndDistances[2] + positionsAndDistances[5])
            || (positionsAndDistances[2] == distanceBetween + positionsAndDistances[5])
            || (positionsAndDistances[5] == distanceBetween + positionsAndDistances[2])

    return when {
        distanceBetween == 0.0 && positionsAndDistances[2] == positionsAndDistances[5] -> -1
        distanceBetween == 0.0 -> 0
        isTriangle -> 2
        isLine -> 1
        else -> 0
    }

}