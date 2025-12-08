fun main() {
    fun part1(input: List<String>): Int = input.sumOf { line ->
        val list = line.toList()
        val max = list.withIndex().maxBy { it.value }
        when {
            max.index == list.size - 1 -> {
                val second = list.take(max.index).max()
                "$second${max.value}".toInt()
            }

            else -> {
                val second = list.subList(max.index + 1, list.size).max()
                "${max.value}$second".toInt()
            }
        }
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    val input = readInput("Day03")

    val test1 = readInput("Day03_test")
    check(part1(test1) == 357)

    part1(input).println()
}