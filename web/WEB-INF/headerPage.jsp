

<%@page import="ru.ProductionControl.Test"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>

        <div id="content1">
            <table>
                <tr>
                    <td><img src="/ProductionControl/img/recipe.jpg" width="130" height="85" alt="recipe"/></td>
                    <td> <li>заголовок из ${pageContext.request.requestURI} </li>
                <li><%=new java.util.Date()%></li>
                <li><%=Test.getCurrentDateTime()%></li></td>
                </tr>
            </table>
        </div>
    </body>

</html>
