package inlamningsuppgift1.aoc2017day2

import java.io.File

class aoc2017day2 {

    fun getChecksum(checksums: List<String>): Int {
        val splitter = """(\S+)""".toRegex()
        var sumByRow = mutableListOf<Int>()
checksums.forEach {
    val splitRow = splitter.findAll(it).toList().map {it.value.toInt()}
    sumByRow.add(splitRow.max() - splitRow.min())
}
        return sumByRow.sum()
    }
}

fun main() {
    val upg4 = aoc2017day2()

    val spreadSheet = File("src/inlamningsuppgift1/aoc2017day2/spreadSheetData.txt").readLines()

    println(upg4.getChecksum(spreadSheet))

}