package PAKET_1;

import java.util.ArrayList;

public class ŞEKERLEME extends ÜRÜN {

	public ŞEKERLEME(String adi, Integer index, String agirlik, Double fiyat, Integer stok) {
		super(adi, index, agirlik, fiyat, stok);
	}

	public ŞEKERLEME() {

	}

	@Override
	public Integer Fiyata_Göre_Stok_Güncelle(Integer stok, String isim) {
		return super.Fiyata_Göre_Stok_Güncelle(stok, isim);
	}

	@Override
	public String İsim_değiştir() {
		return super.İsim_değiştir();
	}

	public Integer seker_güncelle(Double fiyat, Integer stok, Integer index) {
		return this.Stok_Miktari = (int) (stok + Math.floor(fiyat));
	}

	public Integer seker_güncelle(Integer stok, Integer index, Double fiyat) {
		if(stok % 2 == 0){
			return this.Stok_Miktari = stok / 2 ;
		}else {
			return this.Stok_Miktari = stok * 2 ;
		}
	}

	public Integer seker_güncelle(Integer stok, Double fiyat, Integer index) {
		return this.Stok_Miktari = 0;
	}
	
	public static void seker_yaz(ArrayList<ŞEKERLEME> seker_list) {
		for (ŞEKERLEME seker : seker_list) {
			System.out.println("ürün adı:" + "\t" + seker.getAdi() + "\türün indexi:" + "\t" + seker.getKategori_Indexi() + "\t" + "ürün stok:" + seker.getStok_Miktari()
			+ "\t" + "ürün fiyatı:" + "\t" + seker.getBirim_Fiyati() + "\türün ağırlık:" + "\t" + seker.getBirim_Agirligi());
		}
	}

}

