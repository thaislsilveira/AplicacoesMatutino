<%-- 
    Document   : atvcelsius
    Created on : 16/08/2018, 08:39:13
    Author     : PC 05
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>Atividade Celsius</title>
    </head>
    <body>
        <h2>Calculando Celsius</h2>
        
         <form name="enviodedados" action="Celsius" method="POST" >
            <table border="0" align="center">
                <tr>
                    <th colspan="2" align="center">
                        <h3>Calculando...</h3>
                    </th>
                </tr>
                <tr>
                    <td>Celsius:</td>
                    <td>
                        <input class="form-control" type="text"  name ="Valortemp" id="Valortemp" size="20">
                    </td>
               
                    <td colspan="2" align="center">
                        <button type="submit" name="calcular" class="btn btn-outline-success">Calcular</button>
                    </td>
            </table>
        </form>
    </body>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</html>
