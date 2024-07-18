import java.io.BufferedReader
import java.io.InputStreamReader


val br = BufferedReader(InputStreamReader(System.`in`))
lateinit var adj: ArrayList<ArrayList<Int>>
lateinit var visited: IntArray
var order = 1;
var startVertex = 0;

fun main() {

    settingInput()
    bfs(startVertex)
    println( buildString {
        for (i in 1 until visited.size) {
            append(visited[i]).append("\n")
        }
    })
}

fun settingInput() {
    val initData = br.readLine().split(" ").map { it.toInt() }
    startVertex = initData[2]
    visited = IntArray(initData[0]+1)
    adj = ArrayList()
    repeat(initData[0]+1) { adj.add(ArrayList()) }
    val edges = ArrayList<IntArray>()
    repeat(initData[1]) {
        val edge = br.readLine().split(" ").map { it.toInt() }
        edges.add(intArrayOf(edge[0],edge[1]))
        edges.add(intArrayOf(edge[1],edge[0]))
    }
    edges.sortWith( compareBy( {it[0]}, {it[1]} ) )
    edges.forEach { edge -> adj.get(edge[0]).add(edge[1])}
}

fun bfs(vertex: Int) {
    val queue = ArrayDeque<Int>()
    visited[vertex] = order++
    queue.addLast(vertex)
    while (queue.isNotEmpty()) {
        val itm = queue.removeFirst()
        adj.get(itm).forEach { next ->
            if (visited[next] == 0) {
                queue.addLast(next)
                visited[next] = order++
            }
        }
    }


}