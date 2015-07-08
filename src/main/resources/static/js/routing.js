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
        .otherwise({
            redirectTo: '/'
        })
    });