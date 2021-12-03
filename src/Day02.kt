fun main() {
    val input = readInput("Day02")

    val result = calculateDivePart1(input)
    println("""part one: depth x horizontal =  $result""")

    val testInputPart2 = readInput("Day02_part2")
    val testResultPart2 = calculateDivePart2(testInputPart2)
    println("""test for part two: depth x horizontal =  $testResultPart2""")
    check(testResultPart2 == 900)

    val inputPart2 = readInput("Day02")
    val resultPart2 = calculateDivePart2(inputPart2)
    println("""part two: depth x horizontal =  $resultPart2""")
}

fun calculateDivePart1(testInput: List<String>): Int {
    var depth = 0
    var horizontal = 0
    testInput.forEach {
        val line = it.split(" ")
        when (line[0]) {
            "forward" -> {
                val forwardValue = Integer.valueOf(line[1])
                horizontal += forwardValue
            }
            "down" -> {
                depth += Integer.valueOf(line[1])
            }
            "up" -> {
                depth -= Integer.valueOf(line[1])
            }
        }
    }
    return depth * horizontal
}

private fun calculateDivePart2(testInput: List<String>): Int {
    var depth = 0
    var horizontal = 0
    var aim = 0
    testInput.forEach {
        val line = it.split(" ")
        when (line[0]) {
            "forward" -> {
                val forwardValue = Integer.valueOf(line[1])
                horizontal += forwardValue
                depth += aim * forwardValue
            }
            "down" -> {
                aim += Integer.valueOf(line[1])
            }
            "up" -> {
                aim -= Integer.valueOf(line[1])
            }
        }
    }
    return depth * horizontal
}