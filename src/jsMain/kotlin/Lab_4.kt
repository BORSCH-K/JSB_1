import csstype.Color
import csstype.px
import csstype.rgb
import emotion.react.css
import react.*
import react.dom.html.InputType
import react.dom.html.ReactHTML
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.input
import react.dom.html.ReactHTML.picture
import react.dom.html.ReactHTML.s
import react.dom.html.ReactHTML.table
import react.dom.html.ReactHTML.th
import react.dom.html.ReactHTML.tr


val defaultColors = listOf("#B83B5E", "#F08A5D", "#F9ED69", "#3FC1C9")

//    Color("#B83B5E"),
//    Color("#F08A5D"),
//    Color("#F9ED69"),
//    Color("#3FC1C9"),
//    rgb(184, 59, 94),
//    rgb(240, 138, 93),
//    rgb(249, 237, 105),
//    rgb(63, 193, 201)
val colorOutput = createContext<List<String>>()

external interface ModePickerProps : Props {
    var _mode: List<String>
    var _setMode: StateSetter<List<String>>
}

val CModePicker = FC<ModePickerProps>("ModePicker") { props ->

    for (i in 2..5) {
        tr {
            th {
                css { width = 30.px }
                +i.toString()
            }
            th {
                css {
                    width = 50.px
                    background = Color(props._mode[i - 2])
                }
            }
            th {
                input {
                    type = InputType.color
                    defaultValue = defaultColors[i - 2]
                    onChange = { event ->
                        props._mode = props._mode.mapIndexed { index, m ->
                            if (index == (i - 2)) event.target.value
                            else m
                        }
                        props._setMode(props._mode)
                    }
                }
            }
        }
    }
}

val TableGrades = FC<Props> ("TableGrades"){

    val (grades, stateGrades) = useState(listOf(4, 5, 2, 3, 4, 5, 2, 4, 5))

    div {
        +"Оценки студентов"
        table {
            students.forEachIndexed { index, student ->
                tr {
                    th { +student }
                    th {
                        sGradeColor {
                            grade = grades[index]
                            setGrade = { num ->
                                val newGrade = grades.mapIndexed { i, gr ->
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
            gradesAverage = (grades.sum().toFloat() / grades.size)
        }
    }
}
val Lab_4 = FC<Props> {

    val (mode, setMode) = useState(defaultColors)
    CModePicker {
        _mode = mode
        _setMode = setMode
    }
    colorOutput.Provider(mode) {
        TableGrades {}
    }
}