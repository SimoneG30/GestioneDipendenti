package it.gestionedipendenti.service;

import java.util.List;

import javax.persistence.EntityManager;

import it.gestionedipendenti.dao.DipendenteDAO;
import it.gestionedipendenti.model.Dipendente;
import it.gestionedipendenti.web.listener.LocalEntityManagerFactoryListener;

public class DipendenteServiceImpl implements DipendenteService {
	
	private DipendenteDAO dipendenteDao;


	@Override
	public void setDipendenteDao(DipendenteDAO dipendenteDao) {
		this.dipendenteDao = dipendenteDao;
	}

	@Override
	public List<Dipendente> listAll() throws Exception {
		
				EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();
				try {
					dipendenteDao.setEntityManager(entityManager);
					return dipendenteDao.list();
				} catch (Exception e) {
					e.printStackTrace();
					throw e;
				} finally {
					LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
				}
			}

	@Override
	public Dipendente caricaSingoloElemento(Long idInput) throws Exception {
		// questo è come una connection
				EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

				try {
					dipendenteDao.setEntityManager(entityManager);
					return dipendenteDao.findOne(idInput);
				} catch (Exception e) {
					e.printStackTrace();
					throw e;
				} finally {
					LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
				}
			}

	@Override
	public void aggiorna(Dipendente input) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			entityManager.getTransaction().begin();
			dipendenteDao.setEntityManager(entityManager);
			dipendenteDao.update(input);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void inserisciNuovo(Dipendente input) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			entityManager.getTransaction().begin();
			dipendenteDao.setEntityManager(entityManager);
			dipendenteDao.insert(input);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}

	}

	@Override
	public void rimuovi(Dipendente input) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			entityManager.getTransaction().begin();
			dipendenteDao.setEntityManager(entityManager);
			dipendenteDao.delete(input);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<Dipendente> findByExample(Dipendente input) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			dipendenteDao.setEntityManager(entityManager);
			return dipendenteDao.findByExample(input);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

}
