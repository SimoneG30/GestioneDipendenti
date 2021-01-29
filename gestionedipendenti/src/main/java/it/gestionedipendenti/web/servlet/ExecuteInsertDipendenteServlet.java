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
import org.apache.commons.lang3.math.NumberUtils;

import it.gestionedipendenti.service.MyServiceFactory;
import it.gestionedipendenti.model.Dipendente;

@WebServlet("/ExecuteInsertDipendenteServlet")
public class ExecuteInsertDipendenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExecuteInsertDipendenteServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String matricolaInputParam = request.getParameter("matricola");
		String nomeInputParam = request.getParameter("nome");
		String cognomeInputStringParam = request.getParameter("cognome");
		String dataNascitaStringParam = request.getParameter("datanascita");

		Date dataNascitaParsed = parseDateNascitaFromString(dataNascitaStringParam);


		if (!this.validateInput(matricolaInputParam, nomeInputParam, cognomeInputStringParam, dataNascitaStringParam)
				|| dataNascitaParsed == null) {
			request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione");
			request.getRequestDispatcher("/dipendente/insert.jsp").forward(request, response);
			return;
		}
		
		Dipendente dipendenteInstance = new Dipendente(matricolaInputParam, nomeInputParam, 
				cognomeInputStringParam, dataNascitaParsed);

		try {
			MyServiceFactory.getDipendenteServiceInstance().inserisciNuovo(dipendenteInstance);
			request.setAttribute("listaDipendentiAttribute", MyServiceFactory.getDipendenteServiceInstance().listAll());
			request.setAttribute("successMessage", "Operazione effettuata con successo");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/dipendente/insert.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/dipendente/results.jsp").forward(request, response);

	}

	private boolean validateInput(String codiceInputParam, String descrizioneInputParam, String prezzoInputStringParam,
			String dataArrivoStringParam) {
		if (StringUtils.isBlank(codiceInputParam) || StringUtils.isBlank(descrizioneInputParam)
				|| !NumberUtils.isCreatable(prezzoInputStringParam) || StringUtils.isBlank(dataArrivoStringParam)) {
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
