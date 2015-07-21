app.controller('AdminPostsCtrl', function($scope, $http){
    $scope.posts;

    $http.get("/rest/posts").
        success(function(data, status, headers, config){
            $scope.posts = data;
        });

    $scope.deletePost = function(id){
        $http.get("/rest/post/delete?id=" + id).
            success(function(data, status, headers, config){
                $http.get("/rest/posts").
                    success(function(data, status, headers, config){
                        $scope.posts = data;
                    });
            });
    }

});
