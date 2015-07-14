app.controller('AdminEditPostCtrl', function($scope, $routeParams, $http){
    $scope.name = "AdminEditPostCtrl";
    $scope.params = $routeParams;
    $scope.posts;

    $http.get("/rest/post?id=" + $routeParams.id).
                success(function(data, status, headers, config){
                    $scope.post = data;
                }).
                error(function(data, status, headers, config){

                });

});
