package it.gestionedipendenti.web.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import it.gestionedipendenti.model.Dipendente;
import it.gestionedipendenti.service.MyServiceFactory;


@WebServlet("/ExecuteUpdateDipendenteServlet")
public class ExecuteUpdateDipendenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idDipendenteDaModificare = request.getParameter("idDipendente");
		Long idDipendenteDaModificareParsato = Long.parseLong(idDipendenteDaModificare);
		String matricolaInputParam = request.getParameter("matricola");
		String nomeInputParam = request.getParameter("nome");
		String cognomeInputParam = request.getParameter("cognome");
		String dataNascitaStringParam = request.getParameter("dataNascita");
		Date dataNascitaParsed = parseDateNascitaFromString(dataNascitaStringParam);

		if (!this.validateInput(matricolaInputParam, nomeInputParam, cognomeInputParam, dataNascitaStringParam)
				&& dataNascitaParsed == null) {
			request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione");
			request.getRequestDispatcher("/dipendente/edit.jsp").forward(request, response);
			return;
		}

		try {
			Dipendente dipendenteInstance = MyServiceFactory.getDipendenteServiceInstance().caricaSingoloElemento(idDipendenteDaModificareParsato);
			dipendenteInstance.setMatricola(matricolaInputParam);
			dipendenteInstance.setNome(nomeInputParam);
			dipendenteInstance.setCognome(cognomeInputParam);
			if(!dataNascitaStringParam.isEmpty()) {
				dipendenteInstance.setDataNascita(dataNascitaParsed);
			}
			MyServiceFactory.getDipendenteServiceInstance().aggiorna(dipendenteInstance);
			request.setAttribute("listaDipendentiAttribute", MyServiceFactory.getDipendenteServiceInstance().listAll());
			request.setAttribute("successMessage", "Operazione effettuata con successo");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/dipendente/edit.jsp").forward(request, response);
			return;
		}

		// andiamo ai risultati
		request.getRequestDispatcher("/dipendente/results.jsp").forward(request, response);

	}

	private boolean validateInput(String matricolaInputParam, String nomeInputParam, String cognomeInputStringParam,
			String dataNascitaStringParam) {
		// prima controlliamo che non siano vuoti
		if (StringUtils.isBlank(matricolaInputParam) && StringUtils.isBlank(nomeInputParam)
				&& StringUtils.isBlank(cognomeInputStringParam) && StringUtils.isBlank(dataNascitaStringParam)) {
			return false;
		}
		return true;
	}

	private Date parseDateNascitaFromString(String dataNascitaStringParam) {
		if (StringUtils.isBlank(dataNascitaStringParam))
			return null;

		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(dataNascitaStringParam);
		} catch (ParseException e) {
			return null;
		}
	}
}
