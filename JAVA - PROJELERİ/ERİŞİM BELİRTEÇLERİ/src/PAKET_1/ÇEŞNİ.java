package PAKET_1;

import java.util.ArrayList;

public class ÇEŞNİ extends ÜRÜN{

	public ÇEŞNİ(String adi, Integer index, String agirlik, Double fiyat, Integer stok) {
		super(adi, index, agirlik, fiyat, stok);
	}
	
	public static void yaz_cesni(ArrayList<ÇEŞNİ> cesni_list) {
		for (ÇEŞNİ cesni : cesni_list) {
			cesni.Tum_Liste_Yazdir(cesni);
		}
	}
	
	private static void Sifirsa_Sil_Cesni(ArrayList<ÇEŞNİ> cesni_list, Integer i) {
		for (int j = 0; j < cesni_list.size(); j++) {
			if(j == i) {
				cesni_list.remove(j);
				break;
			}
		}
	}
	
	public static void Sifirsa_Sil_Cesni_Yardımcısı(ArrayList<ÇEŞNİ> cesni_list) {
		System.out.println("ÇEŞNİ KATEGORİSİNDE BULUNAN TÜM ÜRÜNLERİN LİSTESİ:");
		ÇEŞNİ.yaz_cesni(cesni_list);
		for (int i = 0; i < cesni_list.size(); i++) {
			if(cesni_list.get(i).Stok_Miktari == 0) {
				ÇEŞNİ.Sifirsa_Sil_Cesni(cesni_list, i);
			}
		}
		System.out.println("\nÇEŞNİ KATEGORİSİNDE STOĞU SIFIRDAN FARKLI OLAN TÜM ÜRÜNLERİN LİSTESİ:");
		ÇEŞNİ.yaz_cesni(cesni_list);
	}

}
