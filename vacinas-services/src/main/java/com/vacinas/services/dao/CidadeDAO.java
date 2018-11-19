/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vacinas.services.dao;

import com.vacinas.lib.Cidade;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

@Stateless
public class CidadeDAO extends GenericDAO<Cidade> {

    public CidadeDAO() {
        super(Cidade.class);
    }

    public List<Cidade> loadByEstado(Integer estadoId) {
        TypedQuery<Cidade> q = getEntityManager().createQuery("SELECT c FROM Cidade c WHERE c.estado.id = :estadoId", Cidade.class);
        q.setParameter("estadoId", estadoId);
        return q.getResultList();

    }

}
