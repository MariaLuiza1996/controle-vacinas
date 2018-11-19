
package com.vacinas.services;

import com.vacinas.services.dao.EstoqueVacinaDAO;
import com.vacinas.lib.EstoqueVacina;
import com.vacinas.lib.ItensNota;
import com.vacinas.services.dao.ItensNotaDAO;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class EstoqueVacinaServices {

    @Inject
    private EstoqueVacinaDAO estoquevacinaDAO;
    
    @Inject
    private ItensNotaDAO itensnota;
    
    public void save(EstoqueVacina estoquevacina) {
        estoquevacinaDAO.save(estoquevacina);
    }
    
    public List<EstoqueVacina> loadAllEstoqueVacinas(){
        return estoquevacinaDAO.loadAll();
    }

    public EstoqueVacinaDAO getEstoqueVacinaDAO() {
        return estoquevacinaDAO;
    }

    public void setEstoqueVacinaDAO(EstoqueVacinaDAO estoquevacinaDAO) {
        this.estoquevacinaDAO = estoquevacinaDAO;
    }

    public void update(EstoqueVacina estoquevacina) {
        this.estoquevacinaDAO.update(estoquevacina);
    }

    public void delete(Integer id) {
        this.estoquevacinaDAO.delete(id);
    }
    
    public EstoqueVacina find(Integer id) {
        return estoquevacinaDAO.find(id);
    }
    
    public EstoqueVacina loadByVacina(Integer id){
        return estoquevacinaDAO.loadByVacina(id);
    }
 
}
