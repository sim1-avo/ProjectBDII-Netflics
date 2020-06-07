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
		<title>Generic - Netflics</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="<%=request.getContextPath()%>/template/assets/css/main.css" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/template/assets/css/gibbo.css">
	</head>
	<body class="subpage">

		<!-- Header -->
			<header id="header" class="alt">
				<div class="logo"><a href="<%=request.getContextPath()%>/template/index.jsp">Netlics <span>by GSD</span></a></div>
				<a href="#menu"><span>Menu</span></a>
			</header>

		<!-- Nav -->
			<nav id="menu">
				<ul class="links">
					<li><a href="<%=request.getContextPath()%>/template/index.jsp">Home</a></li>
					<li><a href="ServletAllMovies?tutto=si">Generic</a></li>
					<li><a href="elements.html">Elements</a></li>
				</ul>
			</nav>
		<!-- Footer -->
			<footer id="footer">
				<div class="inner">

					<h2>Filter</h2>

					<form action="<%=request.getContextPath()%>/ServletFilter" method="post">
											
						<div class="4u 12u$(small)">
						<label for="type">Type</label>
							<input type="radio" id="movies" name="type" value="Movie" >
								<label for="movies">Movies</label>
							<input type="radio" id="tvshows" name="type" value="TV Show" >
								<label for="tvshows">TV Shows</label>
						</div>
						<div class="field half">
							<label for="title">Title</label>
							<input name="title" id="title" type="text" placeholder="Title">
						</div>
						<div class="field half">
							<label for="director">Director</label>
							<input name="director" id="director" type="text" placeholder="Director">
						</div>
						<div class="field half">
							<label for="cast">Cast</label>
							<input name="cast" id="cast" type="text" placeholder="Cast">
						</div>
						<div class="field half">
							<label for="country">Country</label>
							<input name="country" id="country" type="text" placeholder="Country">
						</div>
						<div class="field half">
							<label for="year">Release Year</label>
							<input type="number" min="1925" id="year" name="year" placeholder="Year" >
						</div>
						<div class="field half">
							<label for="date">Date added</label>
							<input type="date" id="date" name="date" placeholder="date" >
						</div>
						<div class="4u 12u$(small)">
						<label for="rating">Rating</label>
							<input type="radio" id="ma" name="rating" value="MA" >
								<label for="ma">MA</label>
							<input type="radio" id="tv14" name="rating" value="TV-14" >
								<label for="tv14">TV-14</label>
							<input type="radio" id="pg" name="rating" value="PG" >
								<label for="pg">PG</label>
							<input type="radio" id="r" name="rating" value="R" >
								<label for="r">R</label>
							<input type="radio" id="other" name="rating" value="Other" >
								<label for="other">Other</label>
						</div>
						<div class="field half">
							<label for="duration">Duration</label>
							<input name="duration" id="duration" type="text" placeholder="Duration">
						</div>
						<div class="field half">
							<label for="category">Category</label>
							<input name="category" id="category" type="text" placeholder="Category">
						</div>
						
						<ul class="actions">
							<li><input value="Send" class="button alt" name="submit" type="submit"></li>
						</ul>
					</form>


				</div>
			</footer>
		<!-- Content -->
		<!--
			Note: To show a background image, set the "data-bg" attribute below
			to the full filename of your image. This is used in each section to set
			the background image.
		-->
			<section id="post" class="wrapper bg-img" data-bg="cinema.jpg" style="background-image: url(template/images/cinema.jpg)">
				<div class="inner">
					<article class="box">
						<div class="content">
						<%String query=(String)request.getAttribute("query");
						%>
						<%=query%>
						</div>
					</article>
				</div>
			</section>



		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>

	</body>
</html>