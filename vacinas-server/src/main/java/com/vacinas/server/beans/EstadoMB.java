package com.vacinas.server.beans;

import com.vacinas.lib.Estado;
import com.vacinas.services.EstadoServices;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "estadoMB")
@ViewScoped
public class EstadoMB implements Serializable {

    private Estado estado = new Estado();
    private List<Estado> estados = new ArrayList<>();

    @Inject
    private EstadoServices estadoServices;

    @PostConstruct
    public void init() {
        refreshEstados();
    }

    public void refreshEstado() {
        estado = new Estado();
    }

    public void refreshEstados() {
        estados = estadoServices.loadAllEstados();
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public EstadoServices getEstadoServices() {
        return estadoServices;
    }

    public void setEstadoServices(EstadoServices estadoServices) {
        this.estadoServices = estadoServices;
    }

    public List<Estado> getEstados() {
        return estados;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }

    public void redirectForCrud() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().getFlash().put("selectedEstado", estado);
        FacesContext.getCurrentInstance().getExternalContext().redirect("estadoCrud.xhtml");

    }

}
