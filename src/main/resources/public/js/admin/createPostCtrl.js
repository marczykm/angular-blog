app.controller('AdminCreatePostCtrl', function($scope, $stateParams, $http){

    $scope.post;

    $scope.savePost = function() {
        var postJson = {
           title: $scope.post.title,
           content: $scope.post.content,
           author: $scope.post.author,
           photo: $scope.post.photo
        };

        $http.post("/rest/post/create", postJson).
            success(function(data, status, headers, config){
                alert("Post created");
            });
    }

});
