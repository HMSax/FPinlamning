package inlamningsuppgift1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Aoc2017Day7ver2KtTest {

    val findtowerTest2 = aoc2017day7ver2()

    val towerTestList: List<String> = listOf(
        "pbga (66)",
        "xhth (57)",
        "ebii (61)",
        "havc (66)",
        "ktlj (57)",
        "fwft (72) -> ktlj, cntj, xhth",
        "qoyq (66)",
        "padx (45) -> pbga, havc, qoyq",
        "tknk (41) -> ugml, padx, fwft",
        "jptl (61)",
        "ugml (68) -> gyxo, ebii, jptl",
        "gyxo (61)",
        "cntj (57)"
    )

    @Test
    fun findBottomTowerTest() {
        val bottomTower = findtowerTest2.findBottomTower(towerTestList)
        assertEquals(bottomTower, "tknk")
    }
}

