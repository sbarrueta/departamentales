var app = angular.module("miApp", []);

app.controller("miController", function($scope) {

	$scope.order = "customername";

	$scope.setOrder = function(order) {
		$scope.order = order;
	};

	$scope.signInFunction = function() {

		var username = $("#inputUserName").val();

		if (username.indexOf("@") < 0) {
			$("#errorDetails").text("Correo invalido!");
			$("#errorMessage").fadeIn("slow");
			$(".form-group").addClass("has-error");
			return;

		}

		
		/*
		var password = b64_md5($("#inputPassword").val());
		var token = "QCiTzbXCAYA3AvDgYN3MuBwY/1i89q6TfW7aVS1Av1c=";
		var digest = b64_md5(username + "," + password + "," + token);
		};*/

		var json = {
				"token" : token,
				"digest" : digest,
				"user" : {
					"username" : username,
					"password" : password
				}
		};
		$.ajax({
			url : "http://localhost:8080/departamentales/personaBO.damePersonaJSON(-410))",
			contentType : "application/json; charset=utf-8",
			data : JSON.stringify(json),
			method : "POST",
			datatype : "jsonp",
			success : function(response) {

				$("#infoMessage").hide();
				console.log(response);
				if (response.code === 0) {
					console.log(response['sessionId']);

					$("#username").text(response["data"].firstname);
					$scope.sessionId = response['sessionId'];
					$("#login").hide();
					$("#wrapper").show();

					$("#errorMessage").hide();
					$(".form-group").removeClass("has-error");
					cargar($scope);
				} else {
					$("#errorDetails").text(response.message);
					$("#errorMessage").fadeIn("slow");
					$(".form-group").addClass("has-error");
				}
			},
			error : function(xhr, status, error) {
				console.log(status + '; ' + error);
			}
		});
	};

	$scope.signOutFunction = function() {
		var json = {
			sessionId : $scope.sessionId
		};
		$.ajax({
			url : "http://localhost:8080/SRA/logout",
			contentType : "application/json; charset=utf-8",
			data : JSON.stringify(json),
			method : "POST",
			datatype : "jsonp",
			success : function(response) {
				$("#infoDetails").text(response.message);
				$("#infoMessage").fadeIn("slow");

				$("#login").show();
				$("#wrapper").hide();

			},
			error : function(xhr, status, error) {
				console.log(status + '; ' + error);
			}
		});
	};

});
