import java.util.ArrayList;

public class SUT extends URUNLER{
	
	public Double Fiyat_Guncelle_Sut() {
		System.out.println("GÜNCELLENECEK ÜRÜNÜN İLK HALİ...");
		System.out.println(this.Adi + "\t" + this.Kategori_Indexi + "\t" + this.Birim_Agirligi + "\t" + this.Birim_Fiyati + "\t" + this.Stok_Miktari);
		this.Birim_Fiyati = (this.Birim_Fiyati * 150) / 100;
		System.out.println("\nGÜNCELLENEN ÜRÜNÜN SON HALİ...");
		System.out.println(this.Adi + "\t" + this.Kategori_Indexi + "\t" + this.Birim_Agirligi + "\t" + this.Birim_Fiyati + "\t" + this.Stok_Miktari);
		return this.Birim_Fiyati;
	}
	
	public static void sut_yazdir(ArrayList<SUT> sut_list) {
		System.out.println("\nSÜT LİSTESİ YAZDIRILIYOR...");
		for (SUT sut : sut_list) {
			sut.Tum_Liste_Yazdir(sut);
		}
	}

}
