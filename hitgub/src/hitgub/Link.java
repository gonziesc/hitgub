package hitgub;

public class Link extends ContenidoEspecial {
	Contenido unContenido;
	public Link(Contenido unNuevoContenido, String unNombre){
		unContenido = unNuevoContenido;
		nombre = unNombre;
	}
	boolean esLiviano(){
		return true;
	}
	boolean roto(Biblioteca unaBiblioteca) {
		return unContenido.roto(unaBiblioteca);
	}
}
