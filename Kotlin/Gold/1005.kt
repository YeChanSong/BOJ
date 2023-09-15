import java.util.*;
import java.io.*;
import kotlin.collections.ArrayList

val br = BufferedReader(InputStreamReader(System.`in`))
var N = 0
var W = 0
lateinit var costs: List<Int>
lateinit var adj: ArrayList<ArrayList<Int>>
lateinit var revAdj: ArrayList<ArrayList<Int>>
lateinit var visited: BooleanArray
lateinit var isBuildTree: HashMap<Int, Boolean>
lateinit var tpSortList: MutableList<Int>

fun main() {
    val time = br.readLine().toInt()
    repeat(time) {
        settingInput()
        settingBuildTree()
        dfsAll()
        tpSortList.reverse()
        val costMap = HashMap<Int, Int>()
        tpSortList.forEach { vertex ->
            var vertexMaxCost = 0
            revAdj[vertex].forEach {before ->
                vertexMaxCost =
                    if (vertexMaxCost >= costMap.getOrDefault(before, 0)) vertexMaxCost
                    else costMap.getOrDefault(before,0)
            }
            costMap.put(vertex, vertexMaxCost+costs[vertex])
        }
        println(costMap[W])
    }
    br.close()
}

fun settingInput() {
    val NM = br.readLine().split(" ").map { it.toInt() }
    N = NM[0]
    val M = NM[1]
    costs = br.readLine().split(" ").map { it.toInt() }
    visited = BooleanArray(N)
    adj = ArrayList()
    revAdj = ArrayList()
    repeat(N) {
        adj.add(ArrayList())
        revAdj.add(ArrayList())
    }
    repeat(M) {
        val edge = br.readLine().split(" ").map { it.toInt() }
        adj.get(edge[0]-1).add(edge[1]-1)
        revAdj.get(edge[1]-1).add(edge[0]-1)
    }
    W = br.readLine().toInt() -1
}

fun settingBuildTree() {
    isBuildTree = HashMap()
    reverseDfs(W)
}

fun reverseDfs(vertex: Int) {
    visited[vertex] = true
    isBuildTree.putIfAbsent(vertex, true)
    revAdj[vertex].forEach { next ->
        if (!visited[next]) {
            reverseDfs(next)
        }
    }
}

fun dfsAll() {
    tpSortList = mutableListOf()
    visited = BooleanArray(N)
    repeat(N) { vertex ->
        if (isBuildTree[vertex] != null && revAdj[vertex].isEmpty() && !visited[vertex]) {
            dfs(vertex)
        }
    }
}

fun dfs(vertex: Int) {
    visited[vertex] = true
    adj[vertex].forEach { next ->
        if (!visited[next]) {
            dfs(next)
        }
    }
    tpSortList.add(vertex)
}