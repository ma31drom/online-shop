<%@include file="parts/header.jsp"%>
<%@ page import="com.epam.shop.domain.Category"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="talk" class="talk">
	<div class="container">
		<table>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Category</th>
				<th>Action</th>
				<th>Photos</th>
				<th>Upload Photo</th>

			</tr>
			<c:forEach items="${products}" var="product">
				<tr>
					<td>${product.id}</td>
					<td>${product.name}</td>
					<td>${product.category}</td>
					<td><a href="/online-shop/editProduct?productId=${product.id}">Edit</a>
					</td>
					
								
					<td><c:forEach items="${product.imgs}" var="img">
					<img alt="Image not found"
								src="/online-shop/product-photo?productImgId=${img.id}" width="50" height="50">
								</c:forEach></td>
					<td>
						<form method="post"
							action="/online-shop/product-photo/upload?productId=${product.id}"
							enctype="multipart/form-data">
							<input class="form_contril" type="file" name="file"> <input
								class="send_btn" type="submit" value="Upload" />
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>

		<c:if test="${createdProduct ne null}">
			<div class="alert alert-success" role="alert">Product created
				with id ${createdProduct.id}</div>
		</c:if>
		<c:if test="${updatedProduct ne null}">
			<div class="alert alert-success" role="alert">Product updated
				with id ${createdProduct.id}</div>
		</c:if>
	</div>
</div>



<%@include file="parts/footer.jsp"%>