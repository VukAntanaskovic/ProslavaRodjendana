<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    HttpSession sesija = request.getSession();
    int uloga = (int) sesija.getAttribute("kor_uloga");
    if(uloga != 2){
    	%><h1 class="nema-autorizaciju">Vasa autorizacija ne odgovara trazenoj stranici</h1><% 
    }else{
%>
<table class="table table-dark table-striped">
  <thead>
    <tr>
      <th scope="col">Sifra</th>
      <th scope="col">Agencija</th>
      <th scope="col">Narucilac</th>
      <th scope="col">Datum</th>
      <th scope="col">Pocetak (h)</th>
      <th scope="col">Kraj (h)</th>
      <th scope="col">Broj zvanica</th>
      <th scope="col">Status</th>
      <th scope="col">Cena</th>
      <th scope="col">Odobravanje</th>
      <th scope="col">Otkazivanje</th>
      
    </tr>
  </thead>
  <tbody ng-controller="proslaveNaCekanjuMenadzerController">
    <tr ng-repeat="x in proslaveNaCekanju" id="tabela_agencije">
      <td>{{x.pro_sifra}}</td>
      <td>{{x.agn_naziv}}</td>
      <td>{{x.kor_ime}} {{x.kor_prezime}}</td>
      <td>{{x.pro_datum}}</td>
      <td>{{x.pro_pocetak}}</td>
      <td>{{x.pro_kraj}}</td>
      <td>{{x.pro_broj_zvanica}}</td>
      <td style="color:goldenrod;"><i class="fa fa-clock-o" aria-hidden="true"></i></td>
      <td><form id="cenaForma" method="POST" action="OdobravanjeProslaveServlet"><input id="inputCena" type="number" name="cena" placeholder="Unesite cenu" required class="form-control"/><input type="hidden" value="{{x.pro_sifra}}" name="sifraProslave"/></form></td>
      <td><button ng-click="potvrdiFormu()" type="button" class="btn btn-success"><i class="fa fa-check" aria-hidden="true"></i></button></td>    
      <td><a href="BrisanjeProslaveServlet?sifraProslave={{x.pro_sifra}}" class="btn btn-danger"><i class="fa fa-times" aria-hidden="true"></i></a></td>    
    </tr>
  </tbody>
</table>

    
    
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
    