(function () {
    'use strict';

    var module = angular.module('currencyConverter', []);

    module.controller('CcyController', CcyController);

    CcyController.$inject = ['$http'];
    function CcyController($http) {
        var vm = this;
        vm.amount = '';
        vm.error = '';
        vm.result = '';
        vm.baseCcy = '';
        vm.selectedRate = null;
        vm.rates = [];
        vm.count = count;

        $http.get('/rates')
            .success(function (data) {
                vm.rates = data;
                vm.selectedRate = selectDefaultCcy(data);
            })
            .error(function (error) {
                vm.error = error;
            });

        function selectDefaultCcy(rates) {
            var filtered = rates.filter(function (rate) {
                return rate.ccy === 'USD';
            });
            return filtered ? filtered[0] : null;
        }

        function count() {
            for (var key in vm.rates) {
                var rate = vm.rates[key];
                if (rate.ccy == vm.selectedRate.ccy) {
                    vm.result = vm.amount * rate.value;
                }
            }
        }
    }

})();
