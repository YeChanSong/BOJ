import java.io.BufferedReader
import java.io.InputStreamReader

val br = BufferedReader(InputStreamReader(System.`in`))

lateinit var adj: ArrayList<ArrayList<Int>>
lateinit var visited: IntArray
var startVertex = 0;
var order = 1;

fun main() {

    settingInput()
    dfs(startVertex)
    println( buildString {
        for (i in 1 until visited.size){
            append(visited[i]).append("\n")
        }
    })

}

fun settingInput() {
    val initData = br.readLine().split(" ").map { it.toInt() }
    adj = ArrayList()
    startVertex = initData[2]
    visited = IntArray(initData[0]+1)
    repeat(initData[0]+1) { adj.add(ArrayList()) }
    val edges = ArrayList<IntArray>()
    repeat(initData[1]) {
        val edge = br.readLine().split(" ").map { it.toInt() }.toIntArray()
        edges.add(edge)
        edges.add(intArrayOf(edge[1], edge[0]))
    }
    edges.sortWith( compareByDescending<IntArray> { it[0] }.thenByDescending { it[1] } )
    edges.forEach { adj.get(it[0]).add(it[1]) }
}

fun dfs(vertex: Int) {
    visited[vertex] = order++
    adj.get(vertex).forEach {
        if (visited[it] == 0) dfs(it)
    }
}