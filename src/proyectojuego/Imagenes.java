package proyectojuego;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Imagenes {
private String todoImagenes="";
private String[] imageneSeparada;
private String[] imagenAsignacion;
private String[] numerosImagen;
private String[][][] mainImagen = new String[100][100][100];
	
	public Imagenes() {
		try{ 
			FileReader archivo = new FileReader("Imagenes historia.txt");
			int caract = archivo.read();
				while(caract !=-1) {
					todoImagenes = todoImagenes + ((char)(caract));
					caract = archivo.read();
				}
			archivo.close();	
		}catch(FileNotFoundException e) {
			System.out.println("El Archivo Imagenes  no se encuentra\nTipo de Error: "+e.getMessage());
		}catch(IOException e) {
			System.out.println("El Archivo Imagenes esta corrupto\nTipo de error: "+e.getMessage());
		
		}
		try {	
		imageneSeparada = todoImagenes.split("\\*"); 
		for(int i = 0 ; i<imageneSeparada.length; i++) {
			imagenAsignacion  = imageneSeparada[i].split("&&");
			numerosImagen = imagenAsignacion[0].split("\\.");
			int n0 = Integer.parseInt(numerosImagen[0]);
			int n1 = Integer.parseInt(numerosImagen[1]);
			int n2 = Integer.parseInt(numerosImagen[2]);
			mainImagen[n0][n1][n2] = imagenAsignacion[1];
		}
		}catch(ArrayIndexOutOfBoundsException io) {
			System.out.println("Datos del archivo Imagenes Erroneos :");
			System.out.println("Error tipo ArrayIndexOutOfBoundsException");
			}
		}
	
	public String NumeroDibujo(int n1,int n2,int n3) {
		return mainImagen[n1][n2][n3];		
		
	}
	
}