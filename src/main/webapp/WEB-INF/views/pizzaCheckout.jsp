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
				<!-- LISTA PIZZE SELEZIONATE -->
				<div class="col-12 d-flex justify-content-center my-3">
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
						<tfoot>
							<tr>
								<td class="fw-bold pt-5">Totale</td>
								<td class="fw-bold text-end pt-5" colspan="2">${formattedTotalPrice}&euro;</td>
							</tr>
						</tfoot>
					</table>
				</div>
				<!-- FINE LISTA PIZZE SELEZIONATE -->
				<!---->
				<!-- BOTTONE RITORNA ALLA HOME -->
				<div class="col-12 d-flex justify-content-center my-3">
					<a href="/java-servlets-1" class="btn btn-primary w-50">Torna alla home</a>
				</div>
				<!-- FINE BOTTONE RITORNA ALLA HOME -->
			</div>
		</div>
	</main>
	<!-- FINE MAIN -->
</body>
</html>