<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <title>Produtos</title>

        <!-- Bootstrap -->
        <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="<c:url value="/resources/js/html5shiv.min.js"/>"></script>
          <script src="<c:url value="/resources/js/respond.min.js"/>"></script>
        <![endif]-->
    </head>
    <body>
        <div class="container"> 
            <h1>Produtos <c:if test="${empty categoria.id}"><small>novo</small></c:if><c:if test="${not empty categoria.id}"><small>editar</small></c:if></h1>
            <br/>
            <form method="post">
                <div class="form-group">
                    <label for="inputNome">Nome:</label>
                    <input type="text" class="form-control" id="inputNome" name="nome" value="${produto.nome}"/>
                </div>
                <div class="form-group">
                    <label for="inputPreco">Preço:</label>
                    <input type="text" class="form-control" id="inputPreco" name="preco" value="${produto.preco}"/>
                </div>
                <div class="form-group">
                    <label for="selectCategoria">Categoria:</label>
                    <select class="form-control" id="selectCategoria" name="categoria">
                        <c:forEach var="categoria" items="${categoriaList}">
                            <option value="${categoria.id}" <c:if test="${categoria.id eq produto.categoria.id}"> selected </c:if>>${categoria.nome}</option>
                        </c:forEach>
                    </select>
                </div>
                <button type="submit" class="pull-right btn btn-primary">Confirmar</button>
            </form>
        </div>  
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="<c:url value="/resources/js/jquery.min.js"/>"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
    </body>
</html>