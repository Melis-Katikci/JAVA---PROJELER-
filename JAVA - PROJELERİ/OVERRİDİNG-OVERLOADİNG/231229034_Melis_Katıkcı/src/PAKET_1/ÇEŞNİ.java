package PAKET_1;

import java.util.ArrayList;

public class ÇEŞNİ extends ÜRÜN{

	public ÇEŞNİ(String adi, Integer index, String agirlik, Double fiyat, Integer stok) {
		super(adi, index, agirlik, fiyat, stok);
	}
	
	public ÇEŞNİ() {
		
	}
	
	@Override
	public Integer Fiyata_Göre_Stok_Güncelle(Integer stok, String isim) {
		return super.Fiyata_Göre_Stok_Güncelle(stok, isim);
	}
	
	@Override
	public String İsim_değiştir() {
		return this.Adi = "BCDFGHJKLMN";
	}
	
	public Integer stok_güncelle(String adi, Integer Stok) {
		return this.Stok_Miktari = Stok;
	}
	
	public Integer stok_güncelle(Integer Stok, String adi) {
		int temp = this.Stok_Miktari - Stok;
		if(temp < 0) {
			return this.Stok_Miktari = 0;
		}else {
			return this.Stok_Miktari = temp;
		}
	}
	
	public static void çeşni_yaz(ArrayList<ÇEŞNİ> cesni_list) {
		for (ÇEŞNİ cesni : cesni_list) {
			System.out.println("ürün adı:" + "\t" + cesni.getAdi() + "\türün indexi:" + "\t" + cesni.getKategori_Indexi() + "\t" + "ürün stok:" + cesni.getStok_Miktari()
			+ "\t" + "ürün fiyatı:" + "\t" + cesni.getBirim_Fiyati() + "\türün ağırlık:" + "\t" + cesni.getBirim_Agirligi() + "   ");
		}
	}

}