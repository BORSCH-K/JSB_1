import csstype.TextAlign
import csstype.px
import emotion.react.css
import kotlinx.browser.document
import org.w3c.dom.Element
import org.w3c.dom.HTMLElement
import org.w3c.dom.HTMLInputElement
import react.FC
import react.Props
import react.dom.html.ReactHTML.button
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.input
import react.dom.html.ReactHTML.li
import react.dom.html.ReactHTML.s
import react.dom.html.ReactHTML.style
import react.dom.html.ReactHTML.table
import react.dom.html.ReactHTML.th
import react.dom.html.ReactHTML.tr
import react.dom.html.ReactHTML.ul
import react.useState

typealias AttrName = String
typealias AttrValue = String
typealias AttrMap = Map<AttrName, AttrValue>
typealias VarAttrMap = MutableMap<AttrName, AttrValue>


external interface TableProps : Props {
    var name: String
}


fun onClickButton() {
//    val sum = 0
//    for (i in 0 until students.size){
//        var temp = document.getElementById("1") as HTMLInputElement
//        sum += temp.toFloat()
//
//
//    }
//    val i = "0"

    var sum = 0F

    for (i in 0 until students.size) {
        val input1: HTMLInputElement = document.getElementById(i.toString()) as HTMLInputElement
        sum += input1.value.toFloat()

//        input2.value += input1.value

    }
    val input2: HTMLInputElement = document.getElementById("sred") as HTMLInputElement

//    val temp = sum/(students.size)
    input2.value = (sum/(students.size)).toString()


//    val input1: HTMLInputElement = document.getElementById(i) as HTMLInputElement
//    val input2: HTMLInputElement = document.getElementById("sred") as HTMLInputElement
//    input2.value = input1.value.toFloat().toString()

}


val students = listOf(
    "Ангелина" to 0, "Владислав" to 1,
    "Денис" to 2, "Константин" to 3,
    "Ксения" to 4, "Ирина" to 5,
    "Наталья" to 6, "Татьяна" to 7,
    "студент 1" to 8, "студент 2" to 9
)

val number = listOf(4, 5, 4, 3, 3, 4, 5, 5, 4, 3)

val Table = FC<TableProps> { props ->
    var name by useState(props.name)
    div {
        table {
            border = 1

            for (i in 0..9) {
                tr {
                    th {
                        +students[i].first
                    }
                    input {

                        css{
                            width = 20.px
                            borderRadius = 20.px
                            height = 20.px
                            textAlign = TextAlign.center
//                             TableAlign.center
//                            TextAlign.center

                        }
//                        form = "circle"
//                        width = 5.0
//                        form =
                        size = 1
                        id = students[i].second.toString()
//                        value = number[i].toString()
                    }
                }
            }
        }

        button {
            +"Средняя оценка"
            onClick = { onClickButton() }
        }
        input {
//            type = InputType.submit

//            +onClickButton().toString()
            id = "sred"
            size = 1
//            autoComplete = AutoComplete.off
//                {onClickButton().toString()}
//            value = onClickButton().toString()

//            +(onClickButton()).toString()
//            value = "1"
//            +"12123"
        }
    }
}

