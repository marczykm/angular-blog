app.controller('DefaultCtrl', function($scope, $routeParams, $http){
    $scope.name = "DefaultCtrl";
    $scope.params = $routeParams;
    $scope.posts;

    $http.get("http://marczyk.ovh/rest/posts").
        success(function(data, status, headers, config){
            $scope.posts = data;
        }).
        error(function(data, status, headers, config){

        });

});