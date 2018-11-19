package com.vacinas.server.beans;

import com.vacinas.lib.Paciente;
import com.vacinas.lib.Vacina;
import com.vacinas.lib.Vacina;
import com.vacinas.services.PacienteServices;
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

@Named(value = "vacinaCrudMB")
@ViewScoped
public class VacinaCrudMB implements Serializable {

    private Vacina vacina;
    private List<Paciente> pacientes;
    private List<Vacina> vacinas;

    @Inject
    private VacinaServices vacinaServices;

    @Inject
    PacienteServices pacienteServices;
    
    @PostConstruct
    public void init() {
        vacina = (Vacina) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("selectedVacina");
        if (Objects.isNull(vacina)) {
            vacina = new Vacina();
        }
        refreshPacientes();
        refreshVacinas();
    }
    
    public void refreshPacientes(){
        pacientes = pacienteServices.loadAllPacientes();
    }
    
    public void refreshVacinas(){
        vacinas = vacinaServices.loadAllVacinas();
    }

    public void save() throws IOException {
        vacinaServices.save(vacina);
        redirectForVacinas();
    }

    public void update() throws IOException {
        vacinaServices.update(vacina);
        redirectForVacinas();
    }

    public void delete(Integer id) throws IOException {
        vacina= vacinaServices.find(id);
        vacinaServices.delete(vacina.getId());
        redirectForVacinas();
    }

    public void refreshVacina() {
        vacina = new Vacina();
    }

    public Vacina getVacina() {
        return vacina;
    }

    public void setVacina(Vacina vacina) {
        this.vacina = vacina;
    }

    public VacinaServices getVacinaServices() {
        return vacinaServices;
    }

    public void setVacinaServices(VacinaServices vacinaServices) {
        this.vacinaServices = vacinaServices;
    }

    public void redirectForVacinas() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("vacinas.xhtml");
    }
    
    public void getVacinaForEdition(Integer id) {
        vacina = vacinaServices.find(id);
        
    }
public void novoVacina() {
        vacina = new Vacina();
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
