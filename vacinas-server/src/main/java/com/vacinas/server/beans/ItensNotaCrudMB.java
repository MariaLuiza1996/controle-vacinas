package com.vacinas.server.beans;

import com.vacinas.lib.ItensNota;
import com.vacinas.lib.ItensNota;
import com.vacinas.lib.NotaFiscal;
import com.vacinas.lib.Vacina;
import static com.vacinas.server.beans.EntityManagerUtil.getEntityManager;
import com.vacinas.services.ItensNotaServices;
import com.vacinas.services.ItensNotaServices;
import com.vacinas.services.NotaFiscalServices;
import com.vacinas.services.dao.ItensNotaDAO;
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

@Named(value = "itensnotaCrudMB")
@ViewScoped
public class ItensNotaCrudMB implements Serializable {
    private ItensNota itensnota;
    private List<NotaFiscal> notas;
    private List<Vacina> vacinas;
    private List<ItensNota> itens;
    private NotaFiscal selectedNota;
    Integer codNota;

    @Inject
    private ItensNotaServices itensnotaServices;

    @Inject
    private ItensNotaDAO itensnotaDAO;
    
    @Inject
    private NotaFiscalServices notaServices;

    @Inject
    private ItensNotaServices itensServices;

    @PostConstruct
    public void init() {
        itensnota = (ItensNota) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("selectedItensNota");
        if (Objects.isNull(itensnota)) {
            itensnota = new ItensNota();
    }
        
        //refreshNotas();
    }

    public Integer getCodNota() {
        return codNota;
    }

    public void setCodNota(Integer codNota) {
        this.codNota = codNota;
    }

    public void save() throws IOException {
        itensnotaServices.save(itensnota);
        redirectForItensNotas();
        itensnota= new ItensNota();
    }

    public void getItensNotaForEdition(Integer id) {
        itensnota = itensnotaServices.find(id);
        
    }

    public void update() throws IOException {
        itensnotaServices.update(itensnota);
        redirectForItensNotas();
    }

    public void delete(Integer id) throws IOException {
        itensnota = itensnotaServices.find(id);
        itensnotaServices.delete(itensnota.getId());
        redirectForItensNotas();
        novoItensNota();
    }

    public void refreshItensNota() {
        itensnota = new ItensNota();
    }

    public ItensNota getItensNota() {
        return itensnota;
    }

    public void setItensNota(ItensNota itensnota) {
        this.itensnota = itensnota;
    }

    public ItensNotaServices getItensNotaServices() {
        return itensnotaServices;
    }

    public void setItensNotaServices(ItensNotaServices itensnotaServices) {
        this.itensnotaServices = itensnotaServices;
    }

    public void redirectForItensNotas() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("itensnotas.xhtml");
    }

    public void novoItensNota() {
        itensnota = new ItensNota();
    }
    
    public NotaFiscal getSelectedNota() {
        return selectedNota;
    }

    public void setSelectedNota(NotaFiscal selectedNota) {
        this.selectedNota = selectedNota;
    }

    public List<NotaFiscal> getNotas() {
        return notas;
    }

    public void setNotas(List<NotaFiscal> notas) {
        this.notas = notas;
    }

    public List<ItensNota> getItens() {
        return itens;
    }

    public void setItens(List<ItensNota> itens) {
        this.itens = itens;
    }

    public ItensNota getItensnota() {
        return itensnota;
    }

    public void setItensnota(ItensNota itensnota) {
        this.itensnota = itensnota;
    }

    public List<Vacina> getVacinas() {
        return vacinas;
    }

    public void setVacinas(List<Vacina> vacinas) {
        this.vacinas = vacinas;
    }

         
     
     
     



}
