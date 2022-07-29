<%@page import="com.tamagotchi.controller.TamagoController"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>MyTamago</title>
		
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
	</head>
	<body id="bdy">
		<script type="text/javascript">
			var isDark = true;
			function myFunc(){
				let str = isDark? "black" : "white";
				document.getElementById('bdy').style.backgroundColor=str; 
				isDark = isDark? false : true;	
			}
		</script>
		<div class="container">
  			<div class="row justify-content-md-center">
  				<div class="row align-items-center justify-content-center" style="height: 200px; width: 150px; margin-top: 50px">
  					<img src="/images/1956988_18ea5.gif">
  				</div>
  			</div>
  			<div class="h-100 d-flex align-items-center justify-content-center">
 				<button class="btn btn-primary" style="background-color: rgb(0,255,50);">Nutri</button>
	  			<button class="btn btn-primary" style="background-color: rgb(0,0,250);">Passeggia</button>
	  			<button class="btn btn-primary" style="background-color: pink">Accarezza</button>
	  			<button class="btn btn-primary" style="background-color: silver;">Stato</button>
	  			<button class="btn btn-primary" style="background-color: gold">Tempo >></button>
	  		</div>
	  		<button class="btn btn-primary" style="background-color: gold" onclick="myFunc()">Theme</button>
		</div>
	</body>
</html>