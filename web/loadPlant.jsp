<%-- 
    Document   : loadPlant.jsp
    Created on : Apr 18, 2022, 12:15:29 PM
    Author     : pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <form action="MainControler" method="POST">
                <input name="searchValue" value="${filter}" placeholder="Search..."/>
                <select name="idCategory">
                    <c:forEach var="category" items="${categories}">
                        <c:if test="${requestScope.idCategory eq category.id}">
                            <option selected value="${category.id}">${category.name}</option>
                        </c:if>
                        <c:if test="${requestScope.idCategory != category.id}">
                            <option value="${category.id}">${category.name}</option>
                        </c:if>
                    </c:forEach>
                </select>
                <button name="btnAction" value="search">Search</button>
            </form>
            <a href="MainControler?btnAction=addNew">Add New</a>
            <c:if test="${not empty plant}">
                <table border>
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Price</th>
                            <th>Date Create</th>
                       
                            <th colspan="2">action</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="plants" items="${plant}" varStatus="counter">
                        <tr>
                        <form action="MainControler" method="POST">
                            <td>${counter.count}</td>
                            <td>${plants.id}</td>
                            <td>${plants.name} /></td>
                            <td>${plants.price} </td>
                            <td>${plants.createDate} </td>
                        
                            <td><a href="MainControler?btnAction=deleteProduct&id=${plants.id}">Delete</a></td>
                            <td><button type="submit" name="btnAction" value="plant">Update</button></td>
                        </form>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
            <c:if test="${empty plant}">
                <h3 style="color:red">Don't have plant</h3>
            </c:if>
        </div>

    </body>
</html>
