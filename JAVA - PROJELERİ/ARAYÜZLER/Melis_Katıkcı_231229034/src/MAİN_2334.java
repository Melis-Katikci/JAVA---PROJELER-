import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import PAKET_1.*;

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
		System.out.println();
		while(menu != 7) {
			System.out.println("MENÜ 1 : IURUN CLASSINA BAĞLI STOK MİKTARINA GÖRE FİYAT İNDİRİMİ YAPMAK İÇİN" + "\nMENÜ 2 : IURUN CLASSINA BAĞLI STOK SIFIRSA SİLMEK İÇİN" + "\nMENÜ 3 : IURUN CLASSINA BAĞLI YENİ ÜRÜN EKLEMEK İÇİN" + "\nMENÜ 4 : IURUN CLASSINA BAĞLI ORTALAMANIN 1 ALTINDAKİ ÜRÜNÜN FİYATINI GÜNCELLEMEK İÇİN" + "\nMENÜ 5 : URUN CLASSINA BAĞLI HER KATEGORİDE GİRİLECEK DEĞERİN ALTINDA KALAN FİYATLI ÜRÜNDERİN STOĞUNU İNDEXE BAĞLI GÜNCELLEMEK İÇİN" + "\nMENÜ 6 : URUN CLASSINA BAĞLI HER KATEGORİDE FİYATI EN ÇOK OLAN ÜRÜNÜN ADINI OTOMATİK DEĞİŞTİRME" + "\nMENÜ 7 : ÇIKIŞ ");
			menu = scanner.nextInt();
			if(menu == 1) {
				Iurun_Stok_Miktarina_Gore_Indirim_Yap(ıcecek_list, cesni_list);
				System.out.println();
			} else if(menu == 2) {
				Iurun_Stok_Sifirsa_Sil(tahil_list, sut_list);
				System.out.println();
			} else if(menu == 3) {
				Iurun_Yeni_Urun_Ekle(seker_list, ıcecek_list);
				System.out.println();
			} else if(menu == 4) {
				Iurun_Fiyat_Guncelle(cesni_list, sut_list);
				System.out.println();
			} else if(menu == 5) {
				Urun_Fiyata_Gore_Stok_Guncelle(ıcecek_list, cesni_list, seker_list, sut_list, tahil_list);
			} else if(menu == 6) {
				En_Cogun_Adini_Degistir(ıcecek_list, cesni_list, seker_list, sut_list, tahil_list);
			} else if(menu == 7) {
				System.out.println("ÇIKIŞ YAPILDI...");
				break;
			} else {
				System.out.println("GEÇERSİZ MENÜ TUŞLANDI 1-7 ARASINDA MENÜ TUŞLAYIN !\n");
				menu = 0;
			}
		}
	}
	
	static void Iurun_Stok_Miktarina_Gore_Indirim_Yap(ArrayList<ICECEK> ıcecek_list, ArrayList<CESNİ> cesni_list) {
		System.out.println("İÇECEK KATEGORİSİNDE İNDİRİM YAPILIYOR...");
		Integer en_az = 100;
		Double fiyat = 0.0;
		for (ICECEK icecek : ıcecek_list) { // İÇECEK LİSTESİNDEKİ EN KÜÇÜK ELEMANI BULMA
			if(icecek.Stok_Miktari < en_az && icecek.Stok_Miktari != 0) {
				en_az = icecek.Stok_Miktari;
				fiyat = icecek.Birim_Fiyati;
			}
		}
		for (ICECEK icecek : ıcecek_list) {
			if(icecek.Stok_Miktari == en_az) {
				icecek.Stok_Miktarina_Gore_Indirim_Yap(en_az, fiyat);
			}
		}
		ICECEK.icecek_yaz(ıcecek_list);
		System.out.println("ÇEŞNİ KATEGORİSİNDE İNDİRİM YAPILIYOR...");
		en_az = 100;
		for (CESNİ cesni : cesni_list) { // İÇECEK LİSTESİNDEKİ EN KÜÇÜK ELEMANI BULMA
			if(cesni.Stok_Miktari < en_az && cesni.Stok_Miktari != 0) {
				en_az = cesni.Stok_Miktari;
			}
		}
		for (CESNİ cesni : cesni_list) {
			if(cesni.Stok_Miktari == en_az) {
				cesni.Stok_Miktarina_Gore_Indirim_Yap(en_az, fiyat);
			}
		}
		CESNİ.cesni_yaz(cesni_list);
	}
	
	static void Iurun_Stok_Sifirsa_Sil(ArrayList<TAHIL> tahil_list, ArrayList<SUT> sut_list) {
		IURUN urun = new TAHIL();
		IURUN urun2 = new SUT();
		System.out.println("TAHIL KATEGORİSİNDE STOK SIFIR OLANLAR SİLİNİYOR...");
		urun.Stok_Sifirsa_Sil(tahil_list, sut_list);
		TAHIL.tahil_yaz(tahil_list);
		System.out.println("\nSÜT KATEGORİSİNDE STOK SIFIR OLAN ÜRÜNLER SİLİNİYOR...");
		urun2.Stok_Sifirsa_Sil(tahil_list, sut_list);
		SUT.sut_yaz(sut_list);
	}
	
	static void Iurun_Yeni_Urun_Ekle(ArrayList<SEKERLEME> seker_list, ArrayList<ICECEK> ıcecek_list) {
		IURUN urun1 = new SEKERLEME();
		IURUN urun2 = new ICECEK();
		System.out.println("İÇECEK KATEGORİSİNE YENİ ÜRÜN EKLEME...");
		urun2.Yeni_Urun_Ekle(seker_list, ıcecek_list);
		ICECEK.icecek_yaz(ıcecek_list);
		System.out.println("\nŞEKERLEME KATEGORİSİNE YENİ ÜRÜN EKLEME...");
		urun1.Yeni_Urun_Ekle(seker_list, ıcecek_list);
		SEKERLEME.sekerleme_yaz(seker_list);
	}
	
	static void Iurun_Fiyat_Guncelle(ArrayList<CESNİ> cesni_list, ArrayList<SUT> sut_list) {
		IURUN urun1 = new CESNİ();
		IURUN urun2 = new SUT();
		System.out.println("ÇEŞNİ KATEGORİSİNDE ORTALAMANIN 1 ALTINDAKİ ÜRÜNÜN FİYATINI %50 ZAMLI HALİ...");
		urun1.Fiyat_Guncelle(cesni_list, sut_list);
		System.out.println("\nSÜT KATEGORİSİNDE ORTALAMANIN 1 ALTINDAKİ ÜRÜNÜN FİYATINI %50 ZAMLI HALİ...");
		urun2.Fiyat_Guncelle(cesni_list, sut_list);
	}
	
	static void Urun_Fiyata_Gore_Stok_Guncelle(ArrayList<ICECEK> ıcecek_list, ArrayList<CESNİ> cesni_list, ArrayList<SEKERLEME> seker_list, ArrayList<SUT> sut_list, ArrayList<TAHIL> tahil_list) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("İÇECEK KATEGORİSİNDE FİYAT HANGİ DEĞERİN ALTINDA İSE STOK GÜNCELLENSİN...");
		Double fiyat = scanner.nextDouble();
		for (ICECEK ıcecek : ıcecek_list) {
			if(fiyat > ıcecek.Birim_Fiyati) {
				ıcecek.Fiyata_Göre_Guncelle(ıcecek.Stok_Miktari, ıcecek.Kategori_Indexi);
			}
		}
		System.out.println("ÇEŞNİ KATEGORİSİNDE FİYAT HANGİ DEĞERİN ALTINDA İSE STOK GÜNCELLENSİN...");
		fiyat = scanner.nextDouble();
		for (CESNİ cesni : cesni_list) {
			if(fiyat > cesni.Birim_Fiyati) {
				cesni.Fiyata_Göre_Guncelle(cesni.Stok_Miktari, cesni.Kategori_Indexi);
			}
		}
		System.out.println("ŞEKERLEME KATEGORİSİNDE FİYAT HANGİ DEĞERİN ALTINDA İSE STOK GÜNCELLENSİN...");
		fiyat = scanner.nextDouble();
		for (SEKERLEME seker : seker_list) {
			if(fiyat > seker.Birim_Fiyati) {
				seker.Fiyata_Göre_Guncelle(seker.Stok_Miktari, seker.Kategori_Indexi);
			}
		}
		System.out.println("SÜT KATEGORİSİNDE FİYAT HANGİ DEĞERİN ALTINDA İSE STOK GÜNCELLENSİN...");
		fiyat = scanner.nextDouble();
		for (SUT sut : sut_list) {
			if(fiyat > sut.Birim_Fiyati) {
				sut.Fiyata_Göre_Guncelle(sut.Stok_Miktari, sut.Kategori_Indexi);
			}
		}
		System.out.println("TAHIL KATEGORİSİNDE FİYAT HANGİ DEĞERİN ALTINDA İSE STOK GÜNCELLENSİN...");
		fiyat = scanner.nextDouble();
		for (TAHIL tahil : tahil_list) {
			if(fiyat > tahil.Birim_Fiyati) {
				tahil.Fiyata_Göre_Guncelle(tahil.Stok_Miktari, tahil.Kategori_Indexi);
			}
		}
		URUN.Hepsi_Yaz(ıcecek_list, tahil_list, sut_list, seker_list, cesni_list);
	}
	
	static void En_Cogun_Adini_Degistir(ArrayList<ICECEK> ıcecek_list, ArrayList<CESNİ> cesni_list, ArrayList<SEKERLEME> seker_list, ArrayList<SUT> sut_list, ArrayList<TAHIL> tahil_list) {
		Double en_cok = 0.0;
		for (ICECEK İ : ıcecek_list) {
			if(İ.Birim_Fiyati > en_cok) {
				en_cok = İ.Birim_Fiyati;
			}
		}
		for (ICECEK İ : ıcecek_list) {
			if(İ.Birim_Fiyati == en_cok) {
				İ.Urun_Isim_Degistir(İ.Kategori_Indexi);
			}
		}
		en_cok = 0.0;
		for (CESNİ Ç : cesni_list) {
			if(Ç.Birim_Fiyati > en_cok) {
				en_cok = Ç.Birim_Fiyati;
			}
		}
		for (CESNİ Ç : cesni_list) {
			if(Ç.Birim_Fiyati == en_cok) {
				Ç.Urun_Isim_Degistir(Ç.Kategori_Indexi);
			}
		}
		en_cok = 0.0;
		for (SEKERLEME Ş : seker_list) {
			if(Ş.Birim_Fiyati > en_cok) {
				en_cok = Ş.Birim_Fiyati;
			}
		}
		for (SEKERLEME Ş : seker_list) {
			if(Ş.Birim_Fiyati == en_cok) {
				Ş.Urun_Isim_Degistir(Ş.Kategori_Indexi);
			}
		}
		en_cok = 0.0;
		for (SUT S : sut_list) {
			if(S.Birim_Fiyati > en_cok) {
				en_cok = S.Birim_Fiyati;
			}
		}
		for (SUT S : sut_list) {
			if(S.Birim_Fiyati == en_cok) {
				S.Urun_Isim_Degistir(S.Kategori_Indexi);
			}
		}
		en_cok = 0.0;
		for (TAHIL T : tahil_list) {
			if(T.Birim_Fiyati > en_cok) {
				en_cok = T.Birim_Fiyati;
			}
		}
		System.out.println("tahıl en cok: " + en_cok);
		for (TAHIL T : tahil_list) {
			if(T.Birim_Fiyati == en_cok) {
				T.Urun_Isim_Degistir(T.Kategori_Indexi);
			}
		}
		URUN.Hepsi_Yaz(ıcecek_list, tahil_list, sut_list, seker_list, cesni_list);
	}
	
	static void List_Olustur(ArrayList<ICECEK> icecek_list, ArrayList<CESNİ> cesni_list, ArrayList<SEKERLEME> seker_list, ArrayList<SUT> sut_list, ArrayList<TAHIL> tahil_list) throws IOException{
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
				icecek_list.add(new ICECEK(adi, index, agirlik, fiyat, stok));
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
				sut_list.add(new SUT(adi, index, agirlik, fiyat, stok));
			} else if (ürün_index == 4) {
				String adi = dizi[0];
				Integer index = Integer.valueOf(dizi[1]);
				String agirlik = dizi[2];
				Double fiyat = Double.valueOf(dizi[3]);
				Integer stok = Integer.valueOf(dizi[4]);
				seker_list.add(new SEKERLEME(adi, index, agirlik, fiyat, stok));
			} else if (ürün_index == 5) {
				String adi = dizi[0];
				Integer index = Integer.valueOf(dizi[1]);
				String agirlik = dizi[2];
				Double fiyat = Double.valueOf(dizi[3]);
				Integer stok = Integer.valueOf(dizi[4]);
				cesni_list.add(new CESNİ(adi, index, agirlik, fiyat, stok));
			}
		}
		URUN.Hepsi_Yaz(icecek_list, tahil_list, sut_list, seker_list, cesni_list);
	}

}
