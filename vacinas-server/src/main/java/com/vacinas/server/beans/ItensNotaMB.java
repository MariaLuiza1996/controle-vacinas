package com.vacinas.server.beans;

import com.vacinas.lib.ItensNota;
import com.vacinas.lib.ItensNota;
import com.vacinas.services.ItensNotaServices;
import com.vacinas.services.dao.ItensNotaDAO;
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

@Named(value = "itensnotaMB")
@ViewScoped
public class ItensNotaMB implements Serializable {

    private ItensNota itensnota = new ItensNota();
    private List<ItensNota> itensnotas;
    private ItensNotaDAO itensnotaDAO;
    EntityManager em;

    @Inject
    private ItensNotaServices itensnotaServices;

    @PostConstruct
    public void init() {
        refreshItensNotas();
    }

    public void refreshItensNota() {
        itensnota = new ItensNota();
    }

    public void refreshItensNotas() {
        itensnotas = itensnotaServices.loadAllItensNotas();
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

    public List<ItensNota> getItensNotas() {
        return itensnotas;
    }

    public void setItensNotas(List<ItensNota> itensnotas) {
        this.itensnotas = itensnotas;
    }

    public void redirectForCrud() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().getFlash().put("selectedItensNota", itensnota);
        FacesContext.getCurrentInstance().getExternalContext().redirect("itensnotas.xhtml");

    }

    public boolean login(String usuario, String senha) {
        Query query = em.createQuery("from ItensNota where upper(nomeusuario)= :usuario and " + "upper(senha)= :senha");
        query.setParameter("usuario", usuario.toUpperCase());
        query.setParameter("senha", senha.toUpperCase());
        if (!query.getResultList().isEmpty()) {

            return true;
        } else {
            return false;
        }
    }

    public ItensNota localizaPorNomeUsuario(String usuario) {

        Query query = em.createQuery("from ItensNota where upper(nomeusuario)= :usuario");
        query.setParameter("usuario", usuario.toUpperCase());
        return (ItensNota) query.getSingleResult();
    }
    
     public List<ItensNota> loadByNota(Integer codnotaId) {
        return itensnotaDAO.loadByNota(codnotaId);
    }

    public List<ItensNota> getItensnotas() {
        return itensnotas;
    }

    public void setItensnotas(List<ItensNota> itensnotas) {
        this.itensnotas = itensnotas;
    }

    public ItensNota getItensnota() {
        return itensnota;
    }

    public void setItensnota(ItensNota itensnota) {
        this.itensnota = itensnota;
    }

   

    
     
}
