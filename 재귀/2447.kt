import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()

    val star = Star(n)

    star.setStar()

    star.printBoard()

}

class Star(n: Int) {

    private val board = Array(n) { CharArray(n) {' '} }
    private val boardSize = n

    fun setStar() {

        recur(0,0,boardSize)

    }

    private fun recur(y: Int, x: Int, len: Int) { // pos = <y, x>

        if (len == 1) {
            board[y][x] = '*'
            return
        }

        val segment = len / 3

        for(idx in 0..2){
            recur(y, x + idx * segment, segment)
        }

        recur(y + segment, x, segment)
        recur(y + segment, x + 2 * segment, segment)

        for(idx in 0..2){
            recur(y + 2 * segment, x + idx * segment, segment)
        }

    }

    fun printBoard() {
        for (arr: CharArray in board) {
            println(arr)
        }
    }

}