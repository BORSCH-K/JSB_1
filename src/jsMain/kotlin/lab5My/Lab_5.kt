package lab5My

import csstype.*
import emotion.react.css
import lab5My.component.*
import react.*
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.h3
import react.dom.html.ReactHTML.li
import react.dom.html.ReactHTML.ol
import react.router.Route
import react.router.Routes
import react.router.dom.HashRouter
import react.router.dom.Link


val linkNames = listOf("Таблица оценок", "Отличники", "Хорошисты", "Двоечники")

external interface ListElementProps : Props {
    var name: String
    var gradesLE: List<Int>
    var stateGradesLE: StateSetter<List<Int>>
}

val ListElement = FC<ListElementProps> { props ->

    div {
        h3 { +props.name }
        ol {
            students.mapIndexed { index, nameStudent ->
                if (props.gradesLE[index] == 1)
                    li { +nameStudent }
            }
        }
    }
}

external interface SettingProps : Props {
    var mode_: List<String>
    var setMode_: StateSetter<List<String>>
    var modeSize_: Int
    var setSize_: StateSetter<Int>

}

val Settings = FC<SettingProps> { props ->
        CModePicker {
        _mode = props.mode_
        _setMode = props.setMode_
    }
    CSizePicker {
        _size = props.modeSize_
        _setSize = props.setSize_
    }
}


val Lab_5 = FC<Props> {

    val (grades, stateGrades) = useState(listOf(4, 5, 2, 3, 4, 5, 2, 4, 5))

    val (mode, setMode) = useState(defaultColors)
    val (modeSize, setSize) = useState(16)

    colorOutput.Provider(mode) {
        sizeLettersContext.Provider(modeSize) {
            HashRouter { // машрутизатор
                div { // блок ссылок на странице
                    linkNames.map { name_ ->
                        Link {
                            css {
                                flex = Flex.minContent
                            }
                            +name_
                            to = name_
                        }
                    }
                    Link {
                        css {
                            flex = Flex.minContent
                        }
                        +"Настройки"
                        to = "Настройки"
                    }
                }
                Routes { // маршруты
                    Route {
                        path = "/Таблица оценок"
                        element = TableGrades.create {
                            grades_ = grades
                            stateGrades_ = stateGrades
                        } // таблица оценок
                    }
                    Route {
                        path = "/Отличники"
                        element = ListElement.create {
                            this.name = linkNames[1] // имя страницы
                            gradesLE = grades.map { if (it == 5) 1 else 0 }
                            stateGradesLE = stateGrades
                        }
                    }
                    Route {
                        path = "/Хорошисты"
                        element = ListElement.create {
                            this.name = linkNames[2] // имя страницы
                            gradesLE = grades.map { if (it > 3) 1 else 0 }
                            stateGradesLE = stateGrades
                        }
                    }
                    Route {
                        path = "/Двоечники"
                        element = ListElement.create {
                            this.name = linkNames[3] // имя страницы
                            gradesLE = grades.map { if (it == 2) 1 else 0 }
                            stateGradesLE = stateGrades
                        }
                    }
                    Route {
                        path = "/Настройки"
                        element = Settings.create {
                            mode_ = mode
                            setMode_ = setMode

                            modeSize_ = modeSize
                            setSize_ = setSize
                        }

                    }
                }
            }
        }
    }
}

