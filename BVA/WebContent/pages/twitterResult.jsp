<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html class="no-js">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<title>Brand Value Analysis</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width">


<link rel="stylesheet" href="../css/normalize.css">
<link rel="stylesheet" href="../css/main.css">
<link rel="stylesheet" href="../css/solido.css">
<link rel="stylesheet" href="../css/isotope.css">
<link rel="stylesheet" href="../css/responsive.css">
<link rel="stylesheet" type="text/css"
	href="../css/vegas/jquery.vegas.css">
<link rel="stylesheet" href="../css/popup/magnific-popup.css">
<link rel="stylesheet"
	href="../js/superslides-0.6.2/dist/stylesheets/superslides.css">


<link rel="stylesheet" href="../css/color/dark.css">
<link rel="stylesheet" href="../css/color/black.css">
<link rel="stylesheet" href="../css/color/green.css">
<link rel="stylesheet" href="../css/color/red.css">
<link rel="stylesheet" href="../css/color/yellow.css">
<link rel="stylesheet" href="../css/color/purple.css">
<link rel="stylesheet" href="../css/color/turquoise.css">
<link rel="stylesheet" href="../css/color/orange.css">
<link rel="stylesheet" href="../css/color/blue.css">

<script src="../js/vendor/modernizr-2.6.2.min.js"></script>
<script src="http://fast.fonts.net/jsapi/3dca1e78-579f-4502-8da9-3eb91453e0dc.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
		<script type="text/javascript">

var arr = <%=session.getAttribute("TwitterResult") %>;
console.log(arr);
//Printing Pie1 Sentiment Scores for Chart
var pie1positive = parseFloat(arr.positive);
var pie1negative = parseFloat(arr.negative);
var pie1neutral = parseFloat(arr.neutral);

console.log(pie1neutral);
$(setTimeout(function () {
  $('#container').highcharts({
      chart: {
          plotBackgroundColor: null,
          plotBorderWidth: null,
          plotShadow: false
      },
      title: {
          text: 'Twitter Overall Sentiment  '
      },
      tooltip: {
  	    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
      },
      plotOptions: {
          pie: {
              allowPointSelect: true,
              cursor: 'pointer',
              dataLabels: {
                  enabled: true,
                  format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                  style: {
                      color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                  }
              }
          }
      },
      series: [{
          type: 'pie',
          name: 'Sentiment',
          data: [
              ['Positive',   pie1positive],
              ['Negative',   pie1negative],
              ['Neutral',    pie1neutral],
          ]
      }]
  });
},3000));

$(setTimeout(function () {
    $('#container4').highcharts({
        chart: {
            type: 'scatter',
            zoomType: 'xy'
        },
        title: {
            text: 'Confidence Values'
        },
        subtitle: {
            text: 'Source: RealTime Tweets/Reviews'
        },
        xAxis: {
            title: {
                enabled: true,
                text: 'Tweet/Review ID'
            },
            startOnTick: true,
            endOnTick: true,
            showLastLabel: true
        },
        yAxis: {
            title: {
                text: 'Confidence Value'
            }
        },
        legend: {
            layout: 'vertical',
            align: 'left',
            verticalAlign: 'top',
            x: 400,
            y: 30,
            floating: true,
            backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF',
            borderWidth: 1
        },
        plotOptions: {
            scatter: {
                marker: {
                    radius: 10,
                    states: {
                        hover: {
                            enabled: true,
                            lineColor: 'rgb(100,100,100)'
                        }
                    }
                },
                states: {
                    hover: {
                        marker: {
                            enabled: false
                        }
                    }
                },
                tooltip: {
                    headerFormat: '<b>{series.name}</b><br>',
                    pointFormat: '{point.x} tweet, {point.y} '
                }
            }
        },
        series: [{
            name: 'Positive',
            color: 'rgba(223, 83, 83, .5)',
            data: [[1, 0.0656], [4, 0.956], [6, 0.726], [8, 0.156], [10, 0.356]]

        }, {
            name: 'Negative',
            color: 'rgba(119, 152, 191, .5)',
            data: [[2, -0.656], [3, -0.956], [5, -0.156], [7, -0.456], [9, -0.766]]
        }]
    });
},3000));
</script>

