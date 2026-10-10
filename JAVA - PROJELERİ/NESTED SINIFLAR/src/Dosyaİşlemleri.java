import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Dosyaİşlemleri implements Serializable {

	public String Adi;
	public Integer Kategori_Indexi;
	public String Birim_Agirligi;
	public Double Birim_Fiyati;
	public Integer Stok_Miktari;
	public Integer Aylik_Satis;
	
	public static class DosyaOkuma{
		public static void ListeleriOluştur(String dosya_adı) throws FileNotFoundException, IOException, ClassNotFoundException {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dosya_adı));
			ArrayList<Dosyaİşlemleri> eklenecek_urun_list = (ArrayList<Dosyaİşlemleri>) ois.readObject();
			for (Dosyaİşlemleri urun : eklenecek_urun_list) {
				System.out.println(urun.Adi + "\t" + urun.Kategori_Indexi + "\t" + urun.Birim_Agirligi + "\t"
						+ urun.Birim_Fiyati + "\t" + urun.Stok_Miktari);
			}
		}
	}

	public static class DosyayaYazma {
		public static void ListeleriYaz(ArrayList<Dosyaİşlemleri> eklenecek_urun_list, String dosya_adı) throws IOException {
			FileOutputStream fos = new FileOutputStream(dosya_adı);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(eklenecek_urun_list);
		}
	}
}