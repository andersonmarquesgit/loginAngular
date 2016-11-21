<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br" ng-app="app">
	<head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width">
        <title>Login AngularJS</title>
        <link rel="stylesheet" href="resources/css/bootstrap.min.css">
        <link rel="stylesheet" href="resources/css/bootstrap-theme.min.css">
        <script src="resources/js/lib/angular.min.js"></script>
        <script src="resources/js/lib/angular-route.min.js"></script>
        <script src="resources/js/main.js"></script>
        <script src="resources/js/controllers/fotos-controller.js"></script>
    </head>
	<body ng-controller="FotosController">
	    <div class="container">
	        <h1 class="text-center">Home</h1>
	
	         <img class="img-responsive center-block" src="{{foto.url}}" alt="{{foto.titulo}}" width="304" height="236">
	
	    </div><!-- fim container -->
	</body>
</html>