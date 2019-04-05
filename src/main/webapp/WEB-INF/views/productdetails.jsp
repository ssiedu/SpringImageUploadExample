<%@ page isELIgnored="false"%>
<html>
<body>
	<h3>Product-Details</h3>
	<hr>
		<pre>
			PCode	${product.pcode}
			PName	${product.pname}
			Price	${product.price}
			<img src="loadImage?pcode=${product.pcode}"/>
		</pre>
	<hr>
	<a href="index.jsp">Home</a>
</body>
</html>