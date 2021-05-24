package models;

public class ProslavaHelper {
	private int pro_sifra;
	private int agn_sifra;
	private int kor_sifra;
	private double pro_cena;
	private String pro_datum;
	private int pro_broj_zvanica;
	private String pro_pocetak;
	private String pro_kraj;
	private String pro_status;
	private String agn_naziv;
	private String kor_ime;
	private String kor_prezime;
	
	public ProslavaHelper(int proslavaSifra, int agencijaSifra, int korisnikSifra, double cena, String datum, int brojZvanica, String pocetak, String kraj, String status, String agencijaNaziv, String korisnikIme, String korisnikPrezime) {
		this.pro_sifra = proslavaSifra;
		this.agn_sifra = agencijaSifra;
		this.kor_sifra = korisnikSifra;
		this.pro_cena = cena;
		this.pro_datum = datum;
		this.pro_broj_zvanica = brojZvanica;
		this.pro_pocetak = pocetak;
		this.pro_kraj = kraj;
		this.pro_status = status;
		this.agn_naziv = agencijaNaziv;
		this.kor_ime = korisnikIme;
		this.kor_prezime = korisnikPrezime;
		
	}

	public int getPro_sifra() {
		return pro_sifra;
	}

	public void setPro_sifra(int pro_sifra) {
		this.pro_sifra = pro_sifra;
	}

	public int getAgn_sifra() {
		return agn_sifra;
	}

	public void setAgn_sifra(int agn_sifra) {
		this.agn_sifra = agn_sifra;
	}

	public int getKor_sifra() {
		return kor_sifra;
	}

	public void setKor_sifra(int kor_sifra) {
		this.kor_sifra = kor_sifra;
	}

	public double getPro_cena() {
		return pro_cena;
	}

	public void setPro_cena(double pro_cena) {
		this.pro_cena = pro_cena;
	}

	public String getPro_datum() {
		return pro_datum;
	}

	public void setPro_datum(String pro_datum) {
		this.pro_datum = pro_datum;
	}

	public int getPro_broj_zvanica() {
		return pro_broj_zvanica;
	}

	public void setPro_broj_zvanica(int pro_broj_zvanica) {
		this.pro_broj_zvanica = pro_broj_zvanica;
	}

	public String getPro_pocetak() {
		return pro_pocetak;
	}

	public void setPro_pocetak(String pro_pocetak) {
		this.pro_pocetak = pro_pocetak;
	}

	public String getPro_kraj() {
		return pro_kraj;
	}

	public void setPro_kraj(String pro_kraj) {
		this.pro_kraj = pro_kraj;
	}

	public String isPro_status() {
		return pro_status;
	}

	public void setPro_status(String pro_status) {
		this.pro_status = pro_status;
	}

	public String getAgn_naziv() {
		return agn_naziv;
	}

	public void setAgn_naziv(String agn_naziv) {
		this.agn_naziv = agn_naziv;
	}

	public String getKor_ime() {
		return kor_ime;
	}

	public void setKor_ime(String kor_ime) {
		this.kor_ime = kor_ime;
	}

	public String getKor_prezime() {
		return kor_prezime;
	}

	public void setKor_prezime(String kor_prezime) {
		this.kor_prezime = kor_prezime;
	}
}
