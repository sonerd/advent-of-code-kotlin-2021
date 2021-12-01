fun main() {
    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    val testInput = readInput("Day01")
    check(part1(testInput) == 2000)
    println("""increased measurements: ${countIncreasedMeasurements(testInput)}""")

    val listOfSums = mutableListOf<String>()
    testInput.forEachIndexed { i, e ->
        val currentValue = Integer.valueOf(e)
        if (i + 2 < testInput.size) {
            val sum = currentValue + Integer.valueOf(testInput[i + 1]) + Integer.valueOf(testInput[i + 2])
            listOfSums.add(sum.toString())
        }
    }
    println("""increased sum of measurements: ${countIncreasedMeasurements(listOfSums)}""")
}

private fun countIncreasedMeasurements(testInput: List<String>): Int {
    var increasedCount = 0
    testInput.forEachIndexed { i, e ->
        val valueAsInt = Integer.valueOf(e)
        if (i > 0 && valueAsInt > Integer.valueOf(testInput[i - 1])) {
            increasedCount++
        }
    }
    return increasedCount
}
