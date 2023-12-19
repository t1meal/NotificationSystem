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
            .when('/edit_production/:notificationId', {
                templateUrl: 'edit_production/edit_production.html',
                controller: 'editProductionController'
            })
            .when('/edit_product/:productId', {
                templateUrl: 'edit_product/edit_product.html',
                controller: 'editProductController'
            })
            .otherwise({
                redirectTo: '/'
            })
    }

    function run($rootScope, $http, $localStorage) {
    }

})();

angular.module('notification_system').controller('indexController', function ($rootScope, $scope, $http, $localStorage, $location) {

});