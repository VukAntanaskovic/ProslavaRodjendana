<%@page import="models.Login"%>
<nav class="navbar navbar-expand-lg navbar-light" id="navigacija">
  <div class="container-fluid">
    <a class="navbar-brand" href="index.jsp">Organizovanje proslava</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link" aria-current="page" href="index.jsp">Pocetna</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Korisnicki nalog
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
          <%
          HttpSession sesija = request.getSession();
          String ulogovanKorisnik = (String)sesija.getAttribute("korisnik");
          int uloga = (int) sesija.getAttribute("kor_uloga");
          if(uloga == 1){
        	  %>
        	  <li><a class="dropdown-item" href="index.jsp?p=PregledOdobrenihRezervacija">Pregled odobrenih rezervacija</a></li>
        	  <li><a class="dropdown-item" href="index.jsp?p=PregledRezervacijaNaCekanju">Pregled rezervacija na cekanju</a></li>
        	  <%
          }
          else if(uloga == 2){
        	  %>
        	  <li><a class="dropdown-item" href="index.jsp?p=PregledOdobrenihRezervacija">Pregled odobrenih rezervacija</a></li>
        	  <li><a class="dropdown-item" href="index.jsp?p=PregledRezervacijaNaCekanju">Pregled rezervacija na cekanju</a></li>
        	  <li><hr class="dropdown-divider"></li>
        	  <li><a class="dropdown-item" href="index.jsp?p=PregledRodjendanskihProslava">Pregled rodjendanskih proslava</a></li>
        	  <li><a class="dropdown-item" href="index.jsp?p=PregledZahtevaZaProslavu">Pregled zahteva za proslavu</a></li>
        	  <li><a class="dropdown-item" href="index.jsp?p=Agencija">Agencija</a></li>
        	  <% 
          }
          else if(uloga == 3){
        	  %>
        	  <li><a class="dropdown-item" href="index.jsp?p=PregledOdobrenihRezervacija">Pregled odobrenih rezervacija</a></li>
        	  <li><a class="dropdown-item" href="index.jsp?p=PregledRezervacijaNaCekanju">Pregled rezervacija na cekanju</a></li>
        	  <li><hr class="dropdown-divider"></li>
        	  <li><a class="dropdown-item" href="index.jsp?p=Korisnici">Korisnici</a></li>
        	  <li><a class="dropdown-item" href="index.jsp?p=AgencijeAdmin">Agencije</a></li>
        	  <% 
          }
          %>
          </ul>
        </li>
        <li class="nav-item">
          <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true"><%=Login.ime + " " +Login.prezime %></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" aria-current="page" href="LogoutServlet">Odjavite se</a>
        </li>
      </ul>
      <form class="d-flex" method="POST" action="SetujParametarServlet">
        <input class="form-control me-2" type="search" placeholder="Pretraga agencija" aria-label="Search" name="pretragaAgencije">
        <button type="submit" class="btn btn-primary"><i class="fa fa-search" aria-hidden="true"></i></button>
      </form>
    </div>
  </div>
</nav>