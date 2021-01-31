package it.gestionedipendenti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.gestionedipendenti.model.Dipendente;

public class DipendenteDAOImpl implements DipendenteDAO{

	private EntityManager entityManager;
	
	@Override
	public List<Dipendente> list() throws Exception {
		return entityManager.createQuery("from Dipendente", Dipendente.class).getResultList();
	}

	@Override
	public Dipendente findOne(Long id) throws Exception {
		return entityManager.find(Dipendente.class, id);
	}

	@Override
	public void update(Dipendente input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		input = entityManager.merge(input);
	}

	@Override
	public void insert(Dipendente input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(input);
	}

	@Override
	public void delete(Dipendente input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(input));
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;		
	}
	
	@Override
	public List<Dipendente> findByExample(Dipendente input) throws Exception {

		   StringBuilder stringBuilder = new StringBuilder("");
	        stringBuilder.append("select d from Dipendente d where");
	        stringBuilder.append("( :matricola is null OR d.matricola like ('%' || :matricola || '%'))");
	        stringBuilder.append("AND (:nome is null OR d.nome like ('%' || :nome || '%'))");
	        stringBuilder.append("AND (:cognome is null OR d.cognome like ('%' || :cognome || '%'))");
	        stringBuilder.append("AND (:dataNascita is null OR d.dataNascita = :dataNascita) ");
	        TypedQuery<Dipendente> typedQuery = entityManager.createQuery(stringBuilder.toString(), Dipendente.class);
	        typedQuery.setParameter("matricola", input.getMatricola());
	        typedQuery.setParameter("nome", input.getNome());
	        typedQuery.setParameter("cognome", input.getCognome());
	        typedQuery.setParameter("dataNascita", input.getDataNascita());
	        return typedQuery.getResultList();
	}

}
