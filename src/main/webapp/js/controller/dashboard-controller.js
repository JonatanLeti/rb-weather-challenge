wApp.controller('DashboardController', function($http, $window) {
    var vm = this;
    vm.city = null;

    vm.weatherDataList = [];
    vm.cityList = [];

    vm.getWeather = function() {

        if (vm.city && _.includes(vm.cityList, vm.city)) {
            $window.alert("Location previously searched: " + vm.city);

        } else {

            var urlQuery = 'https://query.yahooapis.com/v1/public/yql?q=select * from weather.forecast where woeid in (select woeid from geo.places(1) where text="' + vm.city + '")&format=json'

            $http({
                url: urlQuery,
                method: "GET",
                headers: {
                    'Accept': 'application/json'
                }
            }).then(function(res) {
                if (res == null || res.data == null || res.data.query == null || res.data.query.results == null) {
                    $window.alert("Location not found: " + vm.city + "!");

                } else {
                    var weatherData = res.data.query.results.channel.item;
                    weatherData.description = weatherData.description.replace("]]>", "");
                    weatherData.city = vm.city;

                    vm.cityList.push(vm.city);
                    vm.weatherDataList.push(weatherData);
                }
            });
        }
    }

    vm.removeFromList = function(weatherData) {
        vm.weatherDataList = _.filter(vm.weatherDataList, w => w.city != weatherData.city);

        vm.cityList = _.filter(vm.cityList, function(c) {
            return c !== weatherData.city;
        });

    }

  vm.showConfirm = function(ev) {

    if (confirm("Desea guardar las ciudades actuales?")) {
        vm.doSave();
    }else{
        console.log('cancelo la confirmacion');
    }
  };

      vm.doSave = function(){
        $http({
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            url: 'services/create-dashboard',
            data: {
                cityList: vm.cityList
            }
        }).then(function (response) {
            console.log(response);
        }, function (response) {
            console.log(response);
        });

      }

});