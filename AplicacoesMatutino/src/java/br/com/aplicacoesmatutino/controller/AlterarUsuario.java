/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aplicacoesmatutino.controller;

import br.com.aplicacoesmatutino.dao.GenericDAO;
import br.com.aplicacoesmatutino.dao.UsuarioDAOImpl;
import br.com.aplicacoesmatutino.model.Usuario;
import br.com.aplicacoesmatutino.util.Conversoes;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PC 05
 */
@WebServlet(name = "AlterarUsuario", urlPatterns = {"/AlterarUsuario"})
public class AlterarUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {         
            
            
            Integer idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
            String nomeUsuario = request.getParameter("nomeUsuario");
            Date dataNascimentoUsuario = Conversoes.converterData(request.getParameter("dataNascimentoUsuario"));
            String loginUsuario = request.getParameter("loginUsuario");
            String senhaUsuario = request.getParameter("senhaUsuario");
            String mensagem = null;
            
            
            Usuario usuario = new Usuario();
            usuario.setIdUsuario(idUsuario);
            usuario.setNomeUsuario(nomeUsuario);
            usuario.setDataNascimentoUsuario(dataNascimentoUsuario);
            usuario.setLoginUsuario(loginUsuario);
            usuario.setSenhaUsuario(senhaUsuario);
            
            try{
                GenericDAO dao = new UsuarioDAOImpl();
                if(dao.alterar(usuario)){
                    mensagem = "Usuário alterado com sucesso!";
                }else{
                    mensagem = "Problemas ao alterar Usuário!";
                }
                
                request.setAttribute("mensagem", mensagem);
                request.getRequestDispatcher("ListarUsuario").forward(request, response);
            }catch(Exception ex){
                System.out.println("Problemas no Servlet ao alterar usuário! Erro: " + ex.getMessage());
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(AlterarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(AlterarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

 }
