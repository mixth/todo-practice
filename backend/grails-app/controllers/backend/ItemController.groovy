package backend


import grails.rest.*
import grails.converters.*

class ItemController extends RestfulController {
    static responseFormats = ['json']
    static allowedMethods = [index: "GET", save: "POST"]
    ItemController() {
      super(Item)
    }

    @Override
    def delete() {
        render status:405
    }

    @Override
    def update() {
        render status:405
    }
}
