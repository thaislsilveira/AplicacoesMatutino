/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aplicacoesmatutino.dao;

import br.com.aplicacoesmatutino.model.Usuario;
import br.com.aplicacoesmatutino.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author PC 05
 */
public class UsuarioDAOImpl implements GenericDAO{
    
    private Connection conexao;
    
    public UsuarioDAOImpl() throws Exception{
        try{
            this.conexao = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");            
        }catch(Exception ex){
            throw new Exception (ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object objeto) {
      Usuario usuario = (Usuario) objeto;
      PreparedStatement stmt = null;
      String sql = "Insert into usuario(nome_usuario,datanascimento_usuario,"
              + "login_usuario, senha_usuario) values (?, ?, ?, ?)";
      
      try{
          stmt = conexao.prepareStatement(sql);
          stmt.setString(1,usuario.getNomeUsuario());
          stmt.setDate(2, new java.sql.Date(usuario.getDataNascimentoUsuario().getTime()));
          stmt.setString(3, usuario.getLoginUsuario());
          stmt.setString(4, usuario.getSenhaUsuario());
          stmt.execute();
          
          return true;
      }catch(SQLException ex){
          System.out.println("Problemas ao cadastrar usuário! Erro" + ex.getMessage());
          return false;
      }finally{
          try{
              ConnectionFactory.closeConnection(conexao, stmt);
          }catch(Exception ex){
              System.out.println("Problemas ao fechar os parâmetros de conexao! " + ex.getMessage());
          }
      }
    }

    @Override
    public Boolean inserir(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean alterar(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean excluir(int numero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object carregar(int numero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> Listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
