package proyectojuego;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Jugador {
	private String nombreJugador;
	private String porcentageJuegoCompletado;
	String saveData = "";
	String[] saveDataList;
	String NombreAGuardar;
	
	public Jugador(String n) {
		try{ 
			FileReader archivo = new FileReader("Save Data.txt");
			int caract = archivo.read();
				while(caract !=-1) {
					saveData = saveData + ((char)(caract));
					caract = archivo.read();
				}
			archivo.close();	
		}catch(FileNotFoundException e) {
			System.out.println("El Archivo Save Data no se encuentra\n Tipo de Error: "+e.getMessage());
		}catch(IOException e) {
			System.out.println("El Archivo Save Data esta corrupto\n"+e.getMessage());
		
		}
		saveDataList = saveData.split("\\*");
		nombreJugador = saveDataList[1];
		NombreAGuardar= n;
		}	
	public void cambiarSaveGame(String contadorEtapa) {
		FileWriter archivo=null;
		try{
			porcentageJuegoCompletado= ""+contadorEtapa; 
			archivo = new FileWriter("Save Data.txt");
			archivo.append(saveDataList[0]+"*"+NombreAGuardar+"*"+saveDataList[2]+"*"+porcentageJuegoCompletado);
		}catch(IOException e) {
			System.out.println("El Archivo Historia esta corrupto\n"+e.getMessage());
		}
		try {
			archivo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public String cargandoDatosJugador(String nombre) {
		String nEtapa = "";
		System.out.println("El nombre ["+nombre+"]");
			if(nombre.equals(nombreJugador)) {
				System.out.println("Cargando...");
				System.out.println(saveDataList[3]);
			nEtapa = saveDataList[3];
			}else {
				System.out.print("no se encuentra guardado\nel nombre que se encuentra en el archivo guardado es[" +nombreJugador+"]\n\n");
			}
		return	nEtapa;
	}
	
	public String mandarNombre() {
		
		return nombreJugador;
	}

}
