angular.module('notification_system').controller('editProductionController', function ($scope, $http, $routeParams, $location) {

    const baseURL = 'http://localhost:15000/notificationSystem/api/v1/';

    $scope.prepareNotificationForUpdateProduction = function () {
        $http.get(baseURL + 'notifications/' + $routeParams.notificationId)
            .then(
                function successCallback(response) {
                    $scope.notification = response.data;
                },
                function failCallback(response) {
                    alert(response.data.messages);
                    $location.path('/list');
                });
    }

    $scope.navToEditProduct = function (productId) {
        $location.path('edit_product/' + productId);
    }

    $scope.prepareNotificationForUpdateProduction();

});