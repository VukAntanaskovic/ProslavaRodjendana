<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="assets/css/style.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Proslava rodjendana</title>
</head>
<body ng-app="main">
	<%
	HttpSession sesija = request.getSession();
	String ulogovanKorisnik = (String)sesija.getAttribute("korisnik");
	String trenutnaStranica = request.getParameter("p");
	 if(ulogovanKorisnik == null && trenutnaStranica == null){%>
		<jsp:include page="views/login.jsp"></jsp:include>
	<% 
	
	
	}
	 else if(ulogovanKorisnik == null && trenutnaStranica.equals("registracija")){
			%><jsp:include page="views/registracija.jsp"></jsp:include><% 
		}
	else{
		if(trenutnaStranica == null){
		%>
		<jsp:include page="views/fixed/nav.jsp"></jsp:include>
		<jsp:include page="views/home.jsp"></jsp:include>
		<%
		}
		else if(trenutnaStranica.equals("Korisnici")){
			%>
			<jsp:include page="views/fixed/nav.jsp"></jsp:include>
			<jsp:include page="views/korisnici_admin.jsp"></jsp:include>
			<%
		}
		else if(trenutnaStranica.equals("AgencijeAdmin")){
			%>
			<jsp:include page="views/fixed/nav.jsp"></jsp:include>
			<jsp:include page="views/agencije_admin.jsp"></jsp:include>
			<%
		}
		else if(trenutnaStranica.equals("PregledRezervacijaNaCekanju")){
			%>
			<jsp:include page="views/fixed/nav.jsp"></jsp:include>
			<jsp:include page="views/proslabe_na_cekanju.jsp"></jsp:include>
			<%
		}
		else if(trenutnaStranica.equals("PregledOdobrenihRezervacija")){
			%>
			<jsp:include page="views/fixed/nav.jsp"></jsp:include>
			<jsp:include page="views/proslave_odobrene.jsp"></jsp:include>
			<%
		}
		else if(trenutnaStranica.equals("PregledZahtevaZaProslavu")){
			%>
			<jsp:include page="views/fixed/nav.jsp"></jsp:include>
			<jsp:include page="views/proslave_na_cekanju_menadzer.jsp"></jsp:include>
			<%
		}
		else if(trenutnaStranica.equals("PregledRodjendanskihProslava")){
			%>
			<jsp:include page="views/fixed/nav.jsp"></jsp:include>
			<jsp:include page="views/proslave_odobrene_menadzer.jsp"></jsp:include>
			<%
		}
		else if(trenutnaStranica.equals("Agencija")){
			%>
			<jsp:include page="views/fixed/nav.jsp"></jsp:include>
			<jsp:include page="views/sve_agencije_menadzer.jsp"></jsp:include>
			<%
		}
		else if(trenutnaStranica.equals("pretrazeneAgencije")){
			%>
			<jsp:include page="views/fixed/nav.jsp"></jsp:include>
			<jsp:include page="views/pretraga_agencija.jsp"></jsp:include>
			<%
		}
		else{
			%>
			<jsp:include page="views/fixed/nav.jsp"></jsp:include>
			<jsp:include page="views/home.jsp"></jsp:include>
			<%
		}
	}
	
	%>
<script src="assets/js/main.js"></script>
</body>
</html>