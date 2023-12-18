(function () {
    angular
        .module('notification_system', ['ngRoute', 'ngStorage'])
        .config(config)
        .run(run);

    function config($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'welcome/welcome.html',
                controller: 'welcomeController'
            })
            .when('/list', {
                templateUrl: 'list/list.html',
                controller: 'listController'
            })
            .when('/create_notification', {
                templateUrl: 'create_notification/create_notification.html',
                controller: 'createNotificationController'
            })
            .when('/edit_notification/:notificationId', {
                templateUrl: 'edit_notification/edit_notification.html',
                controller: 'editNotificationController'
            })
            .otherwise({
                redirectTo: '/'
            })
    }

    function run($rootScope, $http, $localStorage) {
    }

})();

angular.module('notification_system').controller('indexController', function ($rootScope, $scope, $http, $localStorage, $location) {
    const contextPath = 'http://localhost:5000/auth/api/v1/';
    const cartPath = 'http://localhost:5000/cart/api/v1/cart';
    const corePath = 'http://localhost:5000/core/api/v1';
});