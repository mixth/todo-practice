package backend

class Item {

    static constraints = {
      value blank:false
    }

    Item (String _value) {
      value = _value
    }

    String value
}
