package com.vacinas.server.beans;

import com.vacinas.lib.Cidade;
import com.vacinas.lib.Estado;
import com.vacinas.lib.Paciente;
import com.vacinas.lib.Vacina;
import com.vacinas.services.CidadeServices;
import com.vacinas.services.EstadoServices;
import com.vacinas.services.PacienteServices;
import com.vacinas.services.VacinaServices;
import com.vacinas.services.dao.VacinaDAO;
import com.vacinas.util.UtilRelatorios;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "pacienteCrudMB")
@ViewScoped
public class PacienteCrudMB implements Serializable {

    private Paciente paciente;
    private List<Estado> estados;
    private List<Cidade> cidades;
    private Estado selectedEstado;
    private VacinaDAO dao;
    private List<Vacina> vacinas;

    @Inject
    private PacienteServices pacienteServices;

    @Inject
    private EstadoServices estadoServices;

    @Inject
    private CidadeServices cidadeServices;
    
    @Inject
    private VacinaServices vacinaServices;

//    public PacienteCrudMB() {
//       //dao= new VacinaDAO();
//       //vacinaServices= new VacinaServices();
//    }
    
     
    @PostConstruct
    public void init() {
        paciente = (Paciente) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("selectedPaciente");
        if (Objects.isNull(paciente)) {
            paciente = new Paciente();
        } else {
            selectedEstado = paciente.getCidade().getEstado();
        }
        refreshEstados();
        dao= new VacinaDAO();
    }
    
    public void imprimeVacinas(){
        HashMap parametros= new HashMap();
        UtilRelatorios.imprimeRelatorio("relatorioVacinas", parametros, vacinas=dao.loadAll());
    }

    
   

    public void refreshEstados() {
        estados = estadoServices.loadAllEstados();
    }

    public void save() throws IOException {
        pacienteServices.save(paciente);
        redirectForPacientes();
        paciente= new Paciente();
    }

    public void getPacienteForEdition(Integer id) {
        paciente = pacienteServices.find(id);
        selectedEstado = paciente.getCidade().getEstado();
        refreshCidades();
    }

    public void update() throws IOException {
        pacienteServices.update(paciente);
        redirectForPacientes();
    }

    public void delete(Integer id) throws IOException {
        paciente = pacienteServices.find(id);
        pacienteServices.delete(paciente.getId());
        redirectForPacientes();
        novoPaciente();
    }

    public void refreshPaciente() {
        paciente = new Paciente();
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
        FacesContext.getCurrentInstance().getExternalContext().redirect("pacientes.xhtml");
    }

    public void novoPaciente() {
        paciente = new Paciente();
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

}
