package com.vacinas.server.beans;

import com.vacinas.lib.Funcionario;
import com.vacinas.services.FuncionarioServices;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "funcionarioMB")
@ViewScoped
public class FuncionarioMB implements Serializable {

    private Funcionario funcionario = new Funcionario();
    private List<Funcionario> funcionarios = new ArrayList<>();

    @Inject
    private FuncionarioServices funcionarioServices;

    @PostConstruct
    public void init() {
        refreshFuncionarios();
    }

    public void refreshFuncionario() {
        funcionario = new Funcionario();
    }

    public void refreshFuncionarios() {
        funcionarios = funcionarioServices.loadAllFuncionarios();
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public FuncionarioServices getFuncionarioServices() {
        return funcionarioServices;
    }

    public void setFuncionarioServices(FuncionarioServices funcionarioServices) {
        this.funcionarioServices = funcionarioServices;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public void redirectForCrud() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().getFlash().put("selectedFuncionario", funcionario);
        FacesContext.getCurrentInstance().getExternalContext().redirect("funcionarios.xhtml");

    }

}
