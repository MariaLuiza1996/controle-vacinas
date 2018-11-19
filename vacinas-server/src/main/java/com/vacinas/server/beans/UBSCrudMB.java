package com.vacinas.server.beans;

import com.vacinas.lib.Cidade;
import com.vacinas.lib.Estado;
import com.vacinas.lib.UnidadeBasicaSaude;
import com.vacinas.services.CidadeServices;
import com.vacinas.services.EstadoServices;
import com.vacinas.services.UBSServices;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "ubsCrudMB")
@ViewScoped
public class UBSCrudMB implements Serializable {

    private UnidadeBasicaSaude ubs;
    private List<Estado> estados;
    private List<Cidade> cidades;
    private Estado selectedEstado;

    @Inject
    private UBSServices ubsServices;

    @Inject
    private EstadoServices estadoServices;

    @Inject
    private CidadeServices cidadeServices;

    @PostConstruct
    public void init() {
        ubs = (UnidadeBasicaSaude) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("selectedUnidadeBasicaSaude");
        if (Objects.isNull(ubs)) {
            ubs = new UnidadeBasicaSaude();
        } else {
            selectedEstado = ubs.getCidade().getEstado();
        }
        refreshEstados();
    }

    public void refreshEstados() {
        estados = estadoServices.loadAllEstados();
    }

    public void save() throws IOException {
        ubsServices.save(ubs);
        redirectForUnidadeBasicaSaudes();
        ubs= new UnidadeBasicaSaude();
    }

    public void getUnidadeBasicaSaudeForEdition(Integer id) {
        ubs = ubsServices.find(id);
        selectedEstado = ubs.getCidade().getEstado();
        refreshCidades();
    }

    public void update() throws IOException {
        ubsServices.update(ubs);
        redirectForUnidadeBasicaSaudes();
    }

    public void delete(Integer id) throws IOException {
        ubs = ubsServices.find(id);
        ubsServices.delete(ubs.getId());
        redirectForUnidadeBasicaSaudes();
        novoUnidadeBasicaSaude();
    }

    public void refreshUnidadeBasicaSaude() {
        ubs = new UnidadeBasicaSaude();
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

    public void redirectForUnidadeBasicaSaudes() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("ubs.xhtml");
    }

    public void novoUnidadeBasicaSaude() {
        ubs = new UnidadeBasicaSaude();
    }

    public void refreshCidades() {
        cidades = cidadeServices.loadByEstado(selectedEstado.getId());
    }

    public List<Estado> getEstados() {
        return estados;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }

    public List<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    public EstadoServices getEstadoServices() {
        return estadoServices;
    }

    public void setEstadoServices(EstadoServices estadoServices) {
        this.estadoServices = estadoServices;
    }

    public CidadeServices getCidadeServices() {
        return cidadeServices;
    }

    public void setCidadeServices(CidadeServices cidadeServices) {
        this.cidadeServices = cidadeServices;
    }

    public Estado getSelectedEstado() {
        return selectedEstado;
    }

    public void setSelectedEstado(Estado selectedEstado) {
        this.selectedEstado = selectedEstado;
    }

}
