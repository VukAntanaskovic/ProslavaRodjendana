<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
      <th scope="col">Cena (rsd)</th>
      
    </tr>
  </thead>
  <tbody ng-controller="proslaveOdobreneController">
    <tr ng-repeat="x in proslaveOdobrene" id="tabela_agencije">
      <td>{{x.pro_sifra}}</td>
      <td>{{x.agn_naziv}}</td>
      <td>{{x.kor_ime}} {{x.kor_prezime}}</td>
      <td>{{x.pro_datum}}</td>
      <td>{{x.pro_pocetak}}</td>
      <td>{{x.pro_kraj}}</td>
      <td>{{x.pro_broj_zvanica}}</td>
      <td style="color:green;"><i class="fa fa-check" aria-hidden="true"></i></td>
      <td>{{x.pro_cena}}</td>
    </tr>
  </tbody>
</table>