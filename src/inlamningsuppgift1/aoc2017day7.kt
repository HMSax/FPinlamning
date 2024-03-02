package inlamningsuppgift1

import java.io.File

class aoc2017day7 {

    fun findBottomTower(towerList: List<String>): String {
        val trimmedList = towerList.filter {t -> t.contains("->")}
        val leftSideList = trimmedList.map{p -> p.substring(0, p.indexOf("(")-1)}
        val rightSideList = trimmedList.map{z -> z.substring(z.indexOf(">")+2,z.lastIndex+1).split(", ")}.flatten()
        println(trimmedList)
        println(leftSideList)
        println(rightSideList)

        leftSideList.forEach { l -> if(!rightSideList.contains(l)) return(l) }
        return ""
    }
}

fun main() {
    val upg = aoc2017day7()

    val towerList: List<String> = File("src/inlamningsuppgift1/towerData.txt").readLines()

    println(upg.findBottomTower(towerList))

}

