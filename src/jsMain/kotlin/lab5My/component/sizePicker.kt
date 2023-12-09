package lab5My.component

import csstype.px
import emotion.react.css
import react.*
import react.dom.html.InputType
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.input

external interface ModeSizePickerProps : Props {
    var _size: Int
    var _setSize: StateSetter<Int>
}


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