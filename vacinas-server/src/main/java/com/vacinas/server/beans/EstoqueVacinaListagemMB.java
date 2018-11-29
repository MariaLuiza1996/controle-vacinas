package com.vacinas.server.beans;

import com.vacinas.lib.EstoqueVacina;
import com.vacinas.services.EstoqueVacinaServices;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "estoqueVacinaListagemMB")
@ViewScoped
public class EstoqueVacinaListagemMB implements Serializable {

    private List<EstoqueVacina> estoqueVacinaList;

    @Inject
    private EstoqueVacinaServices estoquevacinaServices;

    @PostConstruct
    public void init() {
        estoqueVacinaList = estoquevacinaServices.loadAllEstoqueVacinas();
    }

    public List<EstoqueVacina> getEstoqueVacinaList() {
        return estoqueVacinaList;
    }

    public void setEstoqueVacinaList(List<EstoqueVacina> estoqueVacinaList) {
        this.estoqueVacinaList = estoqueVacinaList;
    }

}
