<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <%@ page isELIgnored="false" %>
        <meta charset="UTF-8">
        <title>Livros de Java, Python, Ruby, PHP e muito mais - Casa do Codigo</title>
    </head>

    <body>

        <h1>List of Products</h1>
        <table>
            <tr>
                <td>Title</td>
                <td>Description</td>
                <td>Number of Pages</td>
            </tr>
            <c:forEach items="${products}" var="prod">
                <tr>
                    <td>${prod.title}</td>
                    <td>${prod.description}</td>
                    <td>${prod.pages}</td>
                </tr>
            </c:forEach>
        </table>

    </body>

</html>