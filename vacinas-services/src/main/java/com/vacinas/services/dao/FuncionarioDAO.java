/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vacinas.services.dao;

import com.vacinas.lib.Paciente;
import com.vacinas.lib.Funcionario;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

@Stateless
public class FuncionarioDAO extends GenericDAO<Funcionario> {

    public FuncionarioDAO() {
        super(Funcionario.class);
    }

    public Funcionario loginFuncionario(String masp, String senha) {
        TypedQuery<Funcionario> query = getEntityManager().createQuery("SELECT p FROM Funcionario p WHERE p.masp = :masp AND p.senha = :senha", Funcionario.class);
        query.setParameter("masp", masp);
        query.setParameter("senha", senha);
        try {
            return query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }

    }
}
