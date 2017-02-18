var regAng = angular.module('regAng', []);

regAng.controller('restController',function($scope, $http){
	      $scope.submitUser = function() {
                    var url = "";
                    $scope.myvalue = false;
                    $scope.nyvalue = false;
                    url = './rest/UserService/register';
                    var user1 = new Object();
                    user1.fName = $scope.fName;
                    user1.lName = $scope.lName;
                    user1.email = $scope.email;
                    user1.pass = $scope.pwd;
                    var user = angular.toJson(user1);
                    var config = {
                            headers : {
                                'Content-Type': 'application/json'
                            }
                        }
                    var response = $http.post(url, user, config)
                    response.success(function(data, status) {
                	      console.log("Inside create operation..."
                	       + angular.toJson(data, false) + ", status=" + status);
                	      $scope.myvalue = true;
                	      $scope.nyvalue = false;
                	      $scope.resetSearch();
                	    });
                	    response.error(function(user, status) {
                	    	$scope.nyvalue = true;;
                	    })
                };
                
                $scope.clearUser = function(){
                	$scope.resetSearch();
                }
                
                $scope.resetSearch = function(){
                	$scope.fName = null;
                	$scope.lName = null;
                	$scope.email = null;
                	$scope.pwd = null;
                }
}); 	