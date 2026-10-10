import java.util.ArrayList;

public class TAHIL extends URUNLER {

	public Integer Detay_Ekle_Tahil(Integer satis) {
		this.Aylik_Satis = satis;
		return this.Aylik_Satis;
	}

	public static void Tahil_yazdir(ArrayList<TAHIL> tahil_list) {
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

}