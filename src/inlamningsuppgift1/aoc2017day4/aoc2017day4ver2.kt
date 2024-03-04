package inlamningsuppgift1.aoc2017day4

import java.io.File

//this solution was inspired by https://todd.ginsberg.com/post/advent-of-code/2017/day4/
class aoc2017day4ver2 {

    fun getValidPassAmount(passList: List<List<String>>): Int {
        var validSum = 0
        passList.forEach { t -> if (t.size == t.distinct().size) validSum++ }
        return validSum
    }
    fun getValidPassAmount2(passList: List<List<String>>): Int {
        var validSum = 0
        passList.forEach { t ->
            val tSorted = t.map{p -> p.toCharArray().sorted().joinToString("")}
            if (tSorted.size == tSorted.distinct().size) validSum++ }
        return validSum
    }

}

fun main() {
    val upg55 = aoc2017day4ver2()

    val passPhrases = File("src/inlamningsuppgift1/aoc2017day4/passphraseData.txt").readLines()
    val splitter = """(\S+)""".toRegex()

    val ingoingList = passPhrases.map { splitter.findAll(it).toList().map { it.value } }

    println(upg55.getValidPassAmount(ingoingList))

    println(upg55.getValidPassAmount2(ingoingList))

}
