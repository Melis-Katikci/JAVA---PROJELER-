import java.util.ArrayList;

public class CESNİ extends URUNLER {
	
	public static void Sifirsa_Sil_Cesni(ArrayList<CESNİ> cesni_list) {
		for (int i = 0; i < cesni_list.size(); i++) {
			if(cesni_list.get(i).Stok_Miktari == 0) {
				cesni_list.remove(i);
			}
		}
	}
	
	public static void Cesni_Yazdir(ArrayList<CESNİ> cesni_list) {
		System.out.println("ÇEŞNİ LİSTESİ YAZDIRILIYOR...");
		for (CESNİ cesni : cesni_list) {
			cesni.Tum_Liste_Yazdir(cesni);
		}
	}

}
