<%-- 
    Document   : listarTipoUsuario
    Created on : 25/09/2018, 11:02:05
    Author     : PC 05
--%>

<%@page import="br.com.aplicacoesmatutino.model.TipoUsuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>Gerenciamento de Usuários</title>
    </head>
    <body>
        <h1 align="center">Fatec Jales</h1>
        <hr>
        <div class="topo">            
            <h2 class="text-center"> Lista de Usuários</h2>           
        </div>
        <div class="table-responsive">
            <table class="table table-striped text-center">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>                       
                        <th>Editar</th> 
                        <th>Outros</th>
                    </tr>
                </thead>
                <%
                    List<TipoUsuario> tipousuarios = (List<TipoUsuario>) request.getAttribute("tipousuarios");
                for (TipoUsuario tipousuario: tipousuarios){
                %>
                <tbody>
                    <tr>
                        <td><%=tipousuario.getIdTipoUsuario()%></td>
                        <td><%=tipousuario.getDescricaoTipoUsuario()%></td>                  
                        <td><a href="ExcluirTipoUsuario?idTipoUsuario=<%=tipousuario.getIdTipoUsuario()%>">Excluir</a> / <a href="CarregarTipoUsuario?idTipoUsuario=<%=tipousuario.getIdTipoUsuario()%>">Carregar</a></td>
                        <td><a class="btn btn-primary" href="index.jsp">Voltar</a></td>                    
                    </tr>

                    <% }%>
                </tbody>             
            </table>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
</html>
