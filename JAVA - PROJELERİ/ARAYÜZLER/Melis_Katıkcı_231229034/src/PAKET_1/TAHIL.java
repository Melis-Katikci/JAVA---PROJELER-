package PAKET_1;

import java.util.ArrayList;
import java.util.Scanner;

public class TAHIL extends URUN implements IURUN{

	public TAHIL(String Adi, Integer Kategori_Indexi, String Birim_Agirligi, Double Birim_Fiyati,
			Integer Stok_Miktari) {
		super(Adi, Kategori_Indexi, Birim_Agirligi, Birim_Fiyati, Stok_Miktari);
	}
	
	public TAHIL() {
		super();
	}

	@Override
	public Double Stok_Miktarina_Gore_Indirim_Yap(int en_az , Double fiyat) {
		return this.Birim_Fiyati;
	}

	@Override
	public void Stok_Sifirsa_Sil(ArrayList<TAHIL> tahil_list, ArrayList<SUT> sut_list) {
		for (int i = 0; i < tahil_list.size(); i++) {
			if(tahil_list.get(i).Stok_Miktari == 0) {
				tahil_list.remove(i);
			}
		}
	}

	@Override
	public void Yeni_Urun_Ekle(ArrayList<SEKERLEME> seker_list, ArrayList<ICECEK> ıcecek_list) {
	}

	@Override
	public Double Fiyat_Guncelle(ArrayList<CESNİ> cesni_list, ArrayList<SUT> sut_list) {
		return this.Birim_Fiyati;
	}
	
	public static void tahil_yaz(ArrayList<TAHIL> tahil_list) {
		for (TAHIL tahıl : tahil_list) {
			System.out.println("ürün adı:" + "\t" + tahıl.Adi + "\türün indexi:" + "\t" + tahıl.Kategori_Indexi + "\t" + "ürün stok:" + tahıl.Stok_Miktari
			+ "\t" + "ürün fiyatı:" + "\t" + tahıl.Birim_Fiyati + "\türün ağırlık:" + "\t" + tahıl.Birim_Agirligi);
		}
	}

}
