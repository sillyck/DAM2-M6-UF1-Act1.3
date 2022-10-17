import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Exercici3 {

	public static void main(String[] args) throws IOException {
		
		int id = 0,posicio=0;
		double salari2=0;
		char cognomChar[]= new char[10], aux;
		
		File fitxer = new File("Departaments.dat");
		
		RandomAccessFile fileRW = new RandomAccessFile(fitxer, "rw");
		
		String cognom[] = {"Ribellas", "Ramos", "Vallve", "Altozano"};
		
		double salari[] = {1500.00, 1300.00, 2100.00, 2500.00};
		
		Scanner entrada = new Scanner(System.in);
		int n=cognom.length;
		
		StringBuffer buffer = null;

		int cont=0;
		
		for(cont=0;cont<n;cont++) {
			fileRW.writeInt(cont+1);
			buffer = new StringBuffer (cognom[cont]);
			buffer.setLength(10);
			fileRW.writeChars(buffer.toString());
			fileRW.writeDouble(salari[cont]);
		}
		
		int opcio = 0;
		while(opcio!=3) {
			System.out.println("1. Veure treballadors");
			System.out.println("2. Canviar salari treballador");
			System.out.println("3. Sortir");
			System.out.println("Escriu una opcio");
			opcio = entrada.nextInt();
			
			switch (opcio) {
				
				case 1:					
					
					RandomAccessFile fileR = new RandomAccessFile(fitxer, "r");
					posicio = 0;
					Long longitud = fileR.length();
					
					for(;;) {
						int temp=0;
						fileR.seek(posicio);
						id = fileR.readInt();
						for(int i=0;i < cognomChar.length;i++) {
							aux = fileR.readChar();
							cognomChar[i] = aux;
						}
						String cognomS = new String(cognomChar);
						salari2=fileR.readDouble();
						
						System.out.println("ID: " + id +", Cognom: " + cognomS + ", Salari: " + salari2);
						posicio = posicio + 32;
						
						if(fileR.getFilePointer()==fileR.length()) break;
					}
					fileR.close();
					break;
			
			case 2:
					System.out.println("22222222222222222");
					break;
					
				case 3:
					opcio=3;
					break;
				
			}
			
		}
		
		
		
		fileRW.close();
		
	}

}
