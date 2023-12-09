package lab5My.component

import csstype.Color
import emotion.react.css
import react.FC
import react.Props
import react.dom.html.InputType
import react.dom.html.ReactHTML.input
import react.useContext

external interface GradeProps : Props {
    var grade: Int
    var setGrade: (Int) -> Unit
}

val sGradeColor = FC<GradeProps> { prop ->

    input {
        type = InputType.number
        min = 2.0
        max = 5.0
        step = 1.0
        defaultValue = prop.grade.toString()
        onChange = { event ->
            prop.grade = when (event.target.value.toFloat()) {
                in Float.MIN_VALUE..2F -> 2
                in 5F..Float.MAX_VALUE -> 5
                else -> event.target.value.toInt()
            }
            prop.setGrade(prop.grade)
        }
        css {
            background = Color(useContext(colorOutput)[prop.grade - 2])
        }
    }
}