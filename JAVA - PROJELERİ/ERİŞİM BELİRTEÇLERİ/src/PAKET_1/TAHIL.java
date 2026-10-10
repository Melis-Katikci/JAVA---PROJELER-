package PAKET_1;

import java.util.ArrayList;
import java.util.Scanner;

public class TAHIL extends ÜRÜN{

	public TAHIL(String adi, Integer index, String agirlik, Double fiyat, Integer stok) {
		super(adi, index, agirlik, fiyat, stok);
	}
	
	public static void yaz_tahil(ArrayList<TAHIL> tahil_list) {
		System.out.println("TAHIL LİSTESİ YAZDIRILIYOR...");
		for (TAHIL tahil : tahil_list) {
			// DÜZGÜN BİR ÇIKTI OLMASI İÇİN YAPILDI
			if(tahil.Aylik_Satis != null) {  // VERİYE AYLIK SATIŞ MİKTARI EKLEME ŞARTI SAĞLANMIŞSA
				tahil.Tahil_Liste_Yazdir(tahil);
			}else {
				tahil.Tum_Liste_Yazdir(tahil);
			}
			
		}
	}
	
	public static void Detay_Ekle_Tahil_Yardımcısı(ArrayList<TAHIL> tahil_list) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("BİRİM FİYATI HANGİ DEĞERİN ÜSTÜNDE OLAN ÜRÜNLERE AYLIK SATIŞ MİKTARI EKLEMEK İSTİYORSUNUZ:");
		int deger = scanner.nextInt();
		for (TAHIL tahil : tahil_list) {
			if(tahil.Stok_Miktari > deger) {
				System.out.println(tahil.Adi + " ÜRÜNÜNE EKLENECEK YENİ AYLIK SATIŞ MİKTARINI GİRİNİZ:");
				Integer satis = scanner.nextInt();
				tahil.Detay_Ekle_Tahil(satis);
			}
			
		}
		TAHIL.yaz_tahil(tahil_list);
	}
	
	private Integer Detay_Ekle_Tahil(Integer satis) {
		this.Aylik_Satis = satis;
		return this.Aylik_Satis;
	}

}
