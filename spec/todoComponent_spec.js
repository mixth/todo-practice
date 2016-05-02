describe("To-do List", function() {
  var $httpBackend, ctrl;

  beforeEach(function() {
    module("todoApp");
    inject(function(_$httpBackend_, $rootScope, $componentController) {
      $httpBackend = _$httpBackend_;
      ctrl = $componentController("todo", {
        $scope: $rootScope.$new()
      });
    });
  });

  it("should fetch to-do list from API", function() {
    ctrl.$onInit();
    $httpBackend.expectGET("http://localhost:4444")
      .respond(["apple"]);
    $httpBackend.flush();
  });

  it("should have 'apple' in list after successfully fetch API", function () {
    ctrl.$onInit();
    $httpBackend.expectGET("http://localhost:4444")
      .respond(["apple"]);
    $httpBackend.flush();
    
    expect(ctrl.list).toEqual(["apple"]);
  });
});
