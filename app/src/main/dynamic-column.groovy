def getColumns(String header, List<String> markers) {
    String endMarker = null
    markers.drop(1)
            .plus(endMarker)
            .inject([]) { List cols, nextMarker ->
        if (cols.size() == 0) {
            cols + getIndexes(header, 0, nextMarker)
        } else {
            cols + getIndexes(header, cols.last().end, nextMarker)
        }
    }
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

{
    // with trailing spaces
    def example = 'col1  column2      col_3   '
    def markers = ['col1', 'column2', 'col_3']
    def columns = getColumns(example, markers)

    assert columns == [
            [start: 0, end: 6],
            [start: 6, end: 19],
            [start: 19, end: 27],
    ]

    assert parse(example, columns) == ['col1', 'column2', 'col_3']
}

{
    // no trailing spaces
    def example = 'col1  column2      col_3'
    def markers = ['col1', 'column2', 'col_3']
    def columns = getColumns(example, markers)

    assert columns == [
            [start: 0, end: 6],
            [start: 6, end: 19],
            [start: 19, end: 24],
    ]

    assert parse(example, columns) == ['col1', 'column2', 'col_3']
}