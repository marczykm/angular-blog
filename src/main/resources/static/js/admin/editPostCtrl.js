app.controller('AdminEditPostCtrl', function($scope, $stateParams, $http){

    $scope.post;

    $http.get("/rest/post?id=" + $stateParams.id).
        success(function(data, status, headers, config){
            $scope.post = data;
        });

    $scope.savePost = function() {
        var postJson = {
           id: $scope.post.id,
           title: $scope.post.title,
           content: $scope.post.content,
           author: $scope.post.author,
           creationDate: $scope.post.creationDate,
           photo: $scope.post.photo,
           active: $scope.post.active
        };

        $http.post("/rest/post/save", postJson).
            success(function(data, status, headers, config){
                alert("Post saved");
            });
    }

});
