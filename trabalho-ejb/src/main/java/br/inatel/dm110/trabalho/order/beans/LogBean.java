package br.inatel.dm110.trabalho.order.beans;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.inatel.dm110.trabalho.api.interfaces.LogLocal;
import br.inatel.dm110.trabalho.api.model.LogTO;
import br.inatel.dm110.trabalho.order.entities.LogEntity;

@Stateless
@Local(LogLocal.class)
public class LogBean implements LogLocal {
    @PersistenceContext(unitName = "trabalho_dm110_pu")
    private EntityManager entityManager;

    @Override
    public void saveLog(LogTO log) {
        entityManager.persist(new LogEntity(log.getOrderCode(), log.getOperation(), log.getDate()));
    }
}
