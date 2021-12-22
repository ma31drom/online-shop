<%@include file="parts/header.jsp"%>
<%@ page import="com.epam.shop.domain.Category"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="talk" class="talk">

	<div class="container">

		<c:forEach items="${products}" var="product">
			<div class="card my-2" style="width: 50rem;">
				<div class="raw my-1">
					<div class="cell">
						<img class="card-img-top"
							src="<c:url value="/product-photo?productImgId=${product.imgs[0].id}"/>"
							alt="Card image cap">
					</div>
				</div>

				<div class="card-body">
					<h5 class="card-title">${product.name}</h5>
					<p class="card-text">Category: ${product.category}</p>
					<p class="card-text">Price: ${product.price}</p>
					<a href="<c:url value = "/product/details?pId=${product.id}"/>" class="btn btn-primary">Details</a>
				</div>
			</div>
		</c:forEach>




	</div>
</div>



<%@include file="parts/footer.jsp"%>