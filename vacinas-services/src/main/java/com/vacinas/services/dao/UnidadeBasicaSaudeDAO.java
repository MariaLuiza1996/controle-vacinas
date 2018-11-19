/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vacinas.services.dao;

import com.vacinas.lib.Cidade;
import com.vacinas.lib.UnidadeBasicaSaude;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

@Stateless
public class UnidadeBasicaSaudeDAO extends GenericDAO<UnidadeBasicaSaude>{
    
    public UnidadeBasicaSaudeDAO() {
        super(UnidadeBasicaSaude.class);
    }
    

}

