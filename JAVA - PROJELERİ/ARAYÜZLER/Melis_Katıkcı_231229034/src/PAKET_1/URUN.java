package PAKET_1;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class URUN {
	
	public String Adi;
	public Integer Kategori_Indexi;
	public String Birim_Agirligi;
	public Double Birim_Fiyati;
	public Integer Stok_Miktari;
	public Integer Aylik_Satis;
	
	public URUN(String Adi, Integer Kategori_Indexi, String Birim_Agirligi, Double Birim_Fiyati, Integer Stok_Miktari) {
		this.Adi = Adi;
		this.Kategori_Indexi = Kategori_Indexi;
		this.Birim_Agirligi = Birim_Agirligi;
		this.Birim_Fiyati = Birim_Fiyati;
		this.Stok_Miktari = Stok_Miktari;
	}
	
	public URUN() {
		
	}
	
	public static void Hepsi_Yaz(ArrayList<ICECEK> icecek_list, ArrayList<TAHIL> tahil_list, ArrayList<SUT> sut_list,
			ArrayList<SEKERLEME> seker_list, ArrayList<CESNİ> cesni_list) {
		System.out.println("İÇECEK LİSTESİ...");
		for (ICECEK icecek : icecek_list) {
			System.out.println("ürün adı:" + "\t" + icecek.Adi + "\türün indexi:" + "\t" + icecek.Kategori_Indexi + "\t" + "ürün stok:" + icecek.Stok_Miktari
					+ "\t" + "ürün fiyatı:" + "\t" + icecek.Birim_Fiyati + "\türün ağırlık:" + "\t" + icecek.Birim_Agirligi);
		}
		System.out.println();
		System.out.println("TAHIL LİSTESİ...");
		for (TAHIL tahıl : tahil_list) {
			System.out.println("ürün adı:" + "\t" + tahıl.Adi + "\türün indexi:" + "\t" + tahıl.Kategori_Indexi + "\t" + "ürün stok:" + tahıl.Stok_Miktari
			+ "\t" + "ürün fiyatı:" + "\t" + tahıl.Birim_Fiyati + "\türün ağırlık:" + "\t" + tahıl.Birim_Agirligi);
		}
		System.out.println();
		System.out.println("SÜT LİSTESİ...");
		for (SUT sut : sut_list) {
			System.out.println("ürün adı:" + "\t" + sut.Adi + "\türün indexi:" + "\t" + sut.Kategori_Indexi + "\t" + "ürün stok:" + sut.Stok_Miktari
			+ "\t" + "ürün fiyatı:" + "\t" + sut.Birim_Fiyati + "\türün ağırlık:" + "\t" + sut.Birim_Agirligi);
		}
		System.out.println();
		System.out.println("ŞEKERLEME LİSTESİ...");
		for (SEKERLEME seker : seker_list) {
			System.out.println("ürün adı:" + "\t" + seker.Adi + "\türün indexi:" + "\t" + seker.Kategori_Indexi + "\t" + "ürün stok:" + seker.Stok_Miktari
			+ "\t" + "ürün fiyatı:" + "\t" + seker.Birim_Fiyati + "\türün ağırlık:" + "\t" + seker.Birim_Agirligi);
		}
		System.out.println();
		System.out.println("ÇEŞNİ LİSTESİ...");
		for (CESNİ cesni : cesni_list) {
			System.out.println("ürün adı:" + "\t" + cesni.Adi + "\türün indexi:" + "\t" + cesni.Kategori_Indexi + "\t" + "ürün stok:" + cesni.Stok_Miktari
			+ "\t" + "ürün fiyatı:" + "\t" + cesni.Birim_Fiyati + "\türün ağırlık:" + "\t" + cesni.Birim_Agirligi + "   ");
		}
	}
	
	
	public Integer Fiyata_Göre_Guncelle(int stok, int index) {
		this.Stok_Miktari = stok + index;
		return this.Stok_Miktari;
	}
	
	
	public String Urun_Isim_Degistir(int index) {
		if(index == 1) {
			this.Adi = "İÇECEK			";
		}else if(index == 2) {
			this.Adi = "TAHIL			";
		}else if(index == 3) {
			this.Adi = "SÜT			";	
		}else if(index == 4) {
			this.Adi = "ŞEKERLEME		";	
		}else {
			this.Adi = "ÇEŞNİ			";
		}
		return this.Adi;
	}

}
