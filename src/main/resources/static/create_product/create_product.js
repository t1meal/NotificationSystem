angular.module('notification_system').controller('createProductController', function ($scope, $http, $routeParams, $location) {

    const baseURL = 'http://localhost:15000/notificationSystem/api/v1/';

    $scope.getNotificationForCreateProduct = function () {
        $http.get(baseURL + 'notifications/' + $routeParams.notificationId)
            .then(
                function successCallback(response) {
                    $scope.parentNotification = response.data;
                },
                function failCallback(response) {
                    alert(response.data.messages);
                });
    }

    $scope.createProduct = function () {
        if ($scope.new_product == null){
            alert("Form not completed!");
            return;
        }
        $scope.new_product.notificationId = $scope.parentNotification.id;
        $http.post(baseURL + 'product_packages', $scope.new_product)
            .then(
                function successCallback(response) {
                    console.log(response);
                    $scope.new_product = null;
                    alert("New product is created!");
                    $location.path('/list');
                },
                function failCallback(response) {
                    alert(response.data.messages);
                });
    }

    $scope.getNotificationForCreateProduct();

});