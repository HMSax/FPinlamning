package inlamningsuppgift1.aoc2017day8
import java.io.File
class aoc2017day8p2 {

    fun findHighestValueEver(registerList: List<String>): Int {

        val regListWithValues = mutableMapOf<String, Int>()

        var highestValueEver = 0

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
            if (regListWithValues.values.max() > highestValueEver) highestValueEver = regListWithValues.values.max()

        }

        return highestValueEver
    }
}

fun main() {
    val upg23 = aoc2017day8p2()

    val regList: List<String> = File("src/inlamningsuppgift1/aoc2017day8/registerInputData.txt").readLines()

    println(upg23.findHighestValueEver(regList))

}