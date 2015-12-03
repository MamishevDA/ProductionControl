<%-- 
    Document   : recipe
    Created on : 13.08.2015, 3:51:16
    Author     : dmitriy.mamishev
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="confirmPage.jsp" flush="true" />

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>рецепты</title>
    </head>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }

        table, th, td {
            border: 1px solid black;
        }

    </style>

    <body>

        <div style="width: 400px;">
            <h1>Hello World!</h1>
            <table border="1">
                <c:forEach items="${requestScope.recipes}" var="recipe">
                    <tr>
                        <td>${recipe.id}</td>
                        <td>${recipe.mainIngredient}</td>
                        <td>${recipe.description}</td>
                    </tr>
                </c:forEach>

            </table>
            <button  style="margin-top: 10px; margin-left: 20px" onClick='location.href = "addRecipe"' >добавить новый рецепт</button>
        </div>
    </body>
</html>
