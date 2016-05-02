'use strict';

(function() {
  function todoController($http) {
    this.$onInit = function() {
      $http.get("http://localhost:4444");
    }
  }

  angular.module("todoApp", []).component("todo", {
     controller: todoController
  });
})();
