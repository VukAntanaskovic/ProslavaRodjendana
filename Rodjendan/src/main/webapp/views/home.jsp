<%@page import="models.URL"%>
<%@page import="models.Login"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
HttpSession sesija = request.getSession();
String ulogovanKorisnik = (String)sesija.getAttribute("korisnik");
if(ulogovanKorisnik == null){
	response.sendRedirect(URL.baseUrl);
}
%>

<div class="container" id="main-agencije" ng-controller="agencijeController">
        <div class="row" ng-repeat="x in agencije">
            <div class="col-lg-12">
                <div class="kartica-agencije">
                    <div class="row">
                        <div class="col-md-4">
                            <img src={{x.agn_slika}} alt="">
                            <h2>{{x.agn_naziv}}</h2>
                        </div>
                        <div class="col-md-8" id="opis-agencija">
                            <p>{{x.agn_opis}}</p>
                            <h4 class="podaci">{{x.agn_adresa}} | {{x.agn_telefon}}</h4><br>
                            <button ng-click="rezervacijaProslave(x.agn_sifra, x.agn_naziv)">Rezervisite odmah</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
    </div>
    
    <div id="popup-forma-zelena">
        <button class="x-dugme" type="button" onclick="closePopupZeleni()">x</button>
        <h3 id="naslovRezervacija"></h3>
        <form action="UnosProslaveServlet" method="POST">
            <div class="row">
                <div class="col-lg-12">
                    <label for="">Datum</label><br>
        <input type="date" class="form-control" name="datum" required>
        <input type="hidden" name="sifraAgencije" id="sifraAgencije"/>
    </div>
    <div class="col-lg-12">
                    <label for="">Broj zvanica</label><br>
        <input type="number" class="form-control" placeholder="Unesite broj zvanica" min="1" name="brojZvanica" required>
    </div>
    
    </div>
    <div class="row">
<div class="col-lg-6">
            <label for="">Od:</label><br>
<input type="time" class="form-control" name="vremeOd" required>
    </div>
        <div class="col-lg-6">
            <label for="">Do:</label><br>
<input type="time" class="form-control" required name="vremeDo"></div>
    </div>
    <input type="submit" value="Posaljite zahtev" required>
    </form>
    </div>
    <% 
        String poruka = (String) sesija.getAttribute("poruka");
        %>
        <%if(poruka != null && poruka != ""){%>
        	
     <div  class="poruka">
        <p><%=poruka %>  <button type="button" onclick="zatvoriPoruku()">x</button></p>
    </div>
    <style>
    .poruka{
    display:block;
    }
    </style>
        	<% 
        	sesija.setAttribute("poruka", "");
        }
        
        %>