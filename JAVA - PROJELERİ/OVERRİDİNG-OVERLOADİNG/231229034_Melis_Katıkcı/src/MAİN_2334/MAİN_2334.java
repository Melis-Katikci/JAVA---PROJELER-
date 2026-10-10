package MAİN_2334;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import PAKET_1.*;
import PAKET_2.*;

public class MAİN_2334 {
	
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		ArrayList<İÇECEK> icecek_list = new ArrayList<>();
		ArrayList<TAHIL> tahil_list = new ArrayList<>();
		ArrayList<SÜT> sut_list = new ArrayList<>();
		ArrayList<ŞEKERLEME> seker_list = new ArrayList<>();
		ArrayList<ÇEŞNİ> cesni_list = new ArrayList<>();
		//List_Olustur(icecek_list, tahil_list, sut_list, seker_list, cesni_list);
		OKUMA.oku_ve_yaz(icecek_list, tahil_list, sut_list, seker_list, cesni_list);
		int menu = -1;
		while(menu != 0) {
			System.out.println("\nMENÜ 1 : FİYATA GÖRE STOK GÜNCELLE" + "\nMENÜ 2 : FİYATI EN YÜKSEK ÜRÜNLERİN ADINI DEĞİŞTİRME" + "\nMENÜ 3 : İÇECEKİ STOĞA BAĞLI İNDİRİM YAP" + "\nMENÜ 4 : ÇEŞNİ TÜM STOK BİLGİLERİNİ GÜNCELLE" + "\nMENÜ 5 : ŞEKERLEME FİYATA GÖRE STOK GÜNCELLE" + "\nMENÜ 6 : SÜT ÜRÜNÜ ZAM YAP" + "\nMENÜ 7 : TAHIL ÜRÜNÜ DETAY BİLGİ EKLE " + "\nMENÜ 8 : ÇIKIŞ");
			menu = scanner.nextInt();
			if(menu == 1) {
				Fiyata_Gore_Stok_Guncelle(icecek_list, cesni_list, seker_list, sut_list, tahil_list);
			}else if(menu == 2) {
				En_Cogun_Adini_Degistir(icecek_list, cesni_list, seker_list, sut_list, tahil_list);
			}else if(menu == 3) {
				Icecek_Stok_Miktarina_Gore_Indirim_Yap(icecek_list);
			}else if(menu == 4) {
				Cesni_Stok_Sifirsa_Sil(cesni_list);
			}else if(menu == 5) {
				Sekerleme_Yeni_Urun_Ekle(seker_list);
			}else if(menu == 6) {
				Sut_Fiyat_Guncelle(sut_list);
			}else if(menu == 7) {
				Tahil_Detay_Bilgi_Ekle(tahil_list);
			}else {
				System.out.println("ÇIKIŞ YAPILDI...");
				break;
			}
		}
	}
	
	
	static void Fiyata_Gore_Stok_Guncelle(ArrayList<İÇECEK> icecek_list, ArrayList<ÇEŞNİ> cesni_list, ArrayList<ŞEKERLEME> seker_list, ArrayList<SÜT> sut_list, ArrayList<TAHIL> tahil_list) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("İŞLEM YAPILACAK FİYAT DEĞERİNİ GİR:");
		Double fiyat = scanner.nextDouble();
		System.out.println("YENİ STOK MİKTARINI GİR:");
		int stok = scanner.nextInt();
		for (İÇECEK İÇECEK : icecek_list) {
			if(İÇECEK.getBirim_Fiyati() < fiyat) {
				İÇECEK.Fiyata_Göre_Stok_Güncelle(stok, İÇECEK.getAdi());
			}
		}
		for (ÇEŞNİ ÇEŞNİ : cesni_list) {
			if(ÇEŞNİ.getBirim_Fiyati() < fiyat) {
				ÇEŞNİ.Fiyata_Göre_Stok_Güncelle(stok, ÇEŞNİ.getAdi());
			}
		}
		for (ŞEKERLEME ŞEKERLEME : seker_list) {
			if(ŞEKERLEME.getBirim_Fiyati() < fiyat) {
				ŞEKERLEME.Fiyata_Göre_Stok_Güncelle(stok, ŞEKERLEME.getAdi());
			}
		}
		for (SÜT SÜT : sut_list) {
			if(SÜT.getBirim_Fiyati() < fiyat) {
				SÜT.Fiyata_Göre_Stok_Güncelle(stok, SÜT.getAdi());
			}
		}
		for (TAHIL TAHIL : tahil_list) {
			if(TAHIL.getBirim_Fiyati() < fiyat) {
				TAHIL.Fiyata_Göre_Stok_Güncelle(stok, TAHIL.getAdi());
			}
		}
		OKUMA.Hepsi_Yaz(icecek_list, tahil_list, sut_list, seker_list, cesni_list);
	}
	
	
	static void En_Cogun_Adini_Degistir(ArrayList<İÇECEK> icecek_list, ArrayList<ÇEŞNİ> cesni_list, ArrayList<ŞEKERLEME> seker_list, ArrayList<SÜT> sut_list, ArrayList<TAHIL> tahil_list) {
		Double en_cok = 0.0;
		for (İÇECEK İÇECEK : icecek_list) {
			if(İÇECEK.getBirim_Fiyati() > en_cok) {
				en_cok = İÇECEK.getBirim_Fiyati();
			}
		}
		for (İÇECEK İÇECEK : icecek_list) {
			if(İÇECEK.getBirim_Fiyati() == en_cok) {
				İÇECEK.İsim_değiştir();
			}
		}
		en_cok = 0.0;
		for (ÇEŞNİ ÇEŞNİ : cesni_list) {
			if(ÇEŞNİ.getBirim_Fiyati() > en_cok) {
				en_cok = ÇEŞNİ.getBirim_Fiyati();
			}
		}
		for (ÇEŞNİ ÇEŞNİ : cesni_list) {
			if(ÇEŞNİ.getBirim_Fiyati() == en_cok) {
				ÇEŞNİ.İsim_değiştir();
			}
		}
		en_cok = 0.0;
		for (ŞEKERLEME ŞEKERLEME : seker_list) {
			if(ŞEKERLEME.getBirim_Fiyati() > en_cok) {
				en_cok = ŞEKERLEME.getBirim_Fiyati();
			}
		}
		for (ŞEKERLEME ŞEKERLEME : seker_list) {
			if(ŞEKERLEME.getBirim_Fiyati() == en_cok) {
				ŞEKERLEME.İsim_değiştir();
			}
		}
		en_cok = 0.0;
		for (SÜT SÜT : sut_list) {
			if(SÜT.getBirim_Fiyati() > en_cok) {
				en_cok = SÜT.getBirim_Fiyati();
			}
		}
		for (SÜT SÜT : sut_list) {
			if(SÜT.getBirim_Fiyati() == en_cok) {
				SÜT.İsim_değiştir();
			}
		}
		en_cok = 0.0;
		for (TAHIL TAHIL : tahil_list) {
			if(TAHIL.getBirim_Fiyati() > en_cok) {
				en_cok = TAHIL.getBirim_Fiyati();
			}
		}
		for (TAHIL TAHIL : tahil_list) {
			if(TAHIL.getBirim_Fiyati() == en_cok) {
				TAHIL.İsim_değiştir();
			}
		}
		OKUMA.Hepsi_Yaz(icecek_list, tahil_list, sut_list, seker_list, cesni_list);
	}
	
	
	static void Icecek_Stok_Miktarina_Gore_Indirim_Yap(ArrayList<İÇECEK> icecek_list) {
		Scanner scanner = new Scanner(System.in);
		
			System.out.println("İNDİRİM MİKTARI GİR:");
		Double	indirim = scanner.nextDouble();
		if(indirim <= 0) {
			System.out.println("POZİTİF DEĞER GİR:");
			indirim = scanner.nextDouble();
		}
		for (İÇECEK içecek : icecek_list) {
			if(içecek.getStok_Miktari() < 25) {
				içecek.İçecekler_indirim_Yap(içecek.getStok_Miktari(), indirim);
			}else {
				içecek.İçecekler_indirim_Yap(indirim, içecek.getStok_Miktari());
			}
		}
		
		İÇECEK.içecek_yaz(icecek_list);
		
	}
	
	
	static void Cesni_Stok_Sifirsa_Sil(ArrayList<ÇEŞNİ> cesni_list) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("BAZ ALINACAK YANI STOK MİKTARINI GİR:");
		int stok = scanner.nextInt();
		for (ÇEŞNİ çeşni : cesni_list) {
			if(çeşni.getStok_Miktari() == 0) {
				çeşni.stok_güncelle(çeşni.getAdi(), stok);
			}else {
				çeşni.stok_güncelle(stok, çeşni.getAdi());
			}
		}
		ÇEŞNİ.çeşni_yaz(cesni_list);
	}
	
	
	static void Sekerleme_Yeni_Urun_Ekle(ArrayList<ŞEKERLEME> seker_list){
		int index = 0;
		for (ŞEKERLEME şeker : seker_list) {
			if(şeker.getBirim_Fiyati() < 30) {
				şeker.seker_güncelle(şeker.getBirim_Fiyati(), şeker.getStok_Miktari(), index);
			}else if(şeker.getBirim_Fiyati() < 60) {
				şeker.seker_güncelle(şeker.getStok_Miktari(), index, şeker.getBirim_Fiyati());
			}else {
				şeker.seker_güncelle(şeker.getStok_Miktari(), şeker.getBirim_Fiyati(), index);
			}
			index++;
		}
		ŞEKERLEME.seker_yaz(seker_list);
	}
	
	
	static void Sut_Fiyat_Guncelle(ArrayList<SÜT> sut_list){
		Double ort = 0.0;
		int adet = 0;
		for (SÜT süt : sut_list) {
			ort += süt.getBirim_Fiyati();
			adet++;
		}
		ort /= adet;
		for (SÜT süt : sut_list) {
			if(süt.getBirim_Fiyati() < ort) {
				süt.süt_fiyat_güncelle(ort, 250);
			}else {
				süt.süt_fiyat_güncelle(150, ort);
			}
		}
		SÜT.süt_yaz(sut_list);
	}
	
	
	static void Tahil_Detay_Bilgi_Ekle(ArrayList<TAHIL> tahil_list){
		Scanner scanner = new Scanner(System.in);
		System.out.println("SINIR BELİRLEDİĞİNİZ FİYATI GİRİN:");
		Double fiyat = scanner.nextDouble();
		for (TAHIL tahil : tahil_list) {
			if(tahil.getBirim_Fiyati() < fiyat) {
				System.out.println(tahil.getAdi() + " ÜRÜNÜ İÇİN YILLIK SATIŞ MİKTARINI GİR:");
				int satış = scanner.nextInt();
				tahil.tahıl_detay(fiyat, satış);
			}else {
				System.out.println(tahil.getAdi() + " ÜRÜNÜ İÇİN AYLIK SATIŞ MİKTARINI GİR:");
				int satış = scanner.nextInt();
				tahil.tahıl_detay(satış, fiyat);
			}
		}
		TAHIL.tahıl_yaz(tahil_list);
	}
	

}