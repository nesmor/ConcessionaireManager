package com.consultech.concessionairemanager.service;

import java.util.Collection;

import com.consultech.concessionairemanager.exception.BadRequestAlertException;
import com.consultech.concessionairemanager.exception.EntityNotFoundException;


//Esta interfaz se puede definir como implementar en una clase abstracta para un comportamiento CRUD generico.
//y se delega a la implementacion la necesidad de utilizar metodos especializados.
public interface DAO<T> {
		 
	    T get(Long id);
	    Collection<T> getAll();
	    T create(T t) throws BadRequestAlertException;
	    T update(T t) throws BadRequestAlertException, EntityNotFoundException;
	    T delete(Long id) throws EntityNotFoundException;
}
