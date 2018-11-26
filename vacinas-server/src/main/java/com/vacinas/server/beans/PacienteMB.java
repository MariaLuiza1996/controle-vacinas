package com.vacinas.server.beans;

import com.vacinas.lib.Paciente;
import com.vacinas.lib.VacinaPaciente;
import com.vacinas.services.PacienteServices;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@Named(value = "pacienteMB")
@ViewScoped
public class PacienteMB implements Serializable {

    private Paciente paciente = new Paciente();
    private List<Paciente> pacientes = new ArrayList<>();
    private List<VacinaPaciente> vacinasPacientes;
    EntityManager em;

    @Inject
    private PacienteServices pacienteServices;

    @PostConstruct
    public void init() {
        refreshPacientes();
    }

    public void refreshPaciente() {
        paciente = new Paciente();
    }

    public void refreshPacientes() {
        pacientes = pacienteServices.loadAllPacientes();
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

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public void redirectForCrud() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().getFlash().put("selectedPaciente", paciente);
        FacesContext.getCurrentInstance().getExternalContext().redirect("pacientes.xhtml");

    }

    public boolean login(String usuario, String senha) {
        Query query = em.createQuery("from Paciente where upper(nomeusuario)= :usuario and " + "upper(senha)= :senha");
        query.setParameter("usuario", usuario.toUpperCase());
        query.setParameter("senha", senha.toUpperCase());
        if (!query.getResultList().isEmpty()) {

            return true;
        } else {
            return false;
        }
    }

    public Paciente localizaPorNomeUsuario(String usuario) {

        Query query = em.createQuery("from Paciente where upper(nomeusuario)= :usuario");
        query.setParameter("usuario", usuario.toUpperCase());
        return (Paciente) query.getSingleResult();
    }

    public List<VacinaPaciente> getVacinasPacientes() {
        return vacinasPacientes;
    }

    public void setVacinasPacientes(List<VacinaPaciente> vacinasPacientes) {
        this.vacinasPacientes = vacinasPacientes;
    }
    
    
}
