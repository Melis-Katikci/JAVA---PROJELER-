
public class URUNLER {
	
	public String Adi;
	public Integer Kategori_Indexi;
	public String Birim_Agirligi;
	public Double Birim_Fiyati;
	public Integer Stok_Miktari;
	public Integer Aylik_Satis;
	
	public Integer Fiyata_Göre_Guncelle(Integer stok) {
		this.Stok_Miktari = stok;
		return this.Stok_Miktari;
	}
	
	public static void Tum_Liste_Yazdir(URUNLER urun) {
		System.out.println(urun.Adi + "\t" + urun.Kategori_Indexi + "\t" + urun.Birim_Agirligi + "\t" + urun.Birim_Fiyati + "\t" + urun.Stok_Miktari);
	}
	
	public static void Tahil_Liste_Yazdir(URUNLER urun) {
		System.out.println(urun.Adi + "\t" + urun.Kategori_Indexi + "\t" + urun.Birim_Agirligi + "\t" + urun.Birim_Fiyati + "\t" + urun.Stok_Miktari + "\t" + urun.Aylik_Satis);
	}
	
	public String Urun_Isim_Degistir(String yeni) {
		System.out.println(this.Adi + "\t" + this.Kategori_Indexi + "\t" + this.Birim_Agirligi + "\t" + this.Birim_Fiyati + "\t" + this.Stok_Miktari);
		this.Adi = yeni;
		System.out.println(this.Adi + "\t" + this.Kategori_Indexi + "\t" + this.Birim_Agirligi + "\t" + this.Birim_Fiyati + "\t" + this.Stok_Miktari);
		return this.Adi;
	}

}
