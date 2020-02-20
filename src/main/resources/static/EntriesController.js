var app = angular.module("EntriesManagement", []);
 
// Controller Part
app.controller("EntriesController", function($scope, $http) {
 
    $scope.entries = [];
    $scope.entriesForm = {
    		API: "",
    		Description: "",
    		Auth: "",
    		HTTPS: "",
    		Cors: "",
    		Link: "",
    		Category: "",
    };
    $scope.categories = ['Books', 'Animals'];
    $scope.category = "";
    // Now load the data from server
    _refreshEntriesData();
 

    // Private Method  
    // HTTP GET- get all entries collection
    // Call: http://localhost:8080/entries
    function _refreshEntriesData() {
        $http({
            method: 'GET',
            url: '/entries'
        }).then(
            function(res) { // success
                $scope.entries = res.data;                
            },
            function(res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }
    
    $scope.findEntries = function () {
        $http({
            method: 'GET',
            url: '/entries/' + $scope.category
        }).then(
            function(res) { // success
                $scope.entries = res.data;                
            },
            function(res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }
    $scope.resetSearch = function () {
    	_refreshEntriesData();
    	$scope.category = " ";
    }

 
    function _success(res) {
        _refreshEntriesData();        
    }
 
    function _error(res) {
        var data = res.data;
        var status = res.status;
        var header = res.header;
        var config = res.config;
        alert("Error: " + status + ":" + data);
    }
 });