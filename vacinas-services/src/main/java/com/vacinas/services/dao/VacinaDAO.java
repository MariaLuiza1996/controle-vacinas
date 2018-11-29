/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vacinas.services.dao;

import com.vacinas.lib.Vacina;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

@Stateless
public class VacinaDAO extends GenericDAO<Vacina>{
    
    public VacinaDAO() {
        super(Vacina.class);
//        classePersistente = Vacina.class;
//        ordem = "nome";
    }

    public List<Vacina> loadVacinasByQuantidade() {
        TypedQuery<Vacina> q = getEntityManager().createQuery("SELECT DISTINCT(ev.vacina) FROM EstoqueVacina ev WHERE ev.quantidade > 0", Vacina.class);
        return q.getResultList();
    }
    
}
