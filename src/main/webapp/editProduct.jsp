<%@include file="header.jsp"%>
<%@ page import="com.epam.shop.domain.Category"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="talk" class="talk">
	<div class="container">
		<div class="row ">
			<div class="col-md-6 ">
				<div class="wines">
					<h3>Create new Product</h3>
					<p>Enter data for a product</p>

				</div>
			</div>
			<div class="col-md-6 ">
				<form class="main_form " action="/online-shop/create-product?productId = ${product.id}">
					<div class="row">
						<div class="col-md-12 ">
							<input class="form_contril" placeholder="name " type="text"
								name="name" value="${product.name}">
						</div>

						<div class="col-md-12">
							<input class="form_contril" placeholder="description" type="text"
								name="description" value="${product.description}">
						</div>


						<c:forEach items="${Category.values()}" var="category">
							<div class="col-md-12 ">
								<input type="radio" id="${category}" name="category"
									value="${category}"
									<c:if test="${category eq product.category}">  checked </c:if> >
								<label for="${category}">${category}</label>
							</div>
						</c:forEach>


						<div class="col-md-12">
							<input class="form_contril" placeholder="price" type="number"
								name="price" value="${product.price}">
						</div>

						<div class="col-sm-12">
							<input class="send_btn" type="submit" value="Save">
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>



<%@include file="footer.jsp"%>