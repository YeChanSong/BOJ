import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))

    val initPos = br.readLine().split(" ")

    val board = Board()

    board.initBoard(initPos[0], initPos[1])

    for (i in 0 until initPos[2].toInt()) {
        board.moveKing(br.readLine())
    }

    board.print()

}

class Board() {

    private val numToAlphabet = arrayListOf('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H')

    private val directionToPosition = mapOf(
        "R" to Pair(0, 1),
        "L" to Pair(0, -1),
        "B" to Pair(1, 0),
        "T" to Pair(-1, 0),
        "RT" to Pair(-1, 1),
        "LT" to Pair(-1, -1),
        "RB" to Pair(1, 1),
        "LB" to Pair(1, -1)
    )

    private lateinit var king: Pair<Int, Int>
    private lateinit var stone: Pair<Int, Int>

    fun initBoard(king: String, stone: String) {
        this.king = Pair(8 - Character.getNumericValue(king[1]), numToAlphabet.indexOf(king[0]))
        this.stone = Pair(8 - Character.getNumericValue(stone[1]), numToAlphabet.indexOf(stone[0]))
    }

    fun moveKing(direction: String) {
        val dist = directionToPosition[direction]!!
        val nextKingPosition = Pair(this.king.first + dist.first, this.king.second + dist.second)

        if (isOutOfBoard(nextKingPosition)) { // king out of bound
            return
        }

        if (nextKingPosition == this.stone) { // push stone
            val nextStonePosition = Pair(this.stone.first + dist.first, this.stone.second + dist.second)
            if (isOutOfBoard(nextStonePosition)) {
                return
            }
            this.stone = nextStonePosition
        }

        this.king = nextKingPosition
    }

    private fun isOutOfBoard(pos: Pair<Int, Int>): Boolean {
        if (pos.first > 7 || pos.second > 7 || pos.first < 0 || pos.second < 0) {
            return true
        }

        return false
    }

    fun print() {
        val king = numToAlphabet[this.king.second].toString() + (8 - this.king.first)
        val stone = numToAlphabet[this.stone.second].toString() + (8 - this.stone.first)
        println(king)
        println(stone)
    }

}

