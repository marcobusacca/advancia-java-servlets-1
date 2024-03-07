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
				<div class="col-12 d-flex justify-content-center my-5">
					<form action="./cart" method="POST" class="w-50">
						<div class="input-group">
							<select class="form-control text-center py-3 my-3" name="selectedPizzaName">
								<c:forEach items="${sessionScope.pizzas}" var="pizza">
							    	<option value="${pizza.name}">${pizza.name} - ${pizza.getFormattedPrice()}&euro;</option>
								</c:forEach>
							</select>
						</div>
						<div class="input-group">
							<c:forEach items="${selectedPizzas}" var="selectedPizza">
									<input type="hidden" name="selectedPizzasNames" value="${selectedPizza.name}" />
							</c:forEach>
						</div>
						<button class="btn btn-success my-3 w-100">Aggiungi</button>
					</form>
				</div>
				<!-- FINE FORM DI SELEZIONAMENTO PIZZA -->
				<!---->
				<!-- LISTA PIZZE SELEZIONATE -->
				<div class="col-12 d-flex justify-content-center my-5">
					<table class="table table-hover w-50">
						<thead>
							<tr>
								<th scope="col">Nome</th>
								<th scope="col">Quantità</th>
								<th scope="col">Subtotale</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${selectedPizzasOrderItem}" var="pizzaOrderItem">
								<tr>
									<td>${pizzaOrderItem.pizza.name}</td>
									<td>${pizzaOrderItem.quantity}</td>
									<td>${pizzaOrderItem.getFormattedSubtotal()}&euro;</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<!-- FINE LISTA PIZZE SELEZIONATE -->
				<!---->
				<!-- FORM DI INVIO AL CHECKOUT -->
				<div class="col-12 d-flex justify-content-center my-3">
					<form action="./checkout" method="POST" class="w-50">
						<div class="input-group">
							<c:forEach items="${selectedPizzas}" var="selectedPizza">
									<input type="hidden" name="selectedPizzasNames" value="${selectedPizza.name}" />
							</c:forEach>
						</div>
						<button class="btn btn-primary w-100">Vai al pagamento</button>
					</form>
				</div>
				<!-- FINE FORM DI INVIO AL CHECKOUT -->
			</div>
		</div>
	</main>
	<!-- FINE MAIN -->
</body>
</html>