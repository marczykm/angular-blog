app.controller('DefaultCtrl', function($scope, $routeParams, $http){
    $scope.name = "DefaultCtrl";
    $scope.params = $routeParams;
    $scope.posts;

    $http.get("http://localhost:9999/rest/posts").
        success(function(data, status, headers, config){
            $scope.posts = data;
            console.log(data[0].creationDate);
        }).
        error(function(data, status, headers, config){

        });

});