import react.FC
import react.Props
import react.dom.html.InputType
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.input


// 1я лаба
//external interface TableProps : Props {
//    var students: List<Pair<String, Int>>
//}

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

external interface AverageProps : Props {
    var gradesAverage: Float
}

val average = FC<AverageProps> { prop ->
    div {
        +prop.gradesAverage.toString()
    }
}