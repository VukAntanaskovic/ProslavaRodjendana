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
      <th scope="col">Naziv</th>
      <th scope="col">Adresa</th>
      <th scope="col">Telefon</th>
      <th scope="col">Menadzer</th>
      <th scope="col">Brisanje</th>
      <th scope="col">Izmena</th>
      
    </tr>
  </thead>
  <tbody ng-controller="agencijeAdminController">
    <tr ng-repeat="x in agencijeAdmin" id="tabela_agencije">
      <td>{{x.agn_sifra}}</td>
      <td>{{x.agn_naziv}}</td>
      <td>{{x.agn_adresa}}</td>
      <td>{{x.agn_telefon}}</td>
      <td>{{x.imeMenadzera}} {{x.prezimeMenadzera}}</td>
      <td><a href="BrisanjeAgencijeServlet?sifraAgencije={{x.agn_sifra}}" class="btn btn-danger">Brisanje</a></td>
      <td><button type="button" ng-click="azuriranjeAgencije(x.agn_sifra, x.agn_naziv, x.agn_adresa, x.agn_telefon, x.agn_opis)" class="btn btn-success">Izmena</button></td>
    
    </tr>
  </tbody>
</table>
    <div id="popup-forma" style="margin:1%;">
        <button class="x-dugme" type="button" onclick="closePopup()">x</button>
        <h3>Dodajte novu agenciju</h3>
        <form action="UnosAgencijeServlet" method="POST" enctype="multipart/form-data" accept-charset="utf-8">
            <div class="row">
                <div class="col-lg-6">
                    <label for="">Naziv</label><br>
        <input type="text" class="form-control" placeholder="Unesite naziv" name="naziv" required>
    </div>
    <div class="col-lg-6">
                    <label for="">Menadzer</label><br>
        <select class="form-select"  ng-controller="korisniciAdminController" name="menadzer">
        	<option ng-repeat="x in korisniciAdmin" value="{{x.kor_sifra}}">{{x.kor_ime}} {{x.kor_prezime}}</option>
        </select>
    </div>
    
    </div>
    <div class="row">
        <div class="col-lg-6">
            <label for="">Adresa</label><br>
<input type="text" class="form-control" placeholder="Unesite adresu" name="adresa" required>
</div>
<div class="col-lg-6">
            <label for="">Telefon</label><br>
<input type="text" class="form-control" placeholder="Unesite telefon" name="telefon" required>
</div>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <label for="">Slika</label><br>
<input type="file" class="form-control" name="slika" required>
</div>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <label for="">Opis</label><br>
<textarea id="opisTextArea" type="file" class="form-control" placeholder="Unesite opis" name="opis" required></textarea>
</div>
    </div>
    <input type="submit" value="Dodajte novu agenciju">
    </form>
    </div>
    
    <!-- Popup za azuriranje -->
    <div id="popup-forma-zelena">
        <button class="x-dugme" type="button" onclick="closePopupZeleni()">x</button>
        <h3 id="naslovFormeZelene"></h3>
        <form action="AzurirajAgencijeServlet" method="POST">
        <input type="hidden" name="sifra" id="azurirajSifra"/>
            <div class="row">
                <div class="col-lg-12">
                    <label for="">Naziv</label><br>
        <input name="naziv" id="azurirajNaziv" type="text" class="form-control" placeholder="Unesite naziv" required>
    </div>
    <div class="col-lg-12">
                    <label for="">Adresa</label><br>
        <input name="adresa" id="azurirajAdresu" type="text" class="form-control" placeholder="Unesite adresu" required>
    </div>
    
    </div>
    <div class="row">
<div class="col-lg-12">
            <label for="">Telefon</label><br>
<input name="telefon" id="azurirajTelefon" type="text" class="form-control" placeholder="Unesite telefon" required>
</div>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <label for="">Opis</label><br>
<textarea style="height:150px;" id="azurirajOpis" name="opis"  class="form-control" placeholder="Unesite opis" required></textarea>
</div>
    </div>
    <input type="submit" value="Potvrdite izmene">
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
        <button onclick="openPopUp()" type="button" class="dugmeDodaj">+</button>
    