import kotlin.math.abs

fun main() {
    fun part1(input: List<String>, constantBurn: Boolean = true): Int {
        val positions = input.first().split(",").map { it.toInt() }

        val max = positions.maxOrNull() ?: 0
        var best = Int.MAX_VALUE
        for (p in 0..max) {
            val sumOf = positions.sumOf {
                val n = abs(p - it)
                when {
                    constantBurn -> {
                        n
                    }
                    else -> {
                        n * (n + 1) / 2
                    }
                }
            }
            if (sumOf < best) {
                best = sumOf
            }
        }
        return best
    }

    val testInput = readInput("Day07_test")
    println("""test result part1: ${part1(testInput)}""")
    check(part1(testInput) == 37)

    println("""test result part2: ${part1(testInput, false)}""")
    check(part1(testInput, false) == 168)

    val input = readInput("Day07")
    println("""part 1: ${part1(input)}""")
    println("""part 2: ${part1(input, false)}""")
}