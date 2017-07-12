package br.com.caparelli.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.hibernate.Session;

import br.com.caparelli.dao.DAO;
import br.com.caparelli.exception.ValidacaoException;

/**
 *
 * <b>Definicao</b>: Implementa\u00e7\u00e3o gen\u00e9rica dos recursos do DAO.
 *
 * <br><h1>Projeto: MyColab JSF</h1><br>
 *
 * @author 	Felipe Caparelli
 * @date	10 de jul de 2017
 *
 * @param <T>
 */
public abstract class DAOImpl<T, V> implements DAO<T, V>, Serializable {

	private static final long serialVersionUID = 1L;

	private Class<T> classe;

	@PersistenceContext(name = "em", unitName = "MyColabPU")
	protected EntityManager em;

	@SuppressWarnings("unchecked")
	public DAOImpl(){
		if (this.getClass().getGenericSuperclass() instanceof ParameterizedType) {
			this.classe = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		} else {
			this.classe = (Class<T>) ((ParameterizedType) this.getClass().getSuperclass().getGenericSuperclass()).getActualTypeArguments()[0];
		}
	}

	@Override
    public Session getSession() {
        return (Session) em.getDelegate();
    }

	@Override
	public T update(T entity) {
		this.validate(entity);
		entity = this.em.merge(entity);
		this.em.flush();
		return entity;
	}

	@Override
	public T save(T entity) {
		this.validate(entity);
		this.em.persist(entity);
		this.em.flush();
		return entity;
	}

	@Override
	public T find(V id) {

		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(this.classe);

		// SELECT root FROM Root
		Root<T> root = cq.from(this.classe);
		cq.select(root).where(cb.equal(root.get("id"), id));

		TypedQuery<T> query = em.createQuery(cq);
		return query.getSingleResult();
	}

	@Override
	public List<T> list() {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(this.classe);
		Root<T> root = cq.from(this.classe);
		cq.select(root);

		TypedQuery<T> query = this.em.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void remove(T entity) {
		this.em.remove(entity);
		this.em.flush();
	}

	private void validate(T t){
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    	Validator validator = factory.getValidator();
    	Set<ConstraintViolation<T>> validate = validator.validate(t);
    	if (!validate.isEmpty()){
    		throw new ValidacaoException(t);
    	}
	}


    /**
     * {@inheritDoc}
     *
     * @return
     */
    public EntityManager getEm() {
        return em;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void flush() {
        getEm().flush();
    }



}
