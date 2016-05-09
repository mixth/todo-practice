package backend

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Item)
class ItemSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    def "test Item constructor get input correctly"() {
      when:
        def obj = new Item("This is a test")
      then:
        obj.value == "This is a test"
    }
}
