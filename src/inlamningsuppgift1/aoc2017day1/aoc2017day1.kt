package inlamningsuppgift1.aoc2017day1

import java.io.File

class aoc2017day1 {

    fun solveCaptcha(captcha : String): Int {
        val allNum = (captcha + captcha[0])
        var tot = 0

        for (a in 0..<allNum.length -1){
            if (allNum[a].digitToInt() == allNum[a + 1].digitToInt()) {
                tot += allNum[a].digitToInt() }
        }
        return tot
    }

    fun solveCaptchaTwo(captcha : String): Int {
        val allNum = (captcha + captcha)
        var tot = 0

        for (a in 0..<captcha.length){
            if (allNum[a].digitToInt() == allNum[a + captcha.length/2].digitToInt()) {
                tot += allNum[a].digitToInt() }
        }
        return tot
    }
}

fun main() {
    val upg3 = aoc2017day1()

    val numbers = File("src/inlamningsuppgift1/aoc2017day1/captchaData.txt").readLines()

    println(upg3.solveCaptcha(numbers[0]))
    println(upg3.solveCaptchaTwo(numbers[0]))

}