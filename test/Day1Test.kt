import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class Day1Test {

    var sut: Day1? = null

    @Before
    fun setUp() {
        sut = Day1()
    }

    @After
    fun tearDown() {
    }

    @Test
    fun sortedValue() {
        val list = listOf(10,9,3,4,5,6,7,8,2,1)
        val expected = listOf(1,2,3,4,5,6,7,8,9,10)
        val actual = sut?.sortedValue(list)
        assertEquals(expected, actual)
    }

    @Test
    fun compareTwoListAndFindDifference() {
        val list1 = sut?.sortedValue(listOf(1,2,3,4,5,6,7,8,9,10))
        val list2 = sut?.sortedValue(listOf(1,2,3,4,5,6,7,8,9,10))

        val combined = sut?.combine(list1!!,list2!!)
        assertEquals(combined, listOf(0,0,0,0,0,0,0,0,0,0))
    }

    @Test
    fun givenAListSumTheValues() {
        val output = sut?.sumValue(input = listOf(1,2,3,4,5,6,7,8,9,10))
        assertEquals(
            output,
            55
        )
    }

    @Test
    fun givenTwoValuesFindTheDistance() {
        val output = sut?.calculateDistance(a = 1, b = 2)
        assertEquals(
            output,
            1
        )
    }


    /**
     *      3   4
     *      4   3
     *      2   5
     *      1   3
     *      3   9
     *      3   3
     */

    @Test
    fun testRunData() {
        val listOne = listOf(3,4,2,1,3,3)
        val listTw0 = listOf(4,3,5,3,9,3)

        val sortedOne = sut?.sortedValue(listOne)
        val sortedTwo = sut?.sortedValue(listTw0)

        val collection = sut?.combine(sortedOne!!, sortedTwo!!)

        val outut = collection?.let { sut?.sumValue(it) }

        assertEquals(outut, 11)
    }

    /**
     * Part Two
     * 3   4
     * 4   3
     * 2   5
     * 1   3
     * 3   9
     * 3   3
     *
     *  val listOne = listof(3,4,2,1,3,3)
     *  val listTwo = listOf(4,3,5,3,9,3)
     */

    @Test
    fun givenOneListOfNumbersFindIfAnyExistOnSecondSet(){
        val listOne = listOf(3,4,2,1,3,3)
        val listTwo = listOf(4,3,5,3,9,3)

        val output = sut?.findNumberOfMatches(listOne, listTwo)
        assertEquals(output, 31)
    }

}