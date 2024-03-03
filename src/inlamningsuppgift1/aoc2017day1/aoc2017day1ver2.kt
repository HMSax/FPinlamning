package inlamningsuppgift1.aoc2017day1
import java.io.File

//this solution was inspired by https://todd.ginsberg.com/post/advent-of-code/2017/day1/

class aoc2017day1ver2 {

    fun solveCaptcha(captcha : String): Int =
        (captcha + captcha[0]).zipWithNext().filter { it.first == it.second }
            .map{ it.first.digitToInt() }.sum()

    fun solveCaptchaTwo(captcha : String): Int =
        captcha.filterIndexed{i,c -> c == ((captcha+captcha)[i + (captcha.length/2)])}
            .map{it.digitToInt()}.sum()

}

fun main() {
    val upg33 = aoc2017day1ver2()

    val numbers = File("src/inlamningsuppgift1/aoc2017day1/captchaData.txt").readLines()

    println(upg33.solveCaptcha(numbers[0]))
    println(upg33.solveCaptchaTwo(numbers[0]))

}