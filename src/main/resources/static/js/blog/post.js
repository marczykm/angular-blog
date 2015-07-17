app.controller('BlogPostCtrl', function($scope, $stateParams, $http){

    $http.get("/rest/post?id=" + $stateParams.id).
            success(function(data, status, headers, config){
                $scope.post = data;
            }).
            error(function(data, status, headers, config){

            });
});
