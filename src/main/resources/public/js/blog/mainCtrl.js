app.controller('BlogMainCtrl', function($scope, $http, $sce){
    $scope.posts;

    $http.get("rest/posts").
        success(function(data, status, headers, config){
            $scope.posts = data;

            for (i = 0; i < $scope.posts.length; i++){
                $scope.posts[i].content = $scope.posts[i].content.replace(/<[^>]+>/gm, '');
                $scope.posts[i].content = $scope.posts[i].content.substring(0, 255) + "...";
                $scope.posts[i].content = $sce.trustAsHtml($scope.posts[i].content);
            }
        });
});
