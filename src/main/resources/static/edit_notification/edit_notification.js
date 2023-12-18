angular.module('notification_system').controller('editNotificationController', function ($scope, $http, $routeParams, $location) {

    const baseURL = 'http://localhost:15000/notificationSystem/api/v1/';

    $scope.prepareProductForUpdate = function () {
        $http.get(baseURL + 'notifications/' + $routeParams.notificationId)
            .then(
                function successCallback(response) {
                    $scope.updating_notification = response.data;
                },
                function failCallback(response) {
                    alert(response.data.messages);
                    $location.path('/list');
                });
    }
    $scope.updateNotification = function () {
        $http.put(baseURL + 'notifications', $scope.updating_notification)
            .then(
                function successCallback() {
                    $scope.updated_product = null;
                    alert("Notification is updated!");
                    $location.path('/list');
                },
                function failCallback(response) {
                    alert(response.data.messages);
                });
    }

    $scope.prepareProductForUpdate();

});