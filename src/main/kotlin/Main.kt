fun main() {
    // make a list of student names
    val students = listOf("Ahmed", "Laila", "Nour", "Salma", "Youssef", "Omar")

    // create a map to store their scores
    val studentsScores = mutableMapOf(
        "Ahmed" to 85,
        "Laila" to 72,
        "Nour" to 95,
        "Salma" to 58,
        "Youssef" to 47,
        "Omar" to 91
    )

    // students who already graduated
    val grads = setOf("Salma", "Youssef")

    println("names: $students")
    println("scores: $studentsScores")
    println("graduated: $grads")
    println()

    // loop through current students and print score
    students.forEach { s ->
        if (grads.contains(s)) return@forEach
        println("$s: ${studentsScores[s]}")
    }
    println()

    // convert all names to uppercase
    val caps = students.map { it.uppercase() }
    println("upper: $caps")
    println()

    // find students who got more than 80
    println("Students above 80:")
    studentsScores.filter { it.value > 80 }
        .map { it.key }.forEach {
            println(it)
        }
    println()

    // calculate total score using reduce
    val sum = studentsScores.values.reduce { a, b -> a + b }
    println("total=$sum")

    // format the scores in one string like:  "Ahmed: 85 | Laila: 72 | Nour: 95"
    val txt = studentsScores.entries.fold("") { acc, e ->
        if (acc == "") "${e.key}: ${e.value}"
        else acc + " | " + "${e.key}: ${e.value}"
    }
    println("all: $txt")

    println()
    println("report:")
    report(studentsScores)

    println()
    println("test empty:")
    report(emptyMap())
}

// function to print only students who passed (score >= 60)
fun report(scores: Map<String, Int>) {
    if (scores.isEmpty()) {
        println("empty map")
        return
    }

    scores.filter { it.value >= 60 }
        .map { "${it.key}: ${it.value}" }
        .forEach { println(it) }
}
