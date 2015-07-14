app.controller('BlogPostCtrl', function($scope, $routeParams, $http){
    $scope.name = "BlogPostCtrl";
    $scope.params = $routeParams;

    $http.get("/rest/post?id=" + $routeParams.id).
            success(function(data, status, headers, config){
                $scope.post = data;
            }).
            error(function(data, status, headers, config){

            });
});
