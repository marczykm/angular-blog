app.config( function($routeProvider, $locationProvider){
    var baseUrl = 'js';
    $routeProvider
        .when('/',
        {
            templateUrl: baseUrl+'/default/default.html',
            controller: 'DefaultCtrl'
        })
        .when('/test',
        {
            templateUrl: baseUrl+'/test/test.html',
            controller: 'TestCtrl'
        })
        .otherwise({
            redirectTo: '/'
        })
    });