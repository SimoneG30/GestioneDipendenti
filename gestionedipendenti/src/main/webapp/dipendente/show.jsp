<!doctype html>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="it.gestionedipendenti.model.Dipendente"%>
<html lang="it">
<head>
	<jsp:include page="../header.jsp" />
	<title>Visualizza elemento</title>
	
	<!-- style per le pagine diverse dalla index -->
    <link href="./assets/css/global.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="../navbar.jsp" />
	<main role="main" class="container">
		<div class='card'>
		    <div class='card-header'>
		        Visualizza dettaglio
		    </div>
		    <% Dipendente dipendenteInPagina = (Dipendente)request.getAttribute("visualizza_dipendente_attr"); %>
		    <div class='card-body'>
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Codice</dt>
				  <dd class="col-sm-9"><%=dipendenteInPagina.getMatricola() %></dd>
		    	</dl>
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Descrizione:</dt>
				  <dd class="col-sm-9"><%=dipendenteInPagina.getNome() %></dd>
		    	</dl>
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Prezzo:</dt>
				  <dd class="col-sm-9"><%=dipendenteInPagina.getCognome() %></dd>
		    	</dl>
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Data di Arrivo:</dt>
				  <dd class="col-sm-9"><%=dipendenteInPagina.getDataNascita()!=null? new SimpleDateFormat("dd/MM/yyyy").format(dipendenteInPagina.getDataNascita()):"N.D."  %></dd>
		    	</dl>
		    </div>
		    <div class='card-footer'>
		        <a href="ListArticoliServlet" class='btn btn-outline-secondary' style='width:80px'>
		            <i class='fa fa-chevron-left'></i> Back
		        </a>
		    </div>
		</div>
	<!-- end main container -->	
	</main>
	<jsp:include page="../footer.jsp" />
</body>
</html>