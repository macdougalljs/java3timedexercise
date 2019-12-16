<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!--  Author:  Jeremiah MacDougall  SID# 991531555 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Your Results!</title>
<style>
<
link


 


rel




="
stylesheet


"
href




="
style




.css




"
>
</style>
</head>
<body>
	<h1>Your Results:</h1>
	<br> Here is your order:
	<br>


	<c:forEach var="item" items="${fruitList}">
		<div class="fruit">
			<img src="images/${item.name}.png">
		</div>

	</c:forEach>

	Your total is: ${totalCost}
	<br>
	<a href="index.html">Order More Fruits - click here</a>

</body>
</html>