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

        <form action="/codehouse/products" method="POST">
            <div>
                <label>Titulo</label>
                <input type="text" name="title"></input>
            </div>
            <div>
                <label>Descricao</label>
                <textarea name="description" rows="10" cols="20"></textarea>
            </div>
            <div>
                <label>Paginas</label>
                <input type="text" name="pages" />
            </div>
            <c:forEach varStatus="status" items="${types}" var="type">
                <div>
                    <label>${type}</label>
                    <input type="text" name="prices[${status.index}].value" />
                    <input type="hidden" name="prices[${status.index }].type" value="${type}" />
                </div>
            </c:forEach>
            <div>
                <button type="submit">Save</button>
            </div>
        </form>

    </body>

</html>