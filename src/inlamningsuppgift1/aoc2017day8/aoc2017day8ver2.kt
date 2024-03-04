package inlamningsuppgift1.aoc2017day8
import java.io.File

//https://todd.ginsberg.com/post/advent-of-code/2017/day8/
class aoc2017day8ver2 {

    fun findValue(registerList: List<String>): Int {

        val regListWithValues = mutableMapOf<String, Int>()

        fun tryIfTrue(con: String, numb: Int): (Int) -> Boolean =
            when (con) {
                "<" -> {t -> t < numb}
                ">" -> {t -> t > numb}
                "==" -> {t -> t == numb}
                "!=" -> {t -> t != numb}
                "<=" -> {t -> t <= numb}
                ">=" -> {t -> t >= numb}
                else -> throw IllegalArgumentException("Unknown conditional input: $con")
            }

        val splitter = """\s+""".toRegex()

        registerList.forEach {
            val splitRow = it.split(splitter).toList().map { it }

            val reg1 = splitRow[0]
            val reg2 = splitRow[4]
            val changeVal = splitRow[2].toInt()
            val condition = tryIfTrue(splitRow[5], splitRow[6].toInt())

            if (!regListWithValues.contains(reg1)) regListWithValues[reg1] = 0
            if (!regListWithValues.contains(reg2)) regListWithValues[reg2] = 0

            val oldVal = regListWithValues[reg1]

            if ((splitRow[1] == "inc") && condition(regListWithValues[reg2]!!)) {
                if (oldVal != null) {
                    regListWithValues[splitRow[0]] = oldVal.plus(changeVal)
                }
            } else if ((splitRow[1] == "dec") && condition(regListWithValues[reg2]!!)) {
                if (oldVal != null) {
                    regListWithValues[splitRow[0]] = oldVal.minus(changeVal)
                }
            }

        }

        return regListWithValues.values.max()
    }
}

fun main() {
    val upg22 = aoc2017day8ver2()

    val regList: List<String> = File("src/inlamningsuppgift1/aoc2017day8/registerInputData.txt").readLines()

    println(upg22.findValue(regList))

}