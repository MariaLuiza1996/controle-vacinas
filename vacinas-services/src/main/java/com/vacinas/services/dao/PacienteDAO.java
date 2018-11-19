/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vacinas.services.dao;

import com.vacinas.lib.Paciente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

@Stateless
public class PacienteDAO extends GenericDAO<Paciente> {

    EntityManager em;

    public PacienteDAO() {
        super(Paciente.class);
    }

    public Paciente loginPaciente(String cns, String senha) {
        TypedQuery<Paciente> query = getEntityManager().createQuery("SELECT p FROM Paciente p WHERE p.numcns = :cns AND p.senha = :senha", Paciente.class);
        query.setParameter("cns", cns);
        query.setParameter("senha", senha);
        try {
            return query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }

    }

    public Paciente localizarUsuario(String cns) {
        Query query = getEntityManager().createQuery("SELECT p FROM Paciente p WHERE p.numcns = :cns", Paciente.class);
        query.setParameter("cns", cns);
        return (Paciente) query.getSingleResult();
    }

}
