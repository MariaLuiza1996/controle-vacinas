/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vacinas.services.dao;

import com.vacinas.lib.Estado;
import javax.ejb.Stateless;

@Stateless
public class EstadoDAO extends GenericDAO<Estado>{
    
    public EstadoDAO() {
        super(Estado.class);
    }
    
}
