/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vacinas.converters;

import com.vacinas.server.beans.EntityManagerUtil;
import com.vacinas.lib.Paciente;
import java.io.Serializable;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Maria Luiza
 */
@FacesConverter(value = "converterPaciente")
public class ConverterPaciente implements Converter, Serializable {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String string) {
        if (string == null || string.equals("Selecione um registro")) {
            return null;
        }
        return EntityManagerUtil.getEntityManager().find(Paciente.class, Integer.parseInt(string));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object o) {
        if (o == null) {
            return null;
        }
        Paciente obj = (Paciente) o;
        return obj.getId().toString();
    }
}
