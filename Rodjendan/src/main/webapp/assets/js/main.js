function zatvoriPoruku(){
    $('.poruka').css("display" , "none");
}

var app = angular.module('main', []);
app.controller('agencijeController', function($scope, $http){
    $http.get("SveAgencijeServlet").then(function(response){
    $scope.agencije = response.data;

    });
    $scope.rezervacijaProslave = function(sifra, naziv){
        document.getElementById("naslovRezervacija").innerHTML = "Zahtev za proslavu: " + naziv;
        document.getElementById("sifraAgencije").value = sifra;
        $('#popup-forma-zelena').css('display', 'block');
    }
});

app.controller('agencijePretragaController', function($scope, $http){
    $http.get("PretragaAgencijaServlet").then(function(response){
    $scope.agencije = response.data;
    if(response.data.length === 0){
        document.getElementById("poruka-naslov").innerHTML = "Trazena agencija ne postoji u bazi";
    }
    });
    $scope.rezervacijaProslave = function(sifra, naziv){
        document.getElementById("naslovRezervacija").innerHTML = "Zahtev za proslavu: " + naziv;
        document.getElementById("sifraAgencije").value = sifra;
        $('#popup-forma-zelena').css('display', 'block');
    }
});

app.controller('korisniciAdminController', function($scope, $http){
    $http.get("SviKorisniciServlet").then(function(response){
        $scope.korisniciAdmin = response.data;
        $scope.autorizacija = function(sifra, ime, prezime){
        $scope.ime = ime + " " + prezime;
        document.getElementById("sif_kor_autorizacija").value = sifra;
        document.getElementById("imeAutor").innerHTML = "Autorizacija korisnika: " +ime+" "+prezime;
        $('#popup-forma').css("display", "block");
        console.log($scope.ime);
    }

    });
    
});

app.controller('agencijeAdminController', function($scope, $http){
    $http.get("SveAgencijeServlet").then(function(response){
        $scope.agencijeAdmin = response.data;
        $scope.azuriranjeAgencije = function(sifra, naziv, adresa, telefon, opis){
            $('#popup-forma-zelena').css("display", "block");
            document.getElementById("azurirajNaziv").value = naziv;
            document.getElementById("azurirajAdresu").value = adresa;
            document.getElementById("azurirajTelefon").value = telefon;
            document.getElementById("azurirajOpis").value = opis;
            document.getElementById("azurirajSifra").value = sifra;
            document.getElementById("naslovFormeZelene").innerHTML = "Izmena agencije: "+naziv;
        }

    });
});
app.controller('agencijeMenadzerController', function($scope, $http){
    $http.get("SveAgencijeMenadzeraServlet").then(function(response){
        $scope.agencijeMenadzer = response.data;
        $scope.azuriranjeAgencije = function(sifra, naziv, adresa, telefon, opis){
            $('#popup-forma-zelena').css("display", "block");
            document.getElementById("azurirajNaziv").value = naziv;
            document.getElementById("azurirajAdresu").value = adresa;
            document.getElementById("azurirajTelefon").value = telefon;
            document.getElementById("azurirajOpis").value = opis;
            document.getElementById("azurirajSifra").value = sifra;
            document.getElementById("naslovFormeZelene").innerHTML = "Izmena agencije: "+naziv;
        }

    });
});

app.controller('proslaveNaCekanjuController', function($scope, $http){
    $http.get("ProslaveNaCekanjuServlet").then(function(response){
        $scope.proslaveNaCekanju = response.data;
    });
});

app.controller('proslaveOdobreneMenadzerController', function($scope, $http){
    $http.get("OdobreneProslaveMenadzerServlet").then(function(response){
        $scope.proslaveOdobrene = response.data;
    });
});

app.controller('proslaveOdobreneController', function($scope, $http){
    $http.get("OdobreneProslaveServlet").then(function(response){
        $scope.proslaveOdobrene = response.data;
    });
});

app.controller('proslaveNaCekanjuMenadzerController', function($scope, $http){
    $http.get("ProslaveNaCekanjuMenadzer").then(function(response){
        $scope.proslaveNaCekanju = response.data;
        $scope.potvrdiFormu = function(){
            var forma = document.getElementById("cenaForma");
            var input = document.getElementById("inputCena");
            if(input.value != "" && input.value != null){
            forma.submit();
            }
            else{
                alert("Da biste potvrdili proslavu morate uneti cenu");
            }
        }
    });
});

function closePopup(){
    $('#popup-forma').css('display', 'none');
}
function openPopUp(){
  $('#popup-forma').css('display', 'block');
}
function closePopupZeleni(){
    $('#popup-forma-zelena').css('display', 'none');
}
window.setTimeout(zatvoriPoruku, 3000);