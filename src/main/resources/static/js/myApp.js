'use strict'

var module = angular.module('myApp', []);
module.controller("myController", ["$scope","$http",

    function($scope,$http) {
	$scope.submitButton = 'Add';
	$scope.newEmpl = {};
	var loadAllEmpl = function(){
	$http.get('/springbootapp/empl/getAllEmpl').then(function(response) {
        $scope.emplList = response.data;
    });
	}
	loadAllEmpl();
	$scope.createEmpl = function(){
		$http.post('/springbootapp/empl/createEmpl',$scope.newEmpl).then(function (response) {
			$scope.newEmpl={};
			loadAllEmpl();
			$scope.submitButton = 'Add';
		});
	}
	$scope.deleteEmpl = function(id){
		$http.delete('/springbootapp/empl/deleteEmplById/'+id).then(function (response) {
			loadAllEmpl();
		});
	}
	$scope.updateEmpl = function(emp){
		$scope.submitButton = 'Update';
		var temp = angular.copy(emp);
		temp.dob = new Date(temp.dob);
		$scope.newEmpl = temp;
	}
	$scope.clear = function(){
		$scope.submitButton = 'Add';
		$scope.newEmpl = {};
	}
}]);