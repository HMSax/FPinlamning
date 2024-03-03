package inlamningsuppgift1.aoc2017day2

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
/*
5 1 9 5
7 5 3
2 4 6 8
The first row's largest and smallest values are 9 and 1, and their difference is 8.
The second row's largest and smallest values are 7 and 3, and their difference is 4.
The third row's difference is 6.
In this example, the spreadsheet's checksum would be 8 + 4 + 6 = 18.
* */
class Aoc2017day2KtTest {

    val thistest = aoc2017day2()

    val testsheet = listOf("5 1 9 5", "7 5 3","2 4 6 8")
    @Test
    fun getChecksumTest(){
        val testSum = thistest.getChecksum(testsheet)
        assertEquals(18, testSum)

    }

}