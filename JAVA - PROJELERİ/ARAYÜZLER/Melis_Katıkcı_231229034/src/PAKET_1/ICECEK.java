package PAKET_1;

import java.util.ArrayList;
import java.util.Scanner;

public class ICECEK extends URUN implements IURUN{

	public ICECEK(String Adi, Integer Kategori_Indexi, String Birim_Agirligi, Double Birim_Fiyati,
			Integer Stok_Miktari) {
		super(Adi, Kategori_Indexi, Birim_Agirligi, Birim_Fiyati, Stok_Miktari);
	}
	public ICECEK() {
		super();
	}

	@Override
	public Double Stok_Miktarina_Gore_Indirim_Yap(int en_az, Double fiyat) {
		Scanner scanner = new Scanner(System.in);
		int kontrol = 0;
		System.out.println("YÜZDE KAÇ İNDİRİM YAPACAKSİNİZ");
		Integer indirim = scanner.nextInt();
		while(kontrol != 1) {
			if(indirim <= 100) {  // MAX İNDİRİM MİKTARI %100 BUNUN KONTROLÜ
				this.Birim_Fiyati -= (this.Birim_Fiyati * indirim) / 100;
				//icecek.Stok_Miktarina_Gore_Indirim_Yap(indirim);   // İNDİRİM YAPILACAK VERİYİ YOLLADIK İSMİ GÜNCELLEDİK
				kontrol = 1;
			}else {
				System.out.println("EN FAZLA %100 İNDİRİM YAPILABİLİR... İNDİRİM ORANI GİRİN...");
				indirim = scanner.nextInt();
			}
		}
		return this.Birim_Fiyati;
	}

	@Override
	public void Stok_Sifirsa_Sil(ArrayList<TAHIL> tahil_list, ArrayList<SUT> sut_list) {
	}

	@Override
	public void Yeni_Urun_Ekle(ArrayList<SEKERLEME> seker_list, ArrayList<ICECEK> ıcecek_list) {
		Scanner scanner = new Scanner(System.in);
		ICECEK yeni = new ICECEK();
		System.out.println("YENİ ÜRÜNÜN ADINI GİR:");
		String ad = scanner.nextLine();
		yeni.Adi = ad;
		yeni.Kategori_Indexi = 1;
		System.out.println("YENİ ÜRÜNÜN BİRİM AĞIRLIĞINI GİRİN:");
		String agirlik = scanner.nextLine();
		yeni.Birim_Agirligi = agirlik;
		Double ort = 0.0;
		double adet = 0.0;
		Integer min_stok = 100;
		// MİN STOK MİKTARI BULMA
		for (ICECEK ıcecek : ıcecek_list) {
			adet++;
			ort += ıcecek.Birim_Fiyati;
			if(min_stok > ıcecek.Stok_Miktari) {
				min_stok = ıcecek.Stok_Miktari;
			}
		}
		ort /= adet;
		yeni.Birim_Fiyati = ort;
		yeni.Stok_Miktari = min_stok;
		ıcecek_list.add(yeni);
	}

	@Override
	public Double Fiyat_Guncelle(ArrayList<CESNİ> cesni_list, ArrayList<SUT> sut_list) {
		return this.Birim_Fiyati;
	}
	
	public static void icecek_yaz(ArrayList<ICECEK> icecek_list) {
		for (ICECEK icecek : icecek_list) {
			System.out.println("ürün adı:" + "\t" + icecek.Adi + "\türün indexi:" + "\t" + icecek.Kategori_Indexi + "\t" + "ürün stok:" + icecek.Stok_Miktari
					+ "\t" + "ürün fiyatı:" + "\t" + icecek.Birim_Fiyati + "\türün ağırlık:" + "\t" + icecek.Birim_Agirligi);
		}
	}

}
