/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vacinas.services.dao;

import com.vacinas.lib.Paciente;
import com.vacinas.lib.Funcionario;
import javax.ejb.Stateless;

@Stateless
public class FuncionarioDAO extends GenericDAO<Funcionario>{
    
    public FuncionarioDAO() {
        super(Funcionario.class);
    }
    
}
