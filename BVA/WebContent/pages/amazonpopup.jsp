<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
function validateForm()
{
var x=document.forms["AmazonForm"]["amazonBrand"].value;
if (x==null || x=="")
  {
  alert("BRAND DESCRIPTION must be filled out");
  return false;
  }
}
</script>
</head>
<body>
<form name="AmazonForm" action="../AmazonServlet" method="POST">

Describe your Brand:
<br>
<input type="text" name="amazonBrand">

<input type="submit" value="Submit" />
<br />
Example: Wireless Mouse
</form>
</body>
</html>