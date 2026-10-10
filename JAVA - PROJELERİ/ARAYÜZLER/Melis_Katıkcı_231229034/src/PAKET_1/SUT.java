package PAKET_1;

import java.util.ArrayList;
import java.util.Scanner;

public class SUT extends URUN implements IURUN{

	public SUT(String Adi, Integer Kategori_Indexi, String Birim_Agirligi, Double Birim_Fiyati, Integer Stok_Miktari) {
		super(Adi, Kategori_Indexi, Birim_Agirligi, Birim_Fiyati, Stok_Miktari);
	}
	
	public SUT() {
		super();
	}

	@Override
	public Double Stok_Miktarina_Gore_Indirim_Yap(int en_az, Double fiyat) {
		return this.Birim_Fiyati;
	}

	@Override
	public void Stok_Sifirsa_Sil(ArrayList<TAHIL> tahil_list, ArrayList<SUT> sut_list) {
		for (int i = 0; i < sut_list.size(); i++) {
			if(sut_list.get(i).Stok_Miktari == 0) {
				sut_list.remove(i);
			}
		}
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
		for (SUT sut : sut_list) {
			adet++;
			ort += sut.Birim_Fiyati;
		}
		ort /=adet;
		double temp = 100;
		double tut = 0;
		System.out.println("HESAPLANAN ORTALAMA: " + ort);
		// ORTALAMANIN 1 ALTINDEKİ VERİ TESPİTİ
		for (SUT sut : sut_list) {
			double temp2 = ort - sut.Birim_Fiyati;
			if(temp2 > 0 && temp2 < temp) {  // FARK POZİTİF İSE ALTINDADIR 
				temp = temp2;
				tut = sut.Birim_Fiyati;
			}
		}
		// BULUNAN VERİ ÜZERİNDE İŞLEMLER
		for (int i = 0; i < sut_list.size(); i++) {
			if(sut_list.get(i).Birim_Fiyati == tut) {
				System.out.println("GÜNCELLENEN ÜRÜNÜN ESKİ HALİ:");
				System.out.println("ürün adı:" + "\t" + sut_list.get(i).Adi + "\türün indexi:" + "\t" + sut_list.get(i).Kategori_Indexi + "\t" + "ürün stok:" + sut_list.get(i).Stok_Miktari + "\t" + "ürün fiyatı:" + "\t" + sut_list.get(i).Birim_Fiyati + "\türün ağırlık:" + "\t" + sut_list.get(i).Birim_Agirligi);
				sut_list.get(i).Birim_Fiyati = (sut_list.get(i).Birim_Fiyati * 150.0) / 100.0;
				System.out.println("GÜNCELLENEN ÜRÜNÜN YENİ HALİ:");
				System.out.println("ürün adı:" + "\t" + sut_list.get(i).Adi + "\türün indexi:" + "\t" + sut_list.get(i).Kategori_Indexi + "\t" + "ürün stok:" + sut_list.get(i).Stok_Miktari + "\t" + "ürün fiyatı:" + "\t" + sut_list.get(i).Birim_Fiyati + "\türün ağırlık:" + "\t" + sut_list.get(i).Birim_Agirligi);
			}
		}
		return this.Birim_Fiyati;
	}

	public static void sut_yaz(ArrayList<SUT> sut_list) {
		for (SUT sut : sut_list) {
			System.out.println("ürün adı:" + "\t" + sut.Adi + "\türün indexi:" + "\t" + sut.Kategori_Indexi + "\t" + "ürün stok:" + sut.Stok_Miktari
			+ "\t" + "ürün fiyatı:" + "\t" + sut.Birim_Fiyati + "\türün ağırlık:" + "\t" + sut.Birim_Agirligi);
		}
	}

}
