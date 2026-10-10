import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import PAKET_1.*;

public class TUM_SINIFLAR_2334 {
	
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
	
	
	
	
	public interface IURUN {
		
		public Double Stok_Miktarina_Gore_Indirim_Yap(int indirim, Double fiyat);
		
		public void Stok_Sifirsa_Sil(ArrayList<TAHIL> tahil_list, ArrayList<SUT> sut_list);
		
		public void Yeni_Urun_Ekle(ArrayList<SEKERLEME> seker_list, ArrayList<ICECEK> ıcecek_list);
		
		public Double Fiyat_Guncelle(ArrayList<CESNİ> cesni_list, ArrayList<SUT> sut_list);

	}
	
	
	
	
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
	
	
	
	
	public class TAHIL extends URUN implements IURUN{

		public TAHIL(String Adi, Integer Kategori_Indexi, String Birim_Agirligi, Double Birim_Fiyati,
				Integer Stok_Miktari) {
			super(Adi, Kategori_Indexi, Birim_Agirligi, Birim_Fiyati, Stok_Miktari);
		}
		
		public TAHIL() {
			super();
		}

		@Override
		public Double Stok_Miktarina_Gore_Indirim_Yap(int en_az , Double fiyat) {
			return this.Birim_Fiyati;
		}

		@Override
		public void Stok_Sifirsa_Sil(ArrayList<TAHIL> tahil_list, ArrayList<SUT> sut_list) {
			for (int i = 0; i < tahil_list.size(); i++) {
				if(tahil_list.get(i).Stok_Miktari == 0) {
					tahil_list.remove(i);
				}
			}
		}

		@Override
		public void Yeni_Urun_Ekle(ArrayList<SEKERLEME> seker_list, ArrayList<ICECEK> ıcecek_list) {
		}

		@Override
		public Double Fiyat_Guncelle(ArrayList<CESNİ> cesni_list, ArrayList<SUT> sut_list) {
			return this.Birim_Fiyati;
		}
		
		public static void tahil_yaz(ArrayList<TAHIL> tahil_list) {
			for (TAHIL tahıl : tahil_list) {
				System.out.println("ürün adı:" + "\t" + tahıl.Adi + "\türün indexi:" + "\t" + tahıl.Kategori_Indexi + "\t" + "ürün stok:" + tahıl.Stok_Miktari
				+ "\t" + "ürün fiyatı:" + "\t" + tahıl.Birim_Fiyati + "\türün ağırlık:" + "\t" + tahıl.Birim_Agirligi);
			}
		}

	}
	
	
	
	
	public class SUT extends URUN implements IURUN{

		public SUT(String Adi, Integer Kategori_Indexi, String Birim_Agirligi, Double Birim_Fiyati, Integer Stok_Miktari) {
			super(Adi, Kategori_Indexi, Birim_Agirligi, Birim_Fiyati, Stok_Miktari);
		}
		
		public SUT() {
			super();
		}

		@Override
		public Double Stok_Miktarina_Gore_Indirim_Yap(int en_az, Double fiyat) {
			return this.Birim_Fiyati;
		}

		@Override
		public void Stok_Sifirsa_Sil(ArrayList<TAHIL> tahil_list, ArrayList<SUT> sut_list) {
			for (int i = 0; i < sut_list.size(); i++) {
				if(sut_list.get(i).Stok_Miktari == 0) {
					sut_list.remove(i);
				}
			}
		}

		@Override
		public void Yeni_Urun_Ekle(ArrayList<SEKERLEME> seker_list, ArrayList<ICECEK> ıcecek_list) {
		}

