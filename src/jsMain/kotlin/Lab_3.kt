import react.FC
import react.Props
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.table
import react.dom.html.ReactHTML.th
import react.dom.html.ReactHTML.tr
import react.useState

val students =
    listOf("Ангелина", "Владислав", "Денис", "Константин", "Ксения", "Ирина", "Наталья", "Татьяна", "Владимир")


val Lab_3 = FC<Props> {

    val (grades, stateGrades) = useState(listOf(4, 5, 2, 3, 4, 5, 2, 4, 5))

    div {
        table {
            students.forEachIndexed { index, student ->
                tr {
                    th { +student }
                    th {
                        sGrade {
                            grade = grades[index]
                            setGrade = { num ->
                                val newGrade =  grades.mapIndexed{ i, gr ->
                                    if (index == i) num
                                    else gr
                                }
                                stateGrades(newGrade)
                            }
                        }
                    }
                }
            }
        }

        +"Средняя оценка:"
        average {
            gradesAverage = (grades.sum().toFloat()/grades.size)
        }
    }
}




