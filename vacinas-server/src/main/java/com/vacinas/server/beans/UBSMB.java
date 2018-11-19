package com.vacinas.server.beans;

import com.vacinas.lib.UnidadeBasicaSaude;
import com.vacinas.services.UBSServices;
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

@Named(value = "ubsMB")
@ViewScoped
public class UBSMB implements Serializable {

    private UnidadeBasicaSaude ubs = new UnidadeBasicaSaude();
    private List<UnidadeBasicaSaude> ubss = new ArrayList<>();
    EntityManager em;

    @Inject
    private UBSServices ubsServices;

    @PostConstruct
    public void init() {
        refreshUnidadeBasicaSaudes();
    }

    public void refreshUnidadeBasicaSaude() {
        ubs = new UnidadeBasicaSaude();
    }

    public void refreshUnidadeBasicaSaudes() {
        ubss = ubsServices.loadAllUnidadeBasicaSaudes();
    }

    public UnidadeBasicaSaude getUnidadeBasicaSaude() {
        return ubs;
    }

    public void setUnidadeBasicaSaude(UnidadeBasicaSaude ubs) {
        this.ubs = ubs;
    }

    public UBSServices getUnidadeBasicaSaudeServices() {
        return ubsServices;
    }

    public void setUnidadeBasicaSaudeServices(UBSServices ubsServices) {
        this.ubsServices = ubsServices;
    }

    public List<UnidadeBasicaSaude> getUnidadeBasicaSaudes() {
        return ubss;
    }

    public void setUnidadeBasicaSaudes(List<UnidadeBasicaSaude> ubss) {
        this.ubss = ubss;
    }

    public void redirectForCrud() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().getFlash().put("selectedUnidadeBasicaSaude", ubs);
        FacesContext.getCurrentInstance().getExternalContext().redirect("ubs.xhtml");

    }

    public boolean login(String usuario, String senha) {
        Query query = em.createQuery("from UnidadeBasicaSaude where upper(nomeusuario)= :usuario and " + "upper(senha)= :senha");
        query.setParameter("usuario", usuario.toUpperCase());
        query.setParameter("senha", senha.toUpperCase());
        if (!query.getResultList().isEmpty()) {

            return true;
        } else {
            return false;
        }
    }

    public UnidadeBasicaSaude localizaPorNomeUsuario(String usuario) {

        Query query = em.createQuery("from UnidadeBasicaSaude where upper(nomeusuario)= :usuario");
        query.setParameter("usuario", usuario.toUpperCase());
        return (UnidadeBasicaSaude) query.getSingleResult();
    }
}
