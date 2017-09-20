<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <title>Bootstrap 101 Template</title>

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
            <jsp:include page="../template/navbar.jsp"/>
            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <title>Calculadora</title>
            </head>
            <h1>${operacao}</h1>
            <form method="post">
                <div class="form-group">
                    <label for="n1">Primeiro Numero: </label>
                    <input type="text" class="form-control" id="n1" name="n1" value="${n1}">
                </div>
                <div class="form-group">
                    <label for="n2">Segundo Numero: </label>
                    <input type="text" class="form-control" id="n2" name="n2" value="${n2}">
                </div>
                <button type="submit" class="btn btn-default">Calcular</button>
                <br/>
                <br/>
                <c:if test="${not empty resultado}">
                    <div class="form-group">
                        <label for="resultado">Resultado </label>
                        <input type="text" class="form-control" id="resultado" name="resultado" value="${resultado}" readonly />
                    </div>
                </c:if>
            </form>
            <c:if test="${not empty calculoList}">
                <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
                    <div class="panel panel-default">
                        <div class="panel-heading" role="tab" id="headingOne">
                            <h4 class="panel-title">
                                <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                    Operações Anteriores
                                </a>
                            </h4>
                        </div>
                        <div id="collapseOne" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne">
                            <div class="panel-body">
                                <div class="pull-right">
                                    <a class="btn btn-danger" href="Limpar?back=${operacao}"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>
                                    <br/>
                                    <br/>
                                </div>
                                <table class="table table-striped table-condensed">
                                    <c:forEach items="${calculoList}" var="calculo">
                                        <tr>
                                            <td>
                                                ${calculo}
                                            </td>
                                        </tr>                        
                                    </c:forEach>
                                </table>         
                            </div>
                        </div>
                    </div>
                </div>
            </c:if>
        </div>
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="<c:url value="/resources/js/jquery.min.js"/>"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
    </body>
</html>