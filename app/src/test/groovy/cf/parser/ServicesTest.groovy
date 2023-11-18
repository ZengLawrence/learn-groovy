package cf.parser

import spock.lang.Specification
import static Services.*

class ServicesTest extends Specification {

    def "Line starts with 'name' is a header"() {
        expect:
        isHeader("name")
        !isHeader("xxx")
    }
}
