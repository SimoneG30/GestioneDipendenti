<!doctype html>
<html lang="it">
  <head>
    
    <jsp:include page="./header.jsp" />
    
    <!-- Custom styles for this template -->
    <link href="./assets/css/global.css" rel="stylesheet">
    <style type="text/css">
    	body {
		  padding-top: 3.5rem;
		}	
    </style>
    
    <title>Gestione degli Articoli!</title>
  </head>
  <body>
  
	<jsp:include page="./navbar.jsp"></jsp:include>
  
	<main role="main">
	  <!-- Main jumbotron for a primary marketing message or call to action -->
	  <div class="jumbotron" >
	    <div class="container">
	      <h1 style="text-align: center;" class="display-3">Benvenuto!</h1>
	      <h3 style="text-align: center;">Qui potrai gestire i dipendenti della tua azienda</h3>
	      <div class="text-center">
	      <br>
	      <p><a class="btn btn-primary btn-lg" style="float: center;" href="ListDipendentiServlet" role="button">Lista dei Dipendenti</a></p>
	      </div>
	    </div>
	  </div>
	  
	  <div class="container">
	  
		<div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none': ''}" role="alert">
		  ${errorMessage}
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
	</main>
	<jsp:include page="./footer.jsp" />
  </body>
</html>