package backend

import grails.test.mixin.TestFor
import grails.test.mixin.Mock
import grails.util.GrailsWebUtil
import org.springframework.mock.web.MockHttpServletResponse
import spock.lang.Specification
import grails.util.GrailsWebUtil

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(ItemController)
@Mock([Item])

class ItemControllerSpec extends Specification {

    def setup() {
      def apple = new Item("buy apple").save(flush:true)
      def orange = new Item("buy orange").save(flush:true)
    }

    def cleanup() {
    }

    void "test get all items"() {
        request.setContentType("application/json")
        request.setMethod("GET")
        controller.index()

        expect:
          response.json.size() == 2
          response.json[0].value == "buy apple"
          response.json[1].value == "buy orange"
    }

    void "test delete should not be accepted"() {
        request.setContentType("application/json")
        request.setMethod("DELETE")
        request.setParameter("id", "1")
        controller.delete()

        expect:
            response.status == MockHttpServletResponse.SC_METHOD_NOT_ALLOWED
    }

    void "test add one list"() {
        request.setContentType("application/json")
        request.setMethod("POST")
        request.setJSON("{\"value\": \"buy avocado\"}")
        controller.save()

        when:
            response.reset()

            request.setContentType("application/json")
            request.setMethod("GET")
            controller.index()
        then:
            response.json.size() == 3
            response.json[0].value == "buy apple"
            response.json[1].value == "buy orange"
            response.json[2].value == "buy avocado"
    }
}
