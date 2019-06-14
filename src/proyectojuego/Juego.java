package proyectojuego;

public class Juego {
	private Etapa escenario;
	private Jugador player; 
	private String etapa= "";
	
	public Juego() {
		 escenario = new Etapa();
		 
		
	}
	public void setNombre(String nombre) {
		 player = new Jugador(nombre);
	}
			
	public void grabarJuego(String x) {
		player.cambiarSaveGame(x);
	}
	public String getActualStage() {
		return etapa;
	}
	public String saltoAEtapa(String x) {
		String[] separacion = x.split("\\.");
		try {
		int n0 = Integer.parseInt(separacion[0]);
		int n1 = Integer.parseInt(separacion[1]);
		int n2 = Integer.parseInt(separacion[2]);
		return escenario.NumeroEtapa(n0,n1,n2);
	}catch(ArrayIndexOutOfBoundsException io) {
		System.out.println("Datos del archivo Erroneos :");
		return  "Error tipo ArrayIndexOutOfBoundsException";
		}
	}
	public String cargarDatos(String Data) {
		;
		return player.cargandoDatosJugador(Data);
	}
	
	public String getNombre() {
	   
		return player.mandarNombre(); 
	}
		
	public String primerLlamarSelecciondeOpcion(int x) {
		return escenario.llamarSelecciondeOpcion(x);
	}
	public void setEtapaActual(String x) {
		etapa = x;
		
	}
			
	

}
