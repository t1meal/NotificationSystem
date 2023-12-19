angular.module('notification_system').controller('editProductController', function ($scope, $http, $routeParams, $location) {

    const baseURL = 'http://localhost:15000/notificationSystem/api/v1/';

    $scope.prepareNotificationForUpdateProduction = function () {
        $http.get(baseURL + 'product_packages/' + $routeParams.productId)
            .then(
                function successCallback(response) {
                    $scope.updating_product = response.data;
                },
                function failCallback(response) {
                    alert(response.data.messages);
                    $location.path('/edit_production/' + $scope.notification.id);
                });
    }

    $scope.updateProduct = function () {
        $http.put(baseURL + 'product_packages', $scope.updating_product)
            .then(
                function successCallback() {
                    alert("Product is updated!");
                    $location.path('edit_production/' + $scope.updating_product.notification_id);
                    $scope.updating_product = null;
                },
                function failCallback(response) {
                    alert(response.data.messages);
                });
    }

     $scope.prepareNotificationForUpdateProduction();

});