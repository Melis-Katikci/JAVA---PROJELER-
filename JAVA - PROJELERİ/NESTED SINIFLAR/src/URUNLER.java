import java.util.ArrayList;
import java.util.Scanner;

public class URUNLER {
	URUNLER urun;
	public String Adi;
	public Integer Kategori_Indexi;
	public String Birim_Agirligi;
	public Double Birim_Fiyati;
	public Integer Stok_Miktari;
	public Integer Aylik_Satis;
	
	public URUNLER(String adi, Integer index, String agirlik, Double fiyat, Integer stok) {
		this.Adi = adi;
		this.Kategori_Indexi = index;
		this.Birim_Agirligi = agirlik;
		this.Birim_Fiyati = fiyat;
		this.Stok_Miktari = stok;
	}
	
	public URUNLER() {  // ŞEKERLEME yeni = new ŞEKERLEME();     ŞEKERLEME CLASSINDA BU CONTRACTOR KULLANILDIĞI İÇİN İLGİLİ CLASSIN PARENTSINA DA ONA UYGUN EKLEME YAPILDI
		
	}

	public Integer Fiyata_Göre_Guncelle(Integer stok) {
		this.Stok_Miktari = stok;
		return this.Stok_Miktari;
	}

	public static void Tum_Liste_Yazdir(URUNLER urun) {
		System.out.println(urun.Adi + "\t" + urun.Kategori_Indexi + "\t" + urun.Birim_Agirligi + "\t"
				+ urun.Birim_Fiyati + "\t" + urun.Stok_Miktari);
	}

	public static void Tahil_Liste_Yazdir(URUNLER urun) {
		System.out.println(urun.Adi + "\t" + urun.Kategori_Indexi + "\t" + urun.Birim_Agirligi + "\t"
				+ urun.Birim_Fiyati + "\t" + urun.Stok_Miktari + "\t" + urun.Aylik_Satis);
	}

	public String Urun_Isim_Degistir(String yeni) {
		System.out.println(this.Adi + "\t" + this.Kategori_Indexi + "\t" + this.Birim_Agirligi + "\t"
				+ this.Birim_Fiyati + "\t" + this.Stok_Miktari);
		this.Adi = yeni;
		System.out.println(this.Adi + "\t" + this.Kategori_Indexi + "\t" + this.Birim_Agirligi + "\t"
				+ this.Birim_Fiyati + "\t" + this.Stok_Miktari);
		return this.Adi;
	}

	public static class ICECEK{

		public URUNLER urun;

		public ICECEK(URUNLER urun) {
			this.urun = urun;
		}
		public ICECEK() {
			
		}

		public Double Stoka_Gore_İndirim_Yap(Integer indirim) {
			urun.Birim_Fiyati -= (urun.Birim_Fiyati * indirim) / 100;
			return urun.Birim_Fiyati;
		}

		public static void Icecek_Yazdir(ArrayList<ICECEK> ıcecek_list) {
			System.out.println("İÇECEK LİSTESİ YAZDIRILIYOR...");
			for (ICECEK icecek : ıcecek_list) {
				icecek.urun.Tum_Liste_Yazdir(icecek.urun);
			}
		}

	}
	
	public static class CESNİ {

		public URUNLER urun;

		public CESNİ(URUNLER urun) {
			this.urun = urun;
		}
		public CESNİ() {
			
		}
		
		public static void Sifirsa_Sil_Cesni(ArrayList<CESNİ> cesni_list) {
			for (int i = 0; i < cesni_list.size(); i++) {
				if(cesni_list.get(i).urun.Stok_Miktari == 0) {
					cesni_list.remove(i);
				}
			}
		}
		
		public static void Cesni_Yazdir(ArrayList<CESNİ> cesni_list) {
			System.out.println("ÇEŞNİ LİSTESİ YAZDIRILIYOR...");
			for (CESNİ cesni : cesni_list) {
				cesni.urun.Tum_Liste_Yazdir(cesni.urun);
			}
		}

	}
	
	public static class SEKERLEME {
	    
	    public URUNLER urun;

	    public SEKERLEME(URUNLER urun) {
	        this.urun = urun;
	    }

	    public SEKERLEME() {
	        this.urun = new URUNLER();
	    }

