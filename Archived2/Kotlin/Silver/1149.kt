import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min


val br = BufferedReader(InputStreamReader(System.`in`))
lateinit var costMap: Array<IntArray>
lateinit var accCostMap: Array<IntArray>
var houseCount = 0

fun main() {

    houseCount = br.readLine().toInt()
    costMap = Array(houseCount) { IntArray(3) }
    for (idx in 0..houseCount-1) {
        costMap[idx] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    accCostMap = Array(houseCount) { IntArray(3) }
    println(calculateCost())
    br.close()
}

fun calculateCost(): Int {
    var minCost = 987654321
    for (color in 0..2) {
        minCost = min(minCost, calculator(0, color))
    }
    return minCost
}

fun calculator(y: Int, x: Int): Int {

    if (y == houseCount) return 0
    if (accCostMap[y][x] != 0) return accCostMap[y][x]

    var minCost = 987654321
    for (color in 0..2){
        if (color == x) continue
        minCost = min(minCost, calculator(y+1, color))
    }
    accCostMap[y][x] = costMap[y][x] + minCost
    return accCostMap[y][x]
}