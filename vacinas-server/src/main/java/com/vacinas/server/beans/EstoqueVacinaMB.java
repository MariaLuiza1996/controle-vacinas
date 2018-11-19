package com.vacinas.server.beans;

import com.vacinas.lib.EstoqueVacina;
import com.vacinas.lib.ItensNota;
import com.vacinas.services.EstoqueVacinaServices;
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

@Named(value = "estoquevacinaMB")
@ViewScoped
public class EstoqueVacinaMB implements Serializable {

    private EstoqueVacina estoquevacina = new EstoqueVacina();
    private List<EstoqueVacina> estoquevacinas = new ArrayList<>();
    private List<ItensNota> itensnotas= new ArrayList<>();;
    private ItensNota itensnota= new ItensNota();
    private ItensNotaDAO itensnotaDAO;
    EntityManager em;

    @Inject
    private EstoqueVacinaServices estoquevacinaServices;

    @PostConstruct
    public void init() {
        refreshEstoqueVacinas();
    }

    public void refreshEstoqueVacina() {
        estoquevacina = new EstoqueVacina();
    }

    public void refreshEstoqueVacinas() {
        estoquevacinas = estoquevacinaServices.loadAllEstoqueVacinas();
    }
    

    public EstoqueVacina getEstoqueVacina() {
        return estoquevacina;
    }

    public void setEstoqueVacina(EstoqueVacina estoquevacina) {
        this.estoquevacina = estoquevacina;
    }

    public EstoqueVacinaServices getEstoqueVacinaServices() {
        return estoquevacinaServices;
    }

    public void setEstoqueVacinaServices(EstoqueVacinaServices estoquevacinaServices) {
        this.estoquevacinaServices = estoquevacinaServices;
    }

    public List<EstoqueVacina> getEstoqueVacinas() {
        return estoquevacinas;
    }

    public void setEstoqueVacinas(List<EstoqueVacina> estoquevacinas) {
        this.estoquevacinas = estoquevacinas;
    }

    public void redirectForCrud() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().getFlash().put("selectedEstoqueVacina", estoquevacina);
        FacesContext.getCurrentInstance().getExternalContext().redirect("estoquevacinas.xhtml");

    }

    public boolean login(String usuario, String senha) {
        Query query = em.createQuery("from EstoqueVacina where upper(nomeusuario)= :usuario and " + "upper(senha)= :senha");
        query.setParameter("usuario", usuario.toUpperCase());
        query.setParameter("senha", senha.toUpperCase());
        if (!query.getResultList().isEmpty()) {

            return true;
        } else {
            return false;
        }
    }

    public EstoqueVacina localizaPorNomeUsuario(String usuario) {

        Query query = em.createQuery("from EstoqueVacina where upper(nomeusuario)= :usuario");
        query.setParameter("usuario", usuario.toUpperCase());
        return (EstoqueVacina) query.getSingleResult();
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
