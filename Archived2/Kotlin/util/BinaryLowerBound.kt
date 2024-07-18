
fun main() {

    val rawList = listOf(1,5,2,10,10,20,20,20,30,30,30,50,99)

    val sortedList = rawList.sorted()
    println(sortedList)

    val lowerBound = lowerBoundByBinarySearch(sortedList, 20)

    println(lowerBound)
}

fun lowerBoundByBinarySearch(arr: List<Int>, target: Int): Int {

    var first = 0; var mid = 0; var step = 0; var count = arr.size

    while (count > 0) {

        mid = first; step = count/2; mid += step
        if (arr[mid] < target) {
            first = mid+1
            count -= step+1
        } else {
            count = step
        }
    }
    return first
}
