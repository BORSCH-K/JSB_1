import csstype.Color
import emotion.react.css
import react.FC
import react.Props
import react.StateSetter
import react.dom.html.InputType
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.input
import react.useContext


// 1я лаба
external interface TableProps : Props {
    var students: List<Pair<String, Int>>
}

// 2 лаба
external interface GradeProps : Props {
    var grade: Int
    var setGrade: (Int) -> Unit
}

val sGrade = FC<GradeProps> { prop ->

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
    }
}

// 3 лаба
external interface AverageProps : Props {
    var gradesAverage: Float
}

val average = FC<AverageProps> { prop ->
    div {
        +prop.gradesAverage.toString()
    }
}

// 4 лаба

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
        css{
            background = Color(useContext(colorOutput)[prop.grade-2])
        }
    }
}