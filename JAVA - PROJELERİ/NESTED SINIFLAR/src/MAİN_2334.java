import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MAİN_2334 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		Scanner scanner = new Scanner(System.in);
		ArrayList<Dosyaİşlemleri> eklenecek_urun_list = new ArrayList<>();
		ArrayList<URUNLER.ICECEK> ıcecek_list = new ArrayList<>();
		ArrayList<URUNLER.CESNİ> cesni_list = new ArrayList<>();
		ArrayList<URUNLER.SEKERLEME> seker_list = new ArrayList<>();
		ArrayList<URUNLER.SUT> sut_list = new ArrayList<>();
		ArrayList<URUNLER.TAHIL> tahil_list = new ArrayList<>();
		List_Olustur(eklenecek_urun_list, ıcecek_list, cesni_list, seker_list, sut_list, tahil_list);
		int menu = -1;
		while (menu != 0) {
			System.out.println("MENÜ 1 : FİYATA GÖRE STOK GÜNCELLE"
					+ "\nMENÜ 2 : FİYATI EN YÜKSEK ÜRÜNÜN ADINI DEĞİŞTİRME"
					+ "\nMENÜ 3 : İÇECEKİ STOĞU EN AZ OLANA İNDİRİM YAP" 
					+ "\nMENÜ 4 : ÇEŞNİ STOĞU 0 OLAN ÜRÜNLERİ SİL"
					+ "\nMENÜ 5 : ŞEKERLEME YENİ ÜRÜN EKLE" 
					+ "\nMENÜ 6 : SÜT ÜRÜNÜ FİYAT GÜNCELLEME"
					+ "\nMENÜ 7 : TAHIL ÜRÜNÜ DETAY BİLGİ EKLE " 
					+ "\nMENÜ 8 : BİLGİLERİ GÜNCELLENMİŞ TÜM VERİLERİ DOSYAYA EKLEME"
					+ "\nMENÜ 9 : ÇIKIŞ");
			menu = scanner.nextInt();
			if (menu == 1) {
				Fiyata_Gore_Stok_Guncelle(ıcecek_list, cesni_list, seker_list, sut_list, tahil_list, eklenecek_urun_list);
			} else if (menu == 2) {
				En_Cogun_Adini_Degistir(ıcecek_list, cesni_list, seker_list, sut_list, tahil_list, eklenecek_urun_list);
			} else if (menu == 3) {
				Icecek_Stok_Miktarina_Gore_Indirim_Yap(ıcecek_list, eklenecek_urun_list);
			} else if (menu == 4) {
				Cesni_Stok_Sifirsa_Sil(cesni_list);
			} else if (menu == 5) {
				Sekerleme_Yeni_Urun_Ekle(seker_list, eklenecek_urun_list);
			} else if (menu == 6) {
				Sut_Fiyat_Guncelle(sut_list, eklenecek_urun_list);
			} else if (menu == 7) {
				Tahil_Detay_Bilgi_Ekle(tahil_list);
			} else if(menu == 8){
				Yaz_Oku(eklenecek_urun_list);
			} else {
				System.out.println("ÇIKIŞ YAPILDI...");
				break;
			}
		}
	}

	static void Fiyata_Gore_Stok_Guncelle(ArrayList<URUNLER.ICECEK> ıcecek_list, ArrayList<URUNLER.CESNİ> cesni_list,
			ArrayList<URUNLER.SEKERLEME> seker_list, ArrayList<URUNLER.SUT> sut_list, ArrayList<URUNLER.TAHIL> tahil_list, ArrayList<Dosyaİşlemleri> eklenecek_urun_list) {
		Scanner scanner = new Scanner(System.in);
		Dosyaİşlemleri ekle = new Dosyaİşlemleri();
		Dosyaİşlemleri ekle2 = new Dosyaİşlemleri();
		Dosyaİşlemleri ekle3 = new Dosyaİşlemleri();
		Dosyaİşlemleri ekle4 = new Dosyaİşlemleri();
		Dosyaİşlemleri ekle5 = new Dosyaİşlemleri();
		System.out.println("FİYAT HANGİ DEĞERİN ALTINDA İSE STOK GÜNCELLENSİN...");
		Double fiyat = scanner.nextDouble();
		System.out.println("YENİ STOK MİKTARI GİR...");
		Integer stok = scanner.nextInt();

		System.out.println("FİYATINA GÖRE STOĞU GÜNCELLENEN İÇECEKLER...");
		for (URUNLER.ICECEK ıcecek : ıcecek_list) {
			if (ıcecek.urun.Birim_Fiyati < fiyat) { // İSTENEN ŞARTA UYGUN VERİ BULMA
				ıcecek.urun.Fiyata_Göre_Guncelle(stok); // GÜNCELLENECEK DEĞERİ YOLLADIK
				ekle.Adi = ıcecek.urun.Adi;
				ekle.Kategori_Indexi = ıcecek.urun.Kategori_Indexi;
				ekle.Birim_Agirligi = ıcecek.urun.Birim_Agirligi;
				ekle.Birim_Fiyati =ıcecek.urun.Birim_Fiyati;
				ekle.Stok_Miktari = ıcecek.urun.Stok_Miktari;
				eklenecek_urun_list.add(ekle);
			}
			URUNLER.Tum_Liste_Yazdir(ıcecek.urun); // YAZDIRMA
		}

		System.out.println("FİYATINA GÖRE STOĞU GÜNCELLENEN ÇEŞNİLER...");
		for (URUNLER.CESNİ cesni : cesni_list) {
			if (cesni.urun.Birim_Fiyati < fiyat) { // İSTENEN ŞARTA UYGUN VERİ BULMA
				cesni.urun.Fiyata_Göre_Guncelle(stok); // GÜNCELLENECEK DEĞERİ YOLLADIK
				ekle2.Adi = cesni.urun.Adi;
				ekle2.Kategori_Indexi = cesni.urun.Kategori_Indexi;
				ekle2.Birim_Agirligi = cesni.urun.Birim_Agirligi;
				ekle2.Birim_Fiyati =cesni.urun.Birim_Fiyati;
				ekle2.Stok_Miktari = cesni.urun.Stok_Miktari;
				eklenecek_urun_list.add(ekle2);
			}
			URUNLER.Tum_Liste_Yazdir(cesni.urun); // YAZDIRMA
		}

		System.out.println("FİYATINA GÖRE STOĞU GÜNCELLENEN ŞEKERLEMELER...");
		for (URUNLER.SEKERLEME seker : seker_list) {
			if (seker.urun.Birim_Fiyati < fiyat) { // İSTENEN ŞARTA UYGUN VERİ BULMA
				seker.urun.Fiyata_Göre_Guncelle(stok); // GÜNCELLENECEK DEĞERİ YOLLADIK
				ekle3.Adi = seker.urun.Adi;
				ekle3.Kategori_Indexi = seker.urun.Kategori_Indexi;
				ekle3.Birim_Agirligi = seker.urun.Birim_Agirligi;
				ekle3.Birim_Fiyati =seker.urun.Birim_Fiyati;
				ekle3.Stok_Miktari = seker.urun.Stok_Miktari;
				eklenecek_urun_list.add(ekle3);
			}
			URUNLER.Tum_Liste_Yazdir(seker.urun); // YAZDIRMA
		}

		System.out.println("FİYATINA GÖRE STOĞU GÜNCELLENEN SÜTLER...");
		for (URUNLER.SUT sut : sut_list) {
			if (sut.urun.Birim_Fiyati < fiyat) { // İSTENEN ŞARTA UYGUN VERİ BULMA
				sut.urun.Fiyata_Göre_Guncelle(stok); // GÜNCELLENECEK DEĞERİ YOLLADIK
				ekle4.Adi = sut.urun.Adi;
				ekle4.Kategori_Indexi = sut.urun.Kategori_Indexi;
				ekle4.Birim_Agirligi = sut.urun.Birim_Agirligi;
				ekle4.Birim_Fiyati =sut.urun.Birim_Fiyati;
				ekle4.Stok_Miktari = sut.urun.Stok_Miktari;
				eklenecek_urun_list.add(ekle4);
			}
			URUNLER.Tum_Liste_Yazdir(sut.urun); // YAZDIRMA
		}

		System.out.println("FİYATINA GÖRE STOĞU GÜNCELLENEN TAHILLAR...");
		for (URUNLER.TAHIL tahil : tahil_list) {
			if (tahil.urun.Birim_Fiyati < fiyat) { // İSTENEN ŞARTA UYGUN VERİ BULMA
				tahil.urun.Fiyata_Göre_Guncelle(stok); // GÜNCELLENECEK DEĞERİ YOLLADIK
				ekle5.Adi = tahil.urun.Adi;
				ekle5.Kategori_Indexi = tahil.urun.Kategori_Indexi;
				ekle5.Birim_Agirligi = tahil.urun.Birim_Agirligi;
				ekle5.Birim_Fiyati =tahil.urun.Birim_Fiyati;
				ekle5.Stok_Miktari = tahil.urun.Stok_Miktari;
				eklenecek_urun_list.add(ekle5);
			}
			URUNLER.Tum_Liste_Yazdir(tahil.urun); // YAZDIRMA
		}
	}

	static void En_Cogun_Adini_Degistir(ArrayList<URUNLER.ICECEK> ıcecek_list, ArrayList<URUNLER.CESNİ> cesni_list,
			ArrayList<URUNLER.SEKERLEME> seker_list, ArrayList<URUNLER.SUT> sut_list, ArrayList<URUNLER.TAHIL> tahil_list, ArrayList<Dosyaİşlemleri> eklenecek_urun_list) {
		Scanner scanner = new Scanner(System.in);
		Dosyaİşlemleri ekle = new Dosyaİşlemleri();
		Double[] dizi = new Double[5];
		double en_cok = 0.0;
		System.out.println("FİYATI EN ÇOK OLAN ÜRÜNÜN YENİ İSMİNİ GİRİNİZ...");
		String isim = scanner.nextLine();
		int index = 0;
		// HER LİSTEDEKİ MAX DEĞERİ BULUP BİR DİZİDE TUTTUK
		for (URUNLER.ICECEK icecek : ıcecek_list) {
			if (en_cok < icecek.urun.Birim_Fiyati) {
				en_cok = icecek.urun.Birim_Fiyati;
			}
		}
		dizi[index++] = en_cok;
		en_cok = 0.0;
		for (URUNLER.CESNİ cesni : cesni_list) {
			if (en_cok < cesni.urun.Birim_Fiyati) {
				en_cok = cesni.urun.Birim_Fiyati;
			}
		}
		dizi[index++] = en_cok;
		en_cok = 0.0;
		for (URUNLER.SEKERLEME seker : seker_list) {
			if (en_cok < seker.urun.Birim_Fiyati) {
				en_cok = seker.urun.Birim_Fiyati;
			}
		}
		dizi[index++] = en_cok;
		en_cok = 0.0;
		for (URUNLER.SUT sut : sut_list) {
			if (en_cok < sut.urun.Birim_Fiyati) {
				en_cok = sut.urun.Birim_Fiyati;
			}
		}
		dizi[index++] = en_cok;
		en_cok = 0.0;
		for (URUNLER.TAHIL tahil : tahil_list) {
			if (en_cok < tahil.urun.Birim_Fiyati) {
				en_cok = tahil.urun.Birim_Fiyati;
			}
		}
		dizi[index++] = en_cok;
		// DİZİYE ATADIĞIMIZ HER LİSTEDEN MAX DEĞERLER ARASINDAN MAXI BULMA
		en_cok = 0.0;
		int sira = 0;
		for (int i = 0; i < dizi.length; i++) {
			if (en_cok < dizi[i]) {
				en_cok = dizi[i];
				sira = i;
			}
		}
		// DİZİDEN BULUNAN MAX DEĞERİN İNDEXİNE GÖRE HANGİ KATEGORİ LİSTESİNDEN İŞLEM
		// YAPILACAĞI TESPİTİ VE İSİM GÜNCELLEMESİ
		if (sira == 0) {
			for (URUNLER.ICECEK ıcecek : ıcecek_list) {
				if (ıcecek.urun.Birim_Fiyati == en_cok) {
					ıcecek.urun.Urun_Isim_Degistir(isim);
					ekle.Adi = ıcecek.urun.Adi;
					ekle.Kategori_Indexi = ıcecek.urun.Kategori_Indexi;
					ekle.Birim_Agirligi = ıcecek.urun.Birim_Agirligi;
					ekle.Birim_Fiyati =ıcecek.urun.Birim_Fiyati;
					ekle.Stok_Miktari = ıcecek.urun.Stok_Miktari;
					eklenecek_urun_list.add(ekle);
				}
			}
		} else if (sira == 1) {
			for (URUNLER.CESNİ cesni : cesni_list) {
				if (cesni.urun.Birim_Fiyati == en_cok) {
					cesni.urun.Urun_Isim_Degistir(isim);
					ekle.Adi = cesni.urun.Adi;
					ekle.Kategori_Indexi = cesni.urun.Kategori_Indexi;
					ekle.Birim_Agirligi = cesni.urun.Birim_Agirligi;
					ekle.Birim_Fiyati =cesni.urun.Birim_Fiyati;
					ekle.Stok_Miktari = cesni.urun.Stok_Miktari;
					eklenecek_urun_list.add(ekle);
				}
			}
		} else if (sira == 2) {
			for (URUNLER.SEKERLEME seker : seker_list) {
				if (seker.urun.Birim_Fiyati == en_cok) {
					seker.urun.Urun_Isim_Degistir(isim);
					ekle.Adi = seker.urun.Adi;
					ekle.Kategori_Indexi = seker.urun.Kategori_Indexi;
					ekle.Birim_Agirligi = seker.urun.Birim_Agirligi;
					ekle.Birim_Fiyati =seker.urun.Birim_Fiyati;
					ekle.Stok_Miktari = seker.urun.Stok_Miktari;
					eklenecek_urun_list.add(ekle);
				}
			}
		} else if (sira == 3) {
			for (URUNLER.SUT sut : sut_list) {
				if (sut.urun.Birim_Fiyati == en_cok) {
					sut.urun.Urun_Isim_Degistir(isim);
					ekle.Adi = sut.urun.Adi;
					ekle.Kategori_Indexi = sut.urun.Kategori_Indexi;
					ekle.Birim_Agirligi = sut.urun.Birim_Agirligi;
					ekle.Birim_Fiyati =sut.urun.Birim_Fiyati;
					ekle.Stok_Miktari = sut.urun.Stok_Miktari;
					eklenecek_urun_list.add(ekle);
				}
			}
		} else {
			for (URUNLER.TAHIL tahil : tahil_list) {
				if (tahil.urun.Birim_Fiyati == en_cok) {
					tahil.urun.Urun_Isim_Degistir(isim);
					ekle.Adi = tahil.urun.Adi;
					ekle.Kategori_Indexi = tahil.urun.Kategori_Indexi;
					ekle.Birim_Agirligi = tahil.urun.Birim_Agirligi;
					ekle.Birim_Fiyati =tahil.urun.Birim_Fiyati;
					ekle.Stok_Miktari = tahil.urun.Stok_Miktari;
					eklenecek_urun_list.add(ekle);
				}
			}
		}
	}

	static void Icecek_Stok_Miktarina_Gore_Indirim_Yap(ArrayList<URUNLER.ICECEK> ıcecek_list, ArrayList<Dosyaİşlemleri> eklenecek_urun_list) {
		Scanner scanner = new Scanner(System.in);
		Dosyaİşlemleri ekle = new Dosyaİşlemleri();
		Integer en_az = 100;
		for (URUNLER.ICECEK icecek : ıcecek_list) { // İÇECEK LİSTESİNDEKİ EN KÜÇÜK ELEMANI BULMA
			if (icecek.urun.Stok_Miktari < en_az && icecek.urun.Stok_Miktari != 0) {
				en_az = icecek.urun.Stok_Miktari;
			}
		}
		for (URUNLER.ICECEK ıcecek : ıcecek_list) {
			if (ıcecek.urun.Stok_Miktari == en_az) {
				int kontrol = 0;
				System.out.println("YÜZDE KAÇ İNDİRİM YAPACAKSİNİZ");
				Integer indirim = scanner.nextInt();
				while (kontrol != 1) {
					if (indirim <= 100) { // MAX İNDİRİM MİKTARI %100 BUNUN KONTROLÜ
						ıcecek.Stoka_Gore_İndirim_Yap(indirim); // İNDİRİM YAPILACAK VERİYİ YOLLADIK İSMİ GÜNCELLEDİK
						ekle.Adi = ıcecek.urun.Adi;
						ekle.Kategori_Indexi = ıcecek.urun.Kategori_Indexi;
						ekle.Birim_Agirligi = ıcecek.urun.Birim_Agirligi;
						ekle.Birim_Fiyati =ıcecek.urun.Birim_Fiyati;
						ekle.Stok_Miktari = ıcecek.urun.Stok_Miktari;
						eklenecek_urun_list.add(ekle);
						kontrol = 1;
					} else {
						System.out.println("EN FAZLA %100 İNDİRİM YAPILABİLİR... İNDİRİM ORANI GİRİN...");
						indirim = scanner.nextInt();
					}
				}
			}
		}
		URUNLER.ICECEK.Icecek_Yazdir(ıcecek_list);
	}

	static void Cesni_Stok_Sifirsa_Sil(ArrayList<URUNLER.CESNİ> cesni_list) {
		URUNLER.CESNİ.Sifirsa_Sil_Cesni(cesni_list);
		URUNLER.CESNİ.Cesni_Yazdir(cesni_list);
	}

	static void Sekerleme_Yeni_Urun_Ekle(ArrayList<URUNLER.SEKERLEME> seker_list, ArrayList<Dosyaİşlemleri> eklenecek_urun_list) {
		URUNLER.SEKERLEME.Yeni_Urun_Ekle_Sekerleme(seker_list, eklenecek_urun_list);
	}

	static void Sut_Fiyat_Guncelle(ArrayList<URUNLER.SUT> sut_list, ArrayList<Dosyaİşlemleri> eklenecek_urun_list) {
		Scanner scanner = new Scanner(System.in);
		Dosyaİşlemleri ekle = new Dosyaİşlemleri();
		double adet = 0.0;
		double ort = 0.0;
		// FİYATLARIN ORTALAMASINI BULMA
		for (URUNLER.SUT sut : sut_list) {
			adet++;
			ort += sut.urun.Birim_Fiyati;
		}
		ort /= adet;
		double temp = 100;
		double tut = 0;
		// ORTALAMANIN 1 ALTINDEKİ VERİ TESPİTİ
		for (URUNLER.SUT sut : sut_list) {
			double temp2 = ort - sut.urun.Birim_Fiyati;
			if (temp2 > 0 && temp2 < temp) { // FARK POZİTİF İSE ALTINDADIR
				temp = temp2;
				tut = sut.urun.Birim_Fiyati;
			}
		}
		// BULUNAN VERİ ÜZERİNDE İŞLEMLER
		for (int i = 0; i < sut_list.size(); i++) {
			if (sut_list.get(i).urun.Birim_Fiyati == tut) {
				sut_list.get(i).Fiyat_Guncelle_Sut();
				ekle.Adi = sut_list.get(i).urun.Adi;
				ekle.Kategori_Indexi = sut_list.get(i).urun.Kategori_Indexi;
				ekle.Birim_Agirligi = sut_list.get(i).urun.Birim_Agirligi;
				ekle.Birim_Fiyati =sut_list.get(i).urun.Birim_Fiyati;
				ekle.Stok_Miktari = sut_list.get(i).urun.Stok_Miktari;
				eklenecek_urun_list.add(ekle);
			}
		}
		URUNLER.SUT.sut_yazdir(sut_list);
	}

	static void Tahil_Detay_Bilgi_Ekle(ArrayList<URUNLER.TAHIL> tahil_list) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("BİRİM FİYATI HANGİ DEĞERİN ÜSTÜNDE OLAN ÜRÜNLERE AYLIK SATIŞ MİKTARI EKLEMEK İSTİYORSUNUZ:");
		int deger = scanner.nextInt();
		for (URUNLER.TAHIL tahil : tahil_list) {
			if (tahil.urun.Stok_Miktari > deger) {
				System.out.println(tahil.urun.Adi + " ÜRÜNÜNE EKLENECEK YENİ AYLIK SATIŞ MİKTARINI GİRİNİZ:");
				Integer satis = scanner.nextInt();
				tahil.Detay_Ekle_Tahil(satis);
			}

		}
		URUNLER.TAHIL.Tahil_yazdir(tahil_list);
	}

	static void List_Olustur(ArrayList<Dosyaİşlemleri> eklenecek_urun_list, ArrayList<URUNLER.ICECEK> ıcecek_list, ArrayList<URUNLER.CESNİ> cesni_list,
			ArrayList<URUNLER.SEKERLEME> seker_list, ArrayList<URUNLER.SUT> sut_list, ArrayList<URUNLER.TAHIL> tahil_list) throws IOException {
		FileReader fr = new FileReader("UrunListesi.txt");
		BufferedReader br = new BufferedReader(fr);
		
		
		while (true) {
			String str = br.readLine();
			if (str == null) {
				break;
			}
			String[] dizi = str.split("/");
			URUNLER yeni = new URUNLER();
			Dosyaİşlemleri yeni1 = new Dosyaİşlemleri();
			Integer ürün_index = Integer.valueOf(dizi[1]);
			if (ürün_index == 1) {
				yeni.Adi = dizi[0];
				yeni.Kategori_Indexi = Integer.valueOf(dizi[1]);
				yeni.Birim_Agirligi = dizi[2];
				yeni.Birim_Fiyati = Double.valueOf(dizi[3]);
				yeni.Stok_Miktari = Integer.valueOf(dizi[4]);
				yeni1.Adi = dizi[0];
				yeni1.Kategori_Indexi = Integer.valueOf(dizi[1]);
				yeni1.Birim_Agirligi = dizi[2];
				yeni1.Birim_Fiyati = Double.valueOf(dizi[3]);
				yeni1.Stok_Miktari = Integer.valueOf(dizi[4]);
				URUNLER.ICECEK ıcecek = new URUNLER.ICECEK(yeni);
				ıcecek_list.add(ıcecek);
				eklenecek_urun_list.add(yeni1);
			} else if (ürün_index == 2) {
				yeni.Adi = dizi[0];
				yeni.Kategori_Indexi = Integer.valueOf(dizi[1]);
				yeni.Birim_Agirligi = dizi[2];
				yeni.Birim_Fiyati = Double.valueOf(dizi[3]);
				yeni.Stok_Miktari = Integer.valueOf(dizi[4]);
				yeni1.Adi = dizi[0];
				yeni1.Kategori_Indexi = Integer.valueOf(dizi[1]);
				yeni1.Birim_Agirligi = dizi[2];
				yeni1.Birim_Fiyati = Double.valueOf(dizi[3]);
				yeni1.Stok_Miktari = Integer.valueOf(dizi[4]);
				URUNLER.TAHIL tahil = new URUNLER.TAHIL(yeni);
				tahil_list.add(tahil);
				eklenecek_urun_list.add(yeni1);
			} else if (ürün_index == 3) {
				yeni.Adi = dizi[0];
				yeni.Kategori_Indexi = Integer.valueOf(dizi[1]);
				yeni.Birim_Agirligi = dizi[2];
				yeni.Birim_Fiyati = Double.valueOf(dizi[3]);
				yeni.Stok_Miktari = Integer.valueOf(dizi[4]);
				yeni1.Adi = dizi[0];
				yeni1.Kategori_Indexi = Integer.valueOf(dizi[1]);
				yeni1.Birim_Agirligi = dizi[2];
				yeni1.Birim_Fiyati = Double.valueOf(dizi[3]);
				yeni1.Stok_Miktari = Integer.valueOf(dizi[4]);
				URUNLER.SUT sut = new URUNLER.SUT(yeni);
				sut_list.add(sut);
				eklenecek_urun_list.add(yeni1);
			} else if (ürün_index == 4) {
				yeni.Adi = dizi[0];
				yeni.Kategori_Indexi = Integer.valueOf(dizi[1]);
				yeni.Birim_Agirligi = dizi[2];
				yeni.Birim_Fiyati = Double.valueOf(dizi[3]);
				yeni.Stok_Miktari = Integer.valueOf(dizi[4]);
				yeni1.Adi = dizi[0];
				yeni1.Kategori_Indexi = Integer.valueOf(dizi[1]);
				yeni1.Birim_Agirligi = dizi[2];
				yeni1.Birim_Fiyati = Double.valueOf(dizi[3]);
				yeni1.Stok_Miktari = Integer.valueOf(dizi[4]);
				URUNLER.SEKERLEME seker = new URUNLER.SEKERLEME(yeni);
				seker_list.add(seker);
				eklenecek_urun_list.add(yeni1);
			} else if (ürün_index == 5) {
				yeni.Adi = dizi[0];
				yeni.Kategori_Indexi = Integer.valueOf(dizi[1]);
				yeni.Birim_Agirligi = dizi[2];
				yeni.Birim_Fiyati = Double.valueOf(dizi[3]);
				yeni.Stok_Miktari = Integer.valueOf(dizi[4]);
				yeni1.Adi = dizi[0];
				yeni1.Kategori_Indexi = Integer.valueOf(dizi[1]);
				yeni1.Birim_Agirligi = dizi[2];
				yeni1.Birim_Fiyati = Double.valueOf(dizi[3]);
				yeni1.Stok_Miktari = Integer.valueOf(dizi[4]);
				URUNLER.CESNİ cesni = new URUNLER.CESNİ(yeni);
				cesni_list.add(cesni);
				eklenecek_urun_list.add(yeni1);
			}
		}

	}
	
	static void Yaz_Oku(ArrayList<Dosyaİşlemleri> eklenecek_urun_list) throws IOException, ClassNotFoundException {
		String dosya_adı = "UrunListesi_okuma_yazma.txt";
		Dosyaİşlemleri.DosyayaYazma.ListeleriYaz(eklenecek_urun_list, dosya_adı);
		Dosyaİşlemleri.DosyaOkuma.ListeleriOluştur(dosya_adı);
	}

}
