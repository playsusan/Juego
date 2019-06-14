package proyectojuego;

public class Etapa {
	private Historia story;
	private Imagenes dibujo;
	private Opciones deciciones;
	
	public Etapa() {
		story = new Historia();
		dibujo = new Imagenes();
		deciciones = new Opciones();
		
		
	}
	
	public String NumeroEtapa(int x,int y,int z){
		String a = deciciones.NumeroDeciciones(x,y,z);
		String b = dibujo.NumeroDibujo(x,y,z);
		String c = story.NumeroStory(x,y,z);
		return b+c+a;
		
	}

	public String llamarSelecciondeOpcion(int x) {
		if(x==1){
		return deciciones.SelecciondeOpcion1();
		}else if(x==2) {		
		return deciciones.SelecciondeOpcion2();
		}else if(x==3) {	
		return deciciones.SelecciondeOpcion3();
		}else if(x==4) {
		return deciciones.SelecciondeOpcion4();
		}
		return null;
	}
}