</head>
<body>

	<div id="mask">
		<div class="loader">
			<img src="../img/loading.gif" alt='loading'>
		</div>
	</div>

	<div id="anchor1"></div>

	<div id="slides-1">
		<div class="overlay"></div>
		<div class="slides-container">
			<img src="../img/slider/01.jpg" alt=""> <img
				src="../img/slider/02.jpg" alt=""> <img
				src="../img/slider/03.jpg" alt=""> <img
				src="../img/slider/04.jpg" alt="">
		</div>
		<nav class="slides-navigation">
			<a href="#" class="next"></a> <a href="#" class="prev"></a>
		</nav>
	</div>


	<div class="main-title">
		<div class="title-container">
			<div class="welcome">Hello</div>
			<ul>
				<li class="t-current">We are Elevate</li>
				<li>We Are Smart</li>
				<li>We Are Fresh</li>
			</ul>
			<div class="spacer"></div>
			<!--<a href="#anchor2"><div class="slider-logo">Get Started</div></a>-->
			<div class="second-title">
				We help you analyze your brand's impact on social media. <br>
				We help you bolster your position into your customer's mind. <br>
				Our analytics help you elevate your brand!
			</div>
			<a href="#anchor2"><div class="buy-logo">
					Get Started<span></span>
				</div></a>
		</div>
	</div>
	<div id="logx"></div>
	<header class="header">
		<div class="logo">
			<span><span></span></span>Elevate
		</div>
		<nav id="nav2" role="navigation">
			<a class="jump-menu" title="Show navigation">Show navigation</a>
			<ul>
				<li class="current"><a href="#anchor1">home</a></li>
				<li><a href="#anchor2">about</a></li>
				<li><a href="#anchor3">team</a></li>
				<li><a href="#anchor4">services</a></li>
				<li><a href="#anchor5">contact</a></li>
			</ul>
		</nav>
		<nav class="menu">
			<ul id="nav">
				<li class="current"><a href="#anchor1">home</a></li>
				<li><a href="#anchor2">about</a></li>
				<li><a href="#anchor3">team</a></li>
				<li><a href="#anchor4">services</a></li>
				<li><a href="#anchor5">contact</a></li>
			</ul>
		</nav>
	</header>

	<article class="content light">
		<div class="full">
			<section class="half car-show-1">
				<header class="title-one">Brand Value Analysis</header>
				<div class="title-two">Masters Project - SJSU</div>
				<div class="show hideme dontHide">
					<div class="caroussel">
						<div class="caroussel-list">
							<div class="car-img">
								<img src="../img/caroussel/caroussel-01.jpg" alt='img'>
							</div>

						</div>
					</div>

				</div>
				<div class="controller">
					<ul>
					</ul>
				</div>
			</section>
			<section class="half">
				<header class="title-one">The Project</header>
				<div class="title-two">About Us</div>
				<div class="half-content hideme dontHide">
					We are <b>ELEVATE</b>. We analyze your 'brand value' on Twitter.
					Using Amazon and Yelp APIs we also analyze your competitors.
					Keeping in mind the stingent competition you face, we help you
					survive it by helping you keep an eye on them.
				</div>
			</section>
		</div>
		<div class="clear"></div>
	</article>
	<div class="clear"></div>

	<article id=anchor3 class="content dark">
		<header class="title one">Our Team</header>
		<div class="spacer"></div>
		<div class="title two">We are a fun mix of software developers
			with a great passion for all things creative.</div>
		<section class="team-box">
			<div class="s-container team-grid">
				<div class="t-list">

					<div class="t-element hideme dontHide">
						<div class="t-photo">
							<div class="image-hover-overlay"></div>
							<a class="f-category" href="#"></a> <a
								href="mailto:rakesh.ranjan@sjsu.edu"><div
									class="portfolio-meta">
									<div>rakesh.ranjan@sjsu.edu</div>
								</div></a> <img src="../img/team/ranjan.jpg" alt='img'>
						</div>
						<div class="t-data">
							<div class="t-name">Rakesh Ranjan</div>
							<div class="t-info">Project Supervisor</div>
							<div class="t-spacer"></div>
							<div class="t-social">
								<div class="in-social">
									<a href="#"><div class="ts facebook"></div></a> <a href="#"><div
											class="ts twitter"></div></a> <a href="#"><div
											class="ts tumblr"></div></a>
								</div>
							</div>
						</div>
					</div>
					<div class="t-element hideme dontHide">
						<div class="t-photo">
							<div class="image-hover-overlay"></div>
							<a class="f-category" href="#"></a> <a
								href="mailto:kelkarpranav0412@gmail.com"><div
									class="portfolio-meta">
									<div>kelkarpranav0412@gmail.com</div>
								</div></a> <img src="../img/team/team-01.jpg" alt='img'>
						</div>
						<div class="t-data">
							<div class="t-name">Pranav Kelkar</div>
							<div class="t-info">Developer</div>
							<div class="t-spacer"></div>
							<div class="t-social">
								<div class="in-social">
									<a href="#"><div class="ts facebook"></div></a> <a href="#"><div
											class="ts twitter"></div></a> <a href="#"><div
											class="ts tumblr"></div></a>
								</div>
							</div>
						</div>
					</div>
					<div class="t-element hideme dontHide">
						<div class="t-photo">
							<div class="image-hover-overlay"></div>
							<a class="f-category" href="#"></a> <a
								href="mailto:d.rupeshkumar@gmail.com"><div
									class="portfolio-meta">
									<div>d.rupeshkumar@gmail.com</div>
								</div></a> <img src="../img/team/team-02.jpg" alt='img'>
						</div>
						<div class="t-data">
							<div class="t-name">Rupesh Dabbir</div>
							<div class="t-info">Developer</div>
							<div class="t-spacer"></div>
							<div class="t-social">
								<div class="in-social">
									<a href="#"><div class="ts facebook"></div></a> <a href="#"><div
											class="ts twitter"></div></a> <a href="#"><div
											class="ts tumblr"></div></a>
								</div>
							</div>
						</div>
					</div>
					<div class="t-element hideme dontHide">
						<div class="t-photo">
							<div class="image-hover-overlay"></div>
							<a class="f-category" href="#"></a> <a
								href="mailto:vaneetsp@gmail.com"><div class="portfolio-meta">
									<div>vaneetsp@gmail.com</div>
								</div></a> <img src="../img/team/team-03.jpg" alt='img'>
						</div>
						<div class="t-data">
							<div class="t-name">Vaneet Singh</div>
							<div class="t-info">Developer</div>
							<div class="t-spacer"></div>
							<div class="t-social">
								<div class="in-social">
									<a href="#"><div class="ts facebook"></div></a> <a href="#"><div
											class="ts twitter"></div></a> <a href="#"><div
											class="ts tumblr"></div></a>
								</div>
							</div>
						</div>
					</div>

				</div>
			</div>
		</section>
		<div class="clearfix"></div>
	</article>
	<article class="content light">
		<section class="full">
			<div class="title-full-one">enjoy them</div>
			<div class="title-full-two">Some Fun Facts</div>
			<div class="f-container">
				<div class="f-element hideme dontHide">
					<div class="f-ico s-one"></div>
					<div class="milestone-counter" data-perc="3512">
						<span class="milestone-count highlight">0</span>
						<!-- Initial Value = 0 -->
						<div class="milestone-details">Tweets Analyzed</div>
					</div>
				</div>
				<div class="f-element hideme dontHide">
					<div class="f-ico s-two"></div>
					<div class="milestone-counter" data-perc="2701">
						<span class="milestone-count highlight">0</span>
						<!-- Initial Value = 0 -->
						<div class="milestone-details">Amazon product reviews
							analyzed</div>
					</div>
				</div>
				<div class="f-element hideme dontHide">
					<div class="f-ico s-four"></div>
					<div class="milestone-counter" data-perc="2420">
						<span class="milestone-count highlight">0</span>
						<!-- Initial Value = 0 -->
						<div class="milestone-details">Yelp business reviews
							analyzed</div>
					</div>
				</div>
				<div class="f-element hideme dontHide">
					<div class="f-ico s-three"></div>
					<div class="milestone-counter" data-perc="2334">
						<span class="milestone-count highlight">0</span>
						<!-- Initial Value = 0 -->
						<div class="milestone-details">Lines of Code</div>
					</div>
				</div>
			</div>
		</section>
		<div class="clear"></div>
	</article>

	<article class="content dark">
		<header class="title one">Our Services</header>
		<div class="spacer"></div>
		<div class="title two">We take pride in our analysis of your
			brands. We offer engaging interface and deliver intuitive results.</div>
		<div class="s-container services-container">
			<section class="services">
				<!--<div class="s-element">
                            <div class="s-ico"></div>
                            <div class="s-info"><span>Developer Track</span><br><br>Quis aute iure reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Stet clita kasd gubergren.</div>
                        </div>
                        <div class="s-element">
                            <div class="s-ico"></div>
                            <div class="s-info"><span>SEO Analytics</span><br><br>Quis aute iure reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Stet clita kasd gubergren.</div>
                        </div>
                        <div class="s-element">
                            <div class="s-ico"></div>
                            <div class="s-info"><span>Amazing Ideas</span><br><br>Quis aute iure reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Stet clita kasd gubergren.</div>
                        </div>-->
				<div class="sl-element hideme dontHide">
					<div class="sl-ico sl-globe"></div>
					<div class="sl-title">TWITTER</div>
					<div class="tooltip s-roll">
						<div class="details">
							<ul class="feature-list">
								<li><span class="list-dot"></span>Twitter RESTful API</li>
								<li><span class="list-dot"></span>Keyword Search</li>
								<li><span class="list-dot"></span>Relevant Tweets</li>
							</ul>
						</div>
					</div>
					<span class="arrow-down s-roll"></span>
				</div>

				<div class="sl-element hideme dontHide">
					<div class="sl-ico sl-config"></div>
					<div class="sl-title">AMAZON</div>
					<div class="tooltip s-roll">
						<div class="details">
							<ul class="feature-list">
								<li><span class="list-dot"></span>Amazon Product
									Advertising API</li>
								<li><span class="list-dot"></span>Most relevant products</li>
								<li><span class="list-dot"></span>Most voted helpful
									reviews</li>
							</ul>
						</div>
					</div>
					<span class="arrow-down s-roll"></span>
				</div>

				<div class="sl-element hideme dontHide">
					<div class="sl-ico sl-pointer"></div>
					<div class="sl-title">YELP</div>
					<div class="tooltip s-roll">
						<div class="details">
							<ul class="feature-list">
								<li><span class="list-dot"></span>Yelp Search API</li>
								<li><span class="list-dot"></span>Similar Businesses</li>
								<li><span class="list-dot"></span>Top reviews</li>
							</ul>
						</div>
					</div>			
					<span class="arrow-down s-roll"></span>
				</div>
				<div class="clear"></div>
			</section>
		</div>
	</article>
	<article id= anchor4 class="content light">
		<div class="full">
			<section class="half hideme dontHide">
				<div class="title-one">Our Goal</div>
				<div class="title-two">Our Progress so far..</div>
				<div class="half-content">
					<div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
				</div>
			</section>
			<section class="half car-show-2 hideme dontHide">
				<div class="title-one">Twitter</div>
				<div class="title-two">What people THINK about your BRAND?</div>
				<div class="show">
					<div class="caroussel-2">
						<div class="caroussel-list-2">
							<div class="car-quote">
								<div class="testimonials">
									<div class="avatar">
										<img src="../img/testimonials/twittericon.jpg" alt='img'>
									</div>
									<div class="comment">
										"<script type="text/javascript">document.write(arr.tweet1);</script>"<br>
										<br> Sentiment: <span><script type="text/javascript">document.write(arr.sentiment1);</script></span>
									</div>
									<div class="clear q-spacer"></div>
									<div class="avatar">
										<img src="../img/testimonials/twittericon.jpg" alt='img'>
									</div>
									<div class="comment">
										"<script type="text/javascript">document.write(arr.tweet2);</script>"<br><br> <br> Sentiment: <span><script type="text/javascript">document.write(arr.sentiment2);</script></span>
									</div>
								</div>
							</div>
                                <div class="car-quote">
                                	<div class="testimonials">
                                    	<div class="avatar"><img src="../img/testimonials/twittericon.jpg" alt='img'></div>
                                        <div class="comment">"<script type="text/javascript">document.write(arr.tweet3);</script>"<br><br>Sentiment: <span><script type="text/javascript">document.write(arr.sentiment3);</script></span></div>

                                        <div class="clear q-spacer"></div>
                                        <div class="avatar"><img src="../img/testimonials/twittericon.jpg" alt='img'></div>
                                        <div class="comment"><div class="comment">"<script type="text/javascript">document.write(arr.tweet4);</script>"<br><br>Sentiment: <span><script type="text/javascript">document.write(arr.sentiment4);</script></span></div>
                                    </div>
                                </div>
                                </div>
                                <div class="car-quote">
                                	<div class="testimonials">
                                    	<div class="avatar"><img src="../img/testimonials/twittericon.jpg" alt='img'></div>
                                        <div class="comment">"<script type="text/javascript">document.write(arr.tweet5);</script>"<br><br>Sentiment: <span><script type="text/javascript">document.write(arr.sentiment5);</script></span></div>

                                        <div class="clear q-spacer"></div>
                                        <div class="avatar"><img src="../img/testimonials/twittericon.jpg" alt='img'></div>
                                        <div class="comment">"<script type="text/javascript">document.write(arr.tweet6);</script>"<br><br>Sentiment: <span><script type="text/javascript">document.write(arr.sentiment6);</script></span></div>
                                    </div>
                                </div>
					</div>
				</div>
				</div>
				<div class="controller-2">
					<ul>
					</ul>
				</div>
			</section>
		</div>
		<div class="clear"></div>
	</article>
						<div id="container4" style="min-width: 310px; height: 400px; max-width: 800px; margin: 0 auto"></div>
	<div class="clear"></div>


	<article id="anchor2" class="content menu-top dark">
		<header class="title one">SERVICES</header>
		<div class="spacer"></div>
		<div class="title two">Visuals work in every language. We
			communicate in images where words fail to transmit our message. Keep
			it simple.</div>
		<section class="featured-slider">
			<div id="ca-container" class="ca-container">
				<div class="nav-featured"></div>
				<div class="main-carousel hideme dontHide">
					<div class="ca-wrapper">

						<div class="ca-item ca-item-1">
							<div class="f-single">
							<!--  	<a href="../img/featured/big/big04.jpg"> -->
									<div class="f-image">
										<img src="../img/featured/feat-01.jpg" alt='img'>
										<div class="image-hover-overlay"></div>
										<span class="f-category"></span>
										<div class="portfolio-meta">
											<jsp:include page="amazonpopup.jsp">
   <jsp:param name="amazonBrand" value="starbucks" />	
