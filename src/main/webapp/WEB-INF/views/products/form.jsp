<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>
    <head>
        <%@ page isELIgnored="false" %>
        <meta charset="UTF-8">
        <c:url value="/resources/css" var="cssPath" />
        <link rel="stylesheet" href="${cssPath}/bootstrap.min.css" />
        <link rel="stylesheet" href="${cssPath}/bootstrap-theme.min.css" />
        <script src="resources/js/bootstrap.min.js"></script>
        <title>Livros de Java, Python, Ruby, PHP e muito mais - Casa do Codigo</title>
    </head>

    <body>
        <nav class="navbar navbar-inverse">
          <div class="container">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="${s:mvcUrl('HC#index').build()}">Code House</a>
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
              <ul class="nav navbar-nav">
                <li><a href="${s:mvcUrl('PC#list').build()}">Products List</a></li>
                <li><a href="${s:mvcUrl('PC#form').build()}">Add Products</a></li>
            </ul>
            </div><!-- /.navbar-collapse -->
          </div>
        </nav>

        <div class="container">
            <form:form action="${s:mvcUrl('PC#save').build()}" method="POST" commandName="product"
                enctype="multipart/form-data">
                <div class="form-group">
                    <label>Title</label>
                    <form:input path="title" cssClass="form-control" />
                    <form:errors path="title" />
                </div>
                <div class="form-group">
                    <label>Description</label>
                    <form:textarea path="description" rows="10" cols="20" cssClass="form-control"></form:textarea>
                    <form:errors path="description" />
                </div>
                <div class="form-group">
                    <label>Pages</label>
                    <form:input path="pages" cssClass="form-control" />
                    <form:errors path="pages" />
                </div>
                <div class="form-group">
                    <label>Release Date</label>
                    <form:input path="releaseDate" cssClass="form-control" />
                    <form:errors path="releaseDate" />
                </div>
                <c:forEach varStatus="status" items="${types}" var="type">
                    <div class="form-group">
                        <label>${type}</label>
                        <form:input path="prices[${status.index}].value" cssClass="form-control" />
                        <form:hidden path="prices[${status.index }].type" value="${type}" />
                    </div>
                </c:forEach>
                <div class="form-group">
                    <label>Summary</label>
                    <input type="file" name="summary" class="form-control" />
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Save</button>
                </div>
            </form:form>
        </div>

    </body>

</html>