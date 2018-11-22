/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vacinas.services.dao;

import com.vacinas.lib.Paciente;
import com.vacinas.lib.EstoqueVacina;
import com.vacinas.lib.ItensNota;
import com.vacinas.lib.NotaFiscal;
import com.vacinas.lib.Vacina;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

@Stateless
public class EstoqueVacinaDAO extends GenericDAO<EstoqueVacina> {

    public EstoqueVacinaDAO() {
        super(EstoqueVacina.class);
    }

    public EstoqueVacina loadByVacina(Integer id) {
        TypedQuery<EstoqueVacina> q = getEntityManager().createQuery("SELECT ev FROM EstoqueVacina ev WHERE ev.vacina.id = :id AND ev.quantidade > 0 ORDER BY ev.itensNota.datavalidade ASC", EstoqueVacina.class);
        q.setParameter("id", id);
        return q.getResultList().get(0);
    }

    public List<ItensNota> loadByNota(Integer codnotaId) {
        List<ItensNota> lista;
        TypedQuery<ItensNota> q = getEntityManager().createQuery("SELECT n FROM ItensNota n WHERE n.notafiscal.codnota =:codnotaId", ItensNota.class);
        q.setParameter("codnotaId", codnotaId);
        lista = q.getResultList();

        return lista;

    }

    public List<EstoqueVacina> loadByNotaFiscal(Integer id) {
        TypedQuery<EstoqueVacina> q = getEntityManager().createQuery("SELECT ev FROM EstoqueVacina ev WHERE ev.itensNota.notafiscal.id = :id", EstoqueVacina.class);
        q.setParameter("id", id);
        return q.getResultList();

    }

}
