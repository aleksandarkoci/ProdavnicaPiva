var testApp = angular.module('testApp', ['ngRoute']);

testApp.config(['$routeProvider', function($routeProvider) {
    $routeProvider
    	.when('/', {
			templateUrl : '/static/app/html/partial/home.html'
		})
		.when('/piva', {
			templateUrl : '/static/app/html/partial/piva.html'
		})
		.when('/piva/edit/:aid', {
            templateUrl : '/static/app/html/partial/edit-piva.html'
        })
		.otherwise({
            redirectTo: '/'
        });

        
}]);