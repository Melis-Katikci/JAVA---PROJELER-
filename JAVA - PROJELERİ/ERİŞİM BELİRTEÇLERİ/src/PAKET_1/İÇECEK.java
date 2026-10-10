package PAKET_1;

import java.util.ArrayList;
import java.util.Scanner;


public class İÇECEK extends ÜRÜN{

	public İÇECEK(String adi, Integer index, String agirlik, Double fiyat, Integer stok) {
		super(adi, index, agirlik, fiyat, stok);
	}
	
	public static void yaz_icecek(ArrayList<İÇECEK> icecek_list) {
		for (İÇECEK icecek : icecek_list) {
			icecek.Tum_Liste_Yazdir(icecek);
		}
	}
	
	public static void Stoka_Gore_İndirim_Yap_Yardımcısı(ArrayList<İÇECEK> icecek_list, Integer en_az) {
		Scanner scanner = new Scanner(System.in);
		for (İÇECEK icecek : icecek_list) {
			if(icecek.Stok_Miktari == en_az) {
				int kontrol = 0;
				System.out.println("YÜZDE KAÇ İNDİRİM YAPACAKSİNİZ");
				Integer indirim = scanner.nextInt();
				while(kontrol != 1) {
					if(indirim <= 100 && indirim >= 0) {  // MAX İNDİRİM MİKTARI %100 BUNUN KONTROLÜ
						icecek.Stoka_Gore_İndirim_Yap(indirim);   // İNDİRİM YAPILACAK VERİYİ YOLLADIK İSMİ GÜNCELLEDİK
						kontrol = 1;
					}else {
						System.out.println("EN FAZLA %100 İNDİRİM YAPILABİLİR... İNDİRİM ORANI GİRİN...");
						indirim = scanner.nextInt();
					}
				}
			}
		}
		System.out.println("\nİNDİRİM UYGULANMIŞ HAL:");
		İÇECEK.yaz_icecek(icecek_list);
	}
	
	private Double Stoka_Gore_İndirim_Yap(Integer indirim) {
		System.out.println("\nÜRÜNÜN İNDİRİMDEN ÖNCEKİ HALİ:");
		System.out.println("ürün adı: " + "\t" + this.Adi + "\türün indexi: " + "\t" + this.Kategori_Indexi + "\t" + "ürün stok: " + this.Stok_Miktari
				+ "\t" + "ürün fiyatı: " + "\t" + this.Birim_Fiyati + "\türün ağırlık: " + "\t" + this.Birim_Agirligi);
		this.Birim_Fiyati -= (this.Birim_Fiyati * indirim) / 100;
		return this.Birim_Fiyati;
	}

}
