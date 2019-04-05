<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false"%>


<html>
<body>
<h3>Product-List</h3>
<hr>
<table border="2">
	<tr>	
		<th>PCode</th><th>PName</th><th>Price</th><th>Photo</th>
	<tr>

<c:forEach items="${products}" var="product" >
<tr>
	<td>${product.pcode}</td>
	<td>${product.pname}</td>
	<td>${product.price}</td>
	<td><img src="loadImage?pcode=${product.pcode}"/></td>
<tr>
</c:forEach>
</table>
<hr>
<a href="index.jsp">Home</a>
</body>
</html>