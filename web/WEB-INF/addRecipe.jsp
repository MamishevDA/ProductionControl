<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : addRecipe
    Created on : 10.09.2015, 17:35:58
    Author     : dmitriy.mamishev
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%-- <jsp:include page="headerPage.jsp" flush="true" /> --%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/style.css" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta charset="UTF-8"/>

        <title>добавить рецепт</title>
    </head>
    <body>
        <div id="header">
            <jsp:include page="headerPage.jsp" flush="true"/> 
        </div>
        <div id="menu">
            <jsp:include page="leftPage.jsp" flush="true"/> 
        </div>

        <div id="content">
            <form action="confirmPage"
                  method="POST" accept-charset="UTF-8">
                <div class ="main">
                    <p class="head">введите данные рецепта:</p>
                    <div>
                        <div class="list">
                            Название рецепта<br>
                            <input type="text" autofocus="" name="Name" value="" /><br>
                            Описание<br>
                            <input type="text" name="Description" value="" /><br>
                            Основные ингридиенты<br>
                            <input type="text" name="MainIngredients" value="" /><br>
                        </div>
                    </div>
                    <input type="submit" value="Добавить новый рецепт"/>
                </div>
            </form></div>
        <div id="footer">
            <div class="link">
                Перейти <a href="recipe" >на главную</a> страницу
            </div>
        </div>
    </body>


</html>
