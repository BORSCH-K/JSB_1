package lab5My.component

import csstype.Color
import csstype.px
import emotion.react.css
import react.FC
import react.Props
import react.StateSetter
import react.dom.html.InputType
import react.dom.html.ReactHTML.caption
import react.dom.html.ReactHTML.input
import react.dom.html.ReactHTML.th
import react.dom.html.ReactHTML.tr


external interface ModePickerProps : Props {
    var _mode: List<String>
    var _setMode: StateSetter<List<String>>
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
