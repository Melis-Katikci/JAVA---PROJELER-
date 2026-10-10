package PAKET_1;

import java.util.ArrayList;
import java.util.Scanner;

public class ÜRÜN {
	
	protected String Adi;
	protected Integer Kategori_Indexi;
	protected String Birim_Agirligi;
	protected Double Birim_Fiyati;
	protected Integer Stok_Miktari;
	protected Integer Aylik_Satis;
	
	public ÜRÜN(String adi, Integer index, String agirlik, Double fiyat, Integer stok) {
		this.Adi = adi;
		this.Kategori_Indexi = index;
		this.Birim_Agirligi = agirlik;
		this.Birim_Fiyati = fiyat;
		this.Stok_Miktari = stok;
	}
	
	public ÜRÜN() {  // ŞEKERLEME yeni = new ŞEKERLEME();     ŞEKERLEME CLASSINDA BU CONTRACTOR KULLANILDIĞI İÇİN İLGİLİ CLASSIN PARENTSINA DA ONA UYGUN EKLEME YAPILDI
		
	}
	
	public Integer getStok_Miktari() {
		return Stok_Miktari;
	}
	public void setStok_Miktari(Integer stok_Miktari) {
		Stok_Miktari = stok_Miktari;
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
	
	protected static void Tum_Liste_Yazdir(ÜRÜN ürün) {
		System.out.println("ürün adı:" + "\t" + ürün.Adi + "\türün indexi:" + "\t" + ürün.Kategori_Indexi + "\t" + "ürün stok:" + ürün.Stok_Miktari
				+ "\t" + "ürün fiyatı:" + "\t" + ürün.Birim_Fiyati + "\türün ağırlık:" + "\t" + ürün.Birim_Agirligi);
	}

	public static void Tahil_Liste_Yazdir(ÜRÜN ürün) {
		System.out.println("ürün adı:" + "\t" + ürün.Adi + "\türün indexi:" + "\t" + ürün.Kategori_Indexi + "\t" + "ürün stok:" + ürün.Stok_Miktari
				+ "\t" + "ürün fiyatı:" + "\t" + ürün.Birim_Fiyati + "\türün ağırlık:" + "\t" + ürün.Birim_Agirligi + "\t" + "aylık satış:" + "\t" + ürün.Aylik_Satis);	
}
	
	public static void Fiyata_Göre_Guncelle_yardımcısı(ArrayList<İÇECEK> icecek_list, ArrayList<ÇEŞNİ> cesni_list, ArrayList<ŞEKERLEME> seker_list, ArrayList<SÜT> sut_list, ArrayList<TAHIL> tahil_list) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("FİYAT HANGİ DEĞERİN ALTINDA İSE STOK GÜNCELLENSİN...");
		Double fiyat = scanner.nextDouble();
		System.out.println("YENİ STOK MİKTARI GİR...");
		Integer stok = scanner.nextInt();
		
		System.out.println("\nFİYATINA GÖRE STOĞU GÜNCELLENEN İÇECEKLER...");
		for (İÇECEK ıcecek : icecek_list) {
			if(ıcecek.Birim_Fiyati < fiyat) {   // İSTENEN ŞARTA UYGUN VERİ BULMA
				ıcecek.Fiyata_Göre_Guncelle(stok);    // GÜNCELLENECEK DEĞERİ YOLLADIK
			}
			ÜRÜN.Tum_Liste_Yazdir(ıcecek);   // YAZDIRMA
		}
		
		System.out.println("\nFİYATINA GÖRE STOĞU GÜNCELLENEN ÇEŞNİLER...");
		for (TAHIL cesni : tahil_list) {
			if(cesni.Birim_Fiyati < fiyat) {	 // İSTENEN ŞARTA UYGUN VERİ BULMA
				cesni.Fiyata_Göre_Guncelle(stok);	// GÜNCELLENECEK DEĞERİ YOLLADIK
			}
			ÜRÜN.Tum_Liste_Yazdir(cesni);	// YAZDIRMA
		}
		
		System.out.println("\nFİYATINA GÖRE STOĞU GÜNCELLENEN ŞEKERLEMELER...");
		for (SÜT seker : sut_list) {	 
			if(seker.Birim_Fiyati < fiyat) {	// İSTENEN ŞARTA UYGUN VERİ BULMA
				seker.Fiyata_Göre_Guncelle(stok);	// GÜNCELLENECEK DEĞERİ YOLLADIK
			}
			ÜRÜN.Tum_Liste_Yazdir(seker);	// YAZDIRMA
		}
		
		System.out.println("\nFİYATINA GÖRE STOĞU GÜNCELLENEN SÜTLER...");
		for (ŞEKERLEME sut : seker_list) {	 
			if(sut.Birim_Fiyati < fiyat) {	// İSTENEN ŞARTA UYGUN VERİ BULMA
				sut.Fiyata_Göre_Guncelle(stok);	// GÜNCELLENECEK DEĞERİ YOLLADIK
			}
			ÜRÜN.Tum_Liste_Yazdir(sut);	// YAZDIRMA
		}
		
		System.out.println("\nFİYATINA GÖRE STOĞU GÜNCELLENEN TAHILLAR...");
		for (ÇEŞNİ tahil : cesni_list) {	 
			if(tahil.Birim_Fiyati < fiyat) {	// İSTENEN ŞARTA UYGUN VERİ BULMA
				tahil.Fiyata_Göre_Guncelle(stok);	// GÜNCELLENECEK DEĞERİ YOLLADIK
			}
			ÜRÜN.Tum_Liste_Yazdir(tahil);	// YAZDIRMA
		}
	}
	
