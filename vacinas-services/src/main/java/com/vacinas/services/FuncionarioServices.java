package com.vacinas.services;

import com.vacinas.services.dao.FuncionarioDAO;
import com.vacinas.lib.Funcionario;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class FuncionarioServices {

    @Inject
    private FuncionarioDAO funcionarioDAO;

    public void save(Funcionario funcionario) {
        funcionarioDAO.save(funcionario);
    }

    public List<Funcionario> loadAllFuncionarios() {
        return funcionarioDAO.loadAll();
    }

    public FuncionarioDAO getFuncionarioDAO() {
        return funcionarioDAO;
    }

    public void setFuncionarioDAO(FuncionarioDAO funcionarioDAO) {
        this.funcionarioDAO = funcionarioDAO;
    }

    public void update(Funcionario funcionario) {
        this.funcionarioDAO.update(funcionario);
    }

    public void delete(Integer id) {
        this.funcionarioDAO.delete(id);
    }

    public Funcionario find(Integer id) {
        return funcionarioDAO.find(id);
    }

    public Funcionario login(String cns, String senha) {
        return funcionarioDAO.loginFuncionario(cns, senha);
    }

}
