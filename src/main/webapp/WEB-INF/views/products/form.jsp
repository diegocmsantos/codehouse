<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>
    <head>
        <%@ page isELIgnored="false" %>
        <meta charset="UTF-8">
        <title>Livros de Java, Python, Ruby, PHP e muito mais - Casa do Codigo</title>
    </head>

    <body>

        <form:form action="${s:mvcUrl('PC#save').build()}" method="POST" commandName="product">
            <div>
                <label>Titulo</label>
                <input type="text" name="title"></input>
                <form:errors path="title" />
            </div>
            <div>
                <label>Descricao</label>
                <textarea name="description" rows="10" cols="20"></textarea>
                <form:errors path="description" />
            </div>
            <div>
                <label>Paginas</label>
                <input type="text" name="pages" />
                <form:errors path="pages" />
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
        </form:form>

    </body>

</html>