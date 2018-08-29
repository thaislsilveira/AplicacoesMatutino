/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aplicacoesmatutino.model;

import java.util.Date;

/**
 *
 * @author PC 05
 */
public class Usuario {
    private  Integer idUsuario;
    private String nomeUsuario;
    private Date dataNascimentoUsuario;
    private String loginUsuario;
    private String senhaUsuario;

    public Usuario() {
    }

    public Usuario(Integer idUsuario, String nomeUsuario, Date dataNascimentoUsuario, String loginUsuario, String senhaUsuario) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.dataNascimentoUsuario = dataNascimentoUsuario;
        this.loginUsuario = loginUsuario;
        this.senhaUsuario = senhaUsuario;
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public Date getDataNascimentoUsuario() {
        return dataNascimentoUsuario;
    }

    public void setDataNascimentoUsuario(Date dataNascimentoUsuario) {
        this.dataNascimentoUsuario = dataNascimentoUsuario;
    }

    public String getLoginUsuario() {
        return loginUsuario;
    }

    public void setLoginUsuario(String loginUsuario) {
        this.loginUsuario = loginUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }
    
    
    
 
}
