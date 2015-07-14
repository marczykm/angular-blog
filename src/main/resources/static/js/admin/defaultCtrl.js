app.controller('AdminDefaultCtrl', function($scope, $routeParams, $http){
    $scope.name = "AdminDefaultCtrl";
    $scope.params = $routeParams;
    $scope.posts;

    $http.get("/rest/posts").
        success(function(data, status, headers, config){
            $scope.posts = data;
        }).
        error(function(data, status, headers, config){

        });

});
