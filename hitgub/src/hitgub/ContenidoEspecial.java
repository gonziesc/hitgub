package hitgub;

public abstract class ContenidoEspecial extends Contenido {
	double tamano(){
		return 0;
	}
	boolean entraEnbiblioteca(Biblioteca unaBiblioteca){
		 return !this.roto(unaBiblioteca);
	}
	
   

}
