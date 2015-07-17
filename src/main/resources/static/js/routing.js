app.config( function($stateProvider, $urlRouterProvider){
    $urlRouterProvider.otherwise('/');

    $stateProvider
        .state('blogMain', {
            url: '/',
            views:
            {
                '': { templateUrl: 'js/blog/template.html' },
                'main@blogMain': {
                    templateUrl: 'js/blog/main.html',
                    controller: 'BlogMainCtrl'
                }
            }
        })
        .state('blogPost', {
            url: '/post/:id',
            views:
            {
                '': { templateUrl: 'js/blog/template.html' },
                'main@blogPost': {
                    templateUrl:'js/blog/post.html',
                    controller: 'BlogPostCtrl'
                }
            }
        })
        .state('adminMain', {
            url: '/admin',
            views:
            {
                '': { templateUrl: 'js/admin/template.html' },
                'main@adminMain': {
                    templateUrl:'js/admin/main.html',
                    controller: 'AdminDefaultCtrl'
                }
            }
        })
    });
