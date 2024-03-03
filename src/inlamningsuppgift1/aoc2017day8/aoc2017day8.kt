package inlamningsuppgift1.aoc2017day8

import java.io.File

//"b inc 5 if a > 1",
class aoc2017day8 {

    fun findValue(registerList: List<String>): Int {
        val regListWithValues = mutableMapOf<String, Int>()
        val splitter = """\s+""".toRegex()

        fun tryIfTrue(reg: String, con: String, numb: Int): Boolean {
            when (con) {
                "<" -> {
                    if (regListWithValues.getValue(reg) < numb) return true
                }

                ">" -> {
                    if (regListWithValues.getValue(reg) > numb) return true
                }

                "==" -> {
                    if (regListWithValues.getValue(reg) == numb) return true
                }

                "!=" -> {
                    if (regListWithValues.getValue(reg) != numb) return true
                }

                "<=" -> {
                    if (regListWithValues.getValue(reg) <= numb) return true
                }

                ">=" -> {
                    if (regListWithValues.getValue(reg) >= numb) return true
                }
            }
            return false
        }

        registerList.forEach {
            val splitRow = it.split(splitter).toList().map { it }

            if (!regListWithValues.contains(splitRow[0])) regListWithValues[splitRow[0]] = 0
            if (!regListWithValues.contains(splitRow[4])) regListWithValues[splitRow[4]] = 0

            val oldVal = regListWithValues[splitRow[0]]

            val changeVal = splitRow[2].toInt()

            if (splitRow[1] == "inc" && tryIfTrue(splitRow[4], splitRow[5], splitRow[6].toInt())) {
                if (oldVal != null) {
                    regListWithValues[splitRow[0]] = oldVal.plus(changeVal)
                }
            } else if (splitRow[1] == "dec" && tryIfTrue(splitRow[4], splitRow[5], splitRow[6].toInt())) {
                if (oldVal != null) {
                    regListWithValues[splitRow[0]] = oldVal.minus(changeVal)
                }
            }
        }

        val highestValue = regListWithValues.values.max()

        return highestValue
    }
}

fun main() {
    val upg2 = aoc2017day8()

    val regList: List<String> = File("src/inlamningsuppgift1/aoc2017day8/registerInputData.txt").readLines()

    println(upg2.findValue(regList))

}