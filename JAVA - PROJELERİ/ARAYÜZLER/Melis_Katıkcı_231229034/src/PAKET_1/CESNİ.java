package PAKET_1;

import java.util.ArrayList;
import java.util.Scanner;

public class CESNİ extends URUN implements IURUN{

	public CESNİ(String Adi, Integer Kategori_Indexi, String Birim_Agirligi, Double Birim_Fiyati,
			Integer Stok_Miktari) {
		super(Adi, Kategori_Indexi, Birim_Agirligi, Birim_Fiyati, Stok_Miktari);
	}
	
	public CESNİ() {
		super();
	}

	@Override
	public Double Stok_Miktarina_Gore_Indirim_Yap(int en_az, Double fiyat) {
		Scanner scanner = new Scanner(System.in);
		int kontrol = 0;
		System.out.println("YÜZDE KAÇ İNDİRİM YAPACAKSİNİZ");
		Integer indirim = scanner.nextInt();
		while(kontrol != 1) {
			if(indirim <= 100) {  // MAX İNDİRİM MİKTARI %100 BUNUN KONTROLÜ
				this.Birim_Fiyati -= (this.Birim_Fiyati * indirim) / 100;
				//icecek.Stok_Miktarina_Gore_Indirim_Yap(indirim);   // İNDİRİM YAPILACAK VERİYİ YOLLADIK İSMİ GÜNCELLEDİK
				kontrol = 1;
			}else {
				System.out.println("EN FAZLA %100 İNDİRİM YAPILABİLİR... İNDİRİM ORANI GİRİN...");
				indirim = scanner.nextInt();
			}
		}
		return this.Birim_Fiyati;
	}

	@Override
	public void Stok_Sifirsa_Sil(ArrayList<TAHIL> tahil_list, ArrayList<SUT> sut_list) {
	}

	@Override
	public void Yeni_Urun_Ekle(ArrayList<SEKERLEME> seker_list, ArrayList<ICECEK> ıcecek_list) {
	}

	@Override
	public Double Fiyat_Guncelle(ArrayList<CESNİ> cesni_list, ArrayList<SUT> sut_list) {
		Scanner scanner = new Scanner(System.in);
		double adet = 0.0;
		double ort = 0.0;
		// FİYATLARIN ORTALAMASINI BULMA
		for (CESNİ cesni : cesni_list) {
			adet++;
			ort += cesni.Birim_Fiyati;
		}
		ort /=adet;
		double temp = 100;
		double tut = 0;
		System.out.println("HESAPLANAN ORTALAMA: " + ort);
		// ORTALAMANIN 1 ALTINDEKİ VERİ TESPİTİ
		for (CESNİ cesni : cesni_list) {
			double temp2 = ort - cesni.Birim_Fiyati;
			if(temp2 > 0 && temp2 < temp) {  // FARK POZİTİF İSE ALTINDADIR 
				temp = temp2;
				tut = cesni.Birim_Fiyati;
			}
		}
		// BULUNAN VERİ ÜZERİNDE İŞLEMLER
		for (int i = 0; i < cesni_list.size(); i++) {
			if(cesni_list.get(i).Birim_Fiyati == tut) {
				System.out.println("GÜNCELLENEN ÜRÜNÜN ESKİ HALİ:");
				System.out.println("ürün adı:" + "\t" + cesni_list.get(i).Adi + "\türün indexi:" + "\t" + cesni_list.get(i).Kategori_Indexi + "\t" + "ürün stok:" + cesni_list.get(i).Stok_Miktari + "\t" + "ürün fiyatı:" + "\t" + cesni_list.get(i).Birim_Fiyati + "\türün ağırlık:" + "\t" + cesni_list.get(i).Birim_Agirligi);
				cesni_list.get(i).Birim_Fiyati = (cesni_list.get(i).Birim_Fiyati * 150.0) / 100.0;
				System.out.println("GÜNCELLENEN ÜRÜNÜN YENİ HALİ:");
				System.out.println("ürün adı:" + "\t" + cesni_list.get(i).Adi + "\türün indexi:" + "\t" + cesni_list.get(i).Kategori_Indexi + "\t" + "ürün stok:" + cesni_list.get(i).Stok_Miktari + "\t" + "ürün fiyatı:" + "\t" + cesni_list.get(i).Birim_Fiyati + "\türün ağırlık:" + "\t" + cesni_list.get(i).Birim_Agirligi);
			}
		}
		return this.Birim_Fiyati;
	}

	public static void cesni_yaz(ArrayList<CESNİ> cesni_list) {
		for (CESNİ cesni : cesni_list) {
			System.out.println("ürün adı:" + "\t" + cesni.Adi + "\türün indexi:" + "\t" + cesni.Kategori_Indexi + "\t" + "ürün stok:" + cesni.Stok_Miktari
			+ "\t" + "ürün fiyatı:" + "\t" + cesni.Birim_Fiyati + "\türün ağırlık:" + "\t" + cesni.Birim_Agirligi + "   ");
		}
	}

}
