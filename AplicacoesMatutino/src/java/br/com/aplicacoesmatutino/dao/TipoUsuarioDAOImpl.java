/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aplicacoesmatutino.dao;

import br.com.aplicacoesmatutino.model.TipoUsuario;
import br.com.aplicacoesmatutino.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC 05
 */
public class TipoUsuarioDAOImpl implements GenericDAO  {
    
    private Connection conexao;

    public TipoUsuarioDAOImpl() throws Exception {
        try {
            this.conexao = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object objeto) {
       TipoUsuario tipousuario = (TipoUsuario) objeto;
        PreparedStatement stmt = null;
        String sql = "Insert into TipoUsuario(descricaoTipoUsuario) values (?)";

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, tipousuario.getDescricaoTipoUsuario());
            stmt.execute();

            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao cadastrar Tipo Usuário! Erro" + ex.getMessage());
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conexao, stmt);
            } catch (Exception ex) {
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
      TipoUsuario tipousuario = (TipoUsuario) objeto;
        PreparedStatement stmt = null;
        String sql = "update TipoUsuario set descricaoTipoUsuario = ? where idTipoUsuario = ?;";
        
        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, tipousuario.getDescricaoTipoUsuario());            
            stmt.setInt(2, tipousuario.getIdTipoUsuario());            
            stmt.executeUpdate();
            
            return true;
        }catch(SQLException ex){
            System.out.println("Problemas ao alterar Tipo de Usuário! Erro " + ex.getMessage());
            return false;            
        }finally{
            try{
                ConnectionFactory.closeConnection(conexao, stmt);
            }catch(Exception ex){
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
            }
        }
    }

    @Override
    public Boolean excluir(int idObject) {
       PreparedStatement stmt = null;
        
        String sql = "DELETE FROM TipoUsuario WHERE idTipoUsuario = ?";
        try {
            stmt = conexao.prepareStatement(sql);

            stmt.setInt(1, idObject);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao excluir tipo de usuário! Erro: " + ex.getMessage());
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conexao, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão!! Erro " + ex.getMessage());
            }
        }
    }

    @Override
    public Object carregar(int id) {
        TipoUsuario tipousuario = new TipoUsuario();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select * from TipoUsuario where idTipoUsuario = ?;";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while(rs.next()){
                tipousuario.setIdTipoUsuario(rs.getInt("idTipoUsuario"));
                tipousuario.setDescricaoTipoUsuario(rs.getString("descricaoTipoUsuario"));
            }
            return tipousuario;
        } catch (SQLException ex) {
            System.out.println("Erro no TipoUsuarioDAOImpl ao excluir tipo de usuário: " + ex.getMessage());
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conexao, stmt);
            } catch (Exception ex) {
                System.out.println("Erro na TipoUsuarioDAOImpl ao fechar conexão: " + ex.getMessage());
            }
        }
    }

    @Override
    public List<Object> Listar() {
        List<Object> tipoUsuarios = new ArrayList<Object>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM  TipoUsuario order by descricaoTipoUsuario;";

        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                TipoUsuario tipousuario = new TipoUsuario();
                tipousuario.setIdTipoUsuario(rs.getInt("idTipoUsuario"));
                tipousuario.setDescricaoTipoUsuario(rs.getString("descricaoTipoUsuario"));
                tipoUsuarios.add(tipousuario);

            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao Listar Tipo de Usuario! Erro " + ex.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(conexao, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetrs de conexão! "
                        + "Erro " + ex.getMessage());
            }
        }

        return tipoUsuarios;
    
    }
    
}
