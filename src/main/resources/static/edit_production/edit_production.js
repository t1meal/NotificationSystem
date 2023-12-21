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

    $scope.navToAddProductPage = function () {
        $location.path('create_product/' + $scope.notification.id);
    }
    $scope.deleteProduct = function (id) {
        $http.delete(baseURL + 'product_packages/' + id)
            .then(function () {
                $scope.prepareNotificationForUpdateProduction();
            });
    }

    $scope.prepareNotificationForUpdateProduction();

});