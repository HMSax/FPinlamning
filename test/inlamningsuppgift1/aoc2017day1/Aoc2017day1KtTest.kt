package inlamningsuppgift1.aoc2017day1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
class Aoc2017day1KtTest{

    val testAoCd1 = aoc2017day1()

    val t1122 ="1122"
    val t1111 ="1111"
    val t1234 ="1234"
    val t91212129 ="91212129"
    @Test
    fun solveCaptchaTest(){
        val test1122 = testAoCd1.solveCaptcha(t1122)
        assertEquals(test1122, 3)

        val test1111 = testAoCd1.solveCaptcha(t1111)
        assertEquals(test1111, 4)

        val test1234 = testAoCd1.solveCaptcha(t1234)
        assertEquals(test1234, 0)

        val test91212129 = testAoCd1.solveCaptcha(t91212129)
        assertEquals(test91212129, 9)

    }

    @Test
    fun solveCaptchaPart2Test(){
        val test1 = testAoCd1.solveCaptchaTwo("1212")
        assertEquals(test1, 6)

        val test2 = testAoCd1.solveCaptchaTwo("1221")
        assertEquals(test2, 0)

        val test3 = testAoCd1.solveCaptchaTwo("123425")
        assertEquals(test3, 4)

        val test4 = testAoCd1.solveCaptchaTwo("123123")
        assertEquals(test4, 12)

        val test5 = testAoCd1.solveCaptchaTwo("12131415")
        assertEquals(test5, 4)
    }
}