app.controller('BlogPostCtrl', function($scope, $stateParams, $http, $sce){

    $http.get("rest/post?id=" + $stateParams.id).
            success(function(data, status, headers, config){
                $scope.post = data;
                $scope.post.content = $sce.trustAsHtml(data.content);
            });
});
