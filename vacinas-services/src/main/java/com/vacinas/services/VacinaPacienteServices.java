package com.vacinas.services;

import com.vacinas.lib.EstoqueVacina;
import com.vacinas.lib.Funcionario;
import com.vacinas.services.dao.VacinaPacienteDAO;
import com.vacinas.lib.VacinaPaciente;
import com.vacinas.services.dao.FuncionarioDAO;
import com.vacinas.services.dao.VacinaDAO;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class VacinaPacienteServices {

    @Inject
    private VacinaPacienteDAO vacinapacienteDAO;

    @Inject
    private VacinaDAO vacinaDAO;

    @Inject
    private FuncionarioDAO funcionarioDAO;

    @Inject
    EstoqueVacinaServices estoqueVacinasServices;

    public void save(VacinaPaciente vacinapaciente) {
        vacinapacienteDAO.save(vacinapaciente);
        EstoqueVacina ev = estoqueVacinasServices.loadByVacina(vacinapaciente.getVacina().getId());
        if (ev.getQuantidade() == 1) {
            estoqueVacinasServices.delete(ev.getId());
        } else {
            ev.setQuantidade(ev.getQuantidade() - 1);
            estoqueVacinasServices.update(ev);
        }

    }

    public List<VacinaPaciente> loadAllVacinaPacientes() {
        return vacinapacienteDAO.loadAll();
    }

    public VacinaPacienteDAO getVacinaPacienteDAO() {
        return vacinapacienteDAO;
    }

    public void setVacinaPacienteDAO(VacinaPacienteDAO vacinapacienteDAO) {
        this.vacinapacienteDAO = vacinapacienteDAO;
    }

    public void update(VacinaPaciente vacinapaciente) {
        this.vacinapacienteDAO.update(vacinapaciente);
    }

    public void delete(Integer id) {
        this.vacinapacienteDAO.delete(id);
    }

    public VacinaPaciente find(Integer id) {
        return vacinapacienteDAO.find(id);
    }

    public List<Funcionario> loadAllFuncionarios() {
        return funcionarioDAO.loadAll();
    }

}
