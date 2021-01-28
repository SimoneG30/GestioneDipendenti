package it.gestionedipendenti.service;

import it.gestionedipendenti.dao.DipendenteDAO;
import it.gestionedipendenti.dao.DipendenteDAOImpl;

public class MyServiceFactory {


	private static DipendenteService DIPENDENTE_SERVICE_INSTANCE = null;
	private static DipendenteDAO DIPENDENTEDAO_INSTANCE = null;

	public static DipendenteService getDipendenteServiceInstance() {
		if (DIPENDENTE_SERVICE_INSTANCE == null)
			DIPENDENTE_SERVICE_INSTANCE = new DipendenteServiceImpl();

		if (DIPENDENTEDAO_INSTANCE == null)
			DIPENDENTEDAO_INSTANCE = new DipendenteDAOImpl();

		DIPENDENTE_SERVICE_INSTANCE.setDipendenteDao(DIPENDENTEDAO_INSTANCE);

		return DIPENDENTE_SERVICE_INSTANCE;
	}

}
