package com.vacinas.services;

import com.vacinas.services.dao.CidadeDAO;
import com.vacinas.lib.Cidade;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class CidadeServices {

    @Inject
    private CidadeDAO cidadeDAO;

    public CidadeDAO getCidadeDAO() {
        return cidadeDAO;
    }

    public void setCidadeDAO(CidadeDAO cidadeDAO) {
        this.cidadeDAO = cidadeDAO;
    }

    public List<Cidade> loadByEstado(Integer estadoId) {
        return cidadeDAO.loadByEstado(estadoId);
    }
    
}
