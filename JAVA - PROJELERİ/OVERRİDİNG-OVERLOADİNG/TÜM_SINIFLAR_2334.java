
public class TÜM_SINIFLAR_2334 {
	
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
	
	
	
	
	
	
	
	
	package PAKET_2;

	import java.io.BufferedReader;
	import java.io.FileReader;
	import java.io.IOException;
	import java.util.ArrayList;
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
		
		public static void Hepsi_Yaz(ArrayList<İÇECEK> icecek_list, ArrayList<TAHIL> tahil_list, ArrayList<SÜT> sut_list,
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

	
	
	
	
	
	
	
	
	package PAKET_1;

	import java.util.ArrayList;
	import java.util.Scanner;

	// import PAKET_1.*;
	public class ÜRÜN {
		
		protected String Adi;
		protected Integer Kategori_Indexi;
		protected String Birim_Agirligi;
		protected Double Birim_Fiyati;
		protected Integer Stok_Miktari;
		protected Integer Aylik_Satis;
		protected Integer Yıllık_Satis;
		
		public Integer getYıllık_Satis() {
			return Yıllık_Satis;
		}
		public void setYıllık_Satis(Integer yıllık_Satis) {
			Yıllık_Satis = yıllık_Satis;
		}
		public ÜRÜN(String adi, Integer index, String agirlik, Double fiyat, Integer stok) {
			this.Adi = adi;
			this.Kategori_Indexi = index;
			this.Birim_Agirligi = agirlik;
			this.Birim_Fiyati = fiyat;
			this.Stok_Miktari = stok;
		}
		public ÜRÜN() {
			
		}
		
		public String getAdi() {
			return Adi;
		}
		public void setAdi(String adi) {
			Adi = adi;
		}
		public Integer getKategori_Indexi() {
			return Kategori_Indexi;
		}
		public void setKategori_Indexi(Integer kategori_Indexi) {
			Kategori_Indexi = kategori_Indexi;
		}
		public String getBirim_Agirligi() {
			return Birim_Agirligi;
		}
		public void setBirim_Agirligi(String birim_Agirligi) {
			Birim_Agirligi = birim_Agirligi;
		}
		public Double getBirim_Fiyati() {
			return Birim_Fiyati;
		}
		public void setBirim_Fiyati(Double birim_Fiyati) {
			Birim_Fiyati = birim_Fiyati;
		}
		public Integer getStok_Miktari() {
			return Stok_Miktari;
		}
		public void setStok_Miktari(Integer stok_Miktari) {
			Stok_Miktari = stok_Miktari;
		}
		public Integer getAylik_Satis() {
			return Aylik_Satis;
		}
		public void setAylik_Satis(Integer aylik_Satis) {
			Aylik_Satis = aylik_Satis;
		}
		
		public Integer Fiyata_Göre_Stok_Güncelle(Integer stok, String isim) {
			return this.Stok_Miktari = stok;
		}
		
		public String İsim_değiştir() {
			Scanner scanner = new Scanner(System.in);
			System.out.println("FİYATI EN ÇOK OLAN ÜRÜNÜN YENİ İSMİNİ GİRİNİZ...");
			String isim = scanner.nextLine();
			return this.Adi = isim;
		}
		
		

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	package PAKET_1;

	import java.util.ArrayList;
	import java.util.Scanner;

	public class İÇECEK extends ÜRÜN{

		public İÇECEK(String adi, Integer index, String agirlik, Double fiyat, Integer stok) {
			super(adi, index, agirlik, fiyat, stok);
		}
		
		public İÇECEK() {
			
		}
		
		@Override
		public Integer Fiyata_Göre_Stok_Güncelle(Integer stok, String isim) {
			if(isim.length() % 2 == 0) {
				return this.Stok_Miktari = stok;
			}else {
				return this.Stok_Miktari = stok * 2;
			}
		}
		
		@Override
		public String İsim_değiştir() {
			return super.İsim_değiştir();
		}
		
		public Double İçecekler_indirim_Yap(Integer stok, Double indirim) {
			return this.Birim_Fiyati = (this.Birim_Fiyati*indirim ) / 100.0;
		}
		
		public Double İçecekler_indirim_Yap(Double indirim, Integer stok) {
			return this.Birim_Fiyati = (this.Birim_Fiyati*(indirim / 5) ) / 100.0;
		}
		
		public static void içecek_yaz(ArrayList<İÇECEK> icecek_list) {
			for (İÇECEK icecek : icecek_list) {
				System.out.println("ürün adı:" + "\t" + icecek.getAdi() + "\türün indexi:" + "\t" + icecek.getKategori_Indexi() + "\t" + "ürün stok:" + icecek.getStok_Miktari()
				+ "\t" + "ürün fiyatı:" + "\t" + icecek.getBirim_Fiyati() + "\türün ağırlık:" + "\t" + icecek.getBirim_Agirligi());
			}
		}

	}
	
	
	
	
	
	
	
	
	
	package PAKET_1;

	import java.util.ArrayList;

	public class ŞEKERLEME extends ÜRÜN {

		public ŞEKERLEME(String adi, Integer index, String agirlik, Double fiyat, Integer stok) {
			super(adi, index, agirlik, fiyat, stok);
		}

		public ŞEKERLEME() {

		}

		@Override
		public Integer Fiyata_Göre_Stok_Güncelle(Integer stok, String isim) {
			return super.Fiyata_Göre_Stok_Güncelle(stok, isim);
		}

		@Override
		public String İsim_değiştir() {
			return super.İsim_değiştir();
		}

		public Integer seker_güncelle(Double fiyat, Integer stok, Integer index) {
			return this.Stok_Miktari = (int) (stok + Math.floor(fiyat));
		}

		public Integer seker_güncelle(Integer stok, Integer index, Double fiyat) {
			if(stok % 2 == 0){
				return this.Stok_Miktari = stok / 2 ;
			}else {
				return this.Stok_Miktari = stok * 2 ;
			}
		}

		public Integer seker_güncelle(Integer stok, Double fiyat, Integer index) {
			return this.Stok_Miktari = 0;
		}
		
		public static void seker_yaz(ArrayList<ŞEKERLEME> seker_list) {
			for (ŞEKERLEME seker : seker_list) {
				System.out.println("ürün adı:" + "\t" + seker.getAdi() + "\türün indexi:" + "\t" + seker.getKategori_Indexi() + "\t" + "ürün stok:" + seker.getStok_Miktari()
				+ "\t" + "ürün fiyatı:" + "\t" + seker.getBirim_Fiyati() + "\türün ağırlık:" + "\t" + seker.getBirim_Agirligi());
			}
		}

	}

	
	
	
	
	
	
	
	
	package PAKET_1;

	import java.util.ArrayList;


	public class TAHIL extends ÜRÜN {

		public TAHIL(String adi, Integer index, String agirlik, Double fiyat, Integer stok) {
			super(adi, index, agirlik, fiyat, stok);
		}

		public TAHIL() {

		}

		@Override
		public Integer Fiyata_Göre_Stok_Güncelle(Integer stok, String isim) {
			return super.Fiyata_Göre_Stok_Güncelle(stok, isim);
		}

		@Override
		public String İsim_değiştir() {
			return super.İsim_değiştir();
		}

		public void tahıl_detay(Integer satış, Double fiyat) {
			this.Aylik_Satis = satış;
		}

		public void tahıl_detay(Double fiyat, Integer satış) {
			this.Yıllık_Satis = satış;
		}
		
		public static void tahıl_yaz(ArrayList<TAHIL> tahil_list) {
			for (TAHIL tahıl : tahil_list) {
				if(tahıl.Yıllık_Satis != null) {
					System.out.println("ürün adı:" + tahıl.getAdi() + "\türün indexi:" + tahıl.getKategori_Indexi() + "\t"
							+ "ürün stok:" + tahıl.getStok_Miktari() + "\t" + "ürün fiyatı:" + tahıl.getBirim_Fiyati()
							+ "\türün ağırlık:" + tahıl.getBirim_Agirligi() + "\tyıllık satış:" + tahıl.getYıllık_Satis());
				}else {
					System.out.println("ürün adı:" + tahıl.getAdi() + "\türün indexi:" + tahıl.getKategori_Indexi() + "\t"
							+ "ürün stok:" + tahıl.getStok_Miktari() + "\t" + "ürün fiyatı:" + tahıl.getBirim_Fiyati()
							+ "\türün ağırlık:" + tahıl.getBirim_Agirligi() + "\taylık satış:" + tahıl.getAylik_Satis());
				}
			}
		}

	}

	
	
	
	
	
	
	
	
	package PAKET_1;

	import java.util.ArrayList;


	public class SÜT extends ÜRÜN{

		public SÜT(String adi, Integer index, String agirlik, Double fiyat, Integer stok) {
			super(adi, index, agirlik, fiyat, stok);
		}
		
		public SÜT() {
			
		}
		
		@Override
		public Integer Fiyata_Göre_Stok_Güncelle(Integer stok, String isim) {
			return super.Fiyata_Göre_Stok_Güncelle(stok, isim);
		}
		
		@Override
		public String İsim_değiştir() {
			return super.İsim_değiştir();
		}
		
		public Double süt_fiyat_güncelle(Double fiyat, Integer oran) {
			return this.Birim_Fiyati = (this.Birim_Fiyati * oran) /100.0;
		}
		
		public Double süt_fiyat_güncelle(Integer oran, Double fiyat) {
			return this.Birim_Fiyati = (this.Birim_Fiyati * oran) /100.0;
		}
		public static void süt_yaz(ArrayList<SÜT> sut_list) {
			for (SÜT sut : sut_list) {
				System.out.println("ürün adı:" + "\t" + sut.getAdi() + "\türün indexi:" + "\t" + sut.getKategori_Indexi() + "\t" + "ürün stok:" + sut.getStok_Miktari()
				+ "\t" + "ürün fiyatı:" + "\t" + sut.getBirim_Fiyati() + "\türün ağırlık:" + "\t" + sut.getBirim_Agirligi());
			}
		}

	}
	
	
	
	
	
	
	
	
	
	package PAKET_1;

	import java.util.ArrayList;

	public class ÇEŞNİ extends ÜRÜN{

		public ÇEŞNİ(String adi, Integer index, String agirlik, Double fiyat, Integer stok) {
			super(adi, index, agirlik, fiyat, stok);
		}
		
		public ÇEŞNİ() {
			
		}
		
		@Override
		public Integer Fiyata_Göre_Stok_Güncelle(Integer stok, String isim) {
			return super.Fiyata_Göre_Stok_Güncelle(stok, isim);
		}
		
		@Override
		public String İsim_değiştir() {
			return this.Adi = "BCDFGHJKLMN";
		}
		
		public Integer stok_güncelle(String adi, Integer Stok) {
			return this.Stok_Miktari = Stok;
		}
		
		public Integer stok_güncelle(Integer Stok, String adi) {
			int temp = this.Stok_Miktari - Stok;
			if(temp < 0) {
				return this.Stok_Miktari = 0;
			}else {
				return this.Stok_Miktari = temp;
			}
		}
		
		public static void çeşni_yaz(ArrayList<ÇEŞNİ> cesni_list) {
			for (ÇEŞNİ cesni : cesni_list) {
				System.out.println("ürün adı:" + "\t" + cesni.getAdi() + "\türün indexi:" + "\t" + cesni.getKategori_Indexi() + "\t" + "ürün stok:" + cesni.getStok_Miktari()
				+ "\t" + "ürün fiyatı:" + "\t" + cesni.getBirim_Fiyati() + "\türün ağırlık:" + "\t" + cesni.getBirim_Agirligi() + "   ");
			}
		}

	}

}
