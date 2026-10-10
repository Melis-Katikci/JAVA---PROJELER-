 import java.util.Scanner;

public class DEĞİŞKENLER_1_HAFTA {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int number;
		while(true) {       // GİRİLEN SAYI İŞLEME UYGUNMU KONTROLÜ
			System.out.println("1. SORU İÇİN BİR SAYI GİRİNİZ:");
			number = scanner.nextInt();
			if(number > 3 && number >= 0) {
				break;
			}
			else {
				System.out.println("LÜTFEN 3'DEN BÜYÜK BİR SAYI GİRİNİZ:");
				continue;
			}
		}
		System.out.println("SEÇTİĞİNİZ SAYI: " + number);
		int[] up_array = new int[32];
		int up_index = 0;
		up_array[up_index++] = 3;
		int piece = 0;
		boolean temp = true;
		for(int i = 4 ; i < number ; i++) {       // İSTENEN ARALIKTA SAYTI ALIYOR
			temp = true;
			for (int j = 0; j < up_index; j++) {     // DİZİYE ATADIĞIMIZ BİRBİRİNE BÖLÜNMEYEN ELEMANLARDAN HERHANGİ BİRİNE YENİ SAYI BÖLÜNÜYORMU KONTROLÜ
				if(i % up_array[j] == 0) {
					temp = false;
					break;
				}
			}
			if(temp) {      // KONTROL ETTİĞİNMİZ YENİ ELEMAN DİZİDEKİ HİÇ BİR ELEMANA BÖLÜNMÜYOR BURADA ONLARI DİZİYE ATIYORUZ
				up_array[up_index++] = i;
				piece++;
				System.out.print(piece + ".ADIM: ");
				for (int k = 0; k < up_index; k++) {      
					System.out.print(up_array[k] + " ");
				}
				System.out.println();
			}
		}
		up_array[up_index++] = number;    // SINIR NOKTASI OLARAK KULLANBICIDSAN ALINAN VERİNİN DİZİYE ATANMASI
		piece++;
		System.out.print(piece + ".ADIM: ");
		for (int k = 0; k < up_index; k++) {
			System.out.print(up_array[k] + " ");
		}
		piece++;
		System.out.println("\nTOPLAM SAYI ADEDİ: " + piece);
		
		
		System.out.println();
		while(true) {       // GİRİLEN SAYI İŞLEME UYGUNMU KONTOLÜ
			System.out.println("2. SORU İÇİN BİR SAYI GİRİNİZ:");
			number = scanner.nextInt();
			if(number > 3 && number >= 0) {
				break;
			}
			else {
				System.out.println("LÜTFEN 3'DEN BÜYÜK BİR SAYI GİRİNİZ:");
				continue;
			}
		}
		System.out.println("SEÇTİĞİNİZ SAYI: " + number);
		int[] down_array = new int[32];
		int down_index = 0;
		down_array[down_index++] = number;
		piece = 0; 
		temp = true;
		for (int i = number-2; i >= 3; i-=2) {   // 2 2 AZALMA ŞARTINI SAĞLAYARAK İSTENEN ARALIKTA SAYI ALIYOR
			temp = true;
			for (int j = 0; j < down_index; j++) {       // DİZİYE ATADIĞIMIZ BİRBİRİNE BÖLÜNMEYEN ELEMANLARDAN HERHANGİ BİRİNE YENİ SAYI BÖLÜNÜYORMU KONTROLÜ
				if(down_array[j] % i == 0) {
					temp = false;
					break;
				}
			}
			if(temp) {        // KONTROL ETTİĞİNMİZ YENİ ELEMAN DİZİDEKİ HİÇ BİR ELEMANA BÖLÜNMÜYOR BURADA ONLARI DİZİYE ATIYORUZ
				down_array[down_index++] = i;
				piece++;
				System.out.print(piece + ".ADIM: ");
				for (int k = 0; k < down_index; k++) {
					System.out.print(down_array[k] + " ");
				}
				System.out.println();
			}
		}
		piece++;
		System.out.print("TOPLAM SAYI ADEDİ: " + piece);
	}
}