	protected Integer Fiyata_Göre_Guncelle(Integer stok) {
		this.Stok_Miktari = stok;
		return this.Stok_Miktari;
	}
	
	public static void Isim_Degiştir_Yardımcısı(ArrayList<İÇECEK> ıcecek_list, ArrayList<ÇEŞNİ> cesni_list, ArrayList<ŞEKERLEME> seker_list, ArrayList<SÜT> sut_list, ArrayList<TAHIL> tahil_list) {
		Scanner scanner = new Scanner(System.in);
		Double[] dizi = new Double[5];
		double en_cok = 0.0;
		System.out.println("FİYATI EN ÇOK OLAN ÜRÜNÜN YENİ İSMİNİ GİRİNİZ...");
		String isim = scanner.nextLine();
		int index = 0;
		// HER LİSTEDEKİ MAX DEĞERİ BULUP BİR DİZİDE TUTTUK
		for (İÇECEK icecek : ıcecek_list) {
			if(en_cok < icecek.Birim_Fiyati) {
				en_cok = icecek.Birim_Fiyati;
			}
		}
		dizi[index++] = en_cok;
		en_cok = 0.0;
		for (ÇEŞNİ cesni : cesni_list) {
			if(en_cok < cesni.Birim_Fiyati) {
				en_cok = cesni.Birim_Fiyati;
			}
		}
		dizi[index++] = en_cok;
		en_cok = 0.0;
		for (ŞEKERLEME seker : seker_list) {
			if(en_cok < seker.Birim_Fiyati) {
				en_cok = seker.Birim_Fiyati;
			}
		}
		dizi[index++] = en_cok;
		en_cok = 0.0;
		for (SÜT sut : sut_list) {
			if(en_cok < sut.Birim_Fiyati) {
				en_cok = sut.Birim_Fiyati;
			}
		}
		dizi[index++] = en_cok;
		en_cok = 0.0;
		for (TAHIL tahil : tahil_list) {
			if(en_cok < tahil.Birim_Fiyati) {
				en_cok = tahil.Birim_Fiyati;
			}
		}
		dizi[index++] = en_cok;
		// DİZİYE ATADIĞIMIZ HER LİSTEDEN MAX DEĞERLER ARASINDAN MAXI BULMA
		en_cok = 0.0;
		int sira = 0;
		for (int i = 0; i < dizi.length; i++) {
			if(en_cok < dizi[i]) {
				en_cok = dizi[i];
				sira = i;
			}
		}
		// DİZİDEN BULUNAN MAX DEĞERİN İNDEXİNE GÖRE HANGİ KATEGORİ LİSTESİNDEN İŞLEM YAPILACAĞI TESPİTİ VE İSİM GÜNCELLEMESİ 
		if(sira == 0) {
			for (İÇECEK icecek : ıcecek_list) {
				if(icecek.Birim_Fiyati == en_cok) {
					icecek.Urun_Isim_Degistir(isim);
				}
			}
		}else if(sira == 1) {
			for (ÇEŞNİ cesni : cesni_list) {
				if(cesni.Birim_Fiyati == en_cok) {
					cesni.Urun_Isim_Degistir(isim);
				}
			}
		}else if(sira == 2) {
			for (ŞEKERLEME seker : seker_list) {
				if(seker.Birim_Fiyati == en_cok) {
					seker.Urun_Isim_Degistir(isim);
				}
			}
		}else if(sira == 3) {
			for (SÜT sut : sut_list) {
				if(sut.Birim_Fiyati == en_cok) {
					sut.Urun_Isim_Degistir(isim);
				}
			}
		}else {
			for (TAHIL tahil : tahil_list) {
				if(tahil.Birim_Fiyati == en_cok) {
					tahil.Urun_Isim_Degistir(isim);
				}
			}
		}
	}

	protected String Urun_Isim_Degistir(String yeni) {
		System.out.println(this.Adi + "\t" + this.Kategori_Indexi + "\t" + this.Birim_Agirligi + "\t" + this.Birim_Fiyati + "\t" + this.Stok_Miktari);
		this.Adi = yeni;
		System.out.println(this.Adi + "\t" + this.Kategori_Indexi + "\t" + this.Birim_Agirligi + "\t" + this.Birim_Fiyati + "\t" + this.Stok_Miktari);
		return this.Adi;
	}

}
