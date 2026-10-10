package PAKET_1;

import java.util.ArrayList;
import java.util.Scanner;

public class ŞEKERLEME extends ÜRÜN{

	public ŞEKERLEME(String adi, Integer index, String agirlik, Double fiyat, Integer stok) {
		super(adi, index, agirlik, fiyat, stok);
	}
	
	public ŞEKERLEME() {
		
	}
	
	public static void yaz_seker(ArrayList<ŞEKERLEME> seker_list) {
		for (ŞEKERLEME seker : seker_list) {
			seker.Tum_Liste_Yazdir(seker);
		}
	}
	
	private static void Yeni_Urun_Ekle_Sekerleme(ArrayList<ŞEKERLEME> seker_list, String ad, String agirlik, Double ort, Integer min_stok) {
		ŞEKERLEME yeni = new ŞEKERLEME();
		yeni.Adi = ad;
		yeni.Kategori_Indexi = 4;
		yeni.Birim_Agirligi = agirlik;
		yeni.Birim_Fiyati = ort;
		yeni.Stok_Miktari = min_stok;
		seker_list.add(yeni);
		System.out.println("GÜNCEL ŞEKERLEME LİSTESİ YAZDIRILIYOR...");
		ŞEKERLEME.yaz_seker(seker_list);
	}
	
	public static void Yeni_Urun_Ekle_Sekerleme_Yardımcısı(ArrayList<ŞEKERLEME> seker_list) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("YENİ ÜRÜNÜN ADINI GİR:");
		String ad = scanner.nextLine();
		
		System.out.println("YENİ ÜRÜNÜN BİRİM AĞIRLIĞINI GİRİN:");
		String agirlik = scanner.nextLine();
		Double ort = 0.0;
		double adet = 0.0;
		Integer min_stok = 100;
		// MİN STOK MİKTARI BULMA
		for (ŞEKERLEME sekerleme : seker_list) {
			adet++;
			ort += sekerleme.Birim_Fiyati;
			if(min_stok > sekerleme.Stok_Miktari) {
				min_stok = sekerleme.Stok_Miktari;
			}
		}
		ort /= adet;
		ŞEKERLEME.Yeni_Urun_Ekle_Sekerleme(seker_list, ad, agirlik, ort, min_stok);
	}
	
}
