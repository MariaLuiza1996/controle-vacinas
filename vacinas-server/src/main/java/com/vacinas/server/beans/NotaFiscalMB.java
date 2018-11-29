package com.vacinas.server.beans;

import com.vacinas.lib.NotaFiscal;
import com.vacinas.services.NotaFiscalServices;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "notafiscalMB")
@ViewScoped
public class NotaFiscalMB implements Serializable {

    private NotaFiscal notafiscal = new NotaFiscal();
    private List<NotaFiscal> notafiscals = new ArrayList<>();

    @Inject
    private NotaFiscalServices notafiscalServices;

    @PostConstruct
    public void init() {
        refreshNotaFiscals();
    }

    public void refreshNotaFiscal() {
        notafiscal = new NotaFiscal();
    }

    public void refreshNotaFiscals() {
        notafiscals = notafiscalServices.loadAllNotaFiscals();
    }

    public NotaFiscal getNotaFiscal() {
        return notafiscal;
    }

    public void setNotaFiscal(NotaFiscal notafiscal) {
        this.notafiscal = notafiscal;
    }

    public NotaFiscalServices getNotaFiscalServices() {
        return notafiscalServices;
    }

    public void setNotaFiscalServices(NotaFiscalServices notafiscalServices) {
        this.notafiscalServices = notafiscalServices;
    }

    public List<NotaFiscal> getNotaFiscals() {
        return notafiscals;
    }

    public void setNotaFiscals(List<NotaFiscal> notafiscals) {
        this.notafiscals = notafiscals;
    }

    public void redirectForCrud() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().getFlash().put("selectedNotaFiscal", notafiscal);
        FacesContext.getCurrentInstance().getExternalContext().redirect("notafiscal.xhtml");

    }
}
