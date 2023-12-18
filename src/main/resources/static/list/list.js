angular.module('notification_system').controller('listController', function ($scope, $http, $location, $localStorage, $rootScope) {

    const baseURL = 'http://localhost:15000/notificationSystem/api/v1/';

    let currentPage = 1;

    $scope.loadNotifications = function (pageIndex) {
        $http({
            url: baseURL + 'notifications',
            method: 'GET',
            params: {
                p: pageIndex
            }
        }).then(function (response) {
            $scope.notificationsPage = response.data;
            $scope.paginationArray = $scope.generatePageIndexes(1, $scope.notificationsPage.totalPages);
            currentPage = pageIndex;
        });
    }

    $scope.deleteNotification = function (id) {
        $http.delete(baseURL + 'notifications/' + id)
            .then(function () {
                $scope.loadNotifications(currentPage);
            });
    }

    $scope.generatePageIndexes = function (startPage, endPage) {
        let arr = [];
        for (let i = startPage; i <= endPage; i++) {
            arr.push(i);
        }
        return arr;
    }

    $scope.navToEditNotificationPage = function (notificationId) {
        $location.path('edit_notification/' + notificationId);
    }

    $scope.navToEditProduction = function (notificationId) {
        $location.path('edit_production/' + notificationId);
    }

    $scope.nextPage = function () {
        currentPage++;
        if (currentPage > $scope.notificationsPage.totalPages) {
            currentPage = $scope.notificationsPage.totalPages;
        }
        $scope.loadNotifications(currentPage);
    }
    $scope.prevPage = function () {
        currentPage--;
        if (currentPage < 1) {
            currentPage = 1;
        }
        $scope.loadNotifications(currentPage);
    }

    $scope.loadNotifications();

});