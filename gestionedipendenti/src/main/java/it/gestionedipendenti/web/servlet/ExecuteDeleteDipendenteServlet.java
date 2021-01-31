package it.gestionedipendenti.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.gestionedipendenti.model.Dipendente;
import it.gestionedipendenti.service.MyServiceFactory;



@WebServlet("/ExecuteDeleteDipendenteServlet")
public class ExecuteDeleteDipendenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idDipendenteDaEliminare = request.getParameter("idDipendente");
		Long idDipendenteDaModificareParsato = null;
		try {
			if (!idDipendenteDaEliminare.isEmpty()) {
				idDipendenteDaModificareParsato = Long.parseLong(idDipendenteDaEliminare);
				Dipendente dipendenteDaEliminare = MyServiceFactory.getDipendenteServiceInstance()
						.caricaSingoloElemento(idDipendenteDaModificareParsato);
				MyServiceFactory.getDipendenteServiceInstance().rimuovi(dipendenteDaEliminare);
				request.setAttribute("successMessage", "Operazione effettuata con successo");
				request.setAttribute("listaDipendentiAttribute", MyServiceFactory.getDipendenteServiceInstance().listAll());

			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/dipendente/delete.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/dipendente/results.jsp").forward(request, response);
	}

}
