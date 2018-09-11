<%-- 
    Document   : listarUsuario
    Created on : 04/09/2018, 10:52:16
    Author     : PC 05
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="br.com.aplicacoesmatutino.model.Usuario"%>
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
                <th align="center">Data Nascimento</th>
                <th align="center">Login</th>
                <th aligin="center" colspan="2">Editar</th>
            </tr>
            <%
                List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
                for (Usuario usuario: usuarios){
                    
            %>
            <tr>
                <td align="center"><%=usuario.getIdUsuario()%></td>
                <td align="center"><%=usuario.getNomeUsuario()%></td>
                <td align="center"><fmt:formatDate value="<%=usuario.getDataNascimentoUsuario()%>" type="date" pattern="dd/MM/yyyy"></fmt:formatDate></td>
                <td align="center"><%=usuario.getLoginUsuario()%></td>
                <td align="center"><a href="ExcluirUsuario?idUsuario=<%=usuario.getIdUsuario()%>">Excluir</a></td>
                <td align="center"><a href="CarregarUsuario?idUsuario=<%=usuario.getIdUsuario()%>">Carregar</a></td>
            </tr>
            
            <% } %>
            
            <tr>
                <td align="center" colspan="6"><h5><a href="index.jsp">Voltar</a></h5></td>
            </tr>
        </table>
    </body>
</html>
