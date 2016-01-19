var app = angular.module('currencyConverter', []);

app.controller('currencyConverterController', function($scope, $http) {

    $http.get('/rates')
        .success(function(data, status) {$scope.rates = data; $scope.status = status;})
        .error(function(error) {$scope.error = error});

    $scope.baseCcy = 'USD';

    $scope.count = function() {
        for (var key in $scope.rates) {
            var rate = $scope.rates[key];
            if (rate.ccy == $scope.selectedRate.ccy) {
                $scope.result = $scope.amount * rate.value;
            }
        }
    }

});