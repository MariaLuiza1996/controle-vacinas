
package com.vacinas.services;

import com.vacinas.services.dao.PacienteDAO;
import com.vacinas.lib.Paciente;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class PacienteServices {

    @Inject
    private PacienteDAO pacienteDAO;
    
    public void save(Paciente paciente) {
        pacienteDAO.save(paciente);
    }
    
    public List<Paciente> loadAllPacientes(){
        return pacienteDAO.loadAll();
    }

    public PacienteDAO getPacienteDAO() {
        return pacienteDAO;
    }

    public void setPacienteDAO(PacienteDAO pacienteDAO) {
        this.pacienteDAO = pacienteDAO;
    }

    public void update(Paciente paciente) {
        this.pacienteDAO.update(paciente);
    }
    
    public void delete(Integer id){
        this.pacienteDAO.delete(id);
    }
     public Paciente find(Integer id) {
        return pacienteDAO.find(id);
    }
     
     public Paciente login(String cns,String senha){
         return pacienteDAO.loginPaciente(cns, senha);
     }
     
     public Paciente localizar(String cns){
         return pacienteDAO.localizarUsuario(cns);
     }
     
}
