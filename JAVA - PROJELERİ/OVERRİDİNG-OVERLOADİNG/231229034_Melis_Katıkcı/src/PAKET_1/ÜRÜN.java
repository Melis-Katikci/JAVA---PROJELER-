package PAKET_1;

import java.util.ArrayList;
import java.util.Scanner;

// import PAKET_1.*;
public class ÜRÜN {
	
	protected String Adi;
	protected Integer Kategori_Indexi;
	protected String Birim_Agirligi;
	protected Double Birim_Fiyati;
	protected Integer Stok_Miktari;
	protected Integer Aylik_Satis;
	protected Integer Yıllık_Satis;
	
	public Integer getYıllık_Satis() {
		return Yıllık_Satis;
	}
	public void setYıllık_Satis(Integer yıllık_Satis) {
		Yıllık_Satis = yıllık_Satis;
	}
	public ÜRÜN(String adi, Integer index, String agirlik, Double fiyat, Integer stok) {
		this.Adi = adi;
		this.Kategori_Indexi = index;
		this.Birim_Agirligi = agirlik;
		this.Birim_Fiyati = fiyat;
		this.Stok_Miktari = stok;
	}
	public ÜRÜN() {
		
	}
	
	public String getAdi() {
		return Adi;
	}
	public void setAdi(String adi) {
		Adi = adi;
	}
	public Integer getKategori_Indexi() {
		return Kategori_Indexi;
	}
	public void setKategori_Indexi(Integer kategori_Indexi) {
		Kategori_Indexi = kategori_Indexi;
	}
	public String getBirim_Agirligi() {
		return Birim_Agirligi;
	}
	public void setBirim_Agirligi(String birim_Agirligi) {
		Birim_Agirligi = birim_Agirligi;
	}
	public Double getBirim_Fiyati() {
		return Birim_Fiyati;
	}
	public void setBirim_Fiyati(Double birim_Fiyati) {
		Birim_Fiyati = birim_Fiyati;
	}
	public Integer getStok_Miktari() {
		return Stok_Miktari;
	}
	public void setStok_Miktari(Integer stok_Miktari) {
		Stok_Miktari = stok_Miktari;
	}
	public Integer getAylik_Satis() {
		return Aylik_Satis;
	}
	public void setAylik_Satis(Integer aylik_Satis) {
		Aylik_Satis = aylik_Satis;
	}
	
	public Integer Fiyata_Göre_Stok_Güncelle(Integer stok, String isim) {
		return this.Stok_Miktari = stok;
	}
	
	public String İsim_değiştir() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("FİYATI EN ÇOK OLAN ÜRÜNÜN YENİ İSMİNİ GİRİNİZ...");
		String isim = scanner.nextLine();
		return this.Adi = isim;
	}
	
	

}
