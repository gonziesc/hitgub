package hitgub;

import java.util.List;

public class Carpeta extends ContenidoEspecial {
	List<Contenido> referencias;
	public Carpeta(List<Contenido> unasReferencias, String unNombre){
		referencias = unasReferencias;
		nombre = unNombre;
	}
	boolean esLiviano(){
		return referencias.stream().allMatch(unaReferencia -> unaReferencia.esLiviano());
	}
	 boolean roto(Biblioteca unaBiblioteca) {
			return referencias.stream().allMatch(it -> it.roto(unaBiblioteca));
		}
}
