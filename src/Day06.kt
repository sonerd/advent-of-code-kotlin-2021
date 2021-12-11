fun main() {
    fun part1(input: List<String>, days: Int): Int {
        var numbers = input.first().split(",").map { it.toInt() }

        repeat(days) {
            val fish = ArrayList<Int>()
            numbers.forEach {
                when (it) {
                    0 -> {
                        fish.add(8)
                        fish.add(6)
                    }
                    else -> {
                        fish.add(it - 1)
                    }
                }
            }
            numbers = fish
        }

        return numbers.size

    }

    fun part2(input: List<String>, days: Int): Long {
        return 0L
    }

    val testInput = readInput("Day06_test")
    println("""test result: ${part1(testInput, 80)}""")
    check(part1(testInput, 80) == 5934)

    val input = readInput("Day06")
    println("""part 1: ${part1(input, 80)}""")
}