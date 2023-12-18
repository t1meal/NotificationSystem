angular.module('notification_system').controller('createNotificationController', function ($scope, $http, $routeParams, $location) {

    const baseURL = 'http://localhost:15000/products/api/v1/';

    $scope.createNotification = function () {
        if ($scope.new_notification == null){
            alert("Form not completed!");
            return;
        }
        $http.post(baseURL + 'notifications', $scope.new_notification)
            .then(
                function successCallback(response) {
                    console.log(response);
                    $scope.new_notification = null;
                    alert("New notification created!");
                    $location.path('/list');
                },
                function failCallback(response) {
                    alert(response.data.messages);
                });
    }

});