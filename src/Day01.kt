fun main() {
    fun part1(input: List<String>): Int {
        var increasedCount = 0
        input.forEachIndexed { i, e ->
            val valueAsInt = Integer.valueOf(e)
            if (i > 0 && valueAsInt > Integer.valueOf(input[i - 1])) {
                increasedCount++
            }
        }
        return increasedCount
    }

    fun part2(input: List<String>): Int {
        val listOfSums = mutableListOf<String>()
        input.forEachIndexed { i, e ->
            val currentValue = Integer.valueOf(e)
            if (i + 2 < input.size) {
                val sum = currentValue + Integer.valueOf(input[i + 1]) + Integer.valueOf(input[i + 2])
                listOfSums.add(sum.toString())
            }
        }
        return part1(listOfSums)
    }

    val input = readInput("Day01")
    println("""increased measurements: ${part1(input)}""")
    println("""increased sum of measurements: ${part2(input)}""")
}