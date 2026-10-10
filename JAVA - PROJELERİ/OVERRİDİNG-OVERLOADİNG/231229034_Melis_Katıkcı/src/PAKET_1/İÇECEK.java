package PAKET_1;

import java.util.ArrayList;
import java.util.Scanner;

public class İÇECEK extends ÜRÜN{

	public İÇECEK(String adi, Integer index, String agirlik, Double fiyat, Integer stok) {
		super(adi, index, agirlik, fiyat, stok);
	}
	
	public İÇECEK() {
		
	}
	
	@Override
	public Integer Fiyata_Göre_Stok_Güncelle(Integer stok, String isim) {
		if(isim.length() % 2 == 0) {
			return this.Stok_Miktari = stok;
		}else {
			return this.Stok_Miktari = stok * 2;
		}
	}
	
	@Override
	public String İsim_değiştir() {
		return super.İsim_değiştir();
	}
	
	public Double İçecekler_indirim_Yap(Integer stok, Double indirim) {
		return this.Birim_Fiyati = (this.Birim_Fiyati*indirim ) / 100.0;
	}
	
	public Double İçecekler_indirim_Yap(Double indirim, Integer stok) {
		return this.Birim_Fiyati = (this.Birim_Fiyati*(indirim / 5) ) / 100.0;
	}
	
	public static void içecek_yaz(ArrayList<İÇECEK> icecek_list) {
		for (İÇECEK icecek : icecek_list) {
			System.out.println("ürün adı:" + "\t" + icecek.getAdi() + "\türün indexi:" + "\t" + icecek.getKategori_Indexi() + "\t" + "ürün stok:" + icecek.getStok_Miktari()
			+ "\t" + "ürün fiyatı:" + "\t" + icecek.getBirim_Fiyati() + "\türün ağırlık:" + "\t" + icecek.getBirim_Agirligi());
		}
	}

}