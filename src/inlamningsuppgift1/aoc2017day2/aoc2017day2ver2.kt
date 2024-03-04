package inlamningsuppgift1.aoc2017day2

import java.io.File

//this solution was inspired by https://todd.ginsberg.com/post/advent-of-code/2017/day2/
class aoc2017day2ver2 {

    fun getChecksum(checksums: List<List<Int>>): Int =
        checksums.sumOf { it.max() - it.min() }

    fun getChecksum2(checksums: List<List<Int>>): Int {
        var sumByRow2 = mutableListOf<Int>()
        checksums.map {
            it.forEach { t ->
                for (x in 0..<it.size) {
                    if (t != it[x] && t % it[x] == 0) sumByRow2.add(t / it[x])
                }
            }
        }
        return sumByRow2.sum()
    }
}

fun main() {
    val upg44 = aoc2017day2ver2()

    val spreadSheet = File("src/inlamningsuppgift1/aoc2017day2/spreadSheetData.txt").readLines()
    val splitter = """(\S+)""".toRegex()

    val ingoingList = mutableListOf<List<Int>>()

    spreadSheet.forEach {
        val myIntList = splitter.findAll(it).toList().map { it.value.toInt() }
        ingoingList.add(myIntList)
    }

    println(upg44.getChecksum(ingoingList))
    println(upg44.getChecksum2(ingoingList))

}