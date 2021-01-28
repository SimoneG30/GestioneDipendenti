package it.gestionedipendenti.dao;

public class MyDaoFactory {
	
	private MyDaoFactory() {}

	private static DipendenteDAO dipendenteDaoInstance = null;

	public static DipendenteDAO getDipendenteDAOInstance() {
		if (dipendenteDaoInstance == null)
			dipendenteDaoInstance = new DipendenteDAOImpl();

		return dipendenteDaoInstance;
	}

}
