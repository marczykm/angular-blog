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
        .state('adminPosts', {
            url: '/admin/posts',
            views:
            {
                '': { templateUrl: 'js/admin/template.html' },
                'main@adminPosts': {
                    templateUrl:'js/admin/posts.html',
                    controller: 'AdminPostsCtrl'
                }
            }
        })
        .state('adminPostEdit', {
            url: '/admin/post/edit/:id',
            views:
            {
                '': { templateUrl: 'js/admin/template.html' },
                'main@adminPostEdit': {
                    templateUrl:'js/admin/editPost.html',
                    controller: 'AdminEditPostCtrl'
                }
            }
        })
        .state('adminPostCreate', {
            url: '/admin/post/create',
            views:
            {
                '': { templateUrl: 'js/admin/template.html' },
                'main@adminPostCreate': {
                    templateUrl:'js/admin/createPost.html',
                    controller: 'AdminCreatePostCtrl'
                }
            }
        })
    });
