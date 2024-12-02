class Day1 {

    fun sortedValue(list: List<Int>) = list.sorted()

    fun combine(list1: List<Int>, list2: List<Int>) : List<Int> {
        val output = mutableListOf<Int>()
        list1.forEachIndexed { index, i ->
            val distance = calculateDistance(list1[index], list2[index])
            output.add(distance)
        }
        return output
    }

    fun sumValue(input: List<Int>) = input.sum()

    fun calculateDistance(a: Int, b: Int): Int {
        return kotlin.math.abs(a - b)
    }

    fun findNumberOfMatches(listOne: List<Int>, listTwo: List<Int>) : Int {

        val numberToSum = mutableListOf<Int>()
        listOne.forEach { item ->
            val test = listTwo.filter { it == item }
            val output = item * test.count()
            numberToSum.add(output)
        }

        return numberToSum.sum()
    }

}
