package it.gestionedipendenti.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/PrepareSearchDipendenteServlet")
public class PrepareSearchDipendenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public PrepareSearchDipendenteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/dipendente/search.jsp").forward(request, response);

	}

}
