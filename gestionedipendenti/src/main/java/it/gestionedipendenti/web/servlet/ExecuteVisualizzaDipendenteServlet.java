package it.gestionedipendenti.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.gestionedipendenti.service.MyServiceFactory;

@WebServlet("/ExecuteVisualizzaDipendenteServlet")
public class ExecuteVisualizzaDipendenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idArticoloParam = request.getParameter("idArticolo");

		if (!NumberUtils.isCreatable(idArticoloParam)) {
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		try {
			request.setAttribute("visualizza_dipendente_attr", MyServiceFactory.getDipendenteServiceInstance()
					.caricaSingoloElemento(Long.parseLong(idArticoloParam)));
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		
		request.getRequestDispatcher("/dipendente/show.jsp").forward(request, response);
	}

}
