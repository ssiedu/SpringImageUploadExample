<%@page isELIgnored="false" %>
<html>
<body>
	<h3>Product-Details-Stored</h3>
	<h4>Following-Details</h4>
	<hr>
		<pre>
			PCode	${product.pcode}
			PName	${product.pname}
			Price	${product.price}
		</pre>
	<hr>
	<a href="newproduct">Add-More</a><br>
	<a href="index.jsp">Home</a>
</body>
</html>