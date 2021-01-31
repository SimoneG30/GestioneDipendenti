<!-- navbar -->
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">

	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
       <span class="navbar-toggler-icon"></span>
     </button>

  <div class="collapse navbar-collapse" id="navbarsExampleDefault">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Link</a>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Dropdown</a>
        <div class="dropdown-menu" aria-labelledby="dropdown01">
          <a class="dropdown-item" href="index.jsp">Home</a>
          <a class="dropdown-item" href="ListDipendentiServlet">Risultati</a>
          <a class="dropdown-item" href="PrepareInsertDipendenteServlet">Inserisci nuovo elemento</a>
                    <a class="dropdown-item" href="PrepareSearchDipendenteServlet">Cerca dipendente</a>
          
        </div>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <div class="container">
    <a class="navbar-brand">Gestione Dipendenti</a>
  </div>
    </form>
  </div>
</nav>
