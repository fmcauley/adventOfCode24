import java.io.File
import kotlin.math.absoluteValue

class Day2 {

    fun isSafe(numbers: List<Int>): Boolean {
        var safe = true
        var isUp = true
        var isDown = true

        for (i in 0..<numbers.lastIndex) {
            val a = numbers[i]
            val b = numbers[i + 1]
            safe = safe && ((a - b).absoluteValue <= 3)
            when {
                a < b -> isDown = false
                b < a -> isUp = false
                else -> {
                    isUp = false
                    isDown = false
                }
            }
        }

        return safe && (isUp || isDown)
    }

    fun readInFile(fileName: String): Int {
        var result = 0
        val input = File(fileName).readLines()
        for (line in input) {
            val numbers = line.split(" ").map { it.toInt() }
            if (isSafe(numbers)) result++
        }
        val outputPart2 = part2(input)
        println("Part Two $outputPart2")
        return result
    }

    fun part2(input: List<String>) : Int {
       var result = 0
        for (line in input) {
            val numbers = line.split(" ").map { it.toInt() }
            var safe = false
            for (i in 0..numbers.lastIndex) {
                safe = isSafe(numbers.toMutableList().apply { removeAt(i) })
                if (safe) break
            }
            if (safe) result++
        }
        return result
    }

}