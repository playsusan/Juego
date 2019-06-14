package proyectojuego;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Historia {
private String todoHistoria="";
private String[] historiaSeparada;
private String[] historiaAsignacion;
private String[] numerosHistoria;
private String[][][] mainHistoria = new String[100][100][100];
	public Historia() {
		try{ 
			FileReader archivo = new FileReader("Proyecto historia.txt");
			int caract = archivo.read();
				while(caract !=-1) {
					todoHistoria = todoHistoria + ((char)(caract-5));
					caract = archivo.read();
				}
			archivo.close();	
		}catch(FileNotFoundException e) {
			System.out.println("El Archivo Historia no se encuentra\n Tipo de Error: "+e.getMessage());
		}catch(IOException e) {
			System.out.println("El Archivo Historia esta corrupto\n"+e.getMessage());
		
		}
		try {
		historiaSeparada = todoHistoria.split("\\*"); 
		for(int i = 0 ; i<historiaSeparada.length; i++) {
			historiaAsignacion  = historiaSeparada[i].split("&&");
			numerosHistoria = historiaAsignacion[0].split("\\.");
			
			int n0 = Integer.parseInt(numerosHistoria[0]);
			int n1 = Integer.parseInt(numerosHistoria[1]);
			int n2 = Integer.parseInt(numerosHistoria[2]);
			mainHistoria[n0][n1][n2] = historiaAsignacion[1];
		}
		}catch(ArrayIndexOutOfBoundsException io) {
			System.out.println("Datos del archivo Historia Erroneos :");
			System.out.println("Error tipo ArrayIndexOutOfBoundsException");
			}
	}
	

	
	public String NumeroStory(int n1,int n2,int n3) {
		return mainHistoria[n1][n2][n3];		
		
	}
}