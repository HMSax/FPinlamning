package inlamningsuppgift1.aoc2017day2

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
/*
5 9 2 8
9 4 7 3
3 8 6 5
In the first row, the only two numbers that evenly divide are 8 and 2; the result of this division is 4.
In the second row, the two numbers are 9 and 3; the result is 3.
In the third row, the result is 2.
In this example, the sum of the results would be 4 + 3 + 2 = 9.
* */
class Aoc2017day2KtTest {

    val thistest = aoc2017day2()

    val testsheet = listOf("5 1 9 5", "7 5 3","2 4 6 8")
    val testsheet2 = listOf("5 9 2 8", "9 4 7 3","3 8 6 5")
    @Test
    fun getChecksumTest(){
        val testSum = thistest.getChecksum(testsheet)
        assertEquals(18, testSum)

    }
    @Test
    fun getChecksum2Test(){
        val testSum2 = thistest.getChecksum2(testsheet2)
        assertEquals(9, testSum2)

    }

}