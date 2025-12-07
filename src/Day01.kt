import kotlin.math.absoluteValue

fun main() {
    val start = 50
    val circleSize = 100

    fun dialToMoves(dial: String): Int {
        val steps = dial.drop(1).toInt()
        val direction = when (dial.first()) {
            'L' -> -1
            'R' -> 1
            else -> error("Invalid direction: ${dial.first()}")
        }
        return steps * direction
    }

    fun part1(input: List<String>): Int =
        input.scan(start) { total, dial -> (total + dialToMoves(dial)).mod(circleSize) }.count { it == 0 }

    fun part2(input: List<String>): Int = input.fold(start to 0) { (old, count), dial ->
        val moves = dialToMoves(dial)
        val crossings = when {
            moves == 0 -> 0
            old == 0 -> moves.absoluteValue / circleSize
            moves > 0 -> (old + moves) / circleSize
            else -> (circleSize + (moves.absoluteValue) - old) / circleSize
        }
        val new = (old + moves).mod(circleSize)
        new to (count + crossings)
    }.second

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(listOf("R1000")).println() // -> 10
    part2(listOf("L68", "L30", "R48", "L5", "R60", "L55", "L1", "L99", "R14", "L82")).println() // -> 6
    part2(input).println()
}
