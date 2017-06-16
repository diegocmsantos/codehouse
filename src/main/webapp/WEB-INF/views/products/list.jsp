<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
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
              <a class="navbar-brand" href="#">Casa do Código</a>
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
              <ul class="nav navbar-nav">
                <li><a href="${s:mvcUrl('PC#list').build()}">Products List</a></li>
                <li><a href="${s:mvcUrl('PC#form').build()}">Add Products</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
              <li><a href="#"><security:authentication property="principal.username"/></a></li>
            </ul>
            </div><!-- /.navbar-collapse -->
          </div>
        </nav>

        <div class="container">
            <h1>List of Products</h1>
            <h3>${message}</h3>
            <table class="table table-bordered table-striped table-hover">
                <tr>
                    <th>Title</th>
                    <th>Description</th>
                    <th>Number of Pages</th>
                </tr>
                <c:forEach items="${products}" var="prod">
                    <tr>
                        <td>${prod.title}</td>
                        <td>${prod.description}</td>
                        <td>${prod.pages}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>

    </body>

</html>