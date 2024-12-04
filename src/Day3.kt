import java.io.File

class Day3 {

    fun readInFile(fileName: String) {
        val regex = Regex("\\bmul\\(\\d+,\\d+\\)")
        val file = File(fileName)
        val text = file.readText()

        var result = 0

        val matches = regex.findAll(text)
        for (match in matches) {
            val nestedRegex = Regex("\\d+,\\d+")
            val test = nestedRegex.find(match.value)
            val product = test?.value?.split(",")?.map { it.toInt() }?.reduce { acc, i -> acc * i  }
            result += product!!
        }

        println("The result count $result")
    }
}