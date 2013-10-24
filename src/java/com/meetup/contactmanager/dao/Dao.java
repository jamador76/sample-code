package com.meetup.contactmanager.dao;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.TransientObjectException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Abstract class which provides a generic Data Access Object
 * @param <T> 
 */
public abstract class Dao<T> {
    private Class<T> entityClass;
    
    @Autowired
    private SessionFactory sessionFactory;
    
    public Dao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    
    public List<T> findAll(Criteria criteria) {
        return criteria.list();
    }
    
    public List<T> findAll() {
        return findAll(sessionFactory.getCurrentSession().createCriteria(entityClass));
    }
    
    @SuppressWarnings("unchecked")
    public T get(Serializable id) {
        return get(entityClass, id);
    }
    
    @SuppressWarnings("unchecked")
    public T get(Class c, Serializable id) {
        return (T)sessionFactory.getCurrentSession().get(c, id);
    }
    
    @SuppressWarnings("unchecked")
    public T get(Criteria criteria) {
        return (T)criteria.uniqueResult();
    }
    
    @SuppressWarnings("unchecked")
    public T insert(T entity) {
        Serializable id = sessionFactory.getCurrentSession().save(entity);
        entity = get(id);
        return entity;
    }
    
    @SuppressWarnings({"unchecked", "CallToThreadDumpStack"})
    public T save(T entity) {
        boolean pkOK = true;
        try {
            Long primaryKey = getPrimaryKey(entity);
            if( primaryKey != null && primaryKey > 0)
                update( entity );
            else
                entity = insert(entity);
        } catch( IllegalAccessException e ) {
            e.printStackTrace();
            pkOK = false;
        } catch( InvocationTargetException e ) {
            e.printStackTrace();
            pkOK = false;
        } catch( NoSuchMethodException e ) {
            e.printStackTrace();
            pkOK = false;
        } 
        
        if( !pkOK ) {
            try {
                update( entity );
            } catch( TransientObjectException e ) {
                //insert not update
                entity = insert(entity);
            }
        }
        
        return entity;
    }
    
    public void update(T entity) {
        sessionFactory.getCurrentSession().update(entity);
    }
    
    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public Class<T> getEntityClass() {
        return entityClass;
    }
    
    public void setEntityClass(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    
    private Long getPrimaryKey(T entity) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        String primaryKeyFieldName = getPrimaryKeyFieldName();
        Long pk = null;
        if (primaryKeyFieldName != null) {
            if (BeanUtils.getSimpleProperty(entity, primaryKeyFieldName) != null) {
                pk = Long.parseLong(BeanUtils.getSimpleProperty(entity, primaryKeyFieldName));
            }
        }

        return pk;
    }
     
    private String getPrimaryKeyFieldName() {
        return sessionFactory.getClassMetadata(entityClass).getIdentifierPropertyName();
    }
}
