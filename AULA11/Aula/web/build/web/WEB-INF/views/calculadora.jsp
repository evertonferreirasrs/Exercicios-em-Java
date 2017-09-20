<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <title>Categorias</title>


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
            <h1>Calculadora</h1>
            <label for="n1">N1</label>
            <input type="text" id="n1"/>
            <br/>
            <label for="n2">N2</label>
            <input type="text" id="n2"/>
            <br/>
            <button class="btnCalcular">Calcular</button>
            <p id="resultado"></p>

        
        
        
        </div>  
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="<c:url value="/resources/js/jquery.min.js"/>"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
        
        <script>
            $("button.btnCalcular").on("click",function(){
                var n1 = $("#n1").val();
                var n2 = $("#n2").val();
                $.get("<c:url value="/somar"/>?n1="+n1+"&n2="+n2, function (data, status){
                    $("#resultado").html("Resultado: "+ data);
                });
            });
            
        </script>
        
        
    </body>
</html>