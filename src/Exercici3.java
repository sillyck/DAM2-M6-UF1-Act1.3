import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Exercici3 {

	public static void main(String[] args) throws IOException {
				
		File fitxer = new File("Departaments.dat");
		
		RandomAccessFile fileRW = new RandomAccessFile(fitxer, "rw");
		
		String cognom[] = {"Ribellas", "Ramos", "Vallve", "Altozano"};
		
		double salari[] = {1500.00, 1300.00, 2100.00, 2500.00};
		
		int id = 0,posicio=0, opcio=0;
		double salari2=0;
		char cognomChar[]= new char[10], aux;
		
		Scanner entrada = new Scanner(System.in);
		
		StringBuffer buffer = null;
		int n = cognom.length;
		
		for(int i=0; i<n; i++) {
			fileRW.writeInt(i+1);
			buffer = new StringBuffer(cognom[i]);
			buffer.setLength(10);
			fileRW.writeChars(buffer.toString());
			fileRW.writeDouble(salari[i]);
		}
		
		int opcion = 0;
		while(opcion!=3) {
			System.out.println("###########\n1. Veure treballadors");
			System.out.println("2. Canviar salari treballador");
			System.out.println("3. Sortir");
			System.out.println("Escriu una opcio");
			opcion = entrada.nextInt();
			
			switch (opcion) {
				
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
				int findID, nouSalari;
				System.out.println("Indica el ID: ");
				
				findID = entrada.nextInt();
				posicio = (findID - 1)* 32;
				
				if(posicio >= fileRW.length()) {
					System.out.println("Aquest id no existeix");
				}else {
					System.out.println("Escriu el nou salari: ");
					
					int canviarSalari = entrada.nextInt();
					
					fileRW.seek(posicio+4+20);
					nouSalari = fileRW.readInt();
					nouSalari = nouSalari + canviarSalari;
					fileRW.writeDouble(nouSalari);
					System.out.println("S'ha canviat el salari del treballador");
				}
				break;
					
				case 3:
					opcion=3;
					break;
				
			}
			
		}
		
		
		
		fileRW.close();
		
	}

}
