import kotlinx.browser.document
import react.create
import react.dom.client.createRoot

fun main() {
    val container = document.createElement("div")
    document.body!!.appendChild(container)

//    document.bgColor = "red"

//    val welcome = Welcome.create {
//        name = "Kotlin/JS"
//    }
//    createRoot(container).render(welcome)


    val table = Table.create{
        name = "Kotlin/JS"
    }
    createRoot(container).render(table) // меняется
}



// react
// html
// серверная и клиентская части