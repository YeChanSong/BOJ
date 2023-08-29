import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.ArrayDeque


val br = BufferedReader(InputStreamReader(System.`in`))
lateinit var adj: ArrayList<ArrayList<Int>>
var totalSize  = 0
var startVertex = 0
lateinit var visited: BooleanArray
var sb = StringBuilder()

fun main() {

    settingInput()

    visited = BooleanArray(totalSize)
    dfs(startVertex)
    sb.append("\n")

    visited = BooleanArray(totalSize)
    bfs(startVertex)
    println(sb)
}

fun settingInput() {
    val initData = br.readLine().split(" ").map {it.toInt()}

    totalSize = initData[0]+1
    startVertex = initData[2]

    adj = ArrayList()
    repeat(totalSize) {
        adj.add(ArrayList())
    }

    var edges = ArrayList<IntArray>()
    repeat(initData[1]) {
        val edge = br.readLine().split(" ").map {it.toInt()}.toIntArray()
        edges.add(edge)
        edges.add(intArrayOf(edge[1], edge[0]))
    }
    edges.sortWith( compareBy( {it[0]}, {it[1]} ) )
    edges.forEach {
        adj[it[0]].add(it[1])
    }
}

fun dfs(startVertex: Int) {
    sb.append(startVertex).append(" ")
    visited[startVertex] = true
    adj[startVertex].forEach {
        if (!visited[it]) dfs(it)
    }
}

fun bfs(startVertex: Int) {
    sb.append(startVertex).append(" ")
    visited[startVertex] = true
    val queue = ArrayDeque<Int>()
    queue.offerLast(startVertex)

    while (queue.isNotEmpty()) {
        val vertex = queue.pollFirst()
        adj[vertex].forEach {
            if (!visited[it]) {
                queue.offerLast(it)
                visited[it] = true
                sb.append(it).append(" ")
            }
        }
    }
}
