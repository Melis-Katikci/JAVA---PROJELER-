package PAKET_1;

import java.util.ArrayList;

public interface IURUN {
	
	public Double Stok_Miktarina_Gore_Indirim_Yap(int indirim, Double fiyat);
	
	public void Stok_Sifirsa_Sil(ArrayList<TAHIL> tahil_list, ArrayList<SUT> sut_list);
	
	public void Yeni_Urun_Ekle(ArrayList<SEKERLEME> seker_list, ArrayList<ICECEK> ıcecek_list);
	
	public Double Fiyat_Guncelle(ArrayList<CESNİ> cesni_list, ArrayList<SUT> sut_list);

}
