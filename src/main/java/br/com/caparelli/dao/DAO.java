package br.com.caparelli.dao;

import java.util.List;

import org.hibernate.Session;

/**
 *
 * @author LC5257777
 *
 * @param <T>
 */
public interface DAO<T> {

	/**
	 * Retorna o DelegateSession do Hibernate
	 * @return HibernateSession
	 */
	Session getSession();

	T update(T entity);
	T save(T entity);
	T find(Long id);
	List<T> list();
	void remove(T entity);
	void flush();

}
