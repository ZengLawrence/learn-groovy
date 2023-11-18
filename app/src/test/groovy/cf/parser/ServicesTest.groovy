package cf.parser

import spock.lang.Specification
import static Services.*

class ServicesTest extends Specification {

    def "Line starts with 'name' is a header"() {

        when:
        def line = "name "

        then:
        isHeader(line)
    }

    def "Line does not start with 'name' is not a header"() {

        when:
        def line = "xxx "

        then:
        !isHeader(line)
    }
}
