app.config( function($routeProvider, $locationProvider){
    var baseUrl = 'js';
    $routeProvider
        .when('/',
        {
            templateUrl: baseUrl+'/default/default.html',
            controller: 'DefaultCtrl'
        })
        .when('/post/:id',
        {
            templateUrl: baseUrl+'/post/blog_post.html',
            controller: 'BlogPostCtrl'
        })
        .when('/admin',
        {
            templateUrl: baseUrl+'/admin/default.html',
            controller: 'AdminDefaultCtrl'
        })
        .when('/admin/post/:id',
        {
            templateUrl: baseUrl + '/admin/editPost.html',
            controller: 'AdminEditPostCtrl'
        })
        .otherwise({
            redirectTo: '/'
        })
    });
