import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MAİN_2334 {
	
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		ArrayList<ICECEK> ıcecek_list = new ArrayList<>();
		ArrayList<CESNİ> cesni_list = new ArrayList<>();
		ArrayList<SEKERLEME> seker_list = new ArrayList<>();
		ArrayList<SUT> sut_list = new ArrayList<>();
		ArrayList<TAHIL> tahil_list = new ArrayList<>();
		List_Olustur(ıcecek_list, cesni_list, seker_list, sut_list, tahil_list);
		int menu = -1;
		while(menu != 0) {
			System.out.println("MENÜ 1 : FİYATA GÖRE STOK GÜNCELLE" + "\nMENÜ 2 : FİYATI EN YÜKSEK ÜRÜNÜN ADINI DEĞİŞTİRME" + "\nMENÜ 3 : İÇECEKİ STOĞU EN AZ OLANA İNDİRİM YAP" + "\nMENÜ 4 : ÇEŞNİ STOĞU 0 OLAN ÜRÜNLERİ SİL" + "\nMENÜ 5 : ŞEKERLEME YENİ ÜRÜN EKLE" + "\nMENÜ 6 : SÜT ÜRÜNÜ FİYAT GÜNCELLEME" + "\nMENÜ 7 : TAHIL ÜRÜNÜ DETAY BİLGİ EKLE " + "\nMENÜ 8 : ÇIKIŞ");
			menu = scanner.nextInt();
			if(menu == 1) {
				Fiyata_Gore_Stok_Guncelle(ıcecek_list, cesni_list, seker_list, sut_list, tahil_list);
			}else if(menu == 2) {
				En_Cogun_Adini_Degistir(ıcecek_list, cesni_list, seker_list, sut_list, tahil_list);
			}else if(menu == 3) {
				Icecek_Stok_Miktarina_Gore_Indirim_Yap(ıcecek_list);
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
	
	static void Fiyata_Gore_Stok_Guncelle(ArrayList<ICECEK> ıcecek_list, ArrayList<CESNİ> cesni_list, ArrayList<SEKERLEME> seker_list, ArrayList<SUT> sut_list, ArrayList<TAHIL> tahil_list) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("FİYAT HANGİ DEĞERİN ALTINDA İSE STOK GÜNCELLENSİN...");
		Double fiyat = scanner.nextDouble();
		System.out.println("YENİ STOK MİKTARI GİR...");
		Integer stok = scanner.nextInt();
		
		System.out.println("FİYATINA GÖRE STOĞU GÜNCELLENEN İÇECEKLER...");
		for (ICECEK ıcecek : ıcecek_list) {
			if(ıcecek.Birim_Fiyati < fiyat) {   // İSTENEN ŞARTA UYGUN VERİ BULMA
				ıcecek.Fiyata_Göre_Guncelle(stok);    // GÜNCELLENECEK DEĞERİ YOLLADIK
			}
			URUNLER.Tum_Liste_Yazdir(ıcecek);   // YAZDIRMA
		}
		
		System.out.println("FİYATINA GÖRE STOĞU GÜNCELLENEN ÇEŞNİLER...");
		for (CESNİ cesni : cesni_list) {
			if(cesni.Birim_Fiyati < fiyat) {	 // İSTENEN ŞARTA UYGUN VERİ BULMA
				cesni.Fiyata_Göre_Guncelle(stok);	// GÜNCELLENECEK DEĞERİ YOLLADIK
			}
			URUNLER.Tum_Liste_Yazdir(cesni);	// YAZDIRMA
		}
		
		System.out.println("FİYATINA GÖRE STOĞU GÜNCELLENEN ŞEKERLEMELER...");
		for (SEKERLEME seker : seker_list) {	 
			if(seker.Birim_Fiyati < fiyat) {	// İSTENEN ŞARTA UYGUN VERİ BULMA
				seker.Fiyata_Göre_Guncelle(stok);	// GÜNCELLENECEK DEĞERİ YOLLADIK
			}
			URUNLER.Tum_Liste_Yazdir(seker);	// YAZDIRMA
		}
		
		System.out.println("FİYATINA GÖRE STOĞU GÜNCELLENEN SÜTLER...");
		for (SUT sut : sut_list) {	 
			if(sut.Birim_Fiyati < fiyat) {	// İSTENEN ŞARTA UYGUN VERİ BULMA
				sut.Fiyata_Göre_Guncelle(stok);	// GÜNCELLENECEK DEĞERİ YOLLADIK
			}
			URUNLER.Tum_Liste_Yazdir(sut);	// YAZDIRMA
		}
		
		System.out.println("FİYATINA GÖRE STOĞU GÜNCELLENEN TAHILLAR...");
		for (TAHIL tahil : tahil_list) {	 
			if(tahil.Birim_Fiyati < fiyat) {	// İSTENEN ŞARTA UYGUN VERİ BULMA
				tahil.Fiyata_Göre_Guncelle(stok);	// GÜNCELLENECEK DEĞERİ YOLLADIK
			}
			URUNLER.Tum_Liste_Yazdir(tahil);	// YAZDIRMA
		}
	}
	
	static void En_Cogun_Adini_Degistir(ArrayList<ICECEK> ıcecek_list, ArrayList<CESNİ> cesni_list, ArrayList<SEKERLEME> seker_list, ArrayList<SUT> sut_list, ArrayList<TAHIL> tahil_list) {
		Scanner scanner = new Scanner(System.in);
		Double[] dizi = new Double[5];
		double en_cok = 0.0;
		System.out.println("FİYATI EN ÇOK OLAN ÜRÜNÜN YENİ İSMİNİ GİRİNİZ...");
		String isim = scanner.nextLine();
		int index = 0;
		// HER LİSTEDEKİ MAX DEĞERİ BULUP BİR DİZİDE TUTTUK
		for (ICECEK icecek : ıcecek_list) {
			if(en_cok < icecek.Birim_Fiyati) {
				en_cok = icecek.Birim_Fiyati;
			}
		}
		dizi[index++] = en_cok;
		en_cok = 0.0;
		for (CESNİ cesni : cesni_list) {
			if(en_cok < cesni.Birim_Fiyati) {
				en_cok = cesni.Birim_Fiyati;
			}
		}
		dizi[index++] = en_cok;
		en_cok = 0.0;
		for (SEKERLEME seker : seker_list) {
			if(en_cok < seker.Birim_Fiyati) {
				en_cok = seker.Birim_Fiyati;
			}
		}
		dizi[index++] = en_cok;
		en_cok = 0.0;
		for (SUT sut : sut_list) {
			if(en_cok < sut.Birim_Fiyati) {
				en_cok = sut.Birim_Fiyati;
			}
		}
		dizi[index++] = en_cok;
		en_cok = 0.0;
		for (TAHIL tahil : tahil_list) {
			if(en_cok < tahil.Birim_Fiyati) {
				en_cok = tahil.Birim_Fiyati;
			}
		}
		dizi[index++] = en_cok;
		// DİZİYE ATADIĞIMIZ HER LİSTEDEN MAX DEĞERLER ARASINDAN MAXI BULMA
		en_cok = 0.0;
		int sira = 0;
		for (int i = 0; i < dizi.length; i++) {
			if(en_cok < dizi[i]) {
				en_cok = dizi[i];
				sira = i;
			}
		}
		// DİZİDEN BULUNAN MAX DEĞERİN İNDEXİNE GÖRE HANGİ KATEGORİ LİSTESİNDEN İŞLEM YAPILACAĞI TESPİTİ VE İSİM GÜNCELLEMESİ 
		if(sira == 0) {
			for (ICECEK icecek : ıcecek_list) {
				if(icecek.Birim_Fiyati == en_cok) {
					icecek.Urun_Isim_Degistir(isim);
				}
			}
		}else if(sira == 1) {
			for (CESNİ cesni : cesni_list) {
				if(cesni.Birim_Fiyati == en_cok) {
					cesni.Urun_Isim_Degistir(isim);
				}
			}
		}else if(sira == 2) {
			for (SEKERLEME seker : seker_list) {
				if(seker.Birim_Fiyati == en_cok) {
					seker.Urun_Isim_Degistir(isim);
				}
			}
		}else if(sira == 3) {
			for (SUT sut : sut_list) {
				if(sut.Birim_Fiyati == en_cok) {
					sut.Urun_Isim_Degistir(isim);
				}
			}
		}else {
			for (TAHIL tahil : tahil_list) {
				if(tahil.Birim_Fiyati == en_cok) {
					tahil.Urun_Isim_Degistir(isim);
				}
			}
		}
	}
	
	static void Icecek_Stok_Miktarina_Gore_Indirim_Yap(ArrayList<ICECEK> ıcecek_list) {
		Scanner scanner = new Scanner(System.in);
		Integer en_az = 100;
		for (ICECEK icecek : ıcecek_list) { // İÇECEK LİSTESİNDEKİ EN KÜÇÜK ELEMANI BULMA
			if(icecek.Stok_Miktari < en_az && icecek.Stok_Miktari != 0) {
				en_az = icecek.Stok_Miktari;
			}
		}
		for (ICECEK icecek : ıcecek_list) {
			if(icecek.Stok_Miktari == en_az) {
				int kontrol = 0;
				System.out.println("YÜZDE KAÇ İNDİRİM YAPACAKSİNİZ");
				Integer indirim = scanner.nextInt();
				while(kontrol != 1) {
					if(indirim <= 100) {  // MAX İNDİRİM MİKTARI %100 BUNUN KONTROLÜ
						icecek.Stoka_Gore_İndirim_Yap(indirim);   // İNDİRİM YAPILACAK VERİYİ YOLLADIK İSMİ GÜNCELLEDİK
						kontrol = 1;
					}else {
						System.out.println("EN FAZLA %100 İNDİRİM YAPILABİLİR... İNDİRİM ORANI GİRİN...");
						indirim = scanner.nextInt();
					}
				}
			}
		}
		ICECEK.Icecek_Yazdir(ıcecek_list);
	}
	
	static void Cesni_Stok_Sifirsa_Sil(ArrayList<CESNİ> cesni_list) {
		CESNİ.Sifirsa_Sil_Cesni(cesni_list);
		CESNİ.Cesni_Yazdir(cesni_list);
	}
	
	static void Sekerleme_Yeni_Urun_Ekle(ArrayList<SEKERLEME> seker_list){
		SEKERLEME.Yeni_Urun_Ekle_Sekerleme(seker_list);
	}
	
	static void Sut_Fiyat_Guncelle(ArrayList<SUT> sut_list){
		Scanner scanner = new Scanner(System.in);
		double adet = 0.0;
		double ort = 0.0;
		// FİYATLARIN ORTALAMASINI BULMA
		for (SUT sut : sut_list) {
			adet++;
			ort += sut.Birim_Fiyati;
		}
		ort /=adet;
		double temp = 100;
		double tut = 0;
		// ORTALAMANIN 1 ALTINDEKİ VERİ TESPİTİ
		for (SUT sut : sut_list) {
			double temp2 = ort - sut.Birim_Fiyati;
			if(temp2 > 0 && temp2 < temp) {  // FARK POZİTİF İSE ALTINDADIR 
				temp = temp2;
				tut = sut.Birim_Fiyati;
			}
		}
		// BULUNAN VERİ ÜZERİNDE İŞLEMLER
		for (int i = 0; i < sut_list.size(); i++) {
			if(sut_list.get(i).Birim_Fiyati == tut) {
				sut_list.get(i).Fiyat_Guncelle_Sut();
			}
		}
		SUT.sut_yazdir(sut_list);
	}
	
	static void Tahil_Detay_Bilgi_Ekle(ArrayList<TAHIL> tahil_list){
		Scanner scanner = new Scanner(System.in);
		System.out.println("BİRİM FİYATI HANGİ DEĞERİN ÜSTÜNDE OLAN ÜRÜNLERE AYLIK SATIŞ MİKTARI EKLEMEK İSTİYORSUNUZ:");
		int deger = scanner.nextInt();
		for (TAHIL tahil : tahil_list) {
			if(tahil.Stok_Miktari > deger) {
				System.out.println(tahil.Adi + " ÜRÜNÜNE EKLENECEK YENİ AYLIK SATIŞ MİKTARINI GİRİNİZ:");
				Integer satis = scanner.nextInt();
				tahil.Detay_Ekle_Tahil(satis);
			}
			
		}
		TAHIL.Tahil_yazdir(tahil_list);
	}
	
	static void List_Olustur(ArrayList<ICECEK> ıcecek_list, ArrayList<CESNİ> cesni_list, ArrayList<SEKERLEME> seker_list, ArrayList<SUT> sut_list, ArrayList<TAHIL> tahil_list) throws IOException{
		FileReader fr = new FileReader("UrunListesi.txt");
		BufferedReader br = new BufferedReader(fr);
		while(true) {
			String str = br.readLine();
			if(str == null) {
				break;
			}
			String[] dizi = str.split("/");
			URUNLER urun = new URUNLER();
			ICECEK ıcecek = new ICECEK();
			CESNİ cesni = new CESNİ();
			SEKERLEME sekerleme = new SEKERLEME();
			SUT sut = new SUT();
			TAHIL tahil = new TAHIL();
			urun.Kategori_Indexi = Integer.valueOf(dizi[1]);
			// LİSTEDEN OKUDUĞUMUZ VERİNİN İNDEX DEĞERİNE GÖRE KATEGORİLERE AYIRMA VE O KATEGORİNİN LİSTESİNE ATAMA
			if(urun.Kategori_Indexi == 1) {  
				ıcecek.Adi = dizi[0];
				ıcecek.Kategori_Indexi = Integer.valueOf(dizi[1]);
				ıcecek.Birim_Agirligi = dizi[2];
				ıcecek.Birim_Fiyati = Double.valueOf(dizi[3]);
				ıcecek.Stok_Miktari = Integer.valueOf(dizi[4]);
				ıcecek_list.add(ıcecek);
			}else if(urun.Kategori_Indexi == 2) {
				cesni.Adi = dizi[0];
				cesni.Kategori_Indexi = Integer.valueOf(dizi[1]);
				cesni.Birim_Agirligi = dizi[2];
				cesni.Birim_Fiyati = Double.valueOf(dizi[3]);
				cesni.Stok_Miktari = Integer.valueOf(dizi[4]);
				cesni_list.add(cesni);
			}else if(urun.Kategori_Indexi == 3) {
				sekerleme.Adi = dizi[0];
				sekerleme.Kategori_Indexi = Integer.valueOf(dizi[1]);
				sekerleme.Birim_Agirligi = dizi[2];
				sekerleme.Birim_Fiyati = Double.valueOf(dizi[3]);
				sekerleme.Stok_Miktari = Integer.valueOf(dizi[4]);
				seker_list.add(sekerleme);
			}else if(urun.Kategori_Indexi == 4) {
				sut.Adi = dizi[0];
				sut.Kategori_Indexi = Integer.valueOf(dizi[1]);
				sut.Birim_Agirligi = dizi[2];
				sut.Birim_Fiyati = Double.valueOf(dizi[3]);
				sut.Stok_Miktari = Integer.valueOf(dizi[4]);
				sut_list.add(sut);
			}else {
				tahil.Adi = dizi[0];
				tahil.Kategori_Indexi = Integer.valueOf(dizi[1]);
				tahil.Birim_Agirligi = dizi[2];
				tahil.Birim_Fiyati = Double.valueOf(dizi[3]);
				tahil.Stok_Miktari = Integer.valueOf(dizi[4]);
				tahil_list.add(tahil);
			}
		}
		
	}

}
