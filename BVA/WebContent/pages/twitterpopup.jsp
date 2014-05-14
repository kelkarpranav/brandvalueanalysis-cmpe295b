<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Brand Value Analysis</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width">
<script>
function validateForm()
{
var x=document.forms["TwitterForm"]["twitterBrand"].value;
if (x==null || x=="")
  {
  alert("BRAND must be filled out");
  return false;
  }
}
</script>

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
<script
	src="http://fast.fonts.net/jsapi/3dca1e78-579f-4502-8da9-3eb91453e0dc.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form name="TwitterForm" action="../TwitterServlet" method="POST">
Enter your BRAND in one_word:
<br>
<input type="text" name="twitterBrand">

<input type="submit" value="Submit" />
<br />
Example: Dell, Tandoori_Oven
</form>
</body>
</html>