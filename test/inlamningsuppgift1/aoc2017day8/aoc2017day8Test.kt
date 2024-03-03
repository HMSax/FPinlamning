package inlamningsuppgift1.aoc2017day8

import inlamningsuppgift1.aoc2017day7.aoc2017day7
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class aoc2017day8Test{

    val findReg = aoc2017day8()

    val registerTestList: List<String> = listOf(
    "b inc 5 if a > 1",
    "a inc 1 if b < 5",
    "c dec -10 if a >= 1",
    "c inc -20 if c == 10"
    )

    @Test
    fun findRegisterTest() {
        val largestValue = findReg.findValue(registerTestList)
        assertEquals(largestValue, 1)
    }

}