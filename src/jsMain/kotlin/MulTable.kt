import react.FC
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.table
import react.dom.html.ReactHTML.th
import react.dom.html.ReactHTML.tr
import react.useState

val MulTable = FC<TableProps> { props ->
    var name by useState(props.name)
    div {
        table {
            border = 1
            tr {
                th {}
                for (i in 2..10) {
                    th {
                        +i.toString()
                    }
                }
            }
            for (i in 2..10) {
                tr {
                    th {
                        +i.toString()
                    }
                    for (j in 2..10) {
                        th {
                            +(i * j).toString()
                        }
                    }
                }
            }
        }
    }
}