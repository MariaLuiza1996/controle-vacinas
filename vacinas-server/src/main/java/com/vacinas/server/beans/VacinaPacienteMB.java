package com.vacinas.server.beans;

import com.vacinas.lib.VacinaPaciente;
import com.vacinas.services.VacinaPacienteServices;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "vacinapacienteMB")
@ViewScoped
public class VacinaPacienteMB implements Serializable {

    private VacinaPaciente vacinapaciente = new VacinaPaciente();
    private List<VacinaPaciente> vacinapacientes = new ArrayList<>();

    @Inject
    private VacinaPacienteServices vacinapacienteServices;

    @PostConstruct
    public void init() {
        refreshVacinaPacientes();
    }

    public void refreshVacinaPaciente() {
        vacinapaciente = new VacinaPaciente();
    }

    public void refreshVacinaPacientes() {
        vacinapacientes = vacinapacienteServices.loadAllVacinaPacientes();
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

    public List<VacinaPaciente> getVacinaPacientes() {
        return vacinapacientes;
    }

    public void setVacinaPacientes(List<VacinaPaciente> vacinapacientes) {
        this.vacinapacientes = vacinapacientes;
    }

    public void redirectForCrud() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().getFlash().put("selectedVacinaPaciente", vacinapaciente);
        FacesContext.getCurrentInstance().getExternalContext().redirect("vacinaspacientes.xhtml");

    }

}
