
package com.vacinas.services;

import com.vacinas.services.dao.VacinaDAO;
import com.vacinas.lib.Vacina;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class VacinaServices {

    @Inject
    private VacinaDAO vacinaDAO;
    
    public void save(Vacina vacina) {
        vacinaDAO.save(vacina);
    }
    
    public List<Vacina> loadAllVacinas(){
        return vacinaDAO.loadAll();
    }
    
    public List<Vacina> loadVacinasByQuantidade(){
        return vacinaDAO.loadVacinasByQuantidade();
    }

    public VacinaDAO getVacinaDAO() {
        return vacinaDAO;
    }

    public void setVacinaDAO(VacinaDAO vacinaDAO) {
        this.vacinaDAO = vacinaDAO;
    }

    public void update(Vacina vacina) {
        this.vacinaDAO.update(vacina);
    }
    
    public void delete(Integer id){
        this.vacinaDAO.delete(id);
    }
     public Vacina find(Integer id) {
        return vacinaDAO.find(id);
    }
     
      public List<Vacina> loadAllPacientes(){
        return vacinaDAO.loadAll();
    }
    
      public List<Vacina> listaTodos(){
          return vacinaDAO.getListaTodos();
      }
}
