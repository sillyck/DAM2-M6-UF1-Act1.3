import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Exercici1 {

	public static void main(String[] args) throws IOException {
		
		FileReader fr = null;
		BufferedReader br = null;
		
		Scanner entrada1 = new Scanner(System.in);
		
		System.out.println("Escriu el nom del fitxer: ");
				
		File fitxerText = new File(entrada1.nextLine());
		
		if(!fitxerText.exists()) {
			throw new IOException("El fitxer d'origen no existeix");
		}
		
		try {
			
			fr = new FileReader(fitxerText);
			br = new BufferedReader(fr);
			
			String linia;
			while((linia = br.readLine())!=null) {
				System.out.println(linia);
			}
			
		}finally {
			fr.close();
		}

	}

}
