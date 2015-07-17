app.controller('AdminDefaultCtrl', function($scope, $http){
    $scope.posts;

    $http.get("/rest/posts").
        success(function(data, status, headers, config){
            $scope.posts = data;
        }).
        error(function(data, status, headers, config){

        });

});
