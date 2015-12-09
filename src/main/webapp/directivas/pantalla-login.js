angular.module("app.directivas.pantalla.login",[])
	.directive("pantallaLogin",function(){
		return {
			restrict: "E",
			replace:true,
			templateUrl:"templates/pantalla-login.html",
			controller: function() {
				
			}
		};
	});