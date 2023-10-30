import react.FC
import react.Props
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.table
import react.dom.html.ReactHTML.th
import react.dom.html.ReactHTML.tr
import react.useState

val Lab_4 = FC<Props> {

    val (grades, stateGrades) = useState(mutableListOf(4, 5, 2, 3, 4, 5, 2, 4, 5))
    console.log(grades)
    div {
        table {
            students.forEachIndexed { index, student ->
                tr {
                    th { +student }
                    th {
                        sGrade {
                            grade = grades[index]
                            setGrade = { num ->
                                val newGrade = grades.toMutableList()
                                newGrade[index] = num
                                console.log(newGrade)
                                stateGrades(newGrade)
                            }
                        }
                    }
                }
            }
        }

        +"Средняя оценка:"

        console.log("average")
        average {
            gradesAverage = (grades.sum().toFloat()/grades.size)
            console.log("gradesAverage")
        }
    }
}