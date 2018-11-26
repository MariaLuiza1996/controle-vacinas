package com.vacinas.server.beans;

import com.vacinas.lib.Cidade;
import com.vacinas.lib.Estado;
import com.vacinas.lib.Paciente;
import com.vacinas.lib.Vacina;
import com.vacinas.lib.VacinaPaciente;
import com.vacinas.services.CidadeServices;
import com.vacinas.services.EstadoServices;
import com.vacinas.services.PacienteServices;
import com.vacinas.services.VacinaPacienteServices;
import com.vacinas.services.VacinaServices;
import com.vacinas.services.dao.VacinaDAO;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "cadastroPacienteMB")
@ViewScoped
public class CadastroPacienteMB implements Serializable {

    private Paciente paciente;
    private List<Estado> estados;
    private List<Cidade> cidades;
    private Estado selectedEstado;
    private VacinaDAO dao;
    private List<VacinaPaciente> vacinaspaciente;
    private Vacina vacinapaciente;

    @Inject
    private PacienteServices pacienteServices;

    @Inject
    private EstadoServices estadoServices;

    @Inject
    private CidadeServices cidadeServices;

    @Inject
    private VacinaPacienteServices vacinaPacienteServices;

    @PostConstruct
    public void init() {
        if (LoginCrudMB.isPacienteLogado()) {
            paciente = (Paciente) LoginCrudMB.obterUsuarioLogado();
            refreshVacina();
            refreshEstados();
            selectedEstado = paciente.getCidade().getEstado();
            refreshCidades();
        } else {
            paciente = new Paciente();
        }
    }
    
    public void refreshVacina() {
        vacinaspaciente = vacinaPacienteServices.loadAllVacinaPacientes();
    }

    public void refreshEstados() {
        estados = estadoServices.loadAllEstados();
    }

    public void update() throws IOException {
        pacienteServices.update(paciente);
        redirectForPacientes();
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public PacienteServices getPacienteServices() {
        return pacienteServices;
    }

    public void setPacienteServices(PacienteServices pacienteServices) {
        this.pacienteServices = pacienteServices;
    }

    public void redirectForPacientes() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("cadastroPaciente.xhtml");
    }

    public void refreshCidades() {
        cidades = cidadeServices.loadByEstado(selectedEstado.getId());
    }

    public List<Estado> getEstados() {
        return estados;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }

    public List<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    public EstadoServices getEstadoServices() {
        return estadoServices;
    }

    public void setEstadoServices(EstadoServices estadoServices) {
        this.estadoServices = estadoServices;
    }

    public CidadeServices getCidadeServices() {
        return cidadeServices;
    }

    public void setCidadeServices(CidadeServices cidadeServices) {
        this.cidadeServices = cidadeServices;
    }

    public Estado getSelectedEstado() {
        return selectedEstado;
    }

    public void setSelectedEstado(Estado selectedEstado) {
        this.selectedEstado = selectedEstado;
    }

    public List<VacinaPaciente> getVacinaspaciente() {
        return vacinaspaciente;
    }

    public void setVacinaspaciente(List<VacinaPaciente> vacinaspaciente) {
        this.vacinaspaciente = vacinaspaciente;
    }

    public Vacina getVacinapaciente() {
        return vacinapaciente;
    }

    public void setVacinapaciente(Vacina vacinapaciente) {
        this.vacinapaciente = vacinapaciente;
    }

}
