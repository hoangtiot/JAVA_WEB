<%-- 
    Document   : create
    Created on : Mar 15, 2021, 3:36:15 PM
    Author     : PC
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Page</title>
    </head>
    <body>
        <h1>Add new Product</h1>
        <h3><a href="home.jsp" >Back to Home</a></h3>
        <form action="MainController">
            <table border="0" cellspacing="10">                
                <tbody>
                    <tr>
                        <td><label>Product ID</label></td>
                        <td><input type="text" class="form-control" required name="productID" id="productID">
                            ${sessionScope.ERROR_MSG.productIDError}</td>
                    </tr>
                    <tr>
                        <td><label>Name</label></td>
                        <td><input type="text" class="form-control" required name="name">
                            ${sessionScope.ERROR_MSG.nameError}</td>
                    </tr>
                    <tr>
                        <td><label>Price</label></td>
                        <td><input type="number" step="0.01" class="form-control" required name="price">
                            ${sessionScope.ERROR_MSG.priceError}</td>
                    </tr>
                    <tr>
                        <td><label>Quantity</label></td>
                        <td>
                            <input type="number" class="form-control" required name="quantity">
                            ${sessionScope.ERROR_MSG.quantityError}</td>
                    </tr>
                    <tr>
                        <td><label>Description</label></td>
                        <td>
                            <textarea class="form-control" maxlength="500" required name="description"></textarea>
                            ${sessionScope.ERROR_MSG.descriptionError}</td>
                    </tr>
                    <tr>
                        <td><label>Category ID</label></td>
                        <td>
                            <select name="categoryID" >
                                <c:forEach items="${sessionScope.LIST_CATE}" var="c">
                                    <option value="${c.categoryID}">${c.name}</option>
                                </c:forEach>
                            </select></td>
                    </tr>
                    <tr>
                        <td><label>Image</label></td>
                        <td>
                            <input type="file" class="form-control" name="img" required accept=".jpg, .jpeg, .jpe .jif, .jfif, .jfi, .png, .gif, .webp, .tiff, .psd, .raw">
                        </td>
                    </tr>
                    <tr>
                        <td><input type="submit" class="btn btn-success" name="action" value="Create"></td>                        
                    </tr>
                </tbody>
            </table>
    </form>
</body>
</html>
