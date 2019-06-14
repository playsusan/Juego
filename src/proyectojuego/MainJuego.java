package proyectojuego;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MainJuego {
	
	public static void main(String[] args) {
		int opcion = 0;
		String pantalla ="";
		String nombre = "";
		String x="";
		String etapa="";
		Juego principal = new Juego();
		Scanner teclado = new Scanner(System.in);
		int salir=0;
	do {
		do {
			try{
				pantalla = principal.saltoAEtapa("0.0.0");
				System.out.println(pantalla);
				opcion = teclado.nextInt();
				if(opcion == 1) {
					System.out.println("Ingrese el nombre del jugador");
					teclado.nextLine();
					nombre = teclado.nextLine();
					principal.setNombre(nombre);
					etapa="1.0.0";
					principal.setEtapaActual(etapa);
					pantalla = principal.saltoAEtapa(etapa);
					salir=1;
				}
				
				else if(opcion ==2) {
					System.out.println("Ingresa nombre del jugador que tenias para cargar la partida");
					teclado.nextLine();
					nombre = teclado.nextLine();
					principal.setNombre(nombre);
					etapa = principal.cargarDatos(nombre);
					if(principal.getNombre().equals(nombre)) {
						pantalla = principal.saltoAEtapa(etapa);
						salir=1;
					}
				}
				else if(opcion == 3) {
					System.out.println("Fin del programa");
					return;
				}
				
			}catch(InputMismatchException  ex) {
				System.out.println("Porfavor ingrese algun Dato numerico de 1 a 3");
				teclado.next();
			}
			catch(NoSuchElementException  ex) {
				System.out.println("no existe");
			}
	
			
		}while(salir==0);
		salir = 0;
		int finalizarJuego =0;
		do {
			opcion = -1;
			do {
			System.out.println(pantalla);
			try{
				opcion = teclado.nextInt();
			}catch(InputMismatchException  ex) {
				System.out.println("Porfavor ingrese algun Dato numerico de 1 a 5");
				teclado.next();
			}
			}while(opcion<1 || opcion>5);
			
			switch (opcion){
			
				case 1:if( principal.primerLlamarSelecciondeOpcion(opcion).contentEquals("final")) {
							finalizarJuego=-1;
						}else{
						x= principal.primerLlamarSelecciondeOpcion(opcion);
						pantalla =principal.saltoAEtapa(x);
						}
				break;
				case 2: 
						if(principal.primerLlamarSelecciondeOpcion(opcion).contentEquals(" ")){
							finalizarJuego=-1;
							break;
						}else {
						x= principal.primerLlamarSelecciondeOpcion(opcion);
						pantalla =principal.saltoAEtapa(x);
						break;	}
				case 3: 
						if(principal.primerLlamarSelecciondeOpcion(opcion).contentEquals(" ")){
							finalizarJuego=-1;
						break;
							}else {
						x= principal.primerLlamarSelecciondeOpcion(opcion);
						pantalla =principal.saltoAEtapa(x);
						break;}
				case 4: if( principal.primerLlamarSelecciondeOpcion(opcion).contentEquals("final")) {
							finalizarJuego=-1;
						}else{
						x= principal.primerLlamarSelecciondeOpcion(opcion);
						pantalla =principal.saltoAEtapa(x);
						}
						break;
				case 5: finalizarJuego=-1;
						break;
			}
			principal.setEtapaActual(x);
			String numero = principal.getActualStage();
			System.out.println(numero);
			principal.grabarJuego(numero);
			
			
			
		}while(finalizarJuego!=-1);
	}while(salir==0);
	teclado.close();
	}
}
