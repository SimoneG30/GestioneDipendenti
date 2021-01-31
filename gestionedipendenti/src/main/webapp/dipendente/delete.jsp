<!doctype html>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="it.gestionedipendenti.model.Dipendente"%>
<html lang="it">
<head>
	<jsp:include page="../header.jsp" />
	<title>Inserisci nuovo</title>
	
	<!-- style per le pagine diverse dalla index -->
    <link href="./assets/css/global.css" rel="stylesheet">
    
</head>
<body>
	<jsp:include page="../navbar.jsp" />
	
	<main role="main" class="container">
		
		<div class='card'>
		    <div class='card-header'>
		        Delete Dipendente
		    </div>
		    
		    <h1 style="color: red; text-align: center; padding-top: 50px">Attenzione!
		questa azione non può essere annullata</h1>
	<h3 style="text-align: center; padding-top: 50px">Sei sicuro di
		voler elminare questo articolo?</h3>
	
		    <% Dipendente dipendenteInPagina = (Dipendente)request.getAttribute("dipendenteDaEliminare"); %>
		
		    <div class='card-body'>
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Matricola</dt>
				  <dd class="col-sm-9"><%=dipendenteInPagina.getMatricola() %></dd>
		    	</dl>
		    	
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Nome:</dt>
				  <dd class="col-sm-9"><%=dipendenteInPagina.getNome() %></dd>
		    	</dl>
		    	
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Cognome:</dt>
				  <dd class="col-sm-9"><%=dipendenteInPagina.getCognome() %></dd>
		    	</dl>
		    	
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Data di nascita:</dt>
				  <dd class="col-sm-9"><%=dipendenteInPagina.getDataNascita()!=null? new SimpleDateFormat("dd/MM/yyyy").format(dipendenteInPagina.getDataNascita()):"N.D."  %></dd>
		    	</dl>
		    	
		    </div>
		    <div>
			<form role="form" action="ExecuteDeleteDipendenteServlet" method="post">
					<div class="form-group">
						<input class="form-control" name="idDipendente" id="idDipendente"
							placeholder="ID DIPENDENTE" type="hidden"
							value="<%=dipendenteInPagina.getId()%>" />
				</div>
				<div class="text-center">
					<input type="submit" class="btn btn-danger" value='Conferma'>
			
					</div>
			</form>
			</div>
		    <div class='card-footer'>
		        <a href="ListDipendentiServlet" class='btn btn-outline-secondary' style='width:80px'>
		            <i class='fa fa-chevron-left'></i> Back
		        </a>
		    </div>
		</div>	
	
	
	
	<!-- end main container -->	
	</main>
	<jsp:include page="../footer.jsp" />
	
</body>
</html>