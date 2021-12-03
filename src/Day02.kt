fun main() {
    val input = readInput("Day02")

    val forward = "forward"
    val down = "down"
    val up = "up"

    val result = calculateDivePart1(input, forward, down, up)
    println("""part one: depth x horizontal =  $result""")

    val testInputPart2 = readInput("Day02_part2")
    val testResultPart2 = calculateDivePart2(testInputPart2, forward, down, up)
    println("""test for part two: depth x horizontal =  $testResultPart2""")
    check(testResultPart2 == 900)

    val inputPart2 = readInput("Day02")
    val resultPart2 = calculateDivePart2(inputPart2, forward, down, up)
    println("""part two: depth x horizontal =  $resultPart2""")
}

fun calculateDivePart1(testInput: List<String>, forward: String, down: String, up: String): Int {
    var depth = 0
    var horizontal = 0
    testInput.forEach {
        when {
            it.contains(forward) -> {
                val forwardValue = Integer.valueOf(it.substringAfterLast(forward).trim())
                horizontal += forwardValue
            }
            it.contains(down) -> {
                depth += Integer.valueOf(it.substringAfterLast(down).trim())
            }
            it.contains(up) -> {
                depth -= Integer.valueOf(it.substringAfterLast(up).trim())
            }
        }
    }
    return depth * horizontal
}

private fun calculateDivePart2(testInput: List<String>, forward: String, down: String, up: String): Int {
    var depth = 0
    var horizontal = 0
    var aim = 0
    testInput.forEach {
        when {
            it.contains(forward) -> {
                val forwardValue = Integer.valueOf(it.substringAfterLast(forward).trim())
                horizontal += forwardValue
                depth += aim * forwardValue
            }
            it.contains(down) -> {
                aim += Integer.valueOf(it.substringAfterLast(down).trim())
            }
            it.contains(up) -> {
                aim -= Integer.valueOf(it.substringAfterLast(up).trim())
            }
        }
    }
    return depth * horizontal
}