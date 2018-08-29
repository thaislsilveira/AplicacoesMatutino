<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Enviando e recenbendo dados via POST</title>
    </head>
    <body>
        <h1>JavaWeb</h1>
        <form name="enviodedados" action="ReceberDados" method="POST" >
            <table border="0" align="center">
                <tr>
                    <th colspan="2" align="center">
                        <h3>Entre com seu e-mail e senha:</h3>
                    </th>
                </tr>
                <tr>
                    <td>E-mail:</td>
                    <td>
                        <input type="text" id="email" size="20">
                    </td>
                </tr>
                 <tr>
                    <td>Senha:</td>
                    <td>
                        <input type="text" id="senha" size="20">
                    </td>
                </tr>
                <td colspan="2" align="center">
                    <input type="submit" id="submit" name="enviar" value="Enviar">
                </td>
            </table>
        </form>
    </body>
</html>
