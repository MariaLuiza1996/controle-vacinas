/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vacinas.services.dao;

import com.vacinas.lib.ItensNota;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Stateless
public class ItensNotaDAO extends GenericDAO<ItensNota>{
    
    public ItensNotaDAO() {
        super(ItensNota.class);
    }
    EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
    
     public List<ItensNota> loadByNota(Integer codnotaId) {
        TypedQuery<ItensNota> q = getEntityManager().createQuery ("SELECT n FROM ItensNota n WHERE n.notafiscal.codnota = :codnotaId", ItensNota.class );
        q.setParameter("codnotaId", codnotaId);
        return q.getResultList();
}
     
}
