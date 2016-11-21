angular.module('app', ['ngRoute'])
	.config(function($routeProvider, $locationProvider) {

		$locationProvider.html5Mode(true);

		$routeProvider.when('/', {
			templateUrl: 'views/login.html',
			controller: 'LoginController'
		});

		$routeProvider.otherwise({redirectTo: '/'});

	});