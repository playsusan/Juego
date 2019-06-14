package jjj;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class coder {
	
	public static void main(String[] args) throws IOException {
		String historiacod="";
		FileReader archivo = new FileReader("Proyecto historia.txt");
		int caract = archivo.read();
			while(caract !=-1) {
				historiacod = historiacod + ((char)(caract+5));
				caract = archivo.read();
			}
		archivo.close();
		
		FileWriter archive= new FileWriter("Proyecto historia.txt");
			archive.append(historiacod);
	
			archive.close();
	}


}
