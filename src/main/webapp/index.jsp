<%@include file="header.jsp"%>

<!-- end header inner -->
<!-- end header -->
<!-- banner -->
<section class="banner_main">
	<div class="container">
		<div class="row">
			<div class="col-md-10 offset-md-1">
				<div class="text-img">
					<figure>
						<img src="/online-shop/images/box_img.png" alt="#" />
					</figure>
				</div>
			</div>
			<div class="col-md-12">
				<div class="text-bg">
					<h1>Spent the best time with best wine</h1>
					<a href="#">Read More</a>
				</div>
			</div>

		</div>
	</div>
</section>
</div>
</header>
<!-- end banner -->
<!-- store -->
<div class="store">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="titlepage">
					<h2>
						Best Wines <span class="red">In Our Store</span>
					</h2>
					<p>It is a long established fact that a reader will be
						distracted by the readable content of a page when looking at its
						layout. The point of using Lorem</p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="black_bg">
					<div class="row d_flex">
						<div class="col-md-4">
							<div class="store_box ">
								<figure>
									<img src="/online-shop/images/store_img1.png" alt="#" />
								</figure>
							</div>
						</div>
						<div class="col-md-8">
							<div class="store_box ">

								<h3>Black Wine</h3>
								<p>It is a long established fact that a reader will be
									distracted by the readable content of a page when looking at
									its layout. The point of using Lorem Ipsum is that it has a
									more-or-less normal distribution of letters, as opposed to
									using 'Content here, content here', making it look like
									readable English. Many desktop publishing packages</p>
								<a class="read_more" href="#">Read more</a>
							</div>

						</div>
					</div>
				</div>
				<div class="black_bg">
					<div class="row d_flex">
						<div class="col-md-4">
							<div class="store_box ">
								<figure>
									<img src="/online-shop/images/store_img2.png" alt="#" />
								</figure>
							</div>
						</div>
						<div class="col-md-8">
							<div class="store_box ">

								<h3>Red Wine</h3>
								<p>It is a long established fact that a reader will be
									distracted by the readable content of a page when looking at
									its layout. The point of using Lorem Ipsum is that it has a
									more-or-less normal distribution of letters, as opposed to
									using 'Content here, content here', making it look like
									readable English. Many desktop publishing packages</p>
								<a class="read_more" href="#">Read more</a>
							</div>

						</div>
					</div>
				</div>
				<div class="black_bg">
					<div class="row d_flex">
						<div class="col-md-4">
							<div class="store_box ">
								<figure>
									<img src="/online-shop/images/store_img3.png" alt="#" />
								</figure>
							</div>
						</div>
						<div class="col-md-8">
							<div class="store_box ">

								<h3>White Wine</h3>
								<p>It is a long established fact that a reader will be
									distracted by the readable content of a page when looking at
									its layout. The point of using Lorem Ipsum is that it has a
									more-or-less normal distribution of letters, as opposed to
									using 'Content here, content here', making it look like
									readable English. Many desktop publishing packages</p>
								<a class="read_more" href="#">Read more</a>
							</div>

						</div>
					</div>
				</div>
			</div>

		</div>
	</div>
</div>
<!-- end store -->

<!-- Testimonial -->
<div id="" class="Testimonial">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="titlepage">
					<h2>Our Products</h2>

				</div>
			</div>
		</div>
	</div>
</div>
<div id="myCarousel" class="carousel slide Testimonial_carousel"
	data-ride="carousel">

	<c:forEach items="${products}" var="product">


		<ol class="carousel-indicators">

			<c:forEach items="${product.imgs}" var="img">
				<li data-target="#myCarousel" data-slide-to="${img.id}"
					class="active"></li>
			</c:forEach>
		</ol>

		<c:forEach items="${product.imgs}" var="img">
			<li data-target="#myCarousel" data-slide-to="${img.id}"
				class="active"></li>
		</c:forEach>

		<div class="carousel-inner">

			<c:forEach items="${product.imgs}" var="img">

				<div class="carousel-item active">
					<div class="container">
						<div class="carousel-caption">
							<div class="row d_flex">
								<div class="col-md-3">
									<div class="Testimonial_box">
										<i><img
											src="/online-shop/product-photo?productImgId=${img.id}" alt=" #" /></i>
									</div>
								</div>
								<div class="col-md-9">
									<div class="Testimonial_box">
										<h4>${product.name}</h4>
										<h5>${product.description}</h5>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

			</c:forEach>




		</div>
		<a class="carousel-control-prev" href="#myCarousel" role="button"
			data-slide="prev"> <i class="fa fa-long-arrow-left"
			aria-hidden="true"></i>
		</a>
		<a class="carousel-control-next" href="#myCarousel" role="button"
			data-slide="next"> <i class="fa fa-long-arrow-right"
			aria-hidden="true"></i>
		</a>


	</c:forEach>



</div>

</div>




<%@include file="footer.jsp"%>