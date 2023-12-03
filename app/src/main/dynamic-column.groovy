def getColumns(String header) {
    def col1 = getIndexes(header, 0, 'column2')
    def col2 = getIndexes(header, col1.end, 'col_3')
    def col3 = getIndexes(header, col2.end)
    [
            column1 : col1,
            column2 : col2,
            column3 : col3,
    ]
}

def getIndexes(String header, int start, String nextMarker = null) {
    [
            start : start,
            end : nextMarker != null ? header.indexOf(nextMarker, start) : header.size()
    ]
}

assert getColumns('col1  column2      col_3   ') == [
        column1 : [start : 0, end : 6],
        column2 : [start : 6, end : 19],
        column3 : [start : 19, end : 27]
]