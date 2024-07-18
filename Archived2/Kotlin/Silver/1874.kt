import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    checkStackSequence(br)
    br.close()

}

fun checkStackSequence(br: BufferedReader) {

    val n = br.readLine().toInt()
    val queue = ArrayDeque<Int>()
    repeat (n) { index -> queue.addLast(index + 1)}

    val stack = ArrayDeque<Int>()
    val answer = buildString {

        repeat (n) {

            val num = br.readLine().toInt()

            while (stack.isEmpty() || stack.component1() < num) {
                append("+\n")
                stack.addFirst(queue.removeFirst())
            }

            if (stack.component1() > num) {
                println("NO")
                return
            }

            if (stack.component1() == num) {
                append("-\n")
                stack.removeFirst()
            }

        }
    }

    println(answer)

}