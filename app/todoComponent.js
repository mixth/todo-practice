'use strict';

(function() {
  function todoController($http) {
    var self = this;
    self.$onInit = function() {
      $http.get("http://localhost:4444").then(function(result) {
        self.list = result.data;
      });
    }
  }

  angular.module("todoApp", []).component("todo", {
     controller: todoController
  });
})();
