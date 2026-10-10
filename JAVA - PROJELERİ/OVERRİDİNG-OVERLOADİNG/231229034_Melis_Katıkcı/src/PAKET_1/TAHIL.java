package PAKET_1;

import java.util.ArrayList;


public class TAHIL extends ÜRÜN {

	public TAHIL(String adi, Integer index, String agirlik, Double fiyat, Integer stok) {
		super(adi, index, agirlik, fiyat, stok);
	}

	public TAHIL() {

	}

	@Override
	public Integer Fiyata_Göre_Stok_Güncelle(Integer stok, String isim) {
		return super.Fiyata_Göre_Stok_Güncelle(stok, isim);
	}

	@Override
	public String İsim_değiştir() {
		return super.İsim_değiştir();
	}

	public void tahıl_detay(Integer satış, Double fiyat) {
		this.Aylik_Satis = satış;
	}

	public void tahıl_detay(Double fiyat, Integer satış) {
		this.Yıllık_Satis = satış;
	}
	
	public static void tahıl_yaz(ArrayList<TAHIL> tahil_list) {
		for (TAHIL tahıl : tahil_list) {
			if(tahıl.Yıllık_Satis != null) {
				System.out.println("ürün adı:" + tahıl.getAdi() + "\türün indexi:" + tahıl.getKategori_Indexi() + "\t"
						+ "ürün stok:" + tahıl.getStok_Miktari() + "\t" + "ürün fiyatı:" + tahıl.getBirim_Fiyati()
						+ "\türün ağırlık:" + tahıl.getBirim_Agirligi() + "\tyıllık satış:" + tahıl.getYıllık_Satis());
			}else {
				System.out.println("ürün adı:" + tahıl.getAdi() + "\türün indexi:" + tahıl.getKategori_Indexi() + "\t"
						+ "ürün stok:" + tahıl.getStok_Miktari() + "\t" + "ürün fiyatı:" + tahıl.getBirim_Fiyati()
						+ "\türün ağırlık:" + tahıl.getBirim_Agirligi() + "\taylık satış:" + tahıl.getAylik_Satis());
			}
		}
	}

}
