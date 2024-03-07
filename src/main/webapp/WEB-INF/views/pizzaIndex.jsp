<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	<title>java-servlets</title>
</head>
<body>
	<!-- PIZZA HEADER -->
	<%@ include file="pizzaHeader.jsp" %>
	<!-- FINE PIZZA HEADER -->
	<!---->
	<!-- MAIN -->
	<main class="overflow-auto">
		<div class="container d-flex justify-content-center align-items-center" style="height: calc(100vh - 100px);">
			<div class="row w-100">
				<!-- FORM DI SELEZIONAMENTO PIZZA -->
				<c:if test="${!empty sessionScope.pizzas}">
					<div class="col-12 d-flex justify-content-center">
						<form action="./cart" method="POST" class="w-50">
							<div class="input-group">
								<select class="form-control text-center py-3 my-3" name="selectedPizzaName">
									<c:forEach items="${sessionScope.pizzas}" var="pizza">
								    	<option value="${pizza.name}">${pizza.name} - ${pizza.getFormattedPrice()}&euro;</option>
									</c:forEach>
								</select>
							</div>
							<button class="btn btn-primary my-3 w-100">Ordina</button>
						</form>
					</div>
				</c:if>
				<!-- FINE FORM DI SELEZIONAMENTO PIZZA -->
				<!---->
				<!-- MESSAGGIO DI ERRORE -->
				<c:if test="${empty sessionScope.pizzas}">
					<div class="col-12 text-center border border-black py-5">
						<span>Nessuna pizza disponibile</span>
					</div>
				</c:if>
				<!-- FINE MESSAGGIO DI ERRORE -->
			</div>
		</div>
	</main>
	<!-- FINE MAIN -->
</body>
</html>