/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aplicacoesmatutino.dao;

import br.com.aplicacoesmatutino.model.TipoUsuario;
import br.com.aplicacoesmatutino.model.Usuario;
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
public class UsuarioDAOImpl implements GenericDAO {

    private Connection conexao;

    public UsuarioDAOImpl() throws Exception {
        try {
            this.conexao = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object objeto) {
        Usuario usuario = (Usuario) objeto;
        PreparedStatement stmt = null;
        String sql = "Insert into usuario(nomeUsuario,dataNascimentoUsuario,"
                + "loginUsuario, senhaUsuario, tipoUsuario) values (?, ?, ?, ?, ?);";

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, usuario.getNomeUsuario());
            stmt.setDate(2, new java.sql.Date(usuario.getDataNascimentoUsuario().getTime()));
            stmt.setString(3, usuario.getLoginUsuario());
            stmt.setString(4, usuario.getSenhaUsuario());
            stmt.setInt(5, usuario.getTipo().getIdTipoUsuario());
            stmt.execute();

            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao cadastrar usuário! Erro" + ex.getMessage());
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
        
        Usuario usuario = (Usuario) objeto;
        PreparedStatement stmt = null;
        String sql = "update usuario set nomeUsuario = ?, dataNascimentoUsuario = ?, loginUsuario = ?, senhaUsuario = ?, tipoUsuario = ? where idUsuario = ?;";
        
        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, usuario.getNomeUsuario());            
            stmt.setDate(2, new java.sql.Date(usuario.getDataNascimentoUsuario().getTime()));
            stmt.setString(3, usuario.getLoginUsuario());
            stmt.setString(4, usuario.getSenhaUsuario());
            stmt.setInt(5, usuario.getTipo().getIdTipoUsuario());            
            stmt.executeUpdate();
            
            return true;
        }catch(SQLException ex){
            System.out.println("Problemas ao alterar usuário! Erro " + ex.getMessage());
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
        
        String sql = "DELETE FROM usuario WHERE idUsuario = ?;";
        try {
            stmt = conexao.prepareStatement(sql);

            stmt.setInt(1, idObject);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao excluir usuários! Erro: " + ex.getMessage());
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
       Usuario usuario = new Usuario();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select * from Usuario where idUsuario = ?;";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while(rs.next()){
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNomeUsuario(rs.getString("nomeUsuario"));
                usuario.setDataNascimentoUsuario(rs.getDate("dataNascimentoUsuario"));
                usuario.setLoginUsuario(rs.getString("loginUsuario"));
                usuario.setSenhaUsuario(rs.getString("senhaUsuario"));
                usuario.getTipo().setIdTipoUsuario(rs.getInt("idTipoUsuario"));
            }
            return usuario;
        } catch (SQLException ex) {
            System.out.println("Erro no UsuarioDAOImpl ao excluir usuário: " + ex.getMessage());
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conexao, stmt);
            } catch (Exception ex) {
                System.out.println("Erro na UsuarioDAOImpl ao fechar conexão: " + ex.getMessage());
            }
        }
    }

    @Override
    public List<Object> Listar() {
        List<Object> usuarios = new ArrayList<Object>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM  usuario order by nomeUsuario;";

        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNomeUsuario(rs.getString("nomeUsuario"));
                usuario.setDataNascimentoUsuario(rs.getDate("dataNascimentoUsuario"));
                usuario.setLoginUsuario(rs.getString("loginUsuario"));
                usuario.setSenhaUsuario(rs.getString("senhaUsuario"));
                usuario.setTipo((TipoUsuario) new TipoUsuarioDAOImpl().carregar(rs.getInt("tipousuario")));
                usuarios.add(usuario);

            }
        } catch (Exception ex) {
            System.out.println("Problemas ao Listar Usuários! Erro " + ex.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(conexao, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetrs de conexão! "
                        + "Erro " + ex.getMessage());
            }
        }

        return usuarios;
    }

}
