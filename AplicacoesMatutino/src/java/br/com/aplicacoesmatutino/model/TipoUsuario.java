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
    private  Integer id_Tipo_Usuario;
    private String Descricao_Tipo_usario ;

    public TipoUsuario() {
    }

    public TipoUsuario(Integer id_Tipo_Usuario, String Descricao_Tipo_usario) {
        this.id_Tipo_Usuario = id_Tipo_Usuario;
        this.Descricao_Tipo_usario = Descricao_Tipo_usario;
    }

    public Integer getId_Tipo_Usuario() {
        return id_Tipo_Usuario;
    }

    public void setId_Tipo_Usuario(Integer id_Tipo_Usuario) {
        this.id_Tipo_Usuario = id_Tipo_Usuario;
    }

    public String getDescricao_Tipo_usario() {
        return Descricao_Tipo_usario;
    }

    public void setDescricao_Tipo_usario(String Descricao_Tipo_usario) {
        this.Descricao_Tipo_usario = Descricao_Tipo_usario;
    }
   
    
}
