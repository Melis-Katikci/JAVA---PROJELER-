package PAKET_1;

import java.util.ArrayList;
import java.util.Scanner;

public class SEKERLEME extends URUN implements IURUN{

	public SEKERLEME(String Adi, Integer Kategori_Indexi, String Birim_Agirligi, Double Birim_Fiyati,
			Integer Stok_Miktari) {
		super(Adi, Kategori_Indexi, Birim_Agirligi, Birim_Fiyati, Stok_Miktari);
	}
	
	public SEKERLEME() {
		super();
	}

	@Override
	public Double Stok_Miktarina_Gore_Indirim_Yap(int en_az, Double fiyat) {
		return this.Birim_Fiyati;
	}

	@Override
	public void Stok_Sifirsa_Sil(ArrayList<TAHIL> tahil_list, ArrayList<SUT> sut_list) {
	}

	@Override
	public void Yeni_Urun_Ekle(ArrayList<SEKERLEME> seker_list, ArrayList<ICECEK> ıcecek_list) {
		Scanner scanner = new Scanner(System.in);
		SEKERLEME yeni = new SEKERLEME();
		System.out.println("YENİ ÜRÜNÜN ADINI GİR:");
		String ad = scanner.nextLine();
		yeni.Adi = ad;
		yeni.Kategori_Indexi = 4;
		System.out.println("YENİ ÜRÜNÜN BİRİM AĞIRLIĞINI GİRİN:");
		String agirlik = scanner.nextLine();
		yeni.Birim_Agirligi = agirlik;
		Double ort = 0.0;
		double adet = 0.0;
		Integer min_stok = 100;
		// MİN STOK MİKTARI BULMA
		for (SEKERLEME sekerleme : seker_list) {
			adet++;
			ort += sekerleme.Birim_Fiyati;
			if(min_stok > sekerleme.Stok_Miktari) {
				min_stok = sekerleme.Stok_Miktari;
			}
		}
		ort /= adet;
		yeni.Birim_Fiyati = ort;
		yeni.Stok_Miktari = min_stok;
		seker_list.add(yeni);
	}

	@Override
	public Double Fiyat_Guncelle(ArrayList<CESNİ> cesni_list, ArrayList<SUT> sut_list) {
		return this.Birim_Fiyati;
	}

	public static void sekerleme_yaz(ArrayList<SEKERLEME> seker_list) {
		for (SEKERLEME seker : seker_list) {
			System.out.println("ürün adı:" + "\t" + seker.Adi + "\türün indexi:" + "\t" + seker.Kategori_Indexi + "\t" + "ürün stok:" + seker.Stok_Miktari
			+ "\t" + "ürün fiyatı:" + "\t" + seker.Birim_Fiyati + "\türün ağırlık:" + "\t" + seker.Birim_Agirligi);
		}
	}

}
