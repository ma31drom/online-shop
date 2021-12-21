<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.epam.shop.domain.PersonRole"%>
<html lang="en">
<head>
<!-- basic -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- mobile metas -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="initial-scale=1, maximum-scale=1">
<!-- site metas -->
<title>drinker</title>
<meta name="keywords" content="">
<meta name="description" content="">
<meta name="author" content="">
<!-- bootstrap css -->
<link rel="stylesheet" href="/online-shop/css/bootstrap.min.css">
<!-- style css -->
<link rel="stylesheet" href="/online-shop/css/style.css">
<!-- Responsive-->
<link rel="stylesheet" href="/online-shop/css/responsive.css">
<!-- fevicon -->
<link rel="icon" href="/online-shop/images/fevicon.png" type="image/gif" />
<!-- Scrollbar Custom CSS -->
<link rel="stylesheet"
	href="/online-shop/css/jquery.mCustomScrollbar.min.css">
<!-- Tweaks for older IEs-->
<link rel="stylesheet"
	href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css"
	media="screen">
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
</head>
<!-- body -->
<body class="main-layout">
	<!-- loader  -->
	<div class="loader_bg">
		<div class="loader">
			<img src="/online-shop/images/loading.gif" alt="#" />
		</div>
	</div>
	<!-- end loader -->
	<!-- header -->
	<header>
		<!-- header inner -->
		<div class="head_top">
			<div class="header">
				<div class="container-fluid">
					<div class="row">
						<div class="col-xl-3 col-lg-3 col-md-3 col-sm-3 col logo_section">
							<div class="full">
								<div class="center-desk">
									<div class="logo">
										<a href="index.html"><img
											src="/online-shop/images/logo.png" alt="#" /></a>
									</div>
								</div>
							</div>
						</div>
						<div class="col-xl-9 col-lg-9 col-md-9 col-sm-9">
							<nav class="navigation navbar navbar-expand-md navbar-dark ">
								<button class="navbar-toggler" type="button"
									data-toggle="collapse" data-target="#navbarsExample04"
									aria-controls="navbarsExample04" aria-expanded="false"
									aria-label="Toggle navigation">
									<span class="navbar-toggler-icon"></span>
								</button>
								<div class="collapse navbar-collapse" id="navbarsExample04">
									<ul class="navbar-nav mr-auto">
										<c:if test="${sessionScope.user eq null}">
											<li class="nav-item"><a class="nav-link"
												href="/online-shop/registerPage.jsp">Register</a></li>
											<li class="nav-item"><a class="nav-link"
												href="/online-shop/loginPage.jsp">Login</a></li>
										</c:if>
										<c:if test="${sessionScope.user ne null}">
											<li class="nav-item">Hello ${sessionScope.user.login}!</li>
										</c:if>
										<c:if test="${sessionScope.user ne null}">
											<li class="nav-item"><a class="nav-link"
												href="/online-shop/logout">Logout</a></li>
										</c:if>
										<c:if
											test="${sessionScope.user ne null && PersonRole.ADMIN eq sessionScope.user.role}">
											<li class="nav-item"><a class="nav-link"
												href="/online-shop/createProduct.jsp"> Create
													product</a></li>
										</c:if>
									</ul>
								</div>
							</nav>
						</div>
					</div>
				</div>
			</div>