
package com.vacinas.services;

import com.vacinas.services.dao.UnidadeBasicaSaudeDAO;
import com.vacinas.lib.UnidadeBasicaSaude;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class UBSServices {

    @Inject
    private UnidadeBasicaSaudeDAO unidadeBasicaSaudeDAO;
    
    public void save(UnidadeBasicaSaude unidadeBasicaSaude) {
        unidadeBasicaSaudeDAO.save(unidadeBasicaSaude);
    }
    
    public List<UnidadeBasicaSaude> loadAllUnidadeBasicaSaudes(){
        return unidadeBasicaSaudeDAO.loadAll();
    }

    public UnidadeBasicaSaudeDAO getUnidadeBasicaSaudeDAO() {
        return unidadeBasicaSaudeDAO;
    }

    public void setUnidadeBasicaSaudeDAO(UnidadeBasicaSaudeDAO unidadeBasicaSaudeDAO) {
        this.unidadeBasicaSaudeDAO = unidadeBasicaSaudeDAO;
    }

    public void update(UnidadeBasicaSaude unidadeBasicaSaude) {
        this.unidadeBasicaSaudeDAO.update(unidadeBasicaSaude);
    }
    
    public void delete(Integer id){
        this.unidadeBasicaSaudeDAO.delete(id);
    }
     public UnidadeBasicaSaude find(Integer id) {
        return unidadeBasicaSaudeDAO.find(id);
    }
}
