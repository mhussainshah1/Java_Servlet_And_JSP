<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>
<body>
    
<h1>CD list</h1>
<table>
    <tr>
        <th>Description</th>
        <th class="right">Price</th>
        <th>&nbsp;</th>
    </tr>
    <c:forEach var="product" items="${products}">
        <tr>
            <td>${product.description}</td>
            <td>${product.priceCurrencyFormat}</td>
            <td><form action="cart" method="post">
                <input type="hidden" name="productCode" value="<c:out value='${product.code}' />">
                <input type="submit" value="Add To Cart">
            </form></td>
        </tr>
    </c:forEach>
    <%--<tr>
        <td>86 (the band) - True Life Songs and Pictures</td>
        <td class="right">$14.95</td>
        <td><form action="cart" method="post">
                <input type="hidden" name="productCode" value="8601">
                <input type="submit" value="Add To Cart">
            </form></td>
    </tr>
    <tr>
        <td>Paddlefoot - The first CD</td>
        <td class="right">$12.95</td>
        <td><form action="cart" method="post">
                <input type="hidden" name="productCode" value="pf01">
                <input type="submit" value="Add To Cart">
            </form></td>
    </tr>
    <tr>
        <td>Paddlefoot - The second CD</td>
        <td class="right">$14.95</td>
        <td><form action="cart" method="post">
                <input type="hidden" name="productCode" value="pf02">
                <input type="submit" value="Add To Cart">
            </form></td>
    </tr>
    <tr>
        <td>Joe Rut - Genuine Wood Grained Finish</td>
        <td class="right">$14.95</td>
        <td><form action="cart" method="post">
                <input type="hidden" name="productCode" value="jr01">
                <input type="submit" value="Add To Cart">
            </form></td>
    </tr>--%>
</table>
        
</body>
</html>