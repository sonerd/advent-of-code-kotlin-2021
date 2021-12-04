fun main() {
    fun part1(input: List<String>): Int {
        var gamma = ""
        var epsilon = ""
        val lengthOfBits = input.first().length
        for (i in 0 until lengthOfBits) {
            val partition = input.map {
                it[i]
            }.partition { it == '0' }

            when {
                partition.first.size > partition.second.size -> {
                    gamma += 0
                    epsilon += 1
                }
                else -> {
                    gamma += 1
                    epsilon += 0
                }
            }
        }
        return gamma.toInt(2) * epsilon.toInt(2)
    }

    fun reduceRelevantElements(lengthOfBits: Int, list: MutableList<String>, c: Char) {
        val isCo2 = c == '0'
        for (i in 0 until lengthOfBits) {
            val partitions = list.partition {
                it[i] == c
            }
            if (list.size == 1) {
                break
            }

            when {
                isCo2 -> {
                    if (partitions.first.size <= partitions.second.size) {
                        list.removeAll(partitions.second)
                    } else {
                        list.removeAll(partitions.first)
                    }
                }
                else -> {
                    if (partitions.first.size >= partitions.second.size) {
                        list.removeAll(partitions.second)
                    } else {
                        list.removeAll(partitions.first)
                    }
                }
            }

        }
    }

    fun part2(input: List<String>): Int {
        val lengthOfBits = input.first().length
        val oxygen = input.map { it }.toCollection(mutableListOf())
        val co2 = input.map { it }.toCollection(mutableListOf())
        reduceRelevantElements(lengthOfBits, oxygen, '1')
        reduceRelevantElements(lengthOfBits, co2, '0')

        return oxygen.first().toInt(2) * co2.first().toInt(2)
    }

    val testInput = readInput("Day03_test")
    check(part1(testInput) == 198)
    check(part2(testInput) == 230)

    val input = readInput("Day03")
    println("""part 1: ${part1(input)}""")
    println("""part 2: ${part2(input)}""")
}