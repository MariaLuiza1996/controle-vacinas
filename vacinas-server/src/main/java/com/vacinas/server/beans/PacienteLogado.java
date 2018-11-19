/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vacinas.server.beans;

import com.vacinas.lib.Paciente;
import java.io.Serializable;

/**
 *
 * @author Maria Luiza
 */
public class PacienteLogado  implements Serializable
{
   private Paciente paciente;

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
   
   
}
