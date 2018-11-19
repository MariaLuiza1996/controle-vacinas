
package com.vacinas.services;

import com.vacinas.lib.ItensNota;
import com.vacinas.services.dao.ItensNotaDAO;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ItensNotaServices {

    @Inject
    private ItensNotaDAO itensnotaDAO;
    
    public void save(ItensNota itensnota) {
        itensnotaDAO.save(itensnota);
    }
    
    public List<ItensNota> loadAllItensNotas(){
        return itensnotaDAO.loadAll();
    }

    public ItensNotaDAO getItensNotaDAO() {
        return itensnotaDAO;
    }

    public void setItensNotaDAO(ItensNotaDAO itensnotaDAO) {
        this.itensnotaDAO = itensnotaDAO;
    }

    public void update(ItensNota itensnota) {
        this.itensnotaDAO.update(itensnota);
    }
    
    public void delete(Integer id){
        this.itensnotaDAO.delete(id);
    }
     public ItensNota find(Integer id) {
        return itensnotaDAO.find(id);
    }
     
     public List<ItensNota> loadByNota(Integer codnotaId) {
         return itensnotaDAO.loadByNota(codnotaId);
     }
     
}
