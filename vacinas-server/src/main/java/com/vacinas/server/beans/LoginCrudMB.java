/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vacinas.server.beans;

import com.vacinas.lib.Funcionario;
import com.vacinas.services.FuncionarioServices;
import com.vacinas.services.PacienteServices;
import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@ManagedBean(name = "loginCrudMB")
@SessionScoped
public class LoginCrudMB implements Serializable {

    private static Object usuarioLogado;
    private String login;
    private String senha;
    private boolean logado = false;
    private static boolean paciente = false;
    private boolean administrador = false;

    @Inject
    private PacienteServices pacienteServices;

    @Inject
    FuncionarioServices funcionarioServices;

    public LoginCrudMB() {
    }

    public String paginaLogin() {
        return "/login?faces-redirect=true";
    }

    public String efetuarLogin() {
        if (!logado) {
            usuarioLogado = pacienteServices.login(login, senha);
            if (Objects.isNull(usuarioLogado)) {
                usuarioLogado = funcionarioServices.login(login, senha);
                if (Objects.isNull(usuarioLogado)) {
                    FacesContext
                            .getCurrentInstance()
                            .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Usuário ou senha inválidos! Tente novamente..."));
                } else {
                    Funcionario f = (Funcionario) usuarioLogado;
                    administrador = f.getAdmin();
                    paciente = false;
                    logado = true;
                    return "/index?faces-redirect=true";
                }
            } else {
                paciente = true;
                administrador = false;
                logado = true;
                return "/index?faces-redirect=true";
            }
        }
        return "";
    }

    public String efetuarLogout() {
        usuarioLogado = null;
        logado = false;
        paciente = false;
        administrador = false;
        login = null;
        senha = null;
        return "/index?faces-redirect=true";
    }

    public void checkUsuarioLogado() throws IOException {
        if (!logado || Objects.isNull(usuarioLogado)) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/vacinas-server/faces/login.xhtml");
        }
    }

    public PacienteServices getPacienteServices() {
        return pacienteServices;
    }

    public void setPacienteServices(PacienteServices pacienteServices) {
        this.pacienteServices = pacienteServices;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Object getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Object usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    public boolean isLogado() {
        return logado;
    }

    public void setLogado(boolean logado) {
        this.logado = logado;
    }

    public boolean isPaciente() {
        return paciente;
    }

    public void setPaciente(boolean paciente) {
        this.paciente = paciente;
    }

    public static Object obterUsuarioLogado() {
        return usuarioLogado;
    }

    public static Boolean isPacienteLogado() {
        return paciente;
    }

    public Boolean getAdministrador() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

}
