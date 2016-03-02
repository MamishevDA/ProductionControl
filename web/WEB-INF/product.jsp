<%-- 
    Document   : recipe
    Created on : 13.08.2015, 3:51:16
    Author     : dmitriy.mamishev

 <jsp:include page="confirmPage.jsp" flush="true" />
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
    <head>

        <link href="css/style.css" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>рецепты</title>
    </head>
    <body>
        <div id="header">
            <jsp:include page="headerPage.jsp" flush="true"/> 
        </div>
        <div id="menu">
            <jsp:include page="leftPage.jsp" flush="true"/> 
        </div>
        
        <div id="content">Контент
            <table class="mainList" border="1">
                <tr>
                    <c:forEach items="${colNames}" var="cols">
                        <td> <b> ${cols}</b></td>
                    </c:forEach>
                </tr>
                <c:forEach items="${requestScope.products}" var="product">

                    <tr>
                        <%--неявно вызывает геттеры у объекта по имени метода)--%>
                        <td>${product.id}</td>
                        <td>${product.name}</td>
                        <td>${product.description}</td>
                        <td>${product.classification}</td>
                        <td>${product.dateCook}</td>
                        <td>${product.ratingCurrentDistillation}</td>
                        <td>${product.startInfusionDate}</td>
                        <td>${product.endInfusionDate}</td>
                        <td>${product.ratingEndProduct}</td>
                        <td>${product.descriptionEndProduct}</td>
                    </tr>
                </c:forEach>

            </table>
            <button  style="margin-top: 10px; margin-left: 20px" onClick='location.href = "addRecipe"' >добавить новый рецепт</button>
        </div>
        <div id="footer">
            <div class="link">
                Перейти <a href="recipe" >на главную</a> страницу
            </div></div>

    </body>
</html>
