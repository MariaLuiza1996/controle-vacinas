package com.vacinas.server.beans;

import com.vacinas.lib.Paciente;
import com.vacinas.lib.Vacina;
import com.vacinas.lib.Funcionario;
import com.vacinas.services.PacienteServices;
import com.vacinas.services.FuncionarioServices;
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

@Named(value = "funcionarioCrudMB")
@ViewScoped
public class FuncionarioCrudMB implements Serializable {

    private Funcionario funcionario;
    private List<Paciente> pacientes;
    private List<Vacina> vacinas;
    
    @Inject
    private VacinaDAO daovacina;

    @Inject
    private FuncionarioServices funcionarioServices;

    @Inject
    PacienteServices pacienteServices;
    
    @Inject
    VacinaServices vacinaServices;
    
    @PostConstruct
    public void init() {
        funcionario = (Funcionario) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("selectedFuncionario");
        if (Objects.isNull(funcionario)) {
            funcionario = new Funcionario();
//            daovacina = new VacinaDAO();
        }
    }
    
    public void getFuncionarioForEdition(Integer id) {
        funcionario = funcionarioServices.find(id);
        
    }
    
    public void imprimeVacinas(){
        HashMap parametros= new HashMap();
        UtilRelatorios.imprimeRelatorio("relatorioVacinas", parametros,daovacina.loadAll());
    }

    public void refreshVacinas() {
        vacinas = vacinaServices.loadAllVacinas();
    }

    public void save() throws IOException {
        funcionarioServices.save(funcionario);
        redirectForFuncionarios();
    }

    public void update() throws IOException {
        funcionarioServices.update(funcionario);
        redirectForFuncionarios();
    }

    public void delete(Integer id) throws IOException {
        funcionario= funcionarioServices.find(id);
        funcionarioServices.delete(funcionario.getId());
        redirectForFuncionarios();
    }

    public void refreshFuncionario() {
        funcionario = new Funcionario();
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

    public void redirectForFuncionarios() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("funcionarios.xhtml");
    }
    
public void novoFuncionario() {
        funcionario = new Funcionario();
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


}
