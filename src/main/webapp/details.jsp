<%@include file="parts/header.jsp"%>
<%@ page import="com.epam.shop.domain.Category"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="talk" class="talk">

	<div class="container">

		<div class="card" style="width: 50rem;">
			<c:forEach items="${product.imgs}" var="img">
				<div class="raw">
					<div class="cell">
						<img class="card-img-top" alt="Image not found"
							src="/online-shop/product-photo?productImgId=${img.id}"
							width="500px">
					</div>
				</div>
			</c:forEach>

			<div class="card-body">
				<h5 class="card-title">${product.name}</h5>
				<p class="card-text">Description: ${product.description}</p>
				<p class="card-text">Category: ${product.category}</p>
				<p class="card-text">Price: ${product.price}</p>


				<form class="main_form " action="<c:url value = "/add-to-cart"/>">
					<div class="row  mx-auto">
						<div class="col-md-2 mx-auto">
							<input class="form_contril" placeholder="Quantity" type="number"
								name="quant">
								<input class="form_contril" placeholder="pid" type="text"
								name="pid" value="${product.id}" hidden="true">
						</div>
						<div class="col-sm-2">
							<input class="send_btn" type="submit" value="To Cart">
						</div>
					</div>
				</form>

			</div>
		</div>




	</div>
</div>



<%@include file="parts/footer.jsp"%>