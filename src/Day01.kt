fun main() {
    fun part1(input: List<String>): Int {
        var increasedCount = 0
        input.forEachIndexed { i, e ->
            val valueAsInt = e.toInt()
            if (i > 0 && valueAsInt > input[i - 1].toInt()) {
                increasedCount++
            }
        }
        return increasedCount
    }

    fun part2(input: List<String>): Int {
        val listOfSums = mutableListOf<String>()
        input.forEachIndexed { i, e ->
            val currentValue = e.toInt()
            if (i + 2 < input.size) {
                val sum = currentValue + input[i + 1].toInt() + input[i + 2].toInt()
                listOfSums.add(sum.toString())
            }
        }
        return part1(listOfSums)
    }

    val input = readInput("Day01")
    println("""increased measurements: ${part1(input)}""")
    println("""increased sum of measurements: ${part2(input)}""")
}