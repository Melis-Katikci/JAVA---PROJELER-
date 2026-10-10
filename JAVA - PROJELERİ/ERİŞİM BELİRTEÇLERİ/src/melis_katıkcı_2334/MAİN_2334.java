package melis_katıkcı_2334;

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
		OKUMA.oku_ve_yaz(icecek_list, tahil_list, sut_list, seker_list, cesni_list);
		int menu = -1;
		while(menu != 0) {
			System.out.println("\nMENÜ 1 : FİYATA GÖRE STOK GÜNCELLE" + "\nMENÜ 2 : FİYATI EN YÜKSEK ÜRÜNÜN ADINI DEĞİŞTİRME" + "\nMENÜ 3 : İÇECEKİ STOĞU EN AZ OLANA İNDİRİM YAP" + "\nMENÜ 4 : ÇEŞNİ STOĞU 0 OLAN ÜRÜNLERİ SİL" + "\nMENÜ 5 : ŞEKERLEME YENİ ÜRÜN EKLE" + "\nMENÜ 6 : SÜT ÜRÜNÜ FİYAT GÜNCELLEME" + "\nMENÜ 7 : TAHIL ÜRÜNÜ DETAY BİLGİ EKLE " + "\nMENÜ 8 : ÇIKIŞ");
			menu = scanner.nextInt();
			//ArrayList<TAHIL> tahil_list;
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
		ÜRÜN.Fiyata_Göre_Guncelle_yardımcısı(icecek_list, cesni_list, seker_list, sut_list, tahil_list);
	}
	
	
	static void En_Cogun_Adini_Degistir(ArrayList<İÇECEK> ıcecek_list, ArrayList<ÇEŞNİ> cesni_list, ArrayList<ŞEKERLEME> seker_list, ArrayList<SÜT> sut_list, ArrayList<TAHIL> tahil_list) {
		ÜRÜN.Isim_Degiştir_Yardımcısı(ıcecek_list, cesni_list, seker_list, sut_list, tahil_list);
	}
	
	
	static void Icecek_Stok_Miktarina_Gore_Indirim_Yap(ArrayList<İÇECEK> icecek_list) {
		Scanner scanner = new Scanner(System.in);
		Integer en_az = 100;
		String temp = null ;
		for (İÇECEK icecek : icecek_list) { // İÇECEK LİSTESİNDEKİ EN KÜÇÜK ELEMANI BULMA
			if(icecek.getStok_Miktari() < en_az && icecek.getStok_Miktari() != 0) {
				en_az = icecek.getStok_Miktari();
				temp = icecek.getAdi();
			}
		}
		System.out.println(temp + " ADLI ÜRÜNE İNDİRİM UYGULANACAK...");
		İÇECEK.Stoka_Gore_İndirim_Yap_Yardımcısı(icecek_list, en_az);
	}
	
	
	static void Cesni_Stok_Sifirsa_Sil(ArrayList<ÇEŞNİ> cesni_list) {
		ÇEŞNİ.Sifirsa_Sil_Cesni_Yardımcısı(cesni_list);
	}
	
	
	static void Sekerleme_Yeni_Urun_Ekle(ArrayList<ŞEKERLEME> seker_list){
		ŞEKERLEME.Yeni_Urun_Ekle_Sekerleme_Yardımcısı(seker_list);
	}
	
	
	static void Sut_Fiyat_Guncelle(ArrayList<SÜT> sut_list){
		SÜT.Fiyat_Guncelle_Sut_Yardımcısı(sut_list);
	}
	
	
	static void Tahil_Detay_Bilgi_Ekle(ArrayList<TAHIL> tahil_list){
		TAHIL.Detay_Ekle_Tahil_Yardımcısı(tahil_list);
	}
	
		
}