package com.vacinas.server.beans;

import com.vacinas.lib.Estado;
import com.vacinas.services.EstadoServices;
import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "estadoCrudMB")
@ViewScoped
public class EstadoCrudMB implements Serializable {

    private Estado estado;

    @Inject
    private EstadoServices estadoServices;

    @PostConstruct
    public void init() {
        estado = (Estado) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("selectedEstado");
        if (Objects.isNull(estado)) {
            estado = new Estado();
        }
    }
    

    public void save() throws IOException {
        estadoServices.save(estado);
        redirectForEstados();
    }

    public void update() throws IOException {
        estadoServices.update(estado);
        redirectForEstados();
    }

    public void delete() throws IOException {
        estadoServices.delete(estado.getId());
        redirectForEstados();
    }

    public void refreshEstado() {
        estado = new Estado();
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

    public void redirectForEstados() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("estados.xhtml");
    }

}
