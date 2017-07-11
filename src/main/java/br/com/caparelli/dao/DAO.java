package br.com.caparelli.dao;

import java.util.List;

import org.hibernate.Session;

/**
 *
 * <b>Definicao</b>: Interface gen\u00e9rica para DAOs.
 *
 * <br><h1>Projeto:MyColab JSF</h1><br>
 *
 * @author 	Felipe Caparelli
 * @date	11 de jul de 2017
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
