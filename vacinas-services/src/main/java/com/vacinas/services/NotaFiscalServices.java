
package com.vacinas.services;

import com.vacinas.lib.EstoqueVacina;
import com.vacinas.lib.ItensNota;
import com.vacinas.lib.NotaFiscal;
import com.vacinas.services.dao.ItensNotaDAO;
import com.vacinas.services.dao.NotaFiscalDAO;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class NotaFiscalServices {

    @Inject
    private NotaFiscalDAO notafiscalDAO;

    @Inject
    private ItensNotaDAO itensNotaDAO;

    private NotaFiscal nota;
    private EstoqueVacina estoqueVacina;

    List<EstoqueVacina> ev;
    List<ItensNota> itensnotas;

    public void save(NotaFiscal notafiscal) {
        notafiscalDAO.save(notafiscal);
    }

    public NotaFiscal loadByNota(Integer codnotaId) {
        return notafiscalDAO.loadByNota(codnotaId);
    }

    public List<NotaFiscal> loadAllNotaFiscals() {
        return notafiscalDAO.loadAll();
    }

    public List<ItensNota> loadAllItensNota() {
        return itensNotaDAO.loadAll();
    }

    public NotaFiscalDAO getNotaFiscalDAO() {
        return notafiscalDAO;
    }

    public void setNotaFiscalDAO(NotaFiscalDAO notafiscalDAO) {
        this.notafiscalDAO = notafiscalDAO;
    }

    public void update(NotaFiscal notafiscal) {
        this.notafiscalDAO.update(notafiscal);
    }

    public void delete(Integer id) {
        this.notafiscalDAO.delete(id);
    }

    public NotaFiscal find(Integer id) {
        return notafiscalDAO.find(id);
    }

    public NotaFiscal findBynota(Integer codNota) {
        return notafiscalDAO.find(codNota);
    }
}
