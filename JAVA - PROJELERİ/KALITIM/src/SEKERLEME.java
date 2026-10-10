import java.util.ArrayList;
import java.util.Scanner;

public class SEKERLEME extends URUNLER{
	
	public static void Yeni_Urun_Ekle_Sekerleme(ArrayList<SEKERLEME> seker_list) {
		Scanner scanner = new Scanner(System.in);
		SEKERLEME yeni = new SEKERLEME();
		System.out.println("YENİ ÜRÜNÜN ADINI GİR:");
		String ad = scanner.nextLine();
		yeni.Adi = ad;
		yeni.Kategori_Indexi = 3;
		System.out.println("YENİ ÜRÜNÜN BİRİM AĞIRLIĞINI GİRİN:");
		String agirlik = scanner.nextLine();
		yeni.Birim_Agirligi = agirlik;
		Double ort = 0.0;
		double adet = 0.0;
		Integer min_stok = 100;
		// MİN STOK MİKTARI BULMA
		for (SEKERLEME sekerleme : seker_list) {
			adet++;
			ort += sekerleme.Birim_Fiyati;
			if(min_stok > sekerleme.Stok_Miktari) {
				min_stok = sekerleme.Stok_Miktari;
			}
		}
		ort /= adet;
		yeni.Birim_Fiyati = ort;
		yeni.Stok_Miktari = min_stok;
		seker_list.add(yeni);
		System.out.println("ŞEKERLEME LİSTESİ YAZDIRILIYOR...");
		for (SEKERLEME sekerleme : seker_list) {
			sekerleme.Tum_Liste_Yazdir(sekerleme);
		}
	}

}
