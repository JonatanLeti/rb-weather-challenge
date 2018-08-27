wApp.config(['$routeProvider', '$locationProvider', function($routeProvider, $locationProvider) {

	$routeProvider
	.when('/', {
		templateUrl : 'index.html',
		id : 'home'

	}).when('/dashboard', {
		templateUrl : './partials/dashboard.html',
		id : 'dashboard'

	}).otherwise({
        redirectTo: '/'
	});

}]);