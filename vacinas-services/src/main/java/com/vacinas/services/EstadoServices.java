
package com.vacinas.services;

import com.vacinas.services.dao.EstadoDAO;
import com.vacinas.lib.Estado;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class EstadoServices {

    @Inject
    private EstadoDAO estadoDAO;
    
    public void save(Estado estado) {
        estadoDAO.save(estado);
    }
    
    public List<Estado> loadAllEstados(){
        return estadoDAO.loadAll();
    }

    public EstadoDAO getEstadoDAO() {
        return estadoDAO;
    }

    public void setEstadoDAO(EstadoDAO estadoDAO) {
        this.estadoDAO = estadoDAO;
    }

    public void update(Estado estado) {
        this.estadoDAO.update(estado);
    }
    
    public void delete(Integer id){
        this.estadoDAO.delete(id);
    }
    
}
