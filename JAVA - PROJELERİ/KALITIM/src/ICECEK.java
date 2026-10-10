import java.util.ArrayList;

public class ICECEK extends URUNLER{
		
		public Double Stoka_Gore_İndirim_Yap(Integer indirim) {
			this.Birim_Fiyati -= (this.Birim_Fiyati * indirim) / 100;
			return this.Birim_Fiyati;
		}
		
		public static void Icecek_Yazdir(ArrayList<ICECEK> ıcecek_list) {
			System.out.println("İÇECEK LİSTESİ YAZDIRILIYOR...");
			for (ICECEK icecek : ıcecek_list) {
				icecek.Tum_Liste_Yazdir(icecek);
			}
		}

}
