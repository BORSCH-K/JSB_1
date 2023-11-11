import csstype.TextAlign
import csstype.px
import emotion.react.css
import react.FC
import react.dom.html.InputType
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.input
import react.dom.html.ReactHTML.table
import react.dom.html.ReactHTML.th
import react.dom.html.ReactHTML.tr
import react.useState


val Lab_2 = FC<TableProps> {
    var students by useState(listOf(
        "Ангелина" to 5, "Владислав" to 4,
        "Денис" to 2, "Константин" to 3,
        "Ксения" to 2, "Ирина" to 3,
        "Наталья" to 5, "Татьяна" to 5,
        "Владимир" to 4
    ))

    fun _sGrade() = ((students.map { it.second }).sum().toFloat()) / students.size

    div {
        table {
            students.forEachIndexed { i, it ->
                tr {
                    th {
                        +it.first
                    }
                    input {
                        css {
                            width = 60.px
                            borderRadius = 20.px
                            height = 20.px
                            textAlign = TextAlign.center
                        }
                        type = InputType.number
                        min = 2.0
                        max = 5.0
                        step = 1.0
                        defaultValue = it.second.toString()

                        onChange = { event ->
                            val grade: Int
                            when (event.target.value.toFloat()) {
                                in Float.MIN_VALUE..2F -> {
                                    grade = 2
                                    event.target.value = "2"
                                }

                                in 5F..Float.MAX_VALUE -> {
                                    grade = 5
                                    event.target.value = "5"
                                }

                                else -> grade = event.target.value.toInt()
                            }

                            students = students.mapIndexed { j, student ->
                                if (j == i) {
                                    student.first to grade
                                } else student
                            }
                        }
                    }
                }
            }
        }
        +"Средняя оценка: "
        input {
            value = _sGrade().toString()
        }
    }
}