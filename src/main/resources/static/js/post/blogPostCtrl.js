app.controller('BlogPostCtrl', function($scope, $routeParams){
    $scope.name = "BlogPostCtrl";
    $scope.params = $routeParams;

    $scope.test = "test2";

    console.log($scope.params.title);
});