package com.vacinas.server.beans;

import com.vacinas.lib.ItensNota;
import com.vacinas.lib.NotaFiscal;
import com.vacinas.lib.NotaFiscal;
import com.vacinas.lib.NotaFiscal;
import com.vacinas.lib.Vacina;
import static com.vacinas.server.beans.EntityManagerUtil.getEntityManager;
import com.vacinas.services.NotaFiscalServices;
import com.vacinas.services.NotaFiscalServices;
import com.vacinas.services.NotaFiscalServices;
import com.vacinas.services.dao.NotaFiscalDAO;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.TypedQuery;

@Named(value = "notafiscalCrudMB")
@ViewScoped
public class NotaFiscalCrudMB implements Serializable {
    private NotaFiscal notafiscal;
    private List<NotaFiscal> notas;
    private List<Vacina> vacinas;
    //private List<NotaFiscal> itens;
    private NotaFiscal selectedNota;
    private ItensNota itens;

    @Inject
    private NotaFiscalServices notafiscalServices;

    @Inject
    private NotaFiscalDAO notafiscalDAO;
    
    @Inject
    private NotaFiscalServices notaServices;

    @Inject
    private NotaFiscalServices itensServices;

    @PostConstruct
    public void init() {
        notafiscal = (NotaFiscal) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("selectedNotaFiscal");
        if (Objects.isNull(notafiscal)) {
            notafiscal = new NotaFiscal();
    }
        
        //refreshNotas();
    }
    

    public void save() throws IOException {
        notafiscalServices.save(notafiscal);
        redirectForNotaFiscals();
        notafiscal= new NotaFiscal();
    }

    public void getNotaFiscalForEdition(Integer id) {
        notafiscal = notafiscalServices.find(id);
        
    }

    public void update() throws IOException {
        notafiscalServices.update(notafiscal);
        redirectForNotaFiscals();
    }

    public void delete(Integer id) throws IOException {
        notafiscal = notafiscalServices.find(id);
        notafiscalServices.delete(notafiscal.getId());
        redirectForNotaFiscals();
        novoNotaFiscal();
    }

    public void refreshNotaFiscal() {
        notafiscal = new NotaFiscal();
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

    public void redirectForNotaFiscals() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("notafiscal.xhtml");
    }

    public void novoNotaFiscal() {
        notafiscal = new NotaFiscal();
    }

    public NotaFiscal getNotafiscal() {
        return notafiscal;
    }

    public void setNotafiscal(NotaFiscal notafiscal) {
        this.notafiscal = notafiscal;
    }

    public List<NotaFiscal> getNotas() {
        return notas;
    }

    public void setNotas(List<NotaFiscal> notas) {
        this.notas = notas;
    }


    public NotaFiscal getItensnota() {
        return notafiscal;
    }

    public void setItensnota(NotaFiscal notafiscal) {
        this.notafiscal = notafiscal;
    }

    public List<Vacina> getVacinas() {
        return vacinas;
    }

    public void setVacinas(List<Vacina> vacinas) {
        this.vacinas = vacinas;
    }

    public ItensNota getItens() {
        return itens;
    }

    public void setItens(ItensNota itens) {
        this.itens = itens;
    }     
     
     
     



}
