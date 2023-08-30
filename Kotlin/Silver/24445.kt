import java.io.BufferedReader
import java.io.InputStreamReader

val adj = ArrayList<ArrayList<Int>>()
lateinit var visited: IntArray
var order = 1
var startVertex = 0


fun main() {

    settingInput()

    bfs(startVertex)

    println( buildString {
        for (i in 1 until visited.size) {
            append(visited[i]).append("\n")
        }
    } )
}

fun settingInput() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val initData = br.readLine().split(" ").map { it.toInt() }
    startVertex = initData[2]
    visited = IntArray(initData[0]+1)
    repeat(initData[0]+1) { adj.add(ArrayList()) }
    val edges = ArrayList<IntArray>()
    repeat(initData[1]) {
        val edge = br.readLine().split(" ").map { it.toInt() }
        edges.add(intArrayOf(edge[0], edge[1]))
        edges.add(intArrayOf(edge[1], edge[0]))
    }
    edges.sortWith( compareByDescending<IntArray> {it[0]}.thenByDescending { it[1] })
    edges.forEach { edge -> adj.get(edge[0]).add(edge[1])}
}

fun bfs(vertex: Int) {
    val queue = ArrayDeque<Int>()
    queue.addLast(vertex)
    visited[vertex] = order++
    while (queue.isNotEmpty()) {
        val itm = queue.removeFirst()
        adj.get(itm).forEach { next ->
            if(visited[next] == 0) {
                visited[next] = order++
                queue.addLast(next)
            }
        }
    }
}