import java.io.BufferedReader
import java.io.InputStreamReader


val br = BufferedReader(InputStreamReader(System.`in`))
lateinit var adj: ArrayList<ArrayList<Int>>
var startVertex = 0
var order = 1
lateinit var visited: IntArray

fun main() {

    settingInput()

    dfs(startVertex)

    val result = buildString {
        for(i in 1 until visited.size) {
            append(visited[i]).append("\n")
        }
    }
    println(result)
}

fun settingInput() {

    val initData = br.readLine().split(" ").map { it.toInt() }
    adj = ArrayList()
    startVertex = initData[2]
    visited = IntArray(initData[0]+1)
    repeat(initData[0]+1) {
        adj.add(ArrayList())
    }
    val edges = ArrayList<IntArray>()
    repeat(initData[1]) {
        val edge = br.readLine().split(" ").map { it.toInt() }.toIntArray()
        edges.add(edge)
        edges.add(intArrayOf(edge[1], edge[0]))
    }

    edges.sortWith( compareBy({it[0]}, {it[1]}) )
    edges.forEach {
        adj.get(it[0]).add(it[1])
        adj.get(it[1]).add(it[0])
    }

}

fun dfs(vertex: Int) {
    visited[vertex] = order++
    adj.get(vertex).forEach {
        if (visited[it] == 0) dfs(it)
    }
}