app.controller('BlogMainCtrl', function($scope, $http, $sce){
    $scope.posts;

    $http.get("rest/posts").
        success(function(data, status, headers, config){
            $scope.posts = data;

            for (i = 0; i < $scope.posts.length; i++){
                var long = false;
                $scope.posts[i].content = $scope.posts[i].content.replace(/<[^>]+>/gm, ' ');
                if ($scope.posts[i].content.length > 500){
                    long = true;
                }
                $scope.posts[i].content = $scope.posts[i].content.substring(0, 500);
                if (long){
                    $scope.posts[i].content = $scope.posts[i].content + "...";
                }
                $scope.posts[i].content = $sce.trustAsHtml($scope.posts[i].content);
            }
        });
});
