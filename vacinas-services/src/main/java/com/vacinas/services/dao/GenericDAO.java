package com.vacinas.services.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

public abstract class GenericDAO<T> {

    private final Class<T> entityClass;
     protected Class classePersistente;
     private List<T> listaTodos;
      protected String ordem = "id";
    public GenericDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @PersistenceContext(unitName = "VacinasModelPU")
    EntityManager entityManager;

    /**
     * @return the entityManager
     */
    public EntityManager getEntityManager() {
        return entityManager;
    }

    public Class getClassePersistente() {
        return classePersistente;
    }

    public void setClassePersistente(Class classePersistente) {
        this.classePersistente = classePersistente;
    }

    public String getOrdem() {
        return ordem;
    }

    public void setOrdem(String ordem) {
        this.ordem = ordem;
    }
    
    

    public void save(T entity) {
        getEntityManager().persist(getEntityManager().merge(entity));
    }

    public void savePersist(T entity) {
        getEntityManager().persist(entity);
    }

    public void update(T entity) {
        getEntityManager().merge(entity);
    }

    public void delete(Object id) {
        T entity = getEntityManager().find(entityClass, id);
        getEntityManager().remove(entity);
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> loadAll() {
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }
    
//    public List<T> getListaTodos() {
//        String jpql = "from " + classePersistente.getSimpleName() + " order by " + ordem;
//        return entityManager.createQuery(jpql).getResultList();
//    }

    public List<T> getListaTodos() {
        String jpql = "from " + classePersistente.getSimpleName() + " order by " + ordem;
         return entityManager.createQuery(jpql).getResultList();
    }

    public void setListaTodos(List<T> listaTodos) {
        this.listaTodos = listaTodos;
    }
    
    

}
