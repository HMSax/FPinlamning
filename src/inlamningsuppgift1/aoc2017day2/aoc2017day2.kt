package inlamningsuppgift1.aoc2017day2

import java.io.File

class aoc2017day2 {

    fun getChecksum(checksums: List<String>): Int {
        val splitter = """(\S+)""".toRegex()
        var sumByRow = mutableListOf<Int>()
        checksums.forEach {
            val splitRow = splitter.findAll(it).toList().map { it.value.toInt() }
            sumByRow.add(splitRow.max() - splitRow.min())
        }
        return sumByRow.sum()
    }

    fun getChecksum2(checksums: List<String>): Int {
        val splitter = """(\S+)""".toRegex()
        var sumByRow2 = mutableListOf<Int>()
        checksums.forEach {
            val splitRow = splitter.findAll(it).toList().map { it.value.toInt() }
            splitRow.forEach { t ->
                for (x in 0..<splitRow.size) {
                    if (t != splitRow[x] && t % splitRow[x] == 0) sumByRow2.add(t / splitRow[x])
                }
            }
        }
        return sumByRow2.sum()
    }
}

fun main() {
    val upg4 = aoc2017day2()

    val spreadSheet = File("src/inlamningsuppgift1/aoc2017day2/spreadSheetData.txt").readLines()

    println(upg4.getChecksum(spreadSheet))
    println(upg4.getChecksum2(spreadSheet))

}