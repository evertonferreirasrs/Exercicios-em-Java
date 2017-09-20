<%-- 
    Document   : Formulario
    Created on : 12/04/2016, 22:41:07
    Author     : Everton
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculadora</title>
    </head>
    <body>
        <h1>${operacao}</h1>
        <form method="post" autocomplete="off">
            <label for="n1">Primeiro numero</label><br/>
            <input type="text" id="n1" name="n1" value="${n1}"/><br/><br/>
            <label for="n2">Segundo numero</label><br/>
            <input type="text" id="n2" name="n2" value="${n2}"/><br/><br/>
            <input type="submit" value="Calcular"/>
        </form>
        <p><strong>Resultado: ${resultado}</strong></p>
        <c:if test="${not empty calculoList}">
        <hr/>
        <a href="Limpar?back=${operacao}">Limpar</a>
        <ul>
        <c:forEach items="${calculoList}" var="calculo">            
            <li>${calculo}</li>
        </c:forEach>
        </ul>
        </c:if>
    </body>
</html>
