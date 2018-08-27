wApp.controller('LoginController', function($http, $location, $window) {
    var vm = this;
    vm.form = {};

    vm.validateUser = function(){
        $http({
            url: "log/in",
            method: "GET",
            headers : {'Accept' : 'application/json'},
            params: {user: vm.form.user, pass: vm.form.pass}
        }).then(function (response) {
            vm.userPreference = response.data;
            goToDashboard();
        });
    }

    var goToDashboard = function () {
        $location.path("/dashboard")
    };

});