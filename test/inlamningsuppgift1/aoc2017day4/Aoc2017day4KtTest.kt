package inlamningsuppgift1.aoc2017day4

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
class Aoc2017day4KtTest {

    val thistest = aoc2017day4()

    var testList = mutableListOf<List<String>>()

    @Test
    fun getChecksumTest(){
        testList.add(listOf("aa", "bb", "cc", "dd", "ee"))
        testList.add(listOf("aa", "bb", "cc", "dd", "aa"))
        testList.add(listOf("aa", "bb", "cc", "dd", "aaa"))

        val testSum = thistest.getValidPassAmount(testList)
        assertEquals(2, testSum)
    }

    /* @Test
    fun getChecksum2Test(){
        val testSum2 = thistest.getChecksum2(testsheet2)
        assertEquals(9, testSum2)
    }*/

}