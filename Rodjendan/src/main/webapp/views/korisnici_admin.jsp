<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="models.URL"%>
    <%
    HttpSession sesija = request.getSession();
    int uloga = (int) sesija.getAttribute("kor_uloga");
    if(uloga != 3){
    	%><h1 class="nema-autorizaciju">Vasa autorizacija ne odgovara trazenoj stranici</h1><% 
    }else{
%>
<table class="table table-dark table-striped">
  <thead>
    <tr>
      <th scope="col">Sifra</th>
      <th scope="col">Ime</th>
      <th scope="col">Prezime</th>
      <th scope="col">Email</th>
      <th scope="col">Uloga</th>
      <th scope="col">Brisanje</th>
      <th scope="col">Autorizacija</th>
    </tr>
  </thead>
  <tbody ng-controller="korisniciAdminController">
    <tr ng-repeat="x in korisniciAdmin">
      <td>{{x.kor_sifra}}</td>
      <td>{{x.kor_ime}}</td>
      <td>{{x.kor_prezime}}</td>
      <td>{{x.kor_email}}</td>
      <td>{{x.ulg_naziv}}</td>
      <td><a href="BrisanjeKorisnika?sifraKorisnika={{x.kor_sifra}}" class="btn btn-danger">Brisanje</a></td>
      <td><button type="button" ng-click="autorizacija(x.kor_sifra, x.kor_ime, x.kor_prezime)" class="btn btn-primary">Autorizacija</button></td>
    </tr>
  </tbody>
</table>
<div id="popup-forma" ng-app="korisniciAdmin" ng-controller="korisniciAdminController">
        <button class="x-dugme" type="button" onclick="closePopup()">x</button>
        <h3 id="imeAutor"></h3>
        <form action="AutorizacijaKorisnikaServlet" method="POST">
            <input type="hidden" id="sif_kor_autorizacija" name="sifraKorisnika">
            <div class="row">
                <div class="col-lg-6">
                    <label for="">Nova uloga</label><br>
        <select class="slct-autorizacija" name="nivoAutorizacije">
            <option value="1">Klijent</option>
            <option value="3">Administrator</option>
        </select>
    </div>
    <div class="col-lg-6">
        <br><input type="submit" value="Dodelite autorizaciju">
    </div>
    </div>
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
    }
        %>
    