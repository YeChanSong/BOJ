import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.min

lateinit var adj: ArrayList<ArrayList<Vertex>>
lateinit var dist: IntArray
val br = BufferedReader(InputStreamReader(System.`in`))
var V = 0
lateinit var checkPoint: List<Int>

fun main() {
    settingInput()
    println(visitVertexWithOrder())
    br.close()
}

fun settingInput() {
    val VE = br.readLine().split(" ").map { it.toInt() }
    V = VE[0]
    adj = ArrayList()
    repeat(V+1) { adj.add(ArrayList()) }
    repeat(VE[1]) {
        val edge = br.readLine().split(" ").map { it.toInt() }
        adj.get(edge[0]).add(Vertex(edge[1], edge[2]))
        adj.get(edge[1]).add(Vertex(edge[0], edge[2]))
    }
    dist = IntArray(V+1)
    dist.fill(Int.MAX_VALUE)
    checkPoint = br.readLine().split(" ").map { it.toInt() }
}

fun dijkstra(start: Int) {
    val pq = PriorityQueue { a: Vertex, b: Vertex -> a.weight - b.weight }
    dist[start] = 0
    pq.offer(Vertex(start, 0))

    while(pq.isNotEmpty()) {
        val currentVertex = pq.poll()

        if(dist[currentVertex.number] < currentVertex.weight) continue
        adj.get(currentVertex.number).forEach {
            val nextDist = currentVertex.weight + it.weight
            if (dist[it.number] > nextDist) {
                dist[it.number] = nextDist
                pq.offer(Vertex(it.number, nextDist))
            }
        }
    }
}

fun visitVertexWithOrder(): Long {

    var startToFirstVertex = 0L
    var startToSecondVertex = 0L
    var firstVertexToSecondVertex = 0L
    var firstVertexToEnd = 0L
    var secondVertexToEnd = 0L

    dijkstra(checkPoint[0])
    startToFirstVertex = dist[1].toLong()
    firstVertexToEnd = dist[V].toLong()
    firstVertexToSecondVertex = dist[checkPoint[1]].toLong()
    dist.fill(Int.MAX_VALUE)
    dijkstra(checkPoint[1])
    startToSecondVertex = dist[1].toLong()
    secondVertexToEnd = dist[V].toLong()

    val routeA: Long = startToFirstVertex + firstVertexToSecondVertex + secondVertexToEnd
    val routeB: Long = startToSecondVertex + firstVertexToSecondVertex + firstVertexToEnd

    return if (routeA >= Int.MAX_VALUE && routeB >= Int.MAX_VALUE) -1
    else min(routeA, routeB)
}

data class Vertex(val number: Int, val weight: Int)