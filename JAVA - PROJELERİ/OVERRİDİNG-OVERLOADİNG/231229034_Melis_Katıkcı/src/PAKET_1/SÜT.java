package PAKET_1;

import java.util.ArrayList;


public class SÜT extends ÜRÜN{

	public SÜT(String adi, Integer index, String agirlik, Double fiyat, Integer stok) {
		super(adi, index, agirlik, fiyat, stok);
	}
	
	public SÜT() {
		
	}
	
	@Override
	public Integer Fiyata_Göre_Stok_Güncelle(Integer stok, String isim) {
		return super.Fiyata_Göre_Stok_Güncelle(stok, isim);
	}
	
	@Override
	public String İsim_değiştir() {
		return super.İsim_değiştir();
	}
	
	public Double süt_fiyat_güncelle(Double fiyat, Integer oran) {
		return this.Birim_Fiyati = (this.Birim_Fiyati * oran) /100.0;
	}
	
	public Double süt_fiyat_güncelle(Integer oran, Double fiyat) {
		return this.Birim_Fiyati = (this.Birim_Fiyati * oran) /100.0;
	}
	public static void süt_yaz(ArrayList<SÜT> sut_list) {
		for (SÜT sut : sut_list) {
			System.out.println("ürün adı:" + "\t" + sut.getAdi() + "\türün indexi:" + "\t" + sut.getKategori_Indexi() + "\t" + "ürün stok:" + sut.getStok_Miktari()
			+ "\t" + "ürün fiyatı:" + "\t" + sut.getBirim_Fiyati() + "\türün ağırlık:" + "\t" + sut.getBirim_Agirligi());
		}
	}

}
