package inlamningsuppgift1.aoc2017day4

import java.io.File

class aoc2017day4 {

    fun getValidPassAmount(passList: List<List<String>>): Int {
        var validSum = 0
        passList.forEach { t ->
            val tSorted = t.sorted()
            var tempBool = true
            for (x in 0..t.size - 2) {
                if (tSorted[x] == tSorted[x + 1]) {
                    tempBool = false
                    break}
            }
            if (tempBool) validSum++
        }
        return validSum
    }

}

fun main() {
    val upg5 = aoc2017day4()

    val passPhrases = File("src/inlamningsuppgift1/aoc2017day4/passphraseData.txt").readLines()
    val splitter = """(\S+)""".toRegex()

    val ingoingList = passPhrases.map { splitter.findAll(it).toList().map { it.value } }

    println(upg5.getValidPassAmount(ingoingList))
    //println(upg5.getValidPassAmount(ingoingList))

}