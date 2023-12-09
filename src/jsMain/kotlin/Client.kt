import kotlinx.browser.document
import react.create
import react.dom.client.createRoot

fun main() {
    val container = document.createElement("div")
    document.body!!.appendChild(container)

    val client = lab5My.Lab_5.create{}
    createRoot(container).render(client)
}