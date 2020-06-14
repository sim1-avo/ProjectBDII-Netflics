<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<!--
	Road Trip by TEMPLATED
	templated.co @templatedco
	Released for free under the Creative Commons Attribution 3.0 license (templated.co/license)
-->
<html>
	<head>
		<title>Netflics</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="assets/css/main.css" />
	</head>
	<body>

		<!-- Header -->
			<header id="header">
				<div class="logo"><a href="index.jsp">Netflics <span>by GSD</span></a></div>
				<a href="#menu"><span>Menu</span></a>
			</header>

		<!-- Nav -->
			<nav id="menu">
				<ul class="links">
					<li><a href="index.jsp">Home</a></li>
					<li><a href="<%=request.getContextPath()%>/ServletAllMovies?tutto=si">Movies</a></li>
					<li><a href="<%=request.getContextPath()%>/template/Analysis.jsp">Analysis</a></li>
				</ul>
			</nav>

		<!-- Banner -->
		<!--
			Note: To show a background image, set the "data-bg" attribute below
			to the full filename of your image. This is used in each section to set
			the background image.
		-->
			<section id="banner" class="bg-img" data-bg="sipario.jpg">
			
			
				<div class="inner">
					<header>
						<h1>Netflics</h1>
					</header>
				</div>
				<a href="#one" class="more">Learn More</a>
			</section>

		<!-- One -->
			<section id="one" class="wrapper post bg-img" data-bg="sipario2.jpg">
				<div class="inner">
					<article class="box">
						<header>
							<h2>What is the purpose of the project?</h2>
						</header>
						<div class="content">
							<p>The purpose of this project is to search for films on Netflix to find out information such as cast, director, etc.
							<br>You can view statistical information on Netflix's rating, year and country.
							<br>For country statistical information, you can compare 3 countries to know the differences.</b></p>
						</div>
						<footer>
							<a href="<%=request.getContextPath()%>/ServletAllMovies?tutto=si" class="button alt">Look now</a>
						</footer>
					</article>
				</div>
			</section>







		<!-- Scripts -->
			<script src="<%=request.getContextPath()%>/template/assets/js/jquery.min.js"></script>
			<script src="<%=request.getContextPath()%>/template/assets/js/jquery.scrolly.min.js"></script>
			<script src="<%=request.getContextPath()%>/template/assets/js/jquery.scrollex.min.js"></script>
			<script src="<%=request.getContextPath()%>/template/assets/js/skel.min.js"></script>
			<script src="<%=request.getContextPath()%>/template/assets/js/util.js"></script>
			<script src="<%=request.getContextPath()%>/template/assets/js/main.js"></script>

	</body>
</html>