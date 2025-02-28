<!DOCTYPE html>
<html lang="en">
<head>
<!--
"Time-stamp: <Sat, 01-02-21, 19:38:14 Eastern Standard Time>"
//-->
<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="My online portfolio that illustrates skills acquired while working through various project requirements.">
	<meta name="author" content="Mark K. Jowett, Ph.D.">
	<link rel="icon" href="favicon.ico">

	<title>LIS4368 - Assignment1</title>

	<%@ include file="/css/include_css.jsp" %>		
	
</head>
<body>

<!-- display application path -->
<% //= request.getContextPath()%>
	
<!-- can also find path like this...<a href="${pageContext.request.contextPath}${'/a5/index.jsp'}">A5</a> -->

	<%@ include file="/global/nav.jsp" %>	

	<div class="container">
		<div class="starter-template">
					<div class="page-header">
						<%@ include file="global/header.jsp" %>
					</div>

					<h4>Servlet Compilation and Usage:</h4><br />
					<img src="img/helloindex.png" class="img-responsive center-block" alt="Using Servlets" />
					<img src="img/sayhello.png" class="img-responsive center-block" alt="Using Servlets" />
					<img src="img/helloagain.png" class="img-responsive center-block" alt="Using Servlets" />

					<br /> <br />
					<h4>Database Connectivity Using Servlets:</h4><br />
					<img src="img/servlet.png" class="img-responsive center-block" alt="Database Connectivity Using Servlets" />
				<br />
					<img src="img/servletresponse.png" class="img-responsive center-block" alt="Database Connectivity Using Servlets" />

	<%@ include file="/global/footer.jsp" %>

	</div> <!-- end starter-template -->
 </div> <!-- end container -->

 	<%@ include file="/js/include_js.jsp" %>		

</body>
</html>
