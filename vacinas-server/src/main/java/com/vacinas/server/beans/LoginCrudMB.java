/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vacinas.server.beans;

import com.vacinas.lib.Paciente;
import com.vacinas.services.PacienteServices;
import com.vacinas.services.dao.PacienteDAO;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@ManagedBean(name = "loginCrudMB")
@SessionScoped
public class LoginCrudMB implements Serializable {

    private PacienteLogado pacientelogado;
    private String cns;
    private String senha;
    PacienteDAO dao;

    @Inject
    private PacienteServices pacienteServices;

    public LoginCrudMB() {
        dao = new PacienteDAO();
    }

    public String paginaLogin() {
        return "/login?faces-redirect=true";
    }

    public String efetuarLogin() {
        Paciente paciente = pacienteServices.login(cns, senha);
        if(paciente != null){
            this.pacientelogado.setPaciente(paciente);
            return "/index?faces-redirect=true";
        }
        
        return null;
    }

    public String efetuarLogout() {
        pacientelogado = null;
        return "/index?faces-redirect=true";
    }

    public PacienteServices getPacienteServices() {
        return pacienteServices;
    }

    public void setPacienteServices(PacienteServices pacienteServices) {
        this.pacienteServices = pacienteServices;
    }

    public PacienteLogado getPacientelogado() {
        return pacientelogado;
    }

    public void setPacientelogado(PacienteLogado pacientelogado) {
        this.pacientelogado = pacientelogado;
    }

    public String getCns() {
        return cns;
    }

    public void setCns(String cns) {
        this.cns = cns;
    }

   


   

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    

    public PacienteDAO getDao() {
        return dao;
    }

    public void setDao(PacienteDAO dao) {
        this.dao = dao;
    }

  

}
