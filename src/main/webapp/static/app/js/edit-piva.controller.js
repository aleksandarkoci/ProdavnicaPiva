var testApp = angular.module('testApp');

testApp.controller('editPivaCtrl', function ($scope, $http, $routeParams, $location) {

	var url_base_piva = "http://localhost:8080/api/piva";
	var url_base_pivare = "http://localhost:8080/api/pivare";
	var url_base_vrste_piva = "http://localhost:8080/api/vrste_piva";

	var id = $routeParams.aid;

	$scope.pivo = {};
	$scope.pivo.id = "";
	$scope.pivo.naziv = "";
	$scope.pivo.procenatAlc = "";
	$scope.pivo.ibu = "";
	$scope.pivo.stanje = "";
	$scope.pivo.vrstaId = 0;
	$scope.pivo.pivaraId = 0;

	var getPiva = function() {
		$http.get (url_base_piva + '/' + id).then(
			function success(data) {
				$scope.pivo = data.data
				console.log(data);
			},
			function error(data) {
				console.log(data);
				alert('Nesto je pogresno!');
			}
		);
	}
	getPiva();

	$scope.got_pivare = false;
	$scope.got_vrste = false;

	var getPivare = function() {
		$http.get (url_base_pivare).then(
			function success(data) {
				$scope.pivare = data.data
				$scope.got_pivare = true;
				console.log(data);
			},
			function error(data) {
				console.log(data);
			}
		);
	}
	getPivare();
	

	var getVrste = function() {
		$http.get (url_base_vrste_piva).then(
			function success(data) {
				$scope.vrste = data.data
				$scope.got_vrste = true;
				console.log(data);
			},
			function error(data) {
				console.log(data);
			}
		);
	}
	getVrste();

	$scope.editPivo = function(id) {
		$http.put (url_base_piva + '/' +$scope.pivo.id, $scope.pivo).then(
			function success(data) {
				$location.path('/piva');
				console.log(data);
			},
			function error(data) {
				console.log(data);
				alert('Nesto je pogresno!');
			}
		);
	}
});