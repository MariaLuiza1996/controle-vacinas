/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vacinas.services.dao;

import com.vacinas.lib.Paciente;
import com.vacinas.lib.VacinaPaciente;
import javax.ejb.Stateless;

@Stateless
public class VacinaPacienteDAO extends GenericDAO<VacinaPaciente>{
    
    public VacinaPacienteDAO() {
        super(VacinaPaciente.class);
    }
    
}
