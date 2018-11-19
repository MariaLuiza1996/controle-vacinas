package com.vacinas.server.beans;

import com.vacinas.lib.Vacina;
import com.vacinas.services.VacinaServices;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "vacinaMB")
@ViewScoped
public class VacinaMB implements Serializable {

    private Vacina vacina = new Vacina();
    private List<Vacina> vacinas = new ArrayList<>();

    @Inject
    private VacinaServices vacinaServices;

    @PostConstruct
    public void init() {
        refreshVacinas();
    }

    public void refreshVacina() {
        vacina = new Vacina();
    }

    public void refreshVacinas() {
        vacinas = vacinaServices.loadAllVacinas();
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

    public List<Vacina> getVacinas() {
        return vacinas;
    }

    public void setVacinas(List<Vacina> vacinas) {
        this.vacinas = vacinas;
    }

    public void redirectForCrud() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().getFlash().put("selectedVacina", vacina);
        FacesContext.getCurrentInstance().getExternalContext().redirect("vacinas.xhtml");

    }

}
