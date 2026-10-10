package PAKET_1;

import java.util.ArrayList;
import java.util.Scanner;

public class SÜT extends ÜRÜN{

	public SÜT(String adi, Integer index, String agirlik, Double fiyat, Integer stok) {
		super(adi, index, agirlik, fiyat, stok);
	}
	
	public static void yaz_sut(ArrayList<SÜT> sut_list) {
		for (SÜT sut : sut_list) {
			sut.Tum_Liste_Yazdir(sut);
		}
	}
	
	public static void Fiyat_Guncelle_Sut_Yardımcısı(ArrayList<SÜT> sut_list) {
		Scanner scanner = new Scanner(System.in);
		double adet = 0.0;
		double ort = 0.0;
		// FİYATLARIN ORTALAMASINI BULMA
		for (SÜT sut : sut_list) {
			adet++;
			ort += sut.Birim_Fiyati;
		}
		ort /=adet;
		double temp = 100;
		double tut = 0;
		// ORTALAMANIN 1 ALTINDEKİ VERİ TESPİTİ
		for (SÜT sut : sut_list) {
			double temp2 = ort - sut.Birim_Fiyati;
			if(temp2 > 0 && temp2 < temp) {  // FARK POZİTİF İSE ALTINDADIR 
				temp = temp2;
				tut = sut.Birim_Fiyati;
			}
		}
		// BULUNAN VERİ ÜZERİNDE İŞLEMLER
		for (int i = 0; i < sut_list.size(); i++) {
			if(sut_list.get(i).Birim_Fiyati == tut) {
				System.out.println("ZAM YAPILACAK ÜRÜN:");
				System.out.println("ürün adı: " + "\t" + sut_list.get(i).Adi + "\türün indexi: " + "\t" + sut_list.get(i).Kategori_Indexi + "\t" + "ürün stok: " + sut_list.get(i).Stok_Miktari
				+ "\t" + "ürün fiyatı: " + "\t" + sut_list.get(i).Birim_Fiyati + "\türün ağırlık: " + "\t" + sut_list.get(i).Birim_Agirligi);
				sut_list.get(i).Fiyat_Guncelle_Sut( sut_list, i);
			}
		}
	}
	
	private static void Fiyat_Guncelle_Sut(ArrayList<SÜT> sut_list, Integer i) {
		System.out.println("\nGÜNCELLENECEK ÜRÜNÜN ( ORTALAMANIN 1 ALTINDAKİ ÜRÜN ) İLK HALİ...");
		SÜT.yaz_sut(sut_list);
		sut_list.get(i).Birim_Fiyati = (sut_list.get(i).Birim_Fiyati * 150) / 100;
		System.out.println("\nGÜNCELLENEN ÜRÜNÜN ( ORTALAMANIN 1 ALTINDAKİ ÜRÜN ) %50 ZAMLI HALİ...");
		SÜT.yaz_sut(sut_list);
	}

}
