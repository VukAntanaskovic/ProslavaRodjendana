package models;

public class AgencijaHelper {
	private int agn_sifra;
	private String agn_naziv;
	private String agn_adresa;
	private String agn_telefon;
	private String agn_slika;
	private String agn_opis;
	private int kor_menadzer;
	private String imeMenadzera;
	private String prezimeMenadzera;
	
	public AgencijaHelper(int sifra, String naziv, String adresa, String telefon,String slika, String opis, int menadzer, String mndz, String pre) {
		this.agn_sifra = sifra;
		this.agn_naziv = naziv;
		this.agn_adresa = adresa;
		this.agn_telefon = telefon;
		this.agn_slika = slika;
		this.agn_opis = opis;
		this.kor_menadzer = menadzer;
		this.setImeMenadzera(mndz);
		this.setPrezimeMenadzera(pre);
	}
	
	public int getAgn_sifra() {
		return agn_sifra;
	}
	public void setAgn_sifra(int agn_sifra) {
		this.agn_sifra = agn_sifra;
	}
	public String getAgn_naziv() {
		return agn_naziv;
	}
	public void setAgn_naziv(String agn_naziv) {
		this.agn_naziv = agn_naziv;
	}
	public String getAgn_adresa() {
		return agn_adresa;
	}
	public void setAgn_adresa(String agn_adresa) {
		this.agn_adresa = agn_adresa;
	}
	public String getAgn_telefon() {
		return agn_telefon;
	}
	public void setAgn_telefon(String agn_telefon) {
		this.agn_telefon = agn_telefon;
	}
	public String getAgn_opis() {
		return agn_opis;
	}
	public void setAgn_opis(String agn_opis) {
		this.agn_opis = agn_opis;
	}
	public int getKor_menadzer() {
		return kor_menadzer;
	}
	public void setKor_menadzer(int kor_menadzer) {
		this.kor_menadzer = kor_menadzer;
	}

	public String getAgn_slika() {
		return agn_slika;
	}

	public void setAgn_slika(String agn_slika) {
		this.agn_slika = agn_slika;
	}

	public String getImeMenadzera() {
		return imeMenadzera;
	}

	public void setImeMenadzera(String imeMenadzera) {
		this.imeMenadzera = imeMenadzera;
	}

	public String getPrezimeMenadzera() {
		return prezimeMenadzera;
	}

	public void setPrezimeMenadzera(String prezimeMenadzera) {
		this.prezimeMenadzera = prezimeMenadzera;
	}
	
	
}
