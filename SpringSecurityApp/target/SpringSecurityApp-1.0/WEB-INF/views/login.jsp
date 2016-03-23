<%-- 
    Document   : login
    Created on : Mar 23, 2016, 6:37:17 PM
    Author     : forsell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form method="post" action="">
            <c:if test="${param.error!=null}">
                <p>
                Invalid User Name/Password
                </p>
            </c:if>
            <input type="text" name="username" placeholder="Enter User Name"/>
            <input type="password" name="password" placeholder="Enter Password"/>
            <input type="hidden" 
                     name="${_csrf.parameterName}" value="${_csrf.token}" />
            <button type="submit">Login</button>
        </form>
    </body>
</html>
