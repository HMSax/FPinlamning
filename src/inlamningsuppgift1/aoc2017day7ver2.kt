package inlamningsuppgift1


import java.io.File

class aoc2017day7ver2 {

    fun findBottomTower(towerList: List<String>): String {
        val parentList = mutableListOf<String>()
        val childList = mutableListOf<String>()
        val splitter = """\w+""".toRegex()

        towerList.forEach {
            val splitRow = splitter.findAll(it).toList().map {it.value}
            parentList.add(splitRow[0])
            splitRow.drop(2).forEach {childList.add(it)}
        }

        var bottomTower = ""
        parentList.forEach { p -> if(!childList.contains(p)) bottomTower = p}

        return bottomTower

    }
}

fun main() {
    val upg2 = aoc2017day7ver2()

    val towerList: List<String> = File("src/inlamningsuppgift1/towerData.txt").readLines()

    println(upg2.findBottomTower(towerList))

}

