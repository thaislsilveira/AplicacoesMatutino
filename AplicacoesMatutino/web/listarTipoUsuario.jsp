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
        <title>Gerenciamento de Usuários</title>
    </head>
    <body>
        <h1 align="center">Fatec Jales</h1>
        <hr>
        <table align="center" border="1">
            
            <tr>
                <td colspan="6" align="center"> Listar de Usuários</td>
            </tr>
            <tr>
                <th align="center">ID</th>
                <th align="center">Nome</th>              
                <th aligin="center" colspan="2">Editar</th>
            </tr>
            <%
                List<TipoUsuario> tipousuarios = (List<TipoUsuario>) request.getAttribute("tipousuarios");
                for (TipoUsuario tipousuario: tipousuarios){
                    
            %>
            <tr>
                <td align="center"><%=tipousuario.getId_Tipo_Usuario()%></td>
                <td align="center"><%=tipousuario.getDescricao_Tipo_usario()%></td>             
                <td align="center"><a href="ExcluirTipoUsuario?idUsuario=<%=tipousuario.getId_Tipo_Usuario()%>">Excluir</a></td>
                <td align="center"><a href="CarregarTipoUsuario?idUsuario=<%=tipousuario.getId_Tipo_Usuario()%>">Alterar</a></td>
            </tr>
            
            <% } %>
            
            <tr>
                <td align="center" colspan="6"><h5><a href="index.jsp">Voltar</a></h5></td>
            </tr>
        </table>
    </body>
</html>
