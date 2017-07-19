var testApp = angular.module('testApp');

testApp.controller('pivaCtrl', function ($scope, $http, $location) {

	var url_base_piva = "http://localhost:8080/api/piva";
	var url_base_pivare = "http://localhost:8080/api/pivare";
	var url_base_vrste_piva = "http://localhost:8080/api/vrste_piva";

// #############################################################################
	
	$scope.piva = [];
	$scope.pivare = [];
	$scope.vrste = [];

// #############################################################################
	
	$scope.pageNum = 0;
	$scope.totalPages = 0;

// #############################################################################
	
	$scope.pivo = {};
	$scope.pivo.id = "";
	$scope.pivo.naziv = "";
	$scope.pivo.procenatAlc = "";
	$scope.pivo.ibu = "";
	$scope.pivo.stanje = "";
	$scope.pivo.vrstaId = 0;
	$scope.pivo.pivaraId = 0;

// #############################################################################

	$scope.trazenoPivo = {};
	$scope.trazenoPivo.naziv = "";
	$scope.trazenoPivo.ibuOd = "";
	$scope.trazenoPivo.ibuDo = "";
	$scope.trazenoPivo.pivara = 0;

	var getPiva = function() {

		var config = { params: {}};

		config.params.pageNum = $scope.pageNum;

		if($scope.trazenoPivo.naziv != "") {
			config.params.naziv = $scope.trazenoPivo.naziv;
		}

		if($scope.trazenoPivo.ibuOd != "") {
			config.params.ibuOd = $scope.trazenoPivo.ibuOd;
		}

		if($scope.trazenoPivo.ibuDo != "") {
			config.params.ibuDo = $scope.trazenoPivo.ibuDo;
		}

		if($scope.trazenoPivo.pivara != 0) {
			config.params.pivara = $scope.trazenoPivo.pivara;
		}

		$http.get (url_base_piva, config).then(
			function success(data) {
				$scope.piva = data.data;
				$scope.totalPages = data.headers('totalPages');
				console.log(data);
			},
			function error (data) {
				console.log(data);
			}
		);
	};

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
	};
	

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
	};
	getPiva();
	getPivare();
	getVrste();
	
	

// #############################################################################

	$scope.saveOrEdit = function(id) {

		if(id == "" || id == null) {
			addPivo();
		} else {
			editPivo();
		}
	}

	function addPivo() {
		if($scope.pivo.naziv != "" && !isNaN($scope.pivo.procenatAlc) &&
			!isNaN($scope.pivo.ibu) && $scope.pivo.stanje != "" &&
			$scope.pivo.vrsta != 0 && $scope.pivo.pivara != 0) {

			$http.post (url_base_piva, $scope.pivo).then(
				function success(data) {
					alert('Succsess! Dodavanje uspesno!');
					$scope.pivo.naziv = "";
					$scope.pivo.procenatAlc = "";
					$scope.pivo.ibu = "";
					$scope.pivo.stanje = "";
					$scope.pivo.vrsta = 0;
					$scope.pivo.pivara = 0;
					console.log(data);
					getPiva();
				},
				function error(data) {
					console.log(data);
					alert('Nesto je pogresno!')
				}
			);
		}
	}

	function editPivo() {
		$http.put (url_base_piva + '/' + $scope.pivo.id, $scope.pivo).then(
			function success(data) {
				$scope.pivo.id = "";
				$scope.pivo.naziv = "";
				$scope.pivo.procenatAlc = "";
				$scope.pivo.ibu = "";
				$scope.pivo.stanje = "";
				$scope.pivo.vrsta = 0;
				$scope.pivo.pivara = 0;
				console.log(data);
				getPiva();
			},
			function error(data) {
				console.log(data);
				alert('Nesto je pogresno!')
			}
		);
	}

// #############################################################################
     
 	$scope.napred = function(){
        if($scope.pageNum < $scope.totalPages - 1){
            $scope.pageNum = $scope.pageNum + 1;
            getPiva();
        }
    };
    
    $scope.nazad = function(){
        if($scope.pageNum > 0) {
            $scope.pageNum = $scope.pageNum - 1;
            getPiva();
        }
    };

// #############################################################################

 	$scope.search = function(){
        $scope.pageNum = 0;
        getPiva();                                 
    }

// #############################################################################

 	$scope.delete = function(id){        
        $http.delete(url_base_piva + "/" + id).then( 
            function success(data){
                console.log(data);
                getPiva();                           
            },
            function error(data){
                alert('Nesto je pogresno!');
                console.log(data);
            }
        );
    }

// #############################################################################

 	$scope.editInPage = function(id){
        $http.get(url_base_piva + "/" + id).then(     
            function success(data){
                $scope.pivo = data.data;         
                console.log(data);
            },
            function error(data){
                alert('Nesto je pogresno!');
                console.log(data);
            }
        );
    }

// #############################################################################

    $scope.editNekretnineInSinglePage = function(id){
        $location.path("/piva/edit/" +id);            
    }

// #############################################################################

	$scope.kupi = function(id){
        $http.put(url_base_piva + '/kupi/' + id).then(
            function success(data){
                getPiva();
                alert('Uspesno kupljeno pivo!');
                console.log(data);
            },
            function error(data){
                alert('Trenutno stanje je nula!');
                console.log(data);
            }
        );
    }

// #############################################################################
	
});	