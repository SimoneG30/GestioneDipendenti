package it.gestionedipendenti.service;

import java.util.List;

import it.gestionedipendenti.dao.DipendenteDAO;
import it.gestionedipendenti.model.Dipendente;

public interface DipendenteService {


	// questo mi serve per injection
	public void setDipendenteDao(DipendenteDAO dipendenteDao);

	public List<Dipendente> listAll() throws Exception;

	public Dipendente caricaSingoloElemento(Long idInput) throws Exception;

	public void aggiorna(Dipendente input) throws Exception;

	public void inserisciNuovo(Dipendente input) throws Exception;

	public void rimuovi(Dipendente input) throws Exception;

	public List<Dipendente> findByExample(Dipendente input) throws Exception;
	
}
