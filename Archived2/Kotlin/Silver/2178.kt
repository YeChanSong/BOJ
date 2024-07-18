import java.io.*;
import java.util.*;
import kotlin.collections.ArrayDeque
import kotlin.collections.ArrayList

var N = 0
var M = 0
lateinit var board: ArrayList<String>
lateinit var visited: ArrayList<IntArray>
val moveY = intArrayOf(-1, 0, 1, 0)
val moveX = intArrayOf(0, -1, 0, 1)


fun main() {

    settingInput()
    bfs(0,0)
    println(visited[N-1][M-1])

}

fun settingInput() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val NM = br.readLine().split(" ").map { it.toInt() }
    N = NM[0]
    M = NM[1]
    board = ArrayList()
    repeat(N) { board.add(br.readLine()) }
    visited = ArrayList()
    repeat(N) { visited.add(IntArray(M)) }
}

fun bfs(y: Int, x: Int) {
    val queue = ArrayDeque<Pair<Int,Int>>() // y, x
    queue.addLast(Pair(y,x))
    visited[y][x] = 1
    while (queue.isNotEmpty()) {
        val itm = queue.removeFirst()
        for (i in 0..3) {
            val nextY = itm.first + moveY[i]
            val nextX = itm.second + moveX[i]
            if (!isOutOfBoundary(nextY, nextX) && isMovable(nextY, nextX) && visited[nextY][nextX] == 0) {
                queue.addLast(Pair(nextY, nextX))
                visited[nextY][nextX] = visited[itm.first][itm.second] +1
            }

        }
    }

}

fun isOutOfBoundary(y: Int, x: Int): Boolean {
    return y<0 || x<0 || y>=N || x>=M
}

fun isMovable(y: Int, x: Int): Boolean {
    return board[y][x] == '1'
}