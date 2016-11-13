package hitgub;

public abstract class ContenidoSimple extends Contenido {
	boolean esLiviano(){
		return this.tamano() < 150*2024*2024;
	}
	
	boolean  roto(Biblioteca unaBiblioteca){
		return  !unaBiblioteca.contiene(this);
	}
   

	 
}
