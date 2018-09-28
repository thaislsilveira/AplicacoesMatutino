/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aplicacoesmatutino.model;

/**
 *
 * @author PC 05
 */
public class TipoUsuario {
    private  Integer idTipoUsuario;
    private String descricaoTipoUsuario ;

    public TipoUsuario() {
    }

    public TipoUsuario(Integer idTipoUsuario, String descricaoTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
        this.descricaoTipoUsuario = descricaoTipoUsuario;
    }

    public Integer getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(Integer idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public String getDescricaoTipoUsuario() {
        return descricaoTipoUsuario;
    }

    public void setDescricaoTipoUsuario(String descricaoTipoUsuario) {
        this.descricaoTipoUsuario = descricaoTipoUsuario;
    }

   
}