import csstype.Color
import csstype.px
import emotion.react.css
import react.*
import react.dom.html.InputType
import react.dom.html.ReactHTML.caption
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.input
import react.dom.html.ReactHTML.table
import react.dom.html.ReactHTML.th
import react.dom.html.ReactHTML.tr


val defaultColors = listOf("#B83B5E", "#F08A5D", "#F9ED69", "#3FC1C9")

val colorOutput = createContext<List<String>>()
val sizeLettersContext = createContext<Int>()

val CSizePicker = FC<ModeSizePickerProps>("CSizePicker") { props ->

    div {
        +"Размер шрифта: "
        input {
            type = InputType.number
            defaultValue = "16"
            onChange = { event ->
                props._size = event.target.value.toInt()
                props._setSize(props._size)
            }
            css {
                width = 50.px
            }
        }
    }
}


val CModePicker = FC<ModePickerProps>("ModePicker") { props ->

    caption { +"Палитра цветов" }
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

val TableGrades = FC<Props>("TableGrades") {

    val (grades, stateGrades) = useState(listOf(4, 5, 2, 3, 4, 5, 2, 4, 5))

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

        average {
            gradesAverage = (grades.sum().toFloat() / grades.size)
        }
    }
}

val Lab_4 = FC<Props> {

    val (mode, setMode) = useState(defaultColors)
    val (modeSize, setSize) = useState(16)

    CModePicker {
        _mode = mode
        _setMode = setMode
    }
    CSizePicker {
        _size = modeSize
        _setSize = setSize
    }

    sizeLettersContext.Provider(modeSize) {
        colorOutput.Provider(mode) {
            TableGrades {}
        }
    }
}