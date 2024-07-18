import java.io.*;
import java.util.PriorityQueue
import kotlin.collections.ArrayList

lateinit var adj: ArrayList<ArrayList<Vertex>>
lateinit var dist: IntArray
var startVertex = 0
val br = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    settingInput()
    dijkstra()
    println( buildString {
        for (i in 1 until dist.size) {
            if (dist[i] == Int.MAX_VALUE) append("INF").append("\n")
            else append(dist[i]).append("\n")
        }
    })
}

fun settingInput() {
    val VE = br.readLine().split(" ").map { it.toInt() }
    startVertex = br.readLine().toInt()
    adj = ArrayList()
    repeat(VE[0]+1) { adj.add(ArrayList()) }
    repeat(VE[1]) {
        val edge = br.readLine().split(" ").map { it.toInt() }
        adj.get(edge[0]).add(Vertex(edge[1], edge[2]))
    }
    dist = IntArray(VE[0]+1)
    dist.fill(Int.MAX_VALUE)
}

fun dijkstra() {
    val pq = PriorityQueue { a: Vertex, b: Vertex -> a.weight - b.weight }
    dist[startVertex] = 0
    pq.offer(Vertex(startVertex, 0))
    while (pq.isNotEmpty()) {
        val currentVertex = pq.poll()

        if (dist[currentVertex.number] < currentVertex.weight) continue
        adj.get(currentVertex.number).forEach {
            val nextDist = currentVertex.weight + it.weight
            if (dist[it.number] > nextDist) {
                dist[it.number] = nextDist
                pq.offer(Vertex(it.number, nextDist))
            }
        }
    }
}

data class Vertex(
    val number: Int,
    val weight: Int
)