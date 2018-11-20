package com.vacinas.server.beans;

import com.vacinas.lib.EstoqueVacina;
import com.vacinas.lib.ItensNota;
import com.vacinas.lib.NotaFiscal;
import com.vacinas.lib.UnidadeBasicaSaude;
import com.vacinas.lib.Vacina;
import com.vacinas.services.EstoqueVacinaServices;
import com.vacinas.services.ItensNotaServices;
import com.vacinas.services.NotaFiscalServices;
import com.vacinas.services.UBSServices;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "estoquevacinaCrudMB")
@ViewScoped
public class EstoqueVacinaCrudMB implements Serializable {

    private EstoqueVacina estoquevacina;
    private ItensNota itensnota;
    private List<NotaFiscal> notasfiscais;
    private List<Vacina> vacinas;
    private List<EstoqueVacina> estoqueVacinaList;
    private List<ItensNota> itensnotas;
    private List<EstoqueVacina> estoque;
    private NotaFiscal nota;
    private List<UnidadeBasicaSaude> ubs;
    Integer codNota;

    @Inject
    private EstoqueVacinaServices estoquevacinaServices;

    @Inject
    private NotaFiscalServices notaServices;

    @Inject
    private ItensNotaServices itensServices;

    @Inject
    UBSServices ubsServices;

    @PostConstruct
    public void init() {

//        Exemplo de como obter o cns do usuario logado e   utilizar para realizar uma consulta
//        String cns = LoginMB.usuarioLogado();
//        vacinasList = vacinaServices.loadByPaciente(cns);
        estoquevacina = (EstoqueVacina) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("selectedEstoqueVacina");
        if (Objects.isNull(estoquevacina)) {
            estoquevacina = new EstoqueVacina();
        }
        refreshUbs();
    }
    
    public void refreshUbs(){
        ubs= ubsServices.loadAllUnidadeBasicaSaudes();
    }

    public void save() throws IOException {
        estoquevacinaServices.save(estoquevacina);
        redirectForEstoqueVacinas();
        estoquevacina = new EstoqueVacina();
    }

    public void getEstoqueVacinaForEdition(Integer id) {
        estoquevacina = estoquevacinaServices.find(id);

    }

    public Integer getCodNota() {
        return codNota;
    }

    public void setCodNota(Integer codNota) {
        this.codNota = codNota;
    }

    public void buscarCodnota() {

        nota = notaServices.loadByNota(codNota);
        //UnidadeBasicaSaude ubs = ubsServices.find(1);//Trocar para busca através de selectOneMenu
        estoqueVacinaList = new ArrayList<>();
        for (ItensNota in : nota.getItens()) {
            estoqueVacinaList.add(new EstoqueVacina(in));
        }
    }

    public void update() throws IOException {
        estoquevacinaServices.update(estoquevacina);
        redirectForEstoqueVacinas();
    }

    public void delete(Integer id) throws IOException {
        estoquevacina = estoquevacinaServices.find(id);
        estoquevacinaServices.delete(estoquevacina.getId());
        redirectForEstoqueVacinas();
        novoEstoqueVacina();
    }

    public void refreshEstoqueVacina() {
        estoquevacina = new EstoqueVacina();
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

    public void redirectForEstoqueVacinas() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("estoquevacinas.xhtml");
    }

    public void novoEstoqueVacina() {
        estoquevacina = new EstoqueVacina();
    }

    public List<ItensNota> getItensnotas() {
        return itensnotas;
    }

    public void setItensnotas(List<ItensNota> itensnotas) {
        this.itensnotas = itensnotas;
    }

    public List<Vacina> getVacinas() {
        return vacinas;
    }

    public void setVacinas(List<Vacina> vacinas) {
        this.vacinas = vacinas;
    }

    public ItensNota getItensnota() {
        return itensnota;
    }

    public void refreshNotas() {
        itensnotas = itensServices.loadByNota(codNota);
    }

    public void setItensnota(ItensNota itensnota) {
        this.itensnota = itensnota;
    }

    public List<EstoqueVacina> getEstoqueVacinaList() {
        return estoqueVacinaList;
    }

    public void setEstoqueVacinaList(List<EstoqueVacina> estoqueVacinaList) {
        this.estoqueVacinaList = estoqueVacinaList;
    }

    public NotaFiscal getNota() {
        return nota;
    }

    public void setNota(NotaFiscal nota) {
        this.nota = nota;
    }

    public List<UnidadeBasicaSaude> getUbs() {
        return ubs;
    }

    public void setUbs(List<UnidadeBasicaSaude> ubs) {
        this.ubs = ubs;
    }
    
    

    public void saveEV() {
        for (EstoqueVacina ev : estoqueVacinaList) {
            estoquevacinaServices.save(ev);
        }
        nota = new NotaFiscal();
        estoqueVacinaList = new ArrayList<>();
        codNota = null;
        //ubs = new UnidadeBasicaSaude();
    }

}
