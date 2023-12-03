def getColumns(String header) {
    def col1 = getIndexes(header, 0, 'column2')
    def col2 = getIndexes(header, col1.end, 'col_3')
    def col3 = getIndexes(header, col2.end)
    [
            col1,
            col2,
            col3,
    ]
}

def getIndexes(String header, int start, String nextMarker = null) {
    [
            start : start,
            end : nextMarker != null ? header.indexOf(nextMarker, start) : header.size()
    ]
}

def parse(String line, List columns) {
    columns.collect { col ->
        line.substring(col.start, col.end).trim()
    }
}

def example = 'col1  column2      col_3   '
def columns = getColumns(example)

assert columns == [
        [start : 0, end : 6],
        [start : 6, end : 19],
        [start : 19, end : 27],
]

assert parse(example, columns) == ['col1', 'column2', 'col_3']