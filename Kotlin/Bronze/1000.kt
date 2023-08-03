import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {

    val input = BufferedReader(InputStreamReader(System.`in`))
    println(input.readLine().split(" ").map { it.toInt() }.sum())
    input.close()

}