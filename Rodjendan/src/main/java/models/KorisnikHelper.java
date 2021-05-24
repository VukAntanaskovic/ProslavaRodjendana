package models;

public class KorisnikHelper {
	private int kor_sifra;
	private String kor_ime;
	private String kor_prezime;
	private String kor_email;
	private int kor_uloga;
	private String ulg_naziv;
	
	public KorisnikHelper(int sifra, String ime, String prezime, String email, int uloga, String ulgNaziv) {
		this.setKor_sifra(sifra);
		this.setKor_ime(ime);
		this.setKor_prezime(prezime);
		this.setKor_email(email);
		this.setKor_uloga(uloga);
		this.setUlg_naziv(ulgNaziv);
	}

	public int getKor_sifra() {
		return kor_sifra;
	}

	public void setKor_sifra(int kor_sifra) {
		this.kor_sifra = kor_sifra;
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

	public String getKor_email() {
		return kor_email;
	}

	public void setKor_email(String kor_email) {
		this.kor_email = kor_email;
	}

	public int getKor_uloga() {
		return kor_uloga;
	}

	public void setKor_uloga(int kor_uloga) {
		this.kor_uloga = kor_uloga;
	}

	public String getUlg_naziv() {
		return ulg_naziv;
	}

	public void setUlg_naziv(String ulg_naziv) {
		this.ulg_naziv = ulg_naziv;
	}
}
