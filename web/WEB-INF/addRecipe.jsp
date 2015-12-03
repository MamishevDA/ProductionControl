<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : addRecipe
    Created on : 10.09.2015, 17:35:58
    Author     : dmitriy.mamishev
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%-- <jsp:include page="confirmPage.jsp" flush="true" /> --%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta charset="UTF-8"/>
        
        <title>добавить рецепт</title>
    </head>
    <style>
        div.main {
            padding-left: 10px;
        }
    </style>
    <body>
        <form action="confirmPage"
              method="POST" accept-charset="UTF-8">
            <div class ="main">
                <h3>введите данные рецепта:</h3>

                <div>
                    <p>
                        name<br>
                        <input type="text" autofocus="" name="Name" value="" /><br>
                        Description<br>
                        <input type="text" name="Description" value="" /><br>
                        MainIngredients<br>
                        <input type="text" name="MainIngredients" value="" /><br>
                    </p>
                </div>
                <input type="submit" value="addNewRecipe"/>
            </div>
        </form>
    </body>
</html>