	    public static void Yeni_Urun_Ekle_Sekerleme(ArrayList<SEKERLEME> seker_list, ArrayList<Dosyaİşlemleri> eklenecek_urun_list) {
	        Scanner scanner = new Scanner(System.in);
	        Dosyaİşlemleri ekle = new Dosyaİşlemleri();
	        SEKERLEME yeni = new SEKERLEME();

	        System.out.println("YENİ ÜRÜNÜN ADINI GİR:");
	        String ad = scanner.nextLine();
	        yeni.urun.Adi = ad;
	        ekle.Adi = ad;
	        yeni.urun.Kategori_Indexi = 4;
	        ekle.Kategori_Indexi = 4;

	        System.out.println("YENİ ÜRÜNÜN BİRİM AĞIRLIĞINI GİRİN:");
	        String agirlik = scanner.nextLine();
	        yeni.urun.Birim_Agirligi = agirlik;
	        ekle.Birim_Agirligi = agirlik;

	        Double ort = 0.0;
	        double adet = 0.0;
	        Integer min_stok = 100;

	        for (SEKERLEME sekerleme : seker_list) {
	            adet++;
	            ort += sekerleme.urun.Birim_Fiyati;
	            if(min_stok > sekerleme.urun.Stok_Miktari) {
	                min_stok = sekerleme.urun.Stok_Miktari;
	            }
	        }
	        ort /= adet;
	        yeni.urun.Birim_Fiyati = ort;
	        ekle.Birim_Fiyati = ort;

	        yeni.urun.Stok_Miktari = min_stok;
	        ekle.Stok_Miktari = min_stok;

	        seker_list.add(yeni);
	        eklenecek_urun_list.add(ekle);

	        // Ürünlerin yazdırılması
	        System.out.println("ŞEKERLEME LİSTESİ YAZDIRILIYOR...");
	        for (SEKERLEME sekerleme : seker_list) {
	            sekerleme.urun.Tum_Liste_Yazdir(sekerleme.urun);
	        }
	    }
	}
	
	public static class SUT{
		
		public URUNLER urun;

		public SUT(URUNLER urun) {
			this.urun = urun;
		}
		
		public Double Fiyat_Guncelle_Sut() {
			System.out.println("GÜNCELLENECEK ÜRÜNÜN İLK HALİ...");
			System.out.println(this.urun.Adi + "\t" + this.urun.Kategori_Indexi + "\t" + this.urun.Birim_Agirligi + "\t" + this.urun.Birim_Fiyati + "\t" + this.urun.Stok_Miktari);
			this.urun.Birim_Fiyati = (this.urun.Birim_Fiyati * 150) / 100;
			System.out.println("\nGÜNCELLENEN ÜRÜNÜN SON HALİ...");
			System.out.println(this.urun.Adi + "\t" + this.urun.Kategori_Indexi + "\t" + this.urun.Birim_Agirligi + "\t" + this.urun.Birim_Fiyati + "\t" + this.urun.Stok_Miktari);
			return this.urun.Birim_Fiyati;
		}
		
		public static void sut_yazdir(ArrayList<SUT> sut_list) {
			System.out.println("\nSÜT LİSTESİ YAZDIRILIYOR...");
			for (SUT sut : sut_list) {
				sut.urun.Tum_Liste_Yazdir(sut.urun);
			}
		}

	}
	
	public static class TAHIL{
		
		public URUNLER urun;

		public TAHIL(URUNLER urun) {
			this.urun = urun;
		}

		public Integer Detay_Ekle_Tahil(Integer satis) {
			this.urun.Aylik_Satis = satis;
			return this.urun.Aylik_Satis;
		}

		public static void Tahil_yazdir(ArrayList<TAHIL> tahil_list) {
			System.out.println("TAHIL LİSTESİ YAZDIRILIYOR...");
			for (TAHIL tahil : tahil_list) {
				// DÜZGÜN BİR ÇIKTI OLMASI İÇİN YAPILDI
				if(tahil.urun.Aylik_Satis != null) {  // VERİYE AYLIK SATIŞ MİKTARI EKLEME ŞARTI SAĞLANMIŞSA
					tahil.urun.Tahil_Liste_Yazdir(tahil.urun);
				}else {
					tahil.urun.Tum_Liste_Yazdir(tahil.urun);
				}
				
			}
		}

	}

}

