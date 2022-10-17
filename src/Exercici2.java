import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Exercici2 {

	public static void main(String[] args) throws IOException {
		
		
		
		File fitxer = new File("Departaments.dat");
		
		FileOutputStream fileout = new FileOutputStream(fitxer);
		FileInputStream filein = new FileInputStream(fitxer);
		DataOutputStream dataOS = new DataOutputStream(fileout);
		DataInputStream dataIS = new DataInputStream(filein);
		
		int id[] = {1,2,3,4,5};
		
		String nom[] = {"I+D", "RRHH", "Marqueting", "Comptabilitat", "Logisitca"};
		
		String localitat[] = {"Alcover", "Valls", "Tarragona", "Puigpelat", "Reus"};
		
		for(int i=0; i<nom.length; i++) {
			dataOS.writeInt(id[i]);
			dataOS.writeUTF(nom[i]);
			dataOS.writeUTF(localitat[i]);
		}
		
		String nombre, localidad;
		int num;
		
		try {
			for(int i=0; i<nom.length; i++) {
				num = dataIS.readInt();
				nombre = dataIS.readUTF();
				localidad = dataIS.readUTF();
				
				System.out.println("Numero: " + num + ", Nom: " + nombre + ", Locaitat: " + localidad + ".");
			}
		}catch (EOFException eo) {}
		
		dataIS.close();
		dataOS.close();
	}

}
