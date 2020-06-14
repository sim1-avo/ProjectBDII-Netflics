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
		<title>Analysis</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="<%=request.getContextPath()%>/template/assets/css/main.css" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/template/assets/css/sim1style.css">
	</head>
	<body>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.min.js"></script>

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
					<li><a href="Analysis.jsp">Analysis</a></li>
				</ul>
			</nav>

		<!-- Banner -->
		<!--
			Note: To show a background image, set the "data-bg" attribute below
			to the full filename of your image. This is used in each section to set
			the background image.
		-->
			

		<!-- One -->
			<section id="one" class="wrapper post bg-img" data-bg="public.jpg">
				<div class="inner">
					<article class="box">
						<header>
							<h2>Which audience is Netflics suitable for?</h2>
							<p>Discover it with us</p>
						</header>
						<div class="content">
						<div class="chart">
							<canvas id="myChart" width="200px" height="200px"></canvas>
							<script language="JavaScript" type="text/javascript" src="chartRating.js"></script>
						</div>
						<div class="legend">
						<ul>
						<li>PG-13 = Inappropriate for children 13 and under</li>
						<li>TV-PG = TV parental guidelines.</li>
						<li>TV-Y = Appropriate for children of all ages.</li>
						<li>TV-Y7 = Appropriate for children age 7 and older.</li>
						<li>TV-Y14 = Appropriate for children age 14 and older.</li>
						<li>TV-G = Appropriate for all ages.</li>
						<li>TV-MA = Appropriate for children age 17 and older and adults.</li>
						<li>TV-Y7-FV = Fantasy violence (only for children age 7 and older).</li>
						</ul>
						</div>
						
						</div>
					</article>
				</div>
				<a href="#two" class="more">Learn More</a>
			</section>

		<!-- Two -->
			<section id="two" class="wrapper post bg-img" data-bg="road.jpg">
				<div class="inner">
					<article class="box">
						<header>
							<h2>How many movies per year?</h2>
							<p>Discover it with us</p>
						</header>
						<div class="content">
							<div class="chart" id="chartYear">
							<canvas id="myChart2" width="200px" height="200px"></canvas>
							<script language="JavaScript" type="text/javascript" src="chartYear.js"></script>
							</div>
						</div>
					</article>
				</div>
				<a href="#three" class="more">Learn More</a>
			</section>

		<!-- Three -->
			<section id="three" class="wrapper post bg-img" data-bg="world.jpg">
				<div class="inner">
					<article class="box">
						<header>
							<h2>How many movies per country?</h2>
							<p>Discover it with us</p>
						</header>
						<div class="content" id="contentC">
							
							
							<div class="addcountry">
							<form id="formCountry">
							<div id="countries">
							<input type="text" id="country" class="country" required>
							</div>
							<div id="ok">
							<button type="button"  id="new">new</button>
							<button type="submit" id="submit">Search</button>
							</div>
							</form>
							</div>
							
							<div class="chart" id="chartYear">
							<canvas id="myChart3" width="200px" height="200px"></canvas>
							<script language="JavaScript" type="text/javascript" src="chartcountry.js"></script>
							</div>	
												
						</div>
					</article>
				</div>
				<a href="#four" class="more">Learn More</a>
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