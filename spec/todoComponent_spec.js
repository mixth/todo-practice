describe("To-do List", function() {
  it("should fetch to-do list from API", function() {
    var $httpBackend, ctrl;
    module("todoApp");
    inject(function(_$httpBackend_, $rootScope, $componentController) {
      $httpBackend = _$httpBackend_;
      ctrl = $componentController("todo", {
        $scope: $rootScope.$new()
      });
    });
    ctrl.$onInit();
    $httpBackend.expectGET("http://localhost:4444")
      .respond(["apple"]);
    $httpBackend.flush();
  });
});
