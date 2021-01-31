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
		<%
		Dipendente dipendenteInPagina = (Dipendente) request.getAttribute("dipendenteDaModificare");
	%>
	<main role="main" class="container">
	
		<div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none': ''}" role="alert">
		  ${errorMessage}
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
		
		<div class='card'>
		    <div class='card-header'>
		        <h5>Modifica dipendente</h5> 
		    </div>
		    <div class='card-body'>
					<form method="post" action="ExecuteUpdateDipendenteServlet" novalidate="novalidate">
					
						<div class="form-row">
							<div class="form-group col-md-6">
								<label>Matricola</label>
								<input type="text" name="matricola" id="matricola" class="form-control" placeholder="Inserire matricola" value="<%=dipendenteInPagina.getMatricola()%>">
							</div>
							
							<div class="form-group col-md-6">
								<label>Nome</label>
								<input type="text" name="nome" id="nome" class="form-control" placeholder="Inserire nome" value="<%=dipendenteInPagina.getNome()%>">
							</div>
						</div>
						
						<div class="form-row">	
							<div class="form-group col-md-6">
								<label>Cognome</label>
								<input type="text" class="form-control" name="cognome" id="cognome" placeholder="Inserire cognome" value="<%=dipendenteInPagina.getCognome()%>">
							</div>
							<div class="form-group col-md-3">
								<label>Data nascita</label>
                        		<input class="form-control" id="dataNascita" type="date" placeholder="dd/MM/yy"
                            		title="dataNascita"  name="dataNascita" value="<%=dipendenteInPagina.getDataNascita()%>">
							</div>
							</div>
							<div class="form-group col-md-3">
								<input type="hidden" class="form-control" name="idDipendente" id="idDipendente" placeholder="ID DIPENDENTE" value="<%=dipendenteInPagina.getId()%>"/>
							</div>
														
						<button type="submit" name="submit" value="submit" id="submit" class="btn btn-primary">Conferma</button>
					

					</form>

		    
		    
			<!-- end card-body -->			   
		    </div>
		</div>	
	
	
	<!-- end container -->	
	</main>
	<jsp:include page="../footer.jsp" />
	
</body>
</html>