</jsp:include>
										</div>
									</div>
									<div class="f-info">AMAZON</div>
								</a>
							</div>
						</div>

						<div class="ca-item ca-item-2">
							<div class="f-single">
						<!--  		<a href="../img/featured/big/big05.jpg"> -->
									<div class="f-image">
										<img src="../img/featured/feat-02.jpg" alt='img'>
										<div class="image-hover-overlay"></div>
										<span class="f-category"></span>
										<div class="portfolio-meta">
											<jsp:include page="twitterpopup.jsp">
   <jsp:param name="twitterBrand" value="starbucks" />	
</jsp:include>
										</div>
									</div>
									<div class="f-info">TWITTER</div>
								</a>
							</div>
						</div>
						<div class="ca-item ca-item-3">
							<div class="f-single">
							<!-- 	<a href="../img/featured/big/big02.jpg">  -->
									<div class="f-image">
									
										<img src="../img/featured/feat-03.jpg" alt='img'>
										<div class="image-hover-overlay"></div>
										<span class="f-category"></span>
										<div class="portfolio-meta">
											<jsp:include page="yelp_popup.jsp">
   <jsp:param name="yelpBrand" value="starbucks" />	
</jsp:include>
											
										</div>
									</div>
									<div class="f-info">YELP</div>
								</a>
							</div>
						</div>

					</div>
				</div>


			</div>
		</section>
	</article>
	<footer id=anchor6 class="footer light">
		<div class="footer-container">
			<div class="title one no-top">Contact</div>
			<div class="spacer"></div>
			<div class="title two f-bottom">
				We like to create things with fun, like-minded people.<br> Feel
				free to say hello!
			</div>
			<div class="foot-third hideme dontHide">
				<div class="f-title-one">contact</div>
				<div class="f-title-two">Visit Our Office</div>
				<div class="f-data adress">
					<img src="../img/adress-ico.png" alt='img'> Adress: <span>One
						Washington Square, San Jose California USA</span>
				</div>
				<div class="f-data phone">
					<img src="../img/phone-ico.png" alt='img'> Phone: <span>(123)
						456-7890</span>
				</div>
				<div class="f-data e-mail">
					<img src="../img/mail-ico.png" alt='img'> Email: <span>mailus@elevate.com</span>
				</div>
			</div>
			<div class="foot-third hideme dontHide">
				<div class="f-title-one">contact</div>
				<div class="f-title-two">Business Hours</div>
				<div class="f-data hour-1">
					<img src="../img/hours-ico.png" alt='img'> Mon. - Fri. <span>8am
						to 5pm</span>
				</div>
				<div class="f-data hour-2">
					<img src="../img/hours-ico.png" alt='img'> Sat. <span>8am
						to 11am</span>
				</div>
				<div class="f-data hour-3">
					<img src="../img/hours-ico.png" alt='img'> Sun. <span>Closed</span>
				</div>
			</div>
			<div class="foot-third hideme dontHide">
				<form method="post" id="contact" class="peThemeContactForm"
					action="mail.php">
					<div id="personal" class="bay form-horizontal">
						<div class="control-group">
							<!--name field-->
							<div class="controls">
								<input class="required span9" type="text" name="author"
									data-fieldid="0" value="Full Name"
									onclick="if(this.value=='Full Name') this.value=''"
									onblur="if(this.value=='') this.value='Full Name'">
							</div>
						</div>
						<div class="control-group">
							<!--email field-->
							<div class="controls">
								<input class="required span9" type="email" name="email"
									data-fieldid="1" value="Your Email"
									onclick="if(this.value=='Your Email') this.value=''"
									onblur="if(this.value=='') this.value='Your Email'">
							</div>
						</div>
						<div class="control-group">
							<!--message field-->
							<div class="controls">
								<textarea name="message" rows="12" class="required span9"
									data-fieldid="2"
									onclick="if(this.value=='Type Message') this.value=''"
									onblur="if(this.value=='') this.value='Type Message'">Type Message</textarea>
							</div>
						</div>
						<div class="control-group">
							<div class="controls send-btn">
								<button type="submit" class="contour-btn red">Send
									Message</button>
							</div>
						</div>
					</div>
					<div class="notifications">
						<div id="contactFormSent" class="formSent alert alert-success">
							<strong>Your Message Has Been Sent!</strong> Thank you for
							contacting us.
						</div>
						<div id="contactFormError" class="formError alert alert-error">
							<strong>Oops, An error has ocurred!</strong> See the marked
							fields above to fix the errors.
						</div>
					</div>
				</form>
			</div>
		</div>
	</footer>
	<a href="#" class="scrollup">^</a>
	<div id="maps">
		<script type="text/javascript"
			src="http://maps.google.com/maps/api/js?sensor=false"></script>
		<div class="map-content">
			<div class="wpgmappity_container inner-map" id="wpgmappitymap"></div>
		</div>
	</div>
	<div class="socialFooter">
		<div class="social-icons">
			<div class="social">
				<a href="https://www.facebook.com/" target="_blank"><div
						class="face"></div></a> <a href="https://twitter.com/" target="_blank"><div
						class="twitt"></div></a> <a href="https://plus.google.com/"
					target="_blank"><div class="plus"></div></a>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<script
		src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="../js/vendor/jquery-1.9.1.min.js"><\/script>')
	</script>
	<script
		src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/jquery-ui.min.js"></script>
	<script type="text/javascript"
		src="../js/jquery.carouFredSel-6.2.1-packed.js"></script>
	<script src="../js/jquery.smoothwheel.js"></script>
	<script src="../js/main.js"></script>
	<script src="../js/jquery.inview.js"></script>
	<script type="text/javascript" src="../js/jquery.sticky.js"></script>
	<script type="text/javascript"
		src="../js/caroussel/jquery.easing.1.3.js"></script>
	<script type="text/javascript" src="../js/portfolio.js"></script>
	<!--<script type="text/javascript" src="../js/vegas/jquery.vegas.js"></script>-->
	<script src="../js/superslides-0.6.2/dist/jquery.superslides.js"
		type="text/javascript" charset="utf-8"></script>

	<script type="text/javascript" src="../js/jquery.hoverdir.js"></script>
	<script src="../js/jquery.nav.js"></script>
	<script src="../js/popup/jquery.magnific-popup.js"></script>
	<script type="text/javascript"
		src="../js/caroussel/jquery.contentcarousel.js"></script>
	<script src="../js/jquery.isotope.min.js"></script>
	<script src="../js/plugins.js"></script>
	<!--<script type="text/javascript" src="../js/vegas/vegas_slider.js"></script>-->
	<script src="../js/jquery.validate.js"></script>
	<script src="../js/jquery.form.js"></script>
	<script src="../js/test.js"></script>
	<script src="../highcharts/highcharts.js"></script>
	<script src="../highcharts/modules/exporting.js"></script>
</body>
</html>
