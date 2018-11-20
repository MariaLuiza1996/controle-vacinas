package com.vacinas.server.beans;

import com.vacinas.lib.Funcionario;
import com.vacinas.lib.Paciente;
import com.vacinas.lib.Vacina;
import com.vacinas.lib.VacinaPaciente;
import com.vacinas.services.FuncionarioServices;
import com.vacinas.services.PacienteServices;
import com.vacinas.services.VacinaPacienteServices;
import com.vacinas.services.VacinaServices;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "vacinapacienteCrudMB")
@ViewScoped
public class VacinaPacienteCrudMB implements Serializable {

    private VacinaPaciente vacinapaciente;
    private List<Paciente> pacientes;
    private List<Vacina> vacinas;
    private List<Funcionario> funcionarios;

    @Inject
    private VacinaPacienteServices vacinapacienteServices;

    @Inject
    private VacinaServices vacinaServices;
    
    @Inject
    PacienteServices pacienteServices;
    
    @Inject
    FuncionarioServices funcionarioServices;
    
    @PostConstruct
    public void init() {
        vacinapaciente = (VacinaPaciente) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("selectedVacinaPaciente");
        if (Objects.isNull(vacinapaciente)) {
            vacinapaciente = new VacinaPaciente();
        }
        refreshPacientes();
        refreshVacinas();
        refreshFuncionarios();
    }
    
    public void refreshFuncionarios(){
        funcionarios = funcionarioServices.loadAllFuncionarios();
    }
    public void refreshPacientes(){
        pacientes = pacienteServices.loadAllPacientes();
    }
    
    public void refreshVacinas(){
        vacinas = vacinaServices.loadAllVacinas();
    }

    public void save() throws IOException {
        vacinapacienteServices.save(vacinapaciente);
        redirectForVacinaPacientes();
    }

    public void update() throws IOException {
        vacinapacienteServices.update(vacinapaciente);
        redirectForVacinaPacientes();
    }

    public void delete(Integer id) throws IOException {
        vacinapaciente= vacinapacienteServices.find(id);
        vacinapacienteServices.delete(vacinapaciente.getId());
        redirectForVacinaPacientes();
    }

    public void refreshVacinaPaciente() {
        vacinapaciente = new VacinaPaciente();
    }

    public VacinaPaciente getVacinaPaciente() {
        return vacinapaciente;
    }

    public void setVacinaPaciente(VacinaPaciente vacinapaciente) {
        this.vacinapaciente = vacinapaciente;
    }

    public VacinaPacienteServices getVacinaPacienteServices() {
        return vacinapacienteServices;
    }

    public void setVacinaPacienteServices(VacinaPacienteServices vacinapacienteServices) {
        this.vacinapacienteServices = vacinapacienteServices;
    }

    public void redirectForVacinaPacientes() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("listar.xhtml");
    }
    
    public void getVacinaPacienteForEdition(Integer id) {
        vacinapaciente = vacinapacienteServices.find(id);
        
    }
public void novoVacinaPaciente() {
        vacinapaciente = new VacinaPaciente();
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public List<Vacina> getVacinas() {
        return vacinas;
    }

    public void setVacinas(List<Vacina> vacinas) {
        this.vacinas = vacinas;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }


}
