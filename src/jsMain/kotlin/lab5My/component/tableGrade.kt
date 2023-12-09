package lab5My.component

import csstype.px
import emotion.react.css
import react.*
import react.dom.html.ReactHTML
import react.dom.html.ReactHTML.caption
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.table
import react.dom.html.ReactHTML.th
import react.dom.html.ReactHTML.tr


val students =
    listOf("Ангелина", "Владислав", "Денис", "Константин", "Ксения", "Ирина", "Наталья", "Татьяна", "Владимир")

val defaultColors = listOf("#B83B5E", "#F08A5D", "#F9ED69", "#3FC1C9")
val colorOutput = createContext<List<String>>()
val sizeLettersContext = createContext<Int>()

external interface AverageProps : Props {
    var gradesAverage: Float
}

val average = FC<AverageProps> { prop ->
    div {
        +"Средняя оценка: ${prop.gradesAverage}"
    }
}

external interface TableGradesProps : Props {
    var grades_: List<Int>
    var stateGrades_ : StateSetter<List<Int>>
}

val TableGrades = FC<TableGradesProps>("TableGrades") { props ->

    div {
        table {
            caption { +"Оценки студентов" }
            students.forEachIndexed { index, student ->
                tr {
                    th {
                        +student
                        css {
                            fontSize = useContext(sizeLettersContext).px
                        }

                    }
                    th {
                        sGradeColor {
                            grade = props.grades_[index]
                            setGrade = { num ->
                                val newGrade = props.grades_.mapIndexed { i, gr ->
                                    if (index == i) num
                                    else gr
                                }
                                props.stateGrades_(newGrade)
                            }
                        }
                    }
                }
            }
        }

        average {
            gradesAverage = (props.grades_.sum().toFloat() / props.grades_.size)
        }
    }
}