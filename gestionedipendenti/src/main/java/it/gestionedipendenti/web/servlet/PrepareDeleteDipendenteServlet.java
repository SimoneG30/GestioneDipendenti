package it.gestionedipendenti.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.gestionedipendenti.service.MyServiceFactory;




@WebServlet("/PrepareDeleteDipendenteServlet")
public class PrepareDeleteDipendenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	Long idDaRimuovere = Long.parseLong(request.getParameter("idDipendente"));
    	
		try {
			request.setAttribute("dipendenteDaEliminare", MyServiceFactory.getDipendenteServiceInstance().caricaSingoloElemento(idDaRimuovere));
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/dipendente/result.jsp").forward(request, response);
			return;		
			}

		request.getRequestDispatcher("/dipendente/delete.jsp").forward(request, response);

	}
}