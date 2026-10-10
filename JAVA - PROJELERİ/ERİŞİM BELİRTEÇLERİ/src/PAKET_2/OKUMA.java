package PAKET_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import PAKET_1.*;

public class OKUMA {
	
	public static void oku_ve_yaz(ArrayList<İÇECEK> icecek_list, ArrayList<TAHIL> tahil_list, ArrayList<SÜT> sut_list,
			ArrayList<ŞEKERLEME> seker_list, ArrayList<ÇEŞNİ> cesni_list) throws IOException {
		List_Olustur(icecek_list, tahil_list, sut_list, seker_list, cesni_list);
		Hepsi_Yaz(icecek_list, tahil_list, sut_list, seker_list, cesni_list);
	}

	private static void List_Olustur(ArrayList<İÇECEK> icecek_list, ArrayList<TAHIL> tahil_list, ArrayList<SÜT> sut_list,
			ArrayList<ŞEKERLEME> seker_list, ArrayList<ÇEŞNİ> cesni_list) throws IOException {
		FileReader fr = new FileReader("UrunListesi.txt");
		BufferedReader br = new BufferedReader(fr);
		while (true) {
			String str = br.readLine();
			if (str == null) {
				break;
			}
			String[] dizi = str.split("/");
			Integer ürün_index = Integer.valueOf(dizi[1]);
			if (ürün_index == 1) {
				String adi = dizi[0];
				Integer index = Integer.valueOf(dizi[1]);
				String agirlik = dizi[2];
				Double fiyat = Double.valueOf(dizi[3]);
				Integer stok = Integer.valueOf(dizi[4]);
				icecek_list.add(new İÇECEK(adi, index, agirlik, fiyat, stok));
			} else if (ürün_index == 2) {
				String adi = dizi[0];
				Integer index = Integer.valueOf(dizi[1]);
				String agirlik = dizi[2];
				Double fiyat = Double.valueOf(dizi[3]);
				Integer stok = Integer.valueOf(dizi[4]);
				tahil_list.add(new TAHIL(adi, index, agirlik, fiyat, stok));
			} else if (ürün_index == 3) {
				String adi = dizi[0];
				Integer index = Integer.valueOf(dizi[1]);
				String agirlik = dizi[2];
				Double fiyat = Double.valueOf(dizi[3]);
				Integer stok = Integer.valueOf(dizi[4]);
				sut_list.add(new SÜT(adi, index, agirlik, fiyat, stok));
			} else if (ürün_index == 4) {
				String adi = dizi[0];
				Integer index = Integer.valueOf(dizi[1]);
				String agirlik = dizi[2];
				Double fiyat = Double.valueOf(dizi[3]);
				Integer stok = Integer.valueOf(dizi[4]);
				seker_list.add(new ŞEKERLEME(adi, index, agirlik, fiyat, stok));
			} else if (ürün_index == 5) {
				String adi = dizi[0];
				Integer index = Integer.valueOf(dizi[1]);
				String agirlik = dizi[2];
				Double fiyat = Double.valueOf(dizi[3]);
				Integer stok = Integer.valueOf(dizi[4]);
				cesni_list.add(new ÇEŞNİ(adi, index, agirlik, fiyat, stok));
			}
		}
		
	}
	
	private static void Hepsi_Yaz(ArrayList<İÇECEK> icecek_list, ArrayList<TAHIL> tahil_list, ArrayList<SÜT> sut_list,
			ArrayList<ŞEKERLEME> seker_list, ArrayList<ÇEŞNİ> cesni_list) {
		System.out.println("İÇECEK LİSTESİ...");
		for (İÇECEK icecek : icecek_list) {
			System.out.println("ürün adı:" + "\t" + icecek.getAdi() + "\türün indexi:" + "\t" + icecek.getKategori_Indexi() + "\t" + "ürün stok:" + icecek.getStok_Miktari()
					+ "\t" + "ürün fiyatı:" + "\t" + icecek.getBirim_Fiyati() + "\türün ağırlık:" + "\t" + icecek.getBirim_Agirligi());
		}
		System.out.println();
		System.out.println("TAHIL LİSTESİ...");
		for (TAHIL tahıl : tahil_list) {
			System.out.println("ürün adı:" + "\t" + tahıl.getAdi() + "\türün indexi:" + "\t" + tahıl.getKategori_Indexi() + "\t" + "ürün stok:" + tahıl.getStok_Miktari()
			+ "\t" + "ürün fiyatı:" + "\t" + tahıl.getBirim_Fiyati() + "\türün ağırlık:" + "\t" + tahıl.getBirim_Agirligi());
		}
		System.out.println();
		System.out.println("SÜT LİSTESİ...");
		for (SÜT sut : sut_list) {
			System.out.println("ürün adı:" + "\t" + sut.getAdi() + "\türün indexi:" + "\t" + sut.getKategori_Indexi() + "\t" + "ürün stok:" + sut.getStok_Miktari()
			+ "\t" + "ürün fiyatı:" + "\t" + sut.getBirim_Fiyati() + "\türün ağırlık:" + "\t" + sut.getBirim_Agirligi());
		}
		System.out.println();
		System.out.println("ŞEKERLEME LİSTESİ...");
		for (ŞEKERLEME seker : seker_list) {
			System.out.println("ürün adı:" + "\t" + seker.getAdi() + "\türün indexi:" + "\t" + seker.getKategori_Indexi() + "\t" + "ürün stok:" + seker.getStok_Miktari()
			+ "\t" + "ürün fiyatı:" + "\t" + seker.getBirim_Fiyati() + "\türün ağırlık:" + "\t" + seker.getBirim_Agirligi());
		}
		System.out.println();
		System.out.println("ÇEŞNİ LİSTESİ...");
		for (ÇEŞNİ cesni : cesni_list) {
			System.out.println("ürün adı:" + "\t" + cesni.getAdi() + "\türün indexi:" + "\t" + cesni.getKategori_Indexi() + "\t" + "ürün stok:" + cesni.getStok_Miktari()
			+ "\t" + "ürün fiyatı:" + "\t" + cesni.getBirim_Fiyati() + "\türün ağırlık:" + "\t" + cesni.getBirim_Agirligi() + "   ");
		}
	}
}