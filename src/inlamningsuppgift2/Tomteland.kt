package inlamningsuppgift2

class Tomteland {

    val tomten = "Tomten"
    val glader = "Glader"
    val butter = "Butter"
    val tröger = "Tröger"
    val trötter = "Trötter"
    val blyger = "Blyger"
    val rådjuret = "Rådjuret"
    val nyckelpigan = "Nyckelpigan"
    val haren = "Haren"
    val räven = "Räven"
    val skumtomten = "Skumtomten"
    val dammråttan = "Dammråttan"
    val gråsuggan = "Gråsuggan"
    val myran = "Myran"
    val bladlusen = "Bladlusen"

    val hierarkin = mapOf(
        tomten to listOf(glader, butter),
        glader to listOf(tröger, trötter, blyger),
        butter to listOf(rådjuret, nyckelpigan, haren, räven),
        trötter to listOf(skumtomten),
        skumtomten to listOf(dammråttan),
        räven to listOf(gråsuggan, myran),
        myran to listOf(bladlusen)
    )

    fun getUnderlings(currentName: String, underlings: MutableList<String>): List<String> {

        tailrec fun addUnderlings(name: String, underlings: MutableList<String>, indexNr: Int): List<String> {
            hierarkin[name]?.forEach { t -> underlings.add(t) }

            return if (indexNr == underlings.size) underlings
            else addUnderlings(underlings[indexNr], underlings, indexNr + 1)
        }

        return addUnderlings(currentName, underlings, 0)

    }


}

fun main() {
    val tl = Tomteland()
    var list: MutableList<String> = mutableListOf()
    println(tl.getUnderlings("Räven", list))

}
