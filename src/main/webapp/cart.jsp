<%@include file="parts/header.jsp"%>
<%@ page import="com.epam.shop.domain.Category"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="talk" class="talk">
	<div class="container">
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">#</th>
					<th scope="col">Name</th>
					<th scope="col">Price</th>
					<th scope="col">Quantity</th>
					<th scope="col">Summ</th>
				</tr>
			</thead>
			<tbody>
				<c:set var="secCount" value="0" scope="page" />
				<c:set var="total" value="0" scope="page" />
				<c:forEach items="${productsInCart}" var="item">
					<tr>
						<th scope="row">${secCount}</th>
						<td>${item.name}</td>
						<td>${item.price}</td>
						<td>${item.quantity}</td>
						<td>${item.quantity * item.price}</td>
						<c:set var="total"
							value="${total + item.quantity * item.price}" scope="page" />
					</tr>
					<c:set var="secCount" value="${secCount + 1}" scope="page" />
				</c:forEach>
				<tr>
					<th scope="row"></th>
					<td></td>
					<td></td>
					<td>Total</td>
					<td>${total}</td>
				</tr>
			</tbody>
		</table>


	</div>
</div>



<%@include file="parts/footer.jsp"%>