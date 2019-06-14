package proyectojuego;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Opciones {
	private String todoOpciones = "";
	private String[] opcionSeparada;
	private String[] opcionAsignacion;
	private String[] numerosOpcion;
	private String [] alternativas;
	private String[][][] mainOpcion = new String[100][100][100];
	private String[][][] mainOpcionEtapa  = new String[100][100][100];
	private int n1=0;
	private int n2=0;
	private int n3=0;
	public Opciones() {
		try{ 
			FileReader archivo = new FileReader("Opciones de historia.txt");
			int caract = archivo.read();
				while(caract !=-1) {
					todoOpciones = todoOpciones + ((char)(caract));
					caract = archivo.read();
				}
			archivo.close();	
		}catch(FileNotFoundException e) {
			System.out.println("El Archivo Opciones no se encuentra\n Tipo de Error: "+e.getMessage());
		}catch(IOException e) {
			System.out.println("El Archivo Opciones esta corrupto\nTipo de error: "+e.getMessage());
		
		}
		try{
			opcionSeparada = todoOpciones.split("\\*");
		
		for(int i = 0 ; i<opcionSeparada.length; i++) {
			opcionAsignacion  = opcionSeparada[i].split("&&");
			numerosOpcion = opcionAsignacion[0].split("\\.");
			alternativas = opcionAsignacion[1].split(">>");
			String sumaDeAlternativas = alternativas[0]+alternativas[2]+alternativas[4]+alternativas[6]+alternativas[8];
			mainOpcion[Integer.parseInt(numerosOpcion[0])][Integer.parseInt(numerosOpcion[1])][Integer.parseInt(numerosOpcion[2])] = sumaDeAlternativas;
			mainOpcionEtapa[Integer.parseInt(numerosOpcion[0])][Integer.parseInt(numerosOpcion[1])][Integer.parseInt(numerosOpcion[2])] = opcionAsignacion[1];
		}
		}catch(ArrayIndexOutOfBoundsException io) {
			System.out.println("Datos del archivo Opciones Erroneos :");
			System.out.println("Error tipo ArrayIndexOutOfBoundsException");
			}
		
	}
	public String NumeroDeciciones(int x,int y,int z) {
		n1=x;
		n2=y;
		n3=z;
		return mainOpcion[x][y][z];		
		
	}	
	public String SelecciondeOpcion1() {
		String x= mainOpcionEtapa[n1][n2][n3];
		alternativas = x.split(">>");
		return alternativas[1];
	}
	public String SelecciondeOpcion2() {
		String x= mainOpcionEtapa[n1][n2][n3];
		alternativas = x.split(">>");
		return alternativas[3];
	}
	public String SelecciondeOpcion3() {
		String x= mainOpcionEtapa[n1][n2][n3];
		alternativas = x.split(">>");
		return alternativas[5];
	}
	public String SelecciondeOpcion4() {
		String x= mainOpcionEtapa[n1][n2][n3];
		alternativas = x.split(">>");
		return alternativas[7];
	}
}
