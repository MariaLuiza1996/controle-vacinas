/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vacinas.services.dao;

import com.vacinas.lib.NotaFiscal;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

@Stateless
public class NotaFiscalDAO extends GenericDAO<NotaFiscal>{
    
    public NotaFiscalDAO() {
        super(NotaFiscal.class);
    }
    
   
    
  public NotaFiscal loadByNota(Integer codnotaId) {
        
        TypedQuery<NotaFiscal> q = getEntityManager().createQuery ("SELECT n FROM NotaFiscal n WHERE n.codnota = :codnotaId", NotaFiscal.class );
        q.setParameter("codnotaId", codnotaId);
        return q.getSingleResult();
  }
        
    

}
