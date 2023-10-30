import react.FC
import react.Props
import kotlinx.browser.document
import org.w3c.dom.HTMLInputElement
import react.dom.html.ReactHTML.body
import react.dom.html.ReactHTML.button
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.input
import react.useState

external interface WelcomeProps : Props {
    var name: String
}

fun String.CtoF() = (this.toFloat() * 9) / 5 + 32
fun String.FtoC() = (this.toFloat() - 32) * 5 / 9
fun String.CtoK(): String {
    val a = this.toFloat() + 273
    if (a < 0){
        return "null"
    }
    return a.toString()
}


fun onClickButton1() {
    val input1: HTMLInputElement = document.getElementById("pole1") as HTMLInputElement
    val input2: HTMLInputElement = document.getElementById("pole2") as HTMLInputElement
    input2.value = input1.value.CtoF().toString()
}

fun onClickButton2() {
    val input1: HTMLInputElement = document.getElementById("pole1") as HTMLInputElement
    val input2: HTMLInputElement = document.getElementById("pole2") as HTMLInputElement
    input2.value = input1.value.FtoC().toString()
}

fun onClickButton3() {
    val input1: HTMLInputElement = document.getElementById("pole1") as HTMLInputElement
    val input2: HTMLInputElement = document.getElementById("pole2") as HTMLInputElement
    input2.value = input1.value.CtoK()
}

val Lab_1 = FC<Props> {
//    var name by useState(props.name)
    div {
//        head {
////            +"АААААА"
////       title("Калькулятор")
//        }
        body {
//        +"Привет!"
            div {
                input {
                    id = "pole1"
                }
//                +"Поле ввода"
            }
//        val a = input()
            div {
                input {
                    id = "pole2"
                }
//                +"Поле вывода"
            }
            div {
                button {
                    +"C to F"
                    onClick = { onClickButton1() }
                }
                button {
                    +"F to C"
                    onClick = { onClickButton2() }
                }
                button{
                    +"C to K"
                    onClick = { onClickButton3() }
                }
            }
        }
    }
}