		@Override
		public Double Fiyat_Guncelle(ArrayList<CESNİ> cesni_list, ArrayList<SUT> sut_list) {
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
			System.out.println("HESAPLANAN ORTALAMA: " + ort);
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
					System.out.println("GÜNCELLENEN ÜRÜNÜN ESKİ HALİ:");
					System.out.println("ürün adı:" + "\t" + sut_list.get(i).Adi + "\türün indexi:" + "\t" + sut_list.get(i).Kategori_Indexi + "\t" + "ürün stok:" + sut_list.get(i).Stok_Miktari + "\t" + "ürün fiyatı:" + "\t" + sut_list.get(i).Birim_Fiyati + "\türün ağırlık:" + "\t" + sut_list.get(i).Birim_Agirligi);
					sut_list.get(i).Birim_Fiyati = (sut_list.get(i).Birim_Fiyati * 150.0) / 100.0;
					System.out.println("GÜNCELLENEN ÜRÜNÜN YENİ HALİ:");
					System.out.println("ürün adı:" + "\t" + sut_list.get(i).Adi + "\türün indexi:" + "\t" + sut_list.get(i).Kategori_Indexi + "\t" + "ürün stok:" + sut_list.get(i).Stok_Miktari + "\t" + "ürün fiyatı:" + "\t" + sut_list.get(i).Birim_Fiyati + "\türün ağırlık:" + "\t" + sut_list.get(i).Birim_Agirligi);
				}
			}
			return this.Birim_Fiyati;
		}

		public static void sut_yaz(ArrayList<SUT> sut_list) {
			for (SUT sut : sut_list) {
				System.out.println("ürün adı:" + "\t" + sut.Adi + "\türün indexi:" + "\t" + sut.Kategori_Indexi + "\t" + "ürün stok:" + sut.Stok_Miktari
				+ "\t" + "ürün fiyatı:" + "\t" + sut.Birim_Fiyati + "\türün ağırlık:" + "\t" + sut.Birim_Agirligi);
			}
		}

	}
	
	
	
	
	public class SEKERLEME extends URUN implements IURUN{

		public SEKERLEME(String Adi, Integer Kategori_Indexi, String Birim_Agirligi, Double Birim_Fiyati,
				Integer Stok_Miktari) {
			super(Adi, Kategori_Indexi, Birim_Agirligi, Birim_Fiyati, Stok_Miktari);
		}
		
		public SEKERLEME() {
			super();
		}

		@Override
		public Double Stok_Miktarina_Gore_Indirim_Yap(int en_az, Double fiyat) {
			return this.Birim_Fiyati;
		}

		@Override
		public void Stok_Sifirsa_Sil(ArrayList<TAHIL> tahil_list, ArrayList<SUT> sut_list) {
		}

		@Override
		public void Yeni_Urun_Ekle(ArrayList<SEKERLEME> seker_list, ArrayList<ICECEK> ıcecek_list) {
			Scanner scanner = new Scanner(System.in);
			SEKERLEME yeni = new SEKERLEME();
			System.out.println("YENİ ÜRÜNÜN ADINI GİR:");
			String ad = scanner.nextLine();
			yeni.Adi = ad;
			yeni.Kategori_Indexi = 4;
			System.out.println("YENİ ÜRÜNÜN BİRİM AĞIRLIĞINI GİRİN:");
			String agirlik = scanner.nextLine();
			yeni.Birim_Agirligi = agirlik;
			Double ort = 0.0;
			double adet = 0.0;
			Integer min_stok = 100;
			// MİN STOK MİKTARI BULMA
			for (SEKERLEME sekerleme : seker_list) {
				adet++;
				ort += sekerleme.Birim_Fiyati;
				if(min_stok > sekerleme.Stok_Miktari) {
					min_stok = sekerleme.Stok_Miktari;
				}
			}
			ort /= adet;
			yeni.Birim_Fiyati = ort;
			yeni.Stok_Miktari = min_stok;
			seker_list.add(yeni);
		}

		@Override
		public Double Fiyat_Guncelle(ArrayList<CESNİ> cesni_list, ArrayList<SUT> sut_list) {
			return this.Birim_Fiyati;
		}

		public static void sekerleme_yaz(ArrayList<SEKERLEME> seker_list) {
			for (SEKERLEME seker : seker_list) {
				System.out.println("ürün adı:" + "\t" + seker.Adi + "\türün indexi:" + "\t" + seker.Kategori_Indexi + "\t" + "ürün stok:" + seker.Stok_Miktari
				+ "\t" + "ürün fiyatı:" + "\t" + seker.Birim_Fiyati + "\türün ağırlık:" + "\t" + seker.Birim_Agirligi);
			}
		}

	}
	
	
	
	
	public class CESNİ extends URUN implements IURUN{

		public CESNİ(String Adi, Integer Kategori_Indexi, String Birim_Agirligi, Double Birim_Fiyati,
				Integer Stok_Miktari) {
			super(Adi, Kategori_Indexi, Birim_Agirligi, Birim_Fiyati, Stok_Miktari);
		}
		
		public CESNİ() {
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
		}

		@Override
		public Double Fiyat_Guncelle(ArrayList<CESNİ> cesni_list, ArrayList<SUT> sut_list) {
			Scanner scanner = new Scanner(System.in);
			double adet = 0.0;
			double ort = 0.0;
			// FİYATLARIN ORTALAMASINI BULMA
			for (CESNİ cesni : cesni_list) {
				adet++;
				ort += cesni.Birim_Fiyati;
			}
			ort /=adet;
			double temp = 100;
			double tut = 0;
			System.out.println("HESAPLANAN ORTALAMA: " + ort);
			// ORTALAMANIN 1 ALTINDEKİ VERİ TESPİTİ
			for (CESNİ cesni : cesni_list) {
				double temp2 = ort - cesni.Birim_Fiyati;
				if(temp2 > 0 && temp2 < temp) {  // FARK POZİTİF İSE ALTINDADIR 
					temp = temp2;
					tut = cesni.Birim_Fiyati;
				}
			}
			// BULUNAN VERİ ÜZERİNDE İŞLEMLER
			for (int i = 0; i < cesni_list.size(); i++) {
				if(cesni_list.get(i).Birim_Fiyati == tut) {
					System.out.println("GÜNCELLENEN ÜRÜNÜN ESKİ HALİ:");
					System.out.println("ürün adı:" + "\t" + cesni_list.get(i).Adi + "\türün indexi:" + "\t" + cesni_list.get(i).Kategori_Indexi + "\t" + "ürün stok:" + cesni_list.get(i).Stok_Miktari + "\t" + "ürün fiyatı:" + "\t" + cesni_list.get(i).Birim_Fiyati + "\türün ağırlık:" + "\t" + cesni_list.get(i).Birim_Agirligi);
					cesni_list.get(i).Birim_Fiyati = (cesni_list.get(i).Birim_Fiyati * 150.0) / 100.0;
					System.out.println("GÜNCELLENEN ÜRÜNÜN YENİ HALİ:");
					System.out.println("ürün adı:" + "\t" + cesni_list.get(i).Adi + "\türün indexi:" + "\t" + cesni_list.get(i).Kategori_Indexi + "\t" + "ürün stok:" + cesni_list.get(i).Stok_Miktari + "\t" + "ürün fiyatı:" + "\t" + cesni_list.get(i).Birim_Fiyati + "\türün ağırlık:" + "\t" + cesni_list.get(i).Birim_Agirligi);
				}
			}
			return this.Birim_Fiyati;
		}

		public static void cesni_yaz(ArrayList<CESNİ> cesni_list) {
			for (CESNİ cesni : cesni_list) {
				System.out.println("ürün adı:" + "\t" + cesni.Adi + "\türün indexi:" + "\t" + cesni.Kategori_Indexi + "\t" + "ürün stok:" + cesni.Stok_Miktari
				+ "\t" + "ürün fiyatı:" + "\t" + cesni.Birim_Fiyati + "\türün ağırlık:" + "\t" + cesni.Birim_Agirligi + "   ");
			}
		}

	}

}
