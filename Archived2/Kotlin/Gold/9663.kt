import java.io.BufferedReader
import java.io.InputStreamReader

val br = BufferedReader(InputStreamReader(System.`in`))
lateinit var board: ArrayList<BooleanArray>
var boardSize = 0
var successCount = 0


fun main() {

    boardSize = br.readLine().toInt()
    board = ArrayList()
    repeat(boardSize) {
        board.add(BooleanArray(boardSize))
    }


    repeat(boardSize) {
        board[0][it] = true
        setQueen(0,it)
        board[0][it] = false
    }

    println(successCount)
}

fun setQueen(y: Int, x: Int) {

    if(
        isQueenInHorizontal(y,x)
        || isQueenInVertical(y,x)
        || isQueenInLeftDiagonal(y,x)
        || isQueenInRightDiagonal(y,x)) return

    if (y == boardSize-1) {
        successCount++
        return
    }

    repeat(boardSize) {
        board[y+1][it] = true
        setQueen(y+1, it)
        board[y+1][it] = false
    }

}

fun isQueenInHorizontal(y: Int, x: Int):Boolean {

    for (i in 0 until boardSize) {
        if (i == x) continue
        if (board[y][i]) return true
    }
    return false

}

fun isQueenInVertical(y: Int, x: Int): Boolean {
    for (i in 0 until boardSize) {
        if (i == y) continue
        if (board[i][x]) return true
    }
    return false
}

fun isQueenInLeftDiagonal(y: Int, x: Int): Boolean {
    // lower
    for (i in 1 until boardSize) {
        if (y+i >= boardSize || x-i < 0) break
        if (board[y+i][x-i]) return true
    }

    // upper
    for (i in 1..boardSize) {
        if (y-i < 0 || x+i >= boardSize) break
        if (board[y-i][x+i]) return true
    }

    return false
}

fun isQueenInRightDiagonal(y: Int, x: Int): Boolean {
    // lower
    for (i in 1..boardSize) {
        if (y+i >= boardSize || x+i >= boardSize) break
        if (board[y+i][x+i]) return true
    }

    //upper
    for (i in 1 until boardSize) {
        if (y-i < 0 || x-i < 0) break
        if (board[y-i][x-i]) return true
    }
    return false
}