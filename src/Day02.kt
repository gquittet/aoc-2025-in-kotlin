fun main() {
    fun part1(input: List<Pair<Long, Long>>): Long {
        fun hasPattern(n: String): Boolean = when {
            n.length % 2 == 0 -> n.take(n.length / 2) == n.substring(n.length / 2)
            else -> false
        }
        return input.sumOf { (start, end) ->
            (start..end).filter { hasPattern(it.toString()) }.sum()
        }
    }

    fun part2(input: List<Pair<Long, Long>>): Long {
        return input.size.toLong()
    }

    val input = readInput("Day02")[0].split(",").map {
        val pair = it.split("-")
        pair[0].toLong() to pair[1].toLong()
    }

    val test1 = readInput("Day02_part1_test").map {
        val a = it.split(",")
        val b = a[0].split("-")
        (b[0].toLong() to b[1].toLong()) to a[1].toLong()
    }.all { part1(listOf(it.first)) == it.second }
    check(test1)

    part1(input).println()
}