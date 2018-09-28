<%-- 
    Document   : cadastrarUsuario
    Created on : 28/08/2018, 17:35:54
    Author     : Thais Silveira
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>Controle de Usuarios</title>
    </head>
    <body>

        <h1 class="font-weight-light text-primary" align="center">Fatec Jales</h1>
        <hr>
        <div class="container">
            <div class="alert alert-warning alert-dismissible fade show" role="alert">
                <strong>O cadastro .. ${mensagem}</strong> 
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form name="cadastrarusuario" id="cadastrarusuario" action="CadastrarUsuario"  method="POST">
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="nome">Nome</label>
                        <input type="text" class="form-control" id="NomeUsuario" name="nomeUsuario" >
                    </div>
                    <div class="form-group col-md-6">
                        <label for="dataNascimentoUsuario">Data de Nascimento</label>
                        <input type="text" class="form-control" id="dataNascimentoUsuario" name="dataNascimentoUsuario" placeholder="DD/MM/AAAA">
                    </div>
                </div>
                <div class="form-group">
                    <label for="loginUsuario">Login</label>
                    <input  type="text" name="loginUsuario" id="loginUsuario" class="form-control">
                </div>
                <div class="form-group">
                    <label for="senhaUsuario">Senha</label>
                    <input type="password" name="senhaUsuario" id="senhaUsuario" class="form-control">
                </div>
                 <div class="form-group">
                    <label for="tipoUsuario">Tipo</label>
                    <select name="idTipoUsuario">
                        <c:forEach var="tipo" items="${tipos}">
                            <option value="${tipo.idTipoUsuario}">${tipo.descricaoTipoUsuario}</option>
                        </c:forEach>
                    </select>
                </div>
                <button type="submit" name="cadastrar" id="cadastrar" value="Cadastrar" class="btn btn-primary">Cadastrar</button>
                <button href="index.jsp" name="cadastrar" id="voltar" value="Voltar" class="btn btn-primary">Voltar</button>
            </form>
        </div>       
    </body>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</